import SysUserRole_en_US_Base from './sys-user-role_en_US_base';

function getLocaleResource(){
    const SysUserRole_en_US_OwnData = {};
    const targetData = Object.assign(SysUserRole_en_US_Base(), SysUserRole_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;