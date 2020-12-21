import SysAuthLog_en_US_Base from './sys-auth-log_en_US_base';

function getLocaleResource(){
    const SysAuthLog_en_US_OwnData = {};
    const targetData = Object.assign(SysAuthLog_en_US_Base(), SysAuthLog_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;