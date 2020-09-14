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
                        :action="getAction()"
                        :headers="myHeaders"
                        :file-list="uploadFileList"
                        :show-file-list="false"
                        :limit="limit"
                        :http-request="customUploadFile">
                    <div>
                        <i class="el-icon-upload"></i>
                        <div>
                            <span>{{$t('components.diskFileUpload.fileDrag')}}</span>
                            <span style="color:#409EFF;">{{$t('components.diskFileUpload.clickUpload')}}</span>
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
                        :action="getAction()"
                        :headers="myHeaders"
                        :file-list="uploadFileList"
                        :show-file-list="false"
                        :limit="limit"
                        :http-request="customUploadFile">
                    <el-button type="primary" size="small" icon="el-icon-upload">{{$t('components.diskFileUpload.clickUpload')}}</el-button>
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
                    <el-link type="success" icon="el-icon-download" @click="onDownload(item)">{{$t('components.diskFileUpload.load')}}</el-link>
                    <el-link type="warning" icon="el-icon-view" v-show="showPreview" @click="onPreview(item)">{{$t('components.diskFileUpload.preview')}}
                    </el-link>
                    <el-link type="primary" icon="el-icon-edit"
                             v-show="showEdit && (item.name.match(/^.+\.(doc|DOC|docx|DOCX|wps|WPS|xls|XLS|xlsx|XLSX|ppt|PPT|et|ET)$/))"
                             @click="onEdit(item)">{{$t('components.diskFileUpload.edit')}}
                    </el-link>
                    <el-link icon="el-icon-camera"
                             v-show="showOcrview && (item.name.match(/^.+\.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG|bmp|BMP|pdf|PDF)$/))"
                             @click="onOcr(item)">OCR
                    </el-link>
                    <el-link type="danger" icon="el-icon-delete" @click="onRemove(item,index)">{{$t('components.diskFileUpload.delete')}}</el-link>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script lang="ts">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator';
import {Button, Row, Col, Link, Icon, Upload, Message, MessageBox} from 'element-ui';
import Axios from 'axios';
import {Subject, Unsubscribable} from 'rxjs';

@Component({})
export default class DiskFileUpload extends Vue {

    /**
     * 当前表单对象
     *
     * @type {*}
     * @memberof DiskFileUpload
     */  
    @Prop() public data!: any;

    /**
     * 当前属性名
     *
     * @type {string}
     * @memberof DiskFileUpload
     */  
    @Prop() public formItemName!: string;

    /**
     * 当前属性值
     *
     * @type {string}
     * @memberof DiskFileUpload
     */  
    @Prop() public value!: string;

    /**
     * 当前表单状态
     *
     * @type {*}
     * @memberof DiskFileUpload
     */  
    @Prop() public formState!: any;

    /**
     * 默认为当前实体名称，有指定则按表单参数
     *
     * @type {string}
     * @memberof DiskFileUpload
     */  
    @Prop() public folder!: string;

    /**
     * 默认为当前实体主键id，有指定则按表单参数
     *
     * @type {string}
     * @memberof DiskFileUpload
     */  
    @Prop() public ownerid!: string;

    /**
     * 默认为当前属性名，有指定则按表单参数
     *
     * @type {string}
     * @memberof DiskFileUpload
     */  
    @Prop() public ownertype!: string;

    /**
     * 持久化
     *
     * @type {boolean}
     * @memberof DiskFileUpload
     */  
    @Prop({default: false}) public persistence?: boolean;

    /**
     * 是否显示拖拽区域
     *
     * @type {boolean}
     * @memberof DiskFileUpload
     */  
    @Prop({default: false}) public showDrag?: boolean;

    /**
     * 是否显示预览按钮
     *
     * @type {boolean}
     * @memberof DiskFileUpload
     */  
    @Prop({default: false}) public showPreview?: boolean;

    /**
     * 是否显示在线编辑按钮
     *
     * @type {boolean}
     * @memberof DiskFileUpload
     */  
    @Prop({default: false}) public showEdit?: boolean;

    /**
     * 是否显示OCR按钮
     *
     * @type {boolean}
     * @memberof DiskFileUpload
     */  
    @Prop({default: false}) public showOcrview?: boolean;

