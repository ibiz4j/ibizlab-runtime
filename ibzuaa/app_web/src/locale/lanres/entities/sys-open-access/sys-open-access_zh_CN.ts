import SysOpenAccess_zh_CN_Base from './sys-open-access_zh_CN_base';

function getLocaleResource(){
    const SysOpenAccess_zh_CN_OwnData = {};
    const targetData = Object.assign(SysOpenAccess_zh_CN_Base(), SysOpenAccess_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;