import SysPermission_en_US_Base from './sys-permission_en_US_base';

function getLocaleResource(){
    const SysPermission_en_US_OwnData = {};
    const targetData = Object.assign(SysPermission_en_US_Base(), SysPermission_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;