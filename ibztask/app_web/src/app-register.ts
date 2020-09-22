import { ViewTool } from './utils/view-tool/view-tool';
import { UIActionTool } from './utils/uiaction-tool/uiaction-tool';
import { Verify } from './utils/verify/verify';
import { Util } from './utils/util/util';
import { Http } from './utils/http/http';
import { exportExcel } from './utils/export/export';
import { AppPopover } from './utils/app-popover/app-popover';
import { AppModal } from './utils/app-modal/app-modal';
import { AppDrawer } from './utils/app-drawer/app-drawer';
import { uiServiceRegister } from '@/uiservice/ui-service-register';
import { authServiceRegister } from '@/authservice/auth-service-register';
import { utilServiceRegister } from '@/utilservice/util-service-register';
import { entityServiceRegister } from '@/service/entity-service-register';
import { counterServiceRegister } from '@/counter/counter-service-register';
import { codeListRegister } from '@codelist/codelist-register';
import { messageServiceRegister } from '@/message/message-service-register';

import InputBox from './components/input-box/input-box.vue'
import AppKeepAlive from './components/app-keep-alive/app-keep-alive.vue'
import TabPageExp from './components/tab-page-exp/tab-page-exp.vue'
import AppLang from './components/app-lang/app-lang.vue'
import AppTheme from './components/app-theme/app-theme.vue'
import AppUser from './components/app-user/app-user.vue'
import AppForm from './components/app-form/app-form.vue'
import APPAutocomplete from './components/app-autocomplete/app-autocomplete.vue'
import AppFormDruipart from './components/app-form-druipart/app-form-druipart.vue'
import DropdownList from './components/dropdown-list/dropdown-list.vue'
import UploadFile from './components/upload-file/upload-file.vue'
import ContextMenuContainer from './components/context-menu-container/context-menu-container.vue'
import AppCheckboxList from './components/app-checkbox-list/app-checkbox-list.vue'
import AppRadioGroup from './components/app-radio-group/app-radio-group.vue'
import AppEmbedPicker from './components/app-embed-picker/app-embed-picker.vue'
import AppTreePicker from './components/app-tree-picker/app-tree-picker.vue'
import AppFileUpload from './components/app-file-upload/app-file-upload.vue'
import AppImageUpload from './components/app-image-upload/app-image-upload.vue'
import PropertyLayout from './components/property-layout/property-layout.vue'
import AppRangeEditor from './components/app-range-editor/app-range-editor.vue'
import AppExportExcel from './components/app-export-excel/app-export-excel.vue'
import AppFormGroup from './components/app-form-group/app-form-group.vue'
import AppFormItem from './components/app-form-item/app-form-item.vue'
import AppPicker from './components/app-picker/app-picker.vue'
import AppMpicker from './components/app-mpicker/app-mpicker.vue'
import AppUpicker from './components/app-upicker/app-upicker.vue'
import AppFormGroup2 from './components/app-form-group2/app-form-group2.vue'
import AppFormItem2 from './components/app-form-item2/app-form-item2.vue'
import CodeList from './components/codelist/codelist.vue'
import AppQuickMenus from './components/app-quick-menus/app-quick-menus.vue'
import AppCheckbox from './components/app-checkbox/app-checkbox.vue'
import AppColumnRender from './components/app-column-render/app-column-render.vue'
import AppPickerSelectView from './components/app-picker-select-view/app-picker-select-view.vue'
import AppSiderMenus from './components/app-sider-menus/app-sider-menus.vue'
import AppSpan from './components/app-span/app-span.vue'
import AppAddressSelection from './components/app-address-selection/app-address-selection.vue'
import DropdownListMpicker  from './components/dropdown-list-mpicker/dropdown-list-mpicker.vue'
import AppRate from './components/app-rate/app-rate.vue'
import AppSwitch from './components/app-switch/app-switch.vue'
import AppSlider from './components/app-slider/app-slider.vue'
import AppStepper from './components/app-stepper/app-stepper.vue'
import DatePickerRange from './components/date-picker-range/date-picker-range.vue'
import AppRangeDate from './components/app-range-date/app-range-date.vue'
import AppActionBar from './components/app-actionbar/app-actionbar.vue'
import AppOrgSector from  './components/app-orgsector/app-orgsector.vue'
import AppBuild from './components/app-build/app-build.vue'
import AppStudioAction from './components/app-studioaction/app-studioaction.vue'
import AppDebugActions from './components/app-debug-actions/app-debug-actions.vue'
import AppHeaderMenus from './components/app-header-menus/app-header-menus.vue'
import AppColumnLink from './components/app-column-link/app-column-link.vue'
import DropDownListDynamic from './components/dropdown-list-dynamic/dropdown-list-dynamic.vue'
import AppImagePreview from './components/app-image-preview/app-image-preview.vue'
import AppFormatData from './components/app-format-data/app-format-data.vue'
import AppUploadFileInfo from './components/app-upload-file-info/app-upload-file-info.vue'
import ContextMenu from './components/context-menu/context-menu'
import AppColumnFormat from './components/app-column-format/app-column-format.vue'
import AppQuickGroup from './components/app-quick-group/app-quick-group.vue'
import AppGroupPicker from './components/app-group-picker/app-group-picker.vue'
import AppWFApproval from './components/app-wf-approval/app-wf-approval.vue'
import Breadcrumb from './components/app-breadcrumb/app-breadcrumb.vue'
import AppTransfer from './components/app-transfer/app-transfer.vue'
import ContextMenuDrag from './components/context-menu-drag/context-menu-drag.vue'
import AppOrgSelect from './components/app-org-select/app-org-select.vue'
import AppDepartmentSelect from './components/app-department-select/app-department-select.vue'
import AppGroupSelect from './components/app-group-select/app-group-select.vue'
import UpdatePwd from './components/app-update-password/app-update-password.vue'
import AppMenuItem from './components/app-menu-item/app-menu-item.vue'
import AppFullScren from './components/app-full-scren/app-full-scren.vue'
import AppLockScren from './components/app-lock-scren/app-lock-scren.vue'
import ActionTimeline from './components/action-timeline/action-timeline.vue'
import CronEditor from './components/cron-editor/cron-editor.vue'
import AppMessagePopover from './components/app-message-popover/app-message-popover.vue'
import AppPanelField from './components/app-panel-field/app-panel-field.vue'
import AppPanelButton from './components/app-panel-button/app-panel-button.vue'
import AppDepartmentPersonnel from './components/app-department-personnel/app-department-personnel.vue'
import DiskFileUpload from './components/disk-file-upload/disk-file-upload.vue'
import AvueCustomForm  from './components/avue-custom-form/avue-custom-form.vue'
import DiskImageUpload from './components/disk-image-upload/disk-image-upload.vue'
import AppFormPart from './components/app-form-part/app-form-part.vue'
import AppAlert from './components/app-alert/app-alert.vue'
import AppAlertGroup from './components/app-alert-group/app-alert-group.vue'
import AppRawItem from './components/app-rawitem/app-rawitem.vue'

