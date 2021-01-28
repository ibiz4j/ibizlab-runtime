import SysUserAuth_BO_CN_Base from './sys-user-auth_BO_CN_base';

function getLocaleResource(){
    const SysUserAuth_BO_CN_OwnData = {};
    const targetData = Object.assign(SysUserAuth_BO_CN_Base(), SysUserAuth_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;