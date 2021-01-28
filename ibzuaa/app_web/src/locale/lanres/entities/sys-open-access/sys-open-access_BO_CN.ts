import SysOpenAccess_BO_CN_Base from './sys-open-access_BO_CN_base';

function getLocaleResource(){
    const SysOpenAccess_BO_CN_OwnData = {};
    const targetData = Object.assign(SysOpenAccess_BO_CN_Base(), SysOpenAccess_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;