// 全局挂载UI实体服务注册中心
window['uiServiceRegister'] = uiServiceRegister;
// 全局挂载实体权限服务注册中心
window['authServiceRegister'] = authServiceRegister;
// 全局挂载功能服务注册中心
window['utilServiceRegister'] = utilServiceRegister;
// 全局挂载数据服务注册中心
window['entityServiceRegister'] = entityServiceRegister;
// 全局挂载计数器服务注册中心
window['counterServiceRegister'] = counterServiceRegister;
// 全局挂载代码表服务注册中心
window['codeListRegister'] = codeListRegister;
// 全局挂载视图消息服务注册中心
window['messageServiceRegister'] = messageServiceRegister;

export const AppComponents = {
    install(v: any, opt: any) {
        v.prototype.$appdrawer = AppDrawer.getInstance();
        v.prototype.$appmodal = AppModal.getInstance();
        v.prototype.$apppopover = AppPopover.getInstance();
        v.prototype.$http = Http.getInstance();
        v.prototype.$export = exportExcel.getInstance();
        v.prototype.$util = Util;
        v.prototype.$verify = Verify;
        v.prototype.$viewTool = ViewTool;
        v.prototype.$uiActionTool = UIActionTool;
        v.component('app-department-personnel',AppDepartmentPersonnel);
        v.component('app-panel-button',AppPanelButton);
        v.component('app-panel-field',AppPanelField);
        v.component('app-full-scren',AppFullScren);
        v.component('app-lock-scren',AppLockScren);
        v.component('input-box', InputBox);
        v.component('app-keep-alive',AppKeepAlive);
        v.component('tab-page-exp',TabPageExp);
        v.component('app-lang',AppLang);
        v.component('app-theme',AppTheme);
        v.component('app-user',AppUser);
        v.component('app-form', AppForm);
        v.component('app-autocomplete', APPAutocomplete);
        v.component('app-form-druipart', AppFormDruipart);
        v.component('dropdown-list', DropdownList);
        v.component('upload-file', UploadFile);
        v.component('context-menu-container', ContextMenuContainer);
        v.component('app-checkbox-list',AppCheckboxList);
        v.component('app-radio-group',AppRadioGroup);
        v.component('app-embed-picker', AppEmbedPicker);
        v.component('app-tree-picker', AppTreePicker);
        v.component('app-rich-text-editor', () => import('./components/app-rich-text-editor/app-rich-text-editor.vue'));
        v.component('app-file-upload',AppFileUpload);
        v.component('app-image-upload',AppImageUpload);
        v.component('property-layout',PropertyLayout);
        v.component('app-range-editor',AppRangeEditor);
        v.component('app-export-excel',AppExportExcel);
        v.component('app-form-group',AppFormGroup);
        v.component('app-form-item',AppFormItem);
        v.component('app-picker', AppPicker);
        v.component('app-mpicker', AppMpicker);
        v.component('app-upicker', AppUpicker);
        v.component('app-form-group2', AppFormGroup2);
        v.component('app-form-item2', AppFormItem2);
        v.component('codelist', CodeList);
        v.component('app-quick-menus', AppQuickMenus);
        v.component('app-checkbox',AppCheckbox);
        v.component('app-column-render',AppColumnRender);
        v.component('app-picker-select-view',AppPickerSelectView);
        v.component('app-sider-menus',AppSiderMenus);
        v.component('app-span', AppSpan);
        v.component('app-address-selection', AppAddressSelection);
        v.component('dropdown-list-mpicker', DropdownListMpicker);
        v.component('app-rate', AppRate);
        v.component('app-switch', AppSwitch);
        v.component('app-slider', AppSlider);
        v.component('app-stepper', AppStepper);
        v.component('app-portal-design', () => import('./components/app-portal-design/app-portal-design.vue'));
        v.component('date-picker-range',DatePickerRange);
        v.component('app-range-date', AppRangeDate);
        v.component('app-actionbar', AppActionBar);
        v.component('app-orgsector', AppOrgSector);
        v.component('app-build', AppBuild);
        v.component('app-studioaction', AppStudioAction);
        v.component('app-debug-actions', AppDebugActions);
        v.component('app-header-menus', AppHeaderMenus);
        v.component('app-column-link', AppColumnLink);
        v.component('app-data-upload', () => import('./components/app-data-upload/app-data-upload.vue'));
        v.component('dropdown-list-dynamic', DropDownListDynamic);
        v.component('app-image-preview', AppImagePreview);
        v.component('app-format-data', AppFormatData);
        v.component('app-upload-file-info', AppUploadFileInfo);
        v.component('context-menu',ContextMenu);
        v.component('app-column-format',AppColumnFormat);
        v.component('app-quick-group',AppQuickGroup);
        v.component('app-org-select',AppOrgSelect);
        v.component('app-department-select',AppDepartmentSelect);
        v.component('app-group-select',AppGroupSelect);
        v.component('app-group-picker',AppGroupPicker);
        v.component('app-wf-approval',AppWFApproval);
        v.component('app-breadcrumb',Breadcrumb);
        v.component('app-transfer',AppTransfer);
        v.component('context-menu-drag',ContextMenuDrag);
        v.component('app-update-password',UpdatePwd);
        v.component('app-menu-item', AppMenuItem);
        v.component('action-timeline', ActionTimeline);
        v.component('cron-editor', CronEditor);
        v.component('app-message-popover', AppMessagePopover);
        v.component('disk-file-upload', DiskFileUpload);
        v.component('avue-custom-form', AvueCustomForm);
        v.component('disk-image-upload', DiskImageUpload);
        v.component('app-form-part', AppFormPart);
        v.component('app-alert', AppAlert);
        v.component('app-alert-group', AppAlertGroup);
        v.component('app-rawitem',AppRawItem);
    },
};