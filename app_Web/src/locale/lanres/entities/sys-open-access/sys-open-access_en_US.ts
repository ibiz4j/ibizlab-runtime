import SysOpenAccess_en_US_Base from './sys-open-access_en_US_base';

function getLocaleResource(){
    const SysOpenAccess_en_US_OwnData = {};
    const targetData = Object.assign(SysOpenAccess_en_US_Base(), SysOpenAccess_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;