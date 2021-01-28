import SysAuthLog_BO_CN_Base from './sys-auth-log_BO_CN_base';

function getLocaleResource(){
    const SysAuthLog_BO_CN_OwnData = {};
    const targetData = Object.assign(SysAuthLog_BO_CN_Base(), SysAuthLog_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;