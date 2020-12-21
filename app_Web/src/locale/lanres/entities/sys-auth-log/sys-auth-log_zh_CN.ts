import SysAuthLog_zh_CN_Base from './sys-auth-log_zh_CN_base';

function getLocaleResource(){
    const SysAuthLog_zh_CN_OwnData = {};
    const targetData = Object.assign(SysAuthLog_zh_CN_Base(), SysAuthLog_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;