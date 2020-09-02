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
                        :action="action"
                        :headers="myHeaders"
                        :file-list="uploadFileList"
                        :show-file-list="false"
                        :limit="limit"
                        :before-upload="beforeUpload"
                        :on-success="uploadSuccess"
                        :on-error="uploadError">
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
                        :action="action"
                        :file-list="uploadFileList"
                        :show-file-list="false"
                        :limit="limit"
                        :http-request="uploadFile"
                        :on-success="uploadSuccess"
                        :on-error="uploadError">
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
                             v-show="showEdit && (item.name.toString().match(/^.+\.(doc|DOC|docx|DOCX|wps|WPS|xls|XLS|xlsx|XLSX|ppt|PPT|et|ET)$/))"
                             @click="onEdit(item)">编辑
                    </el-link>
                    <el-link icon="el-icon-camera"
                             v-show="showOcrview && (item.name.toString().match(/^.+\.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG|bmp|BMP|pdf|PDF)$/))"
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
    import Qs from 'qs';

    var token ="Bearer " +localStorage.getItem('token');
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
            // 当前父表单对象
            data: {
                type: Object,
            },
            // 当前属性名
            name: {
                type: String,
            },
            // 当前属性值
            value: {
                type: String,
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
                // 上传提示语
                uploadTip: `单个文件大小不超过${this.size}M，文件不超过${this.limit}个`,
                // 文件列表
                uploadFileList: [],
                // headers
                myHeaders: {Authorization: token},
            }
        },
        computed: {
            action() {
                const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
                const ownertype = typeof this.ownertype == "string" ? this.ownertype : JSON.stringify(this.ownertype);
                const ownerid = typeof this.ownerid == "string" ? this.ownerid : JSON.stringify(this.ownerid);
                const uploadUrl = '../net-disk/upload/sysopenaccesses?ownertype=' + ownertype + '&ownerid=' + ownerid;
                // const uploadUrl = '../ibizutil/upload';
                return uploadUrl;
            }
        },
        watch: {
            data: {
                handler(newVal, oldVal) {
                    if (newVal) {
                        // 解析表单数据
                        const data = JSON.parse(JSON.stringify(newVal));
                        if (data.srfkey) {
                            this.ownerid = data.srfkey;
                        }
                        // 当persistence = true时，直接从表单的data数据里获取当前属性的值
                        if (this.persistence == true && data[this.name]) {
                            const files = data[this.name];
                            if (files) this.uploadFileList = files;
                        }
                    }
                },
                immediate: false,
                deep: true
            },
            ownerid: {
                handler(newVal, oldVal) {
                    if (newVal) {
                        // 当persistence = false并且表单保存后，有主键ownerid了，调用接口批量更新下文件表里的fileid
                        if (this.persistence == false) {
                            this.updateFileBatch();
                        } else {
                            // this.getFiles();
                        }
                    }
                },
                immediate: false,
                deep: true
            }
        },
        mounted() {
            /*
             * 1.当persistence = true时，直接从表单的data数据里获取当前属性的值
             * 2.当persistence = false时,判断ownerid是否有值
             *      ownerid有值，表单data数据里并没有这个值，这时需要get请求获取文件列表
             *      ownerid无值，给一个空数组
             * 3.默认情况下给一个空数组
             */
            if (this.persistence == true) {
                const files = JSON.parse(JSON.stringify(this.value));
                if (files) this.uploadFileList = files;
            } else if (this.persistence == false) {
                if (this.ownerid) {
                    this.getFiles();
                } else {
                    this.uploadFileList = [];
                }
            } else {
                this.uploadFileList = [];
            }
        },
        methods: {
            /**
             * 获取文件列表
             */
            getFiles() {
                const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
                const ownertype = typeof this.ownertype == "string" ? this.ownertype : JSON.stringify(this.ownertype);
                const ownerid = typeof this.ownerid == "string" ? this.ownerid : JSON.stringify(this.ownerid);
                const getUrl = `net-disk/files/${folder}`;
                Axios.get(getUrl, {
                    params: {
                        ownertype: ownertype,
                        ownerid: ownerid,
                    },
                }).then(response => {
                    if (!response || response.status != 200) {
                        Message.error("请求当前控件的值发生错误!");
                        return;
                    }
                    if (response.data) {
                        const files = JSON.parse(JSON.stringify(response.data));
                        this.uploadFileList = files;
                    }
                }).catch(error => {
                    Message.error("请求当前控件的值发生错误:" + error);
                });
            },
            /**
             * 上传之前
             */
            beforeUpload(file) {
                const isSize = file.size / 1024 / 1024 < this.size;
                if (!isSize) {
                    Message.error(`上传失败,单个文件不得超过${this.size}M!`);
                    return false;
                }
            },
            /**
             * 自定义的文件上传行为
             * @param param
             */
            uploadFile(param) {
                console.log("uploadFile run");
                return;
                // 上传的文件
                let file = param.file;
                const isSize = file.size / 1024 / 1024 < this.size;
                if (!isSize) {
                    Message.error(`上传失败,单个文件不得超过${this.size}M!`);
                    return;
                }
                // url及参数
                const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
                const ownertype = typeof this.ownertype == "string" ? this.ownertype : JSON.stringify(this.ownertype);
                const ownerid = typeof this.ownerid == "string" ? this.ownerid : JSON.stringify(this.ownerid);
                const uploadUrl = 'net-disk/upload/sysopenaccesses?ownertype=' + ownertype + '&ownerid=' + ownerid;
                let formData = new FormData();
                formData.append('file', file);
                formData.append('ownertype', ownertype);
                formData.append('ownerid', ownerid);
                // post请求
                Axios.post(uploadUrl, formData, {timeout: 2000}).then(res => {
                    // 成功回调->uploadSuccess
                    param.onSuccess(res);
                }).catch(err => {
                    // 失败回调->uploadError
                    param.onError(err);
                });
            },
            /**
             * 上传成功的回调
             * @param response
             * @param file
             * @param fileList
             */
            uploadSuccess(response, file, fileList) {
                if (response.data) {
                    // 后端返回的是一个jsonObject
                    const data = response.data;
                    // 刷新上传文件列表
                    this.uploadFileList.push(data);
                    // 需要持久化表单属性到数据库
                    if (this.persistence == true) {
                        // json转字符串给父组件表单对象指定属性
                        this.$emit('formitemvaluechange', {
                            name: this.name,
                            value: JSON.stringify(this.uploadFileList)
                        });
                    }
                } else {
                    // 刷新上传文件列表
                    let files = fileList;
                    this.uploadFileList = files;
                    // 需要持久化表单属性到数据库
                    if (this.persistence == true) {
                        // json转字符串给父组件表单对象指定属性
                        this.$emit('formitemvaluechange', {
                            name: this.name,
                            value: JSON.stringify(this.uploadFileList)
                        });
                    }
                }
            },
            /**
             * 上传失败的回调
             * @param err
             * @param file
             * @param fileList
             */
            uploadError(err, file, fileList) {
                Message.error('文件上传失败,' + err);
            },
            /**
             * 下载文件
             * @param item
             */
            onDownload(item) {
                const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
                const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
                const name = typeof item.name == "string" ? item.name : JSON.stringify(item.name);
                const downloadUrl = `net-disk/download/${folder}/${id}/${name}`;
                Axios.get(downloadUrl, {
                    headers: {
                        authcode: item.authcode
                    },
                }).then(response => {
                    if (!response || response.status != 200) {
                        Message.error("请求当前文件发生错误!");
                        return;
                    }
                }).catch(error => {
                    Message.error("请求当前文件发生错误!" + error);
                });
            },
            /**
             * 预览文件
             * @param item
             */
            onPreview(item) {
                const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
                const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
                const name = typeof item.name == "string" ? item.name : JSON.stringify(item.name);
                const previewUrl = `net-disk/preview/${folder}/${id}/${name}`;
                Axios.get(previewUrl, {
                    headers: {
                        authcode: item.authcode
                    },
                }).then(response => {
                    if (!response || response.status != 200) {
                        Message.error("请求当前文件发生错误!");
                        return;
                    }
                }).catch(error => {
                    Message.error("请求当前文件发生错误!" + error);
                });
            },
            /**
             * 编辑文件
             * @param item
             */
            onEdit(item) {
                const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
                const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
                const name = typeof item.name == "string" ? item.name : JSON.stringify(item.name);
                const editUrl = `net-disk/edit/${folder}/${id}/${name}`;
                Axios.get(editUrl, {
                    headers: {
                        authcode: item.authcode
                    },
                }).then(response => {
                    if (!response || response.status != 200) {
                        Message.error("请求当前文件发生错误!");
                        return;
                    }
                }).catch(error => {
                    Message.error("请求当前文件发生错误!" + error);
                });
            },
            /**
             * ocr识别
             * @param item
             */
            onOcr(item) {
                const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
                const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
                const name = typeof item.name == "string" ? item.name : JSON.stringify(item.name);
                const ocrviewUrl = `net-disk/ocrview/${folder}/${id}/${name}`;
                Axios.get(ocrviewUrl, {
                    headers: {
                        authcode: item.authcode
                    },
                }).then(response => {
                    if (!response || response.status != 200) {
                        Message.error("请求当前文件发生错误!");
                        return;
                    }
                }).catch(error => {
                    Message.error("请求当前文件发生错误!" + error);
                });
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
                        // 从文件列表中删除
                        this.uploadFileList.splice(index, 1);
                        // 需要持久化表单属性到数据库
                        if (this.persistence == true) {
                            // json转字符串给父组件表单对象指定属性
                            this.$emit('formitemvaluechange', {
                                name: this.name,
                                value: JSON.stringify(this.uploadFileList)
                            });
                        }
                        // 提示删除成功
                        Message({
                            type: 'success',
                            message: '删除成功!'
                        });
                    }).catch(() => {
                        Message({
                            type: 'info',
                            message: '已取消删除'
                        });
                    });
                }
            },
            /**
             * 批量更新文件表的fileid
             */
            updateFileBatch() {
                // 当persistence = false时,新建表单保存之后会拿到主键id
                if (this.persistence == false && this.ownerid) {
                    const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
                    const ownertype = typeof this.ownertype == "string" ? this.ownertype : JSON.stringify(this.ownertype);
                    const ownerid = typeof this.ownerid == "string" ? this.ownerid : JSON.stringify(this.ownerid);
                    const url = `net-disk/files/${folder}?ownertype=${ownertype}&ownerid=${ownerid}`;
                    let requestbody = this.uploadFileList;
                    Axios.post(url, requestbody, {
                        timeout: 2000,
                    }).then(res => {
                        if (!res || res.status != 200) {
                            Message.error("批量更新文件失败!");
                            return;
                        }
                    }).catch(error => {
                        Message.error("批量更新文件失败!" + error);
                    });
                }
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