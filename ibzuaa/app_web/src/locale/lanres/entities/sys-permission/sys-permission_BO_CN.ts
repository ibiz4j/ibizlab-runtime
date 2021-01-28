import SysPermission_BO_CN_Base from './sys-permission_BO_CN_base';

function getLocaleResource(){
    const SysPermission_BO_CN_OwnData = {};
    const targetData = Object.assign(SysPermission_BO_CN_Base(), SysPermission_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;