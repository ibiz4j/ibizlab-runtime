import SysUserRole_BO_CN_Base from './sys-user-role_BO_CN_base';

function getLocaleResource(){
    const SysUserRole_BO_CN_OwnData = {};
    const targetData = Object.assign(SysUserRole_BO_CN_Base(), SysUserRole_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;