import SysApp_BO_CN_Base from './sys-app_BO_CN_base';

function getLocaleResource(){
    const SysApp_BO_CN_OwnData = {};
    const targetData = Object.assign(SysApp_BO_CN_Base(), SysApp_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;