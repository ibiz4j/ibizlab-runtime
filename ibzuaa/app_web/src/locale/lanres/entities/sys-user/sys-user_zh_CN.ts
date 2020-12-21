import SysUser_zh_CN_Base from './sys-user_zh_CN_base';

function getLocaleResource(){
    const SysUser_zh_CN_OwnData = {};
    const targetData = Object.assign(SysUser_zh_CN_Base(), SysUser_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;