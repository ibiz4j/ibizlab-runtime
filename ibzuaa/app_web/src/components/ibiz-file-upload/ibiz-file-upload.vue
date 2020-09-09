<template>
    <div id="file-upload">
        <el-row id="el-row">
            <!--拖拽上传-->
            <el-col v-if="showDrag==true" class="withDrag">
                <el-upload
                        ref="upload"
                        drag
                        multiple
                        list-type="text"
                        :action="getAction"
                        :headers="myHeaders"
                        :file-list="uploadFileList"
                        :show-file-list="false"
                        :limit="limit"
                        :http-request="customUploadFile">
                    <div>
                        <i class="el-icon-upload"></i>
                        <div>
                            <span>将文件拖到此处，或</span>
                            <span style="color:#409EFF;">点击上传</span>
                        </div>
                        <div slot="tip" class="el-upload__tip">{{uploadTip}}</div>
                    </div>
                </el-upload>
            </el-col>
            <!--点击上传-->
            <el-col v-else class="withoutDrag">
                <el-upload
                        ref="upload"
                        multiple
                        list-type="text"
                        :action="getAction"
                        :headers="myHeaders"
                        :file-list="uploadFileList"
                        :show-file-list="false"
                        :limit="limit"
                        :http-request="customUploadFile">
                    <el-button type="primary" size="small" icon="el-icon-upload">点击上传</el-button>
                    <div slot="tip" class="el-upload__tip">{{uploadTip}}</div>
                </el-upload>
            </el-col>
            <!--文件操作-->
            <el-col v-for="(item,index) in uploadFileList" :key="index" class="fileList">
                <div class="fileTitle">
                    <i class="el-icon-document"></i>
                    <span>{{item.name}}</span>
                </div>
                <div class="fileMain">
                    <el-link type="success" icon="el-icon-download" @click="onDownload(item)">下载</el-link>
                    <el-link type="warning" icon="el-icon-view" v-show="showPreview" @click="onPreview(item)">预览
                    </el-link>
                    <el-link type="primary" icon="el-icon-edit"
                             v-show="showEdit && (item.name.match(/^.+\.(doc|DOC|docx|DOCX|wps|WPS|xls|XLS|xlsx|XLSX|ppt|PPT|et|ET)$/))"
                             @click="onEdit(item)">编辑
                    </el-link>
                    <el-link icon="el-icon-camera"
                             v-show="showOcrview && (item.name.match(/^.+\.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG|bmp|BMP|pdf|PDF)$/))"
                             @click="onOcr(item)">OCR
                    </el-link>
                    <el-link type="danger" icon="el-icon-delete" @click="onRemove(item,index)">删除</el-link>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    import {Button, Row, Col, Link, Icon, Upload, Message, MessageBox} from 'element-ui';
    import Axios from 'axios';
    import {Subject, Unsubscribable} from 'rxjs';

    // 当前登录人token
    var token = "Bearer " + localStorage.getItem('token');

    export default {
        name: "ibiz-file-upload",
        components: {
            'el-button': Button,
            'el-row': Row,
            'el-col': Col,
            'el-link': Link,
            'el-icon': Icon,
            'el-upload': Upload,
        },
        props: {
            // 当前表单对象
            data: {
                type: Object,
            },
            // 当前属性名
            formItemName: {
                type: String,
            },
            // 当前属性值
            value: {
                type: String,
            },
            // 订阅表单状态
            formState: {
                type: Subject
            },
            // 默认为当前实体名称，有指定则按表单参数
            folder: {
                type: String,
            },
            // 默认为当前实体主键id，有指定则按表单参数
            ownerid: {
                type: String,
            },
            // 默认为当前属性名，有指定则按表单参数
            ownertype: {
                type: String,
            },
            // 持久化
            persistence: {
                type: Boolean,
                default: false
            },
            // 是否显示拖拽区域
            showDrag: {
                type: Boolean,
                default: false
            },
            // 是否显示预览按钮
            showPreview: {
                type: Boolean,
                default: false
            },
            // 是否显示在线编辑按钮
            showEdit: {
                type: Boolean,
                default: false
            },
            // 是否显示OCR按钮
            showOcrview: {
                type: Boolean,
                default: false
            },
            // 单文件大小
            size: {
                type: Number,
                default: 1
            },
            // 文件上传个数
            limit: {
                type: Number,
                default: 5
            },
        },
        data() {
            return {
                // 表单是否处于编辑状态（有真实主键,srfuf='1';srfuf='0'时处于新建未保存）
                srfuf: '0',
                // 上传提示语
                uploadTip: `单个文件大小不超过${this.size}M，文件不超过${this.limit}个`,
                // 文件列表
                uploadFileList: [],
                // headers
                myHeaders: {Authorization: token},
                // 表单状态事件
                formStateEvent: Unsubscribable | undefined,
                // 批量更新标识，false为不更新，true才可以更新
                isUpdateBatch: true,
                // 新建状态标识,true为新建，false为编辑
                isCreate: true,
            }
        },
        computed: {
            /**
             * return action
             */
            getAction() {
                const uploadUrl = '/net-disk/upload/' + this.getFolder + '?ownertype=' + this.getOwnertype + '&ownerid=' + this.getOwnerid;
                return uploadUrl;
            },
            /**
             *  return folder
             */
            getFolder() {
                const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
                return folder;
            },
            /**
             *  return ownertype
             */
            getOwnertype() {
                const ownertype = typeof this.ownertype == "string" ? this.ownertype : JSON.stringify(this.ownertype);
                return ownertype;
            },
            /**
             *  return ownerid
             */
            getOwnerid() {
                const ownerid = typeof this.ownerid == "string" ? this.ownerid : JSON.stringify(this.ownerid);
                return ownerid;
            }
        },
        watch: {},
        created() {
            this.formStateEvent = this.formState.subscribe(($event) => {
                // 表单加载完成
                if (Object.is($event.type, 'load')) {
                    const data = JSON.parse(JSON.stringify($event.data));
                    // 编辑表单，保存时不进行批量更新
                    if (data.srfuf == '1') {
                        this.isCreate = false;
                        this.isUpdateBatch = false;
                    }
                    // 当persistence = true时
                    if (this.persistence == true) {
                        // 直接从表单的data数据里获取当前属性的值
                        if (data[this.formItemName] && this.uploadFileList.length == 0) {
                            const files = JSON.parse(data[this.formItemName]);
                            for (let i = 0; i < files.length; i++) {
                                this.uploadFileList.push(files[i]);
                            }
                        }
                    } else {
                        // 发送get请求获取文件列表
                        this.getFiles();
                    }
                }
                // 表单保存完成
                if (Object.is($event.type, 'save')) {
                    // 批量更新文件表中的ownerid
                    if (this.isUpdateBatch == true && this.uploadFileList.length > 0) {
                        this.updateFileBatch(this.uploadFileList, 'update');
                    }
                }
            });
        },
        mounted() {

        },
        methods: {
            /**
             * 获取文件列表
             */
            getFiles() {
                // 拼接url
                const getUrl = '/net-disk/files/' + this.getFolder;
                // 发送get请求
                Axios.get(getUrl, {
                    params: {
                        ownertype: this.getOwnertype,
                        ownerid: this.getOwnerid,
                    },
                }).then(response => {
                    if (!response || response.status != 200) {
                        Message.error("获取文件列表失败!");
                        return;
                    }
                    // 返回的是一个jsonArray
                    if (response.data) {
                        const files = JSON.parse(JSON.stringify(response.data));
                        if (this.uploadFileList.length == 0) {
                            this.uploadFileList.push.apply(this.uploadFileList, files);
                        }
                    }
                }).catch(error => {
                    Message.error("获取文件列表失败:" + error);
                });
            },
            /**
             * 自定义上传文件
             */
            customUploadFile(param) {
                // 上传的文件
                let file = param.file;
                // 文件大小
                const isSize = file.size / 1024 / 1024 < this.size;
                if (!isSize) {
                    Message.error(`上传失败,单个文件不得超过${this.size}M!`);
                    return;
                }
                // formData传参
                let formData = new FormData();
                formData.append('file', file);
                // 拼接url
                const uploadUrl = this.getAction;
                // 发送post请求
                Axios.post(uploadUrl, formData, {timeout: 2000}).then(response => {
                    if (!response || response.status != 200) {
                        Message.error('上传文件失败!');
                    }
                    // 返回的是一个jsonobject
                    if (response.data) {
                        // 新建表单上传，后续需要批量更新操作
                        if (this.isCreate == true) {
                            this.isUpdateBatch = true;
                        }
                        // 保存到文件列表进行显示
                        this.uploadFileList.push(response.data);
                        // persistence=true时需要持久化表单属性
                        if (this.persistence == true && this.uploadFileList.length > 0) {
                            const value = JSON.stringify(this.uploadFileList);
                            this.$emit('formitemvaluechange', {name: this.formItemName, value: value});
                        }
                    }
                }).catch(err => {
                    Message.error('上传文件失败:' + err);
                });
            },
            /**
             * 下载文件
             * @param item
             */
            onDownload(item) {
                // 拼接url
                const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
                const name = typeof item.name == "string" ? item.name : JSON.stringify(item.filename);
                const downloadUrl = '/net-disk/download/' + this.getFolder + '/' + id + '/' + name;
                // 发送get请求
                Axios.get(downloadUrl, {
                    headers: {
                        'authcode': item.authcode
                    },
                    responseType: 'arraybuffer',
                }).then(response => {
                    if (!response || response.status != 200) {
                        Message.error("下载文件失败!");
                        return;
                    }
                    // 请求成功，后台返回的是一个文件流
                    if (response.data) {
                        // 获取文件名
                        const disposition = response.headers['content-disposition'];
                        const filename = disposition.split('filename=')[1];
                        // 用blob对象获取文件流
                        var blob = new Blob([response.data], {type: response.headers['content-type']});
                        // 创建下载链接
                        var href = URL.createObjectURL(blob);
                        // 创建一个a元素并设置相关属性
                        var a = document.createElement('a');
                        a.href = href;
                        a.download = filename;
                        // 添加a元素到当前网页
                        document.body.appendChild(a);
                        // 触发a元素的点击事件，实现下载
                        a.click();
                        // 从当前网页移除a元素
                        document.body.removeChild(a);
                        // 释放blob对象
                        URL.revokeObjectURL(href);
                    } else {
                        Message.error('下载文件失败,未获取到文件!');
                    }
                }).catch(error => {
                    Message.error("下载文件失败:" + error);
                });
            },
            /**
             * 预览文件
             * @param item
             */
            onPreview(item) {
                // 拼接url
                const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
                const name = typeof item.name == "string" ? item.name : JSON.stringify(item.name);
                const previewUrl = '/net-disk/preview/' + this.getFolder + '/' + id + '/' + name + '?authcode=' + item.authcode;
                // 新窗口打开url
                window.open(previewUrl);
            },
            /**
             * 编辑文件
             * @param item
             */
            onEdit(item) {
                // 拼接url
                const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
                const name = typeof item.name == "string" ? item.name : JSON.stringify(item.name);
                const editUrl = '/net-disk/edit/' + this.getFolder + '/' + id + '/' + name + '?authcode=' + item.authcode;
                // 新窗口打开url
                window.open(editUrl);
            },
            /**
             * ocr识别
             * @param item
             */
            onOcr(item) {
                // 拼接url
                const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
                const name = typeof item.name == "string" ? item.name : JSON.stringify(item.name);
                const ocrUrl = '/net-disk/ocrview/' + this.getFolder + '/' + id + '/' + name + '?authcode=' + item.authcode;
                // 新窗口打开url
                window.open(ocrUrl);
            },
            /**
             * 删除文件
             * @param item
             * @param index
             */
            onRemove(item, index) {
                if (item) {
                    MessageBox.confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        //　拼接url
                        const deleteUrl = '/net-disk/files/' + item.id;
                        // 发送delete请求
                        Axios.delete(deleteUrl).then(response => {
                            if (!response || response.status != 200) {
                                Message.error("删除文件失败!");
                            }
                            // 从文件列表中删除
                            this.uploadFileList.splice(index, 1);
                            // persistence=true时需要持久化表单属性
                            if (this.persistence == true) {
                                const value = JSON.stringify(this.uploadFileList);
                                this.$emit('formitemvaluechange', {name: this.formItemName, value: value});
                            }
                        }).catch(error => {
                            // 提示删除失败
                            Message.error("删除文件失败:" + error);
                        });
                    });
                }
            },
            /**
             * 批量更新文件表的ownerid
             */
            updateFileBatch(files, opt) {
                // 拼接url
                const updateUrl = '/net-disk/files/' + this.getFolder + '?ownertype=' + this.getOwnertype + "&ownerid=" + this.getOwnerid;
                // requestBody参数
                let requestBody = [];
                if (files) {
                    requestBody = files;
                }
                // 发送post请求
                Axios.post(updateUrl, requestBody, {
                    headers: {
                        "Content-Type": "application/json;charset=UTF-8"
                    },
                    timeout: 2000
                }).then(response => {
                    if (!response || response.status != 200) {
                        Message.error("批量更新文件失败!");
                        return;
                    }
                }).catch(error => {
                    Message.error("批量更新文件失败:" + error);
                });
            },

        }
    }
</script>

<style scoped>
    #file-upload {
        width: auto;
        height: auto;
        border: 0px solid black;
    }

    #el-row {
        border: 0px solid red;
        width: 400px;
    }

    .withDrag {
        border: 0px solid grey;
        width: 400px;
    }

    .withoutDrag {
        border: 0px solid grey;
        width: 400px;
        text-align: left;
        padding-left: 0px;
        padding-top: 0px;
        margin-top: 0px;
    }

    .el-upload__tip {
        margin-top: 0px;
    }

    .fileList {
        width: 400px;
        border: 0px solid grey;
        margin-top: 0px;
    }

    .fileTitle {
        text-align: left;
        margin-left: 0px;
    }

    .fileTitle i {
        margin-right: 5px;
    }

    .fileMain {
        text-align: left;
        margin-left: 0px;
        margin-top: -10px;
    }

    .fileMain .el-link:nth-child(n+2) {
        margin-left: 10px;
    }
</style>