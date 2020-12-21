import SysRole_zh_CN_Base from './sys-role_zh_CN_base';

function getLocaleResource(){
    const SysRole_zh_CN_OwnData = {};
    const targetData = Object.assign(SysRole_zh_CN_Base(), SysRole_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;