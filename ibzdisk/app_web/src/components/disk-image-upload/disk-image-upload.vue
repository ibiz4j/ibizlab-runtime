<template>
    <div id="image-upload">
        <el-upload
                ref="imageUpload"
                multiple
                :file-list="imageList"
                list-type="picture-card"
                :action="getAction()"
                :headers="myHeaders"
                :before-upload="beforeUpload"
                :http-request="customImageUpload">
            <i class="el-icon-plus"></i>
            <div slot="file" slot-scope="{file,index}">
                <img class="el-upload-list__item-thumbnail" :src="file.url">
                <span class="el-upload-list__item-actions">
                    <!--预览按钮-->
                    <span class="el-upload-list__item-preview" @click="onPreview(file)"
                          :title="$t('components.diskImageUpload.preview')"
                          v-show="showPreview">
                        <i class="el-icon-view"></i>
                    </span>
                    <!--OCR按钮-->
                    <span class="el-upload-list__item-delete" @click="onOcr(file)"
                          :title="$t('components.diskImageUpload.OCRdiscern')"
                          v-show="showOcrview && (file.name.match(/^.+\.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG|bmp|BMP)$/))">
                      <i class="el-icon-camera"></i>
                    </span>
                    <!--下载按钮-->
                    <span class="el-upload-list__item-delete" @click="onDownload(file)"
                          :title="$t('components.diskImageUpload.load')">
                      <i class="el-icon-download"></i>
                    </span>
                    <!--删除按钮-->
                    <span class="el-upload-list__item-delete" @click="onRemove(file)"
                          :title="$t('components.diskImageUpload.delete')">
                      <i class="el-icon-delete"></i>
                    </span>
              </span>
            </div>
        </el-upload>
        <!-- 预览弹框 -->
        <el-dialog :visible.sync="dialogVisible" :modal="false">
            <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
        <!-- 自定义弹框 -->
        <div class="dialogDiv">
            <el-dialog
                    :title="dialogTitle"
                    center
                    width="70%"
                    top="5vh"
                    :visible="showDialog"
                    :close-on-click-modal="true"
                    :show-close="true"
                    :before-close="dialogClose"
                    :modal-append-to-body="false">
                <div style="height: 100%;">
                    <iframe id="fileIframe" :src="iframeUrl" frameborder="0" width="100%"></iframe>
                </div>
            </el-dialog>
        </div>
    </div>
</template>