    /**
     * 单文件大小
     *
     * @type {number}
     * @memberof DiskFileUpload
     */  
    @Prop({default: 1}) public size!: number;

    /**
     * 文件上传个数
     *
     * @type {number}
     * @memberof DiskFileUpload
     */  
    @Prop({default: 5}) public limit!: number;

    /**
     * 表单是否处于编辑状态（有真实主键,srfuf='1';srfuf='0'时处于新建未保存）
     *
     * @type {string}
     * @memberof DiskFileUpload
     */  
    public srfuf: string = '0';

    /**
     * 上传提示语
     *
     * @type {string}
     * @memberof DiskFileUpload
     */  
    get uploadTip(): string {
       return this.$t('components.diskFileUpload.clues')+this.size.toString()+"M，"+this.$t('components.diskFileUpload.clues1')+this.limit;
    }

    /**
     * 文件列表
     *
     * @type {Array<any>}
     * @memberof DiskFileUpload
     */  
    public uploadFileList: Array<any> = [];

    /**
     * 当前登陆人的token
     *
     * @type {string}
     * @memberof DiskFileUpload
     */  
    public token: string = "Bearer " + localStorage.getItem('token');

    /**
     * 上传文件请求头
     *
     * @type {*}
     * @memberof DiskFileUpload
     */  
    public myHeaders: any = {Authorization: this.token};

    /**
     * 表单状态事件
     *
     * @type {*}
     * @memberof DiskFileUpload
     */  
    public formStateEvent: any | Unsubscribable | undefined;

    /**
     * 批量更新标识，false为不更新，true才可以更新
     *
     * @type {boolean}
     * @memberof DiskFileUpload
     */  
    public isUpdateBatch: boolean = true;

    /**
     * 新建状态标识,true为新建，false为编辑
     *
     * @type {boolean}
     * @memberof DiskFileUpload
     */  
    public isCreate: boolean = true;

    /**
     * 拼接上传路径
     * 
     * @memberof DiskFileUpload
     */
    public getAction() {
        const uploadUrl = '/net-disk/upload/' + this.getFolder() + '?ownertype=' + this.getOwnertype() + '&ownerid=' + this.getOwnerid();
        return uploadUrl;
    }

    /**
     * return folder
     * 
     * @memberof DiskFileUpload
     */
    public getFolder() {
        const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
        return folder;
    }

    /**
     * return ownertype
     * 
     * @memberof DiskFileUpload
     */
    public getOwnertype() {
        const ownertype = typeof this.ownertype == "string" ? this.ownertype : JSON.stringify(this.ownertype);
        return ownertype;
    }

    /**
     * return ownerid
     * 
     * @memberof DiskFileUpload
     */
    public getOwnerid() {
        const ownerid = typeof this.ownerid == "string" ? this.ownerid : JSON.stringify(this.ownerid);
        return ownerid;
    }

