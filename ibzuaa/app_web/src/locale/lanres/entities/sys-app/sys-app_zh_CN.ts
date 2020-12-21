import SysApp_zh_CN_Base from './sys-app_zh_CN_base';

function getLocaleResource(){
    const SysApp_zh_CN_OwnData = {};
    const targetData = Object.assign(SysApp_zh_CN_Base(), SysApp_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;