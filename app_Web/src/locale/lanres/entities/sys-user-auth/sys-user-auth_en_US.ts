import SysUserAuth_en_US_Base from './sys-user-auth_en_US_base';

function getLocaleResource(){
    const SysUserAuth_en_US_OwnData = {};
    const targetData = Object.assign(SysUserAuth_en_US_Base(), SysUserAuth_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;