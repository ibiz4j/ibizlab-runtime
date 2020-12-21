import SysUserRole_zh_CN_Base from './sys-user-role_zh_CN_base';

function getLocaleResource(){
    const SysUserRole_zh_CN_OwnData = {};
    const targetData = Object.assign(SysUserRole_zh_CN_Base(), SysUserRole_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;