<script lang="ts">
    import {Component, Vue, Prop, Watch} from 'vue-property-decorator';
    import {Message, MessageBox} from 'element-ui';
    import Axios from 'axios';
    import {Subject, Unsubscribable} from 'rxjs';

    @Component({})
    export default class DiskImageUplaod extends Vue {

        /**
         * 当前表单对象
         *
         * @type {*}
         * @memberof DiskImageUplaod
         */
        @Prop() public data!: any;

        /**
         * 当前属性名
         *
         * @type {string}
         * @memberof DiskImageUplaod
         */
        @Prop() public formItemName!: string;

        /**
         * 当前属性值
         *
         * @type {string}
         * @memberof DiskImageUplaod
         */
        @Prop() public value!: string;

        /**
         * 当前表单状态
         *
         * @type {*}
         * @memberof DiskImageUplaod
         */
        @Prop() public formState!: any;

        /**
         * 默认为当前实体名称，有指定则按表单参数
         *
         * @type {string}
         * @memberof DiskImageUplaod
         */
        @Prop() public folder!: string;

        /**
         * 默认为当前实体主键id，有指定则按表单参数
         *
         * @type {string}
         * @memberof DiskImageUplaod
         */
        @Prop() public ownerid!: string;

        /**
         * 默认为当前属性名，有指定则按表单参数
         *
         * @type {string}
         * @memberof DiskImageUplaod
         */
        @Prop() public ownertype!: string;

        /**
         * 持久化
         *
         * @type {boolean}
         * @memberof DiskImageUplaod
         */
        @Prop({default: false}) public persistence?: boolean;

        /**
         * 是否显示预览按钮
         *
         * @type {boolean}
         * @memberof DiskImageUplaod
         */
        @Prop({default: false}) public showPreview?: boolean;


        /**
         * 是否显示OCR按钮
         *
         * @type {boolean}
         * @memberof DiskImageUplaod
         */
        @Prop({default: false}) public showOcrview?: boolean;


        /**
         * 表单是否处于编辑状态（有真实主键,srfuf='1';srfuf='0'时处于新建未保存）
         *
         * @type {string}
         * @memberof DiskImageUplaod
         */
        public srfuf: string = '0';

        /**
         * 图片列表
         *
         * @type {Array<any>}
         * @memberof DiskImageUplaod
         */
        public imageList: Array<any> = [];

        /**
         * 当前登陆人的token
         *
         * @type {string}
         * @memberof DiskImageUplaod
         */
        public token: string = "Bearer " + localStorage.getItem('token');

        /**
         * 上传文件请求头
         *
         * @type {*}
         * @memberof DiskImageUplaod
         */
        public myHeaders: any = {Authorization: this.token};

        /**
         * 表单状态事件
         *
         * @type {*}
         * @memberof DiskImageUplaod
         */
        public formStateEvent: any | Unsubscribable | undefined;

        /**
         * 批量更新标识，false为不更新，true才可以更新
         *
         * @type {boolean}
         * @memberof DiskImageUplaod
         */
        public isUpdateBatch: boolean = true;

        /**
         * 新建状态标识,true为新建，false为编辑
         *
         * @type {boolean}
         * @memberof DiskImageUplaod
         */
        public isCreate: boolean = true;

        /**
         * 预览弹出框显示标识，true显示，false隐藏
         *
         * @type {boolean}
         * @memberof DiskImageUplaod
         */
        public dialogVisible: boolean = false;

        /**
         * 预览弹出框中的图片地址
         *
         * @type {string}
         * @memberof DiskImageUplaod
         */
        public dialogImageUrl: string = '';

        /**
         * 存放图片的fileid,用于图片列表定位
         *
         * @type {boolean}
         * @memberof DiskImageUplaod
         */
        public imageFileids: Array<any> = [];

        /**
         * 自定义弹框标题
         *
         * @type {*}
         * @memberof DiskImageUplaod
         */
        public dialogTitle: any = '';

        /**
         * 是否显示自定义弹框
         *
         * @type {boolean}
         * @memberof DiskImageUplaod
         */
        public showDialog: boolean = false;

        /**
         * 嵌入自定义弹框中iframe的url
         *
         * @type {*}
         * @memberof DiskImageUplaod
         */
        public iframeUrl: any = '';

        /**
         * 关闭自定义弹框
         *
         * @memberof DiskImageUplaod
         */
        public dialogClose() {
            this.dialogTitle = '';
            this.showDialog = false;
            this.iframeUrl = '';
            let iframe: any = document.getElementById("fileIframe");
            iframe.parentNode.removeChild("fileIframe");
        }

        /**
         * 拼接上传路径
         *
         * @memberof DiskImageUplaod
         */
        public getAction() {
            return '/net-disk/upload/' + this.getFolder() + '?ownertype=' + this.getOwnertype() + '&ownerid=' + this.getOwnerid();
        }

        /**
         * return folder
         *
         * @memberof DiskImageUplaod
         */
        public getFolder() {
            return typeof this.folder == "string" ? this.folder : JSON.stringify(this.folder);
        }

        /**
         * return ownertype
         *
         * @memberof DiskImageUplaod
         */
        public getOwnertype() {
            return typeof this.ownertype == "string" ? this.ownertype : JSON.stringify(this.ownertype);
        }

        /**
         * return ownerid
         *
         * @memberof DiskImageUplaod
         */
        public getOwnerid() {
            return typeof this.ownerid == "string" ? this.ownerid : JSON.stringify(this.ownerid);
        }

        /**
         * vue创建
         *
         * @memberof DiskImageUplaod
         */
        public created() {
            this.formStateEvent = this.formState.subscribe(($event: any) => {
                // 表单加载完成
                if (Object.is($event.type, 'load')) {
                    const data = JSON.parse(JSON.stringify($event.data));
                    // 编辑表单，保存时不进行批量更新
                    if (data.srfuf == '1') {
                        this.isCreate = false;
                        this.isUpdateBatch = false;
                    }
                    // 当persistence = true时,表单持久化
                    if (this.persistence == true) {
                        // 直接从表单的data数据里获取当前属性的值
                        if (data[this.formItemName] && this.imageList.length == 0) {
                            const files = JSON.parse(data[this.formItemName]);
                            files.forEach((item: any, i: number) => {
                                // 图片列表显示缩略图需要获取真实的图片信息
                                if (item.id && item.name) {
                                    this.getRealImageData(item);
                                }
                            });
                        }
                    } else {
                        // 发送get请求获取图片列表
                        this.getFiles();
                    }
                }
                // 表单保存完成
                if (Object.is($event.type, 'save')) {
                    // 批量更新文件表中的ownerid
                    if (this.isUpdateBatch == true && this.imageList.length > 0) {
                        this.updateFileBatch(this.imageList);
                    }
                }
            });
        }

        /**
         * 获取图片列表
         *
         * @memberof DiskImageUplaod
         */
        public getFiles() {
            // 拼接url
            let _this: any = this;
            const getUrl = '/net-disk/files/' + this.getFolder();
            // 发送get请求
            Axios.get(getUrl, {
                params: {
                    ownertype: this.getOwnertype(),
                    ownerid: this.getOwnerid(),
                },
            }).then((response: any) => {
                if (!response || response.status != 200) {
                    Message.error(_this.$t('components.diskImageUpload.getImageFailure') + "!");
                    return;
                }
                // 返回的是一个jsonArray
                if (response.data) {
                    const files = JSON.parse(JSON.stringify(response.data));
                    if (this.imageList.length == 0) {
                        files.forEach((item: any, i: number) => {
                            // 图片列表显示缩略图需要获取真实的图片信息
                            if (item.id && item.name) {
                                this.getRealImageData(item);
                            }
                        });
                    }
                }
            }).catch((error: any) => {
                Message.error(_this.$t('components.diskImageUpload.getImageFailure') + ':' + error);
            });
        }

        /**
         * 获取真实的图片信息
         * @param file
         * @memberof DiskImageUplaod
         */
        public getRealImageData(file: any) {
            let fileData = file;
            let _this: any = this;
            // 拼接url，与下载一致
            const downloadUrl = '/net-disk/download/' + this.getFolder() + '/' + fileData.id + '/' + fileData.name;
            // 发送get请求
            Axios.get(downloadUrl, {
                headers: {
                    'authcode': fileData.authcode
                },
                responseType: 'blob',
            }).then((response: any) => {
                if (!response || response.status != 200) {
                    Message.error(_this.$t('components.diskImageUpload.loadImageFailure') + '!');
                }
                // 请求成功，后台返回的是一个文件流
                if (response.data) {
                    // 用blob对象获取文件流
                    var blob = new Blob([response.data], {type: response.headers['content-type']});
                    // 通过文件流创建下载链接
                    var href = URL.createObjectURL(blob);
                    // 将下载链接保存到图片中
                    fileData.url = href;
                    // 保存图片fileid
                    if (fileData.fileid) {
                        this.imageFileids.push(fileData.fileid);
                    } else if (fileData.id) {
                        this.imageFileids.push(fileData.id);
                    } else {
                        Message.error(_this.$t('components.diskImageUpload.ImageIdNone'));
                        return;
                    }
                    // 保存图片到图片列表进行显示
                    this.imageList.push(fileData);
                } else {
                    Message.error(_this.$t('components.diskImageUpload.loadImageFailure1'));
                }
            }).catch((error: any) => {
                Message.error(_this.$t('components.diskImageUpload.loadImageFailure') + ':' + error);
            });
        }

        /**
         * 上传之前
         * @param file
         * @memberof DiskImageUplaod
         */
        public beforeUpload(file: any) {
            // 支持上传的图片格式
            let _this: any = this;
            if (!file.name.match(/^.+\.(gif|GIF|jpg|JPG|jpeg|JPEG|png|PNG|bmp|BMP)$/)) {
                Message.error(_this.$t('components.diskImageUpload.uploadImageFailure1'));
                return false;
            }
        }

        /**
         * 自定义图片上传
         * @param param
         * @memberof DiskImageUplaod
         */
        public customImageUpload(param: any) {
            let _this: any = this;
            // 上传的文件
            let file = param.file;
            // formData传参
            let formData = new FormData();
            formData.append('file', file);
            // 拼接url
            const uploadUrl = this.getAction();
            // 发送post请求
            Axios.post(uploadUrl, formData, {timeout: 2000}).then((response: any) => {
                if (!response || response.status != 200) {
                    Message.error(_this.$t('components.diskImageUpload.uploadImageFailure') + "!");
                }
                // 返回的是一个jsonobject
                if (response.data) {
                    let returnData = response.data;
                    // 拼接缩略图下载url
                    const downloadUrl = '/net-disk/download/' + this.getFolder() + '/' + returnData.id + '/' + returnData.name;
                    // 发送get请求
                    Axios.get(downloadUrl, {
                        headers: {
                            'authcode': returnData.authcode
                        },
                        responseType: 'blob',
                    }).then((response2) => {
                        if (!response2 || response2.status != 200) {
                            Message.error(_this.$t('components.diskImageUpload.loadImageFailure') + "!");
                            return;
                        }
                        // 请求成功，后台返回的是一个文件流
                        if (response2.data) {
                            // 用blob对象获取文件流
                            var blob = new Blob([response2.data], {type: response2.headers['content-type']});
                            // 通过文件流创建下载链接
                            var href = URL.createObjectURL(blob);
                            // 将下载链接保存到本次上传成功后返回的jsonobject中
                            returnData.url = href;
                            // 保存jsonobject中的图片fileid
                            if (returnData.fileid) {
                                this.imageFileids.push(returnData.fileid);
                            } else if (returnData.id) {
                                this.imageFileids.push(returnData.id);
                            } else {
                                Message.error(_this.$t('components.diskImageUpload.ImageIdNone'));
                                return;
                            }
                            // 保存jsonobject到图片列表进行显示
                            this.imageList.push(returnData);
                            // 新建表单上传时，后续需要批量更新操作
                            if (this.isCreate == true) {
                                this.isUpdateBatch = true;
                            }
                            // persistence=true时，需要持久化表单属性
                            if (this.persistence == true && this.imageList.length > 0) {
                                const value = JSON.stringify(this.imageList);
                                this.$emit('formitemvaluechange', {name: this.formItemName, value: value});
                            }
                        } else {
                            Message.error(_this.$t('components.diskImageUpload.loadImageFailure1'));
                        }
                    }).catch((error2: any) => {
                        Message.error(_this.$t('components.diskImageUpload.loadImageFailure') + ':' + error2);
                    });
                }
            }).catch((error: any) => {
                Message.error(_this.$t('components.diskImageUpload.uploadImageFailure') + ':' + error);
            });
        }


        /**
         *　预览
         * @param file
         * @memberof DiskImageUplaod
         */
        public onPreview(file: any) {
            let _this: any = this;
            if (file.url) {
                this.dialogImageUrl = file.url;
                this.dialogVisible = true;
            } else {
                Message.error(_this.$t('components.diskImageUpload.notImageUrl'));
            }
        }

        /**
         * Ocr识别
         * @param file
         * @memberof DiskImageUplaod
         */
        public onOcr(file: any) {
            // 拼接url
            const id = typeof file.id == "string" ? file.id : JSON.stringify(file.id);
            const name = typeof file.name == "string" ? file.name : JSON.stringify(file.name);
            const ocrUrl = '/net-disk/ocrview/' + this.getFolder() + '/' + id + '/' + name + '?authcode=' + file.authcode;
            Axios.get(ocrUrl).then((response: any) => {
                if (!response || response.status != 200) {
                    return;
                }
                // 返回一个url，通过自定义弹框打开
                if (response.data) {
                    this.dialogTitle = name;
                    this.showDialog = true;
                    this.iframeUrl = response.data;
                }
            }).catch((error: any) => {
                Message.error(error);
            });
        }

        /**
         * 下载
         * @param file
         * @memberof DiskImageUplaod
         */
        public onDownload(file: any) {
            // 拼接url
            let _this: any = this;
            const id = typeof file.id == "string" ? file.id : JSON.stringify(file.id);
            const name = typeof file.name == "string" ? file.name : JSON.stringify(file.filename);
            const downloadUrl = '/net-disk/download/' + this.getFolder() + '/' + id + '/' + name;
            // 发送get请求
            Axios.get(downloadUrl, {
                headers: {
                    'authcode': file.authcode
                },
                responseType: 'blob',
            }).then((response: any) => {
                if (!response || response.status != 200) {
                    Message.error(_this.$t('components.diskImageUpload.loadImageFailure2') + '!');
                    return;
                }
                // 请求成功，后台返回的是一个文件流
                if (response.data) {
                    // 获取文件名
                    const disposition = response.headers['content-disposition'];
                    const filename = disposition.split('filename=')[1];
                    // 用blob对象获取文件流
                    var blob = new Blob([response.data], {type: response.headers['content-type']});
                    // 通过文件流创建下载链接
                    var href = URL.createObjectURL(blob);
                    // 创建一个a元素并设置相关属性
                    var a = document.createElement('a');
                    a.href = href;
                    if (name) {
                        a.download = name;
                    } else {
                        a.download = filename;
                    }
                    // 添加a元素到当前网页
                    document.body.appendChild(a);
                    // 触发a元素的点击事件，实现下载
                    a.click();
                    // 下载完成，从当前网页移除a元素
                    document.body.removeChild(a);
                    // 释放blob对象
                    URL.revokeObjectURL(href);
                } else {
                    Message.error(_this.$t('components.diskImageUpload.loadImageFailure3'));
                }
            }).catch((error: any) => {
                Message.error(_this.$t('components.diskImageUpload.loadImageFailure2') + ':' + error);
            });
        }


        /**
         * 删除
         * @param file
         * @memberof DiskImageUplaod
         */
        public onRemove(file: any) {
            let _this: any = this;
            if (file) {
                MessageBox.confirm(_this.$t('components.diskImageUpload.deleteFile'), _this.$t('components.diskImageUpload.deleteFilePrompt'), {
                    confirmButtonText: _this.$t('components.diskImageUpload.true'),
                    cancelButtonText: _this.$t('components.diskImageUpload.false'),
                    type: 'warning'
                }).then(() => {
                    if (this.imageFileids.indexOf(file.id) != -1) {
                        // 要删除的图片在图片列表中的下标
                        const index = this.imageFileids.indexOf(file.id);
                        //　拼接url
                        const deleteUrl = '/net-disk/files/' + file.id;
                        // 发送delete请求
                        Axios.delete(deleteUrl).then((response: any) => {
                            if (!response || response.status != 200) {
                                Message.error(_this.$t('components.diskImageUpload.deleteImageFailure') + '!');
                            }
                            // 从fileid数组中删除
                            this.imageFileids.splice(index, 1);
                            // 从图片列表中删除
                            this.imageList.splice(index, 1);
                            // persistence=true,时需要持久化表单属性
                            if (this.persistence == true) {
                                const value = JSON.stringify(this.imageList);
                                this.$emit('formitemvaluechange', {name: this.formItemName, value: value});
                            }
                        }).catch((error: any) => {
                            // 提示删除失败
                            Message.error(_this.$t('components.diskImageUpload.deleteImageFailure') + ':' + error);
                        });
                    }
                });
            }
        }


        /**
         * 批量更新文件表的ownerid
         * @param files
         * @memberof DiskImageUplaod
         */
        public updateFileBatch(files: any) {
            let _this: any = this;
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
            }).then((response: any) => {
                if (!response || response.status != 200) {
                    Message.error(_this.$t('components.diskImageUpload.updateFailure') + '!');
                    return;
                }
            }).catch((error: any) => {
                Message.error(_this.$t('components.diskImageUpload.updateFailure') + ':' + error);
            });
        }


    }
</script>

<style lang="less">
    .dialogDiv {
        // el-dialog头部
        .el-dialog__header {
            height: 40px;
        }

        // el-dialog面板
        .el-dialog__wrapper {
            height: 90vh;
            overflow: visible;
        }

        // el-dialog
        .el-dialog {
            height: 100%;
        }

        // el-dailog内容
        .el-dialog__body {
            height: inherit;
        }

        // iframe
        #fileIframe {
            height: calc(100% - 40px);
        }
    }
</style>