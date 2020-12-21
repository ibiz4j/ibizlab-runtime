import SysPermission_zh_CN_Base from './sys-permission_zh_CN_base';

function getLocaleResource(){
    const SysPermission_zh_CN_OwnData = {};
    const targetData = Object.assign(SysPermission_zh_CN_Base(), SysPermission_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;