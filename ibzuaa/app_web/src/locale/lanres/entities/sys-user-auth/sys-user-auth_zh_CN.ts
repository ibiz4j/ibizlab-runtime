import SysUserAuth_zh_CN_Base from './sys-user-auth_zh_CN_base';

function getLocaleResource(){
    const SysUserAuth_zh_CN_OwnData = {};
    const targetData = Object.assign(SysUserAuth_zh_CN_Base(), SysUserAuth_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;