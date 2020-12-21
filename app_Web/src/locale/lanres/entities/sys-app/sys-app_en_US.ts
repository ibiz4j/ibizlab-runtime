import SysApp_en_US_Base from './sys-app_en_US_base';

function getLocaleResource(){
    const SysApp_en_US_OwnData = {};
    const targetData = Object.assign(SysApp_en_US_Base(), SysApp_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;