    /**
     * 
     * 
     * @memberof DiskFileUpload
     */
    public created(){
        this.formStateEvent = this.formState.subscribe(($event: any) => {
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
    }

    /**
     * 获取文件列表
     * 
     * @memberof DiskFileUpload
     */
    public getFiles(){
            // 拼接url
            let _this:any = this;
            const getUrl = '/net-disk/files/' + this.getFolder();
            // 发送get请求
            Axios.get(getUrl, {
                params: {
                    ownertype: this.getOwnertype(),
                    ownerid: this.getOwnerid(),
                },
            }).then(response => {
                if (!response || response.status != 200) {
                    Message.error(_this.$t('components.diskFileUpload.getFileFailure')+'!');
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
                Message.error(_this.$t('components.diskFileUpload.getFileFailure')+':'+ error);
            });
    }

    /**
     * 自定义上传文件
     * 
     * @param 上传文件
     * @memberof DiskFileUpload
     */
    public customUploadFile(param: any) {
        // 上传的文件
        let _this: any = this;
        let file = param.file;
        // 文件大小
        const isSize = file.size / 1024 / 1024 < this.size;
        if (!isSize) {
            Message.error(_this.$t('components.diskFileUpload.loadFailure1')+_this.size.toString()+"M!");
            return;
        }
        // formData传参
        let formData = new FormData();
        formData.append('file', file);
        // 拼接url
        const uploadUrl = this.getAction();
        // 发送post请求
        Axios.post(uploadUrl, formData, {timeout: 2000}).then(response => {
            if (!response || response.status != 200) {
                Message.error(_this.$t('components.diskFileUpload.loadFailure')+'!');
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
            Message.error(_this.$t('components.diskFileUpload.loadFailure')+':'+ err);
        })
    }

    /**
     * 下载文件
     * 
     * @param item 下载文件
     * @memberof DiskFileUpload
     */
    public onDownload(item: any) {
        // 拼接url
        let _this: any = this;
        const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
        const name = typeof item.name == "string" ? item.name : JSON.stringify(item.filename);
        const downloadUrl = '/net-disk/download/' + this.getFolder() + '/' + id + '/' + name;
        // 发送get请求
        Axios.get(downloadUrl, {
            headers: {
                'authcode': item.authcode
            },
            responseType: 'arraybuffer',
        }).then(response => {
            if (!response || response.status != 200) {
                Message.error(_this.$t('components.diskFileUpload.downloadFile')+'!');
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
                Message.error(_this.$t('components.diskFileUpload.downloadFile1'));
            }
        }).catch(error => {
            Message.error(_this.$t('components.diskFileUpload.downloadFile')+':'+ error);
        });
    }

    /**
     * 预览文件
     * 
     * @param item 预览文件
     * @memberof DiskFileUpload
     */
    public onPreview(item: any) {
        // 拼接url
        const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
        const name = typeof item.name == "string" ? item.name : JSON.stringify(item.name);
        const previewUrl = '/net-disk/preview/' + this.getFolder() + '/' + id + '/' + name + '?authcode=' + item.authcode;
        // 新窗口打开url
        window.open(previewUrl);
    }

    /**
     * 编辑文件
     * 
     * @param item
     * @memberof DiskFileUpload
     */
    public onEdit(item: any) {
        // 拼接url
        const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
        const name = typeof item.name == "string" ? item.name : JSON.stringify(item.name);
        const editUrl = '/net-disk/edit/' + this.getFolder() + '/' + id + '/' + name + '?authcode=' + item.authcode;
        // 新窗口打开url
        window.open(editUrl);
    }

    /**
     * ocr识别
     * @param item
     * @memberof DiskFileUpload
     */
    public onOcr(item: any) {
        // 拼接url
        const folder = typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
        const id = typeof item.id == "string" ? item.id : JSON.stringify(item.id);
        const name = typeof item.name == "string" ? item.name : JSON.stringify(item.name);
        const ocrUrl = '/net-disk/ocrview/' + this.getFolder() + '/' + id + '/' + name + '?authcode=' + item.authcode;
        // 新窗口打开url
        window.open(ocrUrl);
    }

    /**
     * 删除文件
     * 
     * @param item
     * @param index
     * @memberof DiskFileUpload
     */
    public onRemove(item: any, index: number) {
        let _this:any = this;
        if (item) {
            MessageBox.confirm(_this.$t('components.diskFileUpload.deleteFile'), _this.$t('components.diskFileUpload.deleteFilePrompt'), {
                confirmButtonText: _this.$t('components.diskFileUpload.true'),
                cancelButtonText: _this.$t('components.diskFileUpload.false'),
                type: 'warning'
            }).then(() => {
                //　拼接url
                const deleteUrl = '/net-disk/files/' + item.id;
                // 发送delete请求
                Axios.delete(deleteUrl).then(response => {
                    if (!response || response.status != 200) {
                        Message.error(_this.$t('components.diskFileUpload.deleteFileFailure')+'!');
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
                    Message.error(_this.$t('components.diskFileUpload.deleteFileFailure')+':'+ error);
                });
            });
        }
    }

    /**
     * 批量更新文件表的ownerid
     * 
     * @memberof DiskFileUpload
     */
    public updateFileBatch(files: any, opt: any) {
        let _this:any = this;
        // 拼接url
        const updateUrl = '/net-disk/files/' + this.getFolder() + '?ownertype=' + this.getOwnertype() + "&ownerid=" + this.getOwnerid();
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
                Message.error(_this.$t('components.diskFileUpload.updateFailure')+'!');
                return;
            }
        }).catch(error => {
            Message.error(_this.$t('components.diskFileUpload.updateFailure')+':'+ error);
        });
    }
}
</script>
<style lang="less">
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