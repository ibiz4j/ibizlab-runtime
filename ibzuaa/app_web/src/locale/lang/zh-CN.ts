import app_zh_CN_Base from './zh-CN-base';

function getLocaleResource(){
    const app_zh_CN_OwnData = {};
    const targetData = Object.assign(app_zh_CN_Base(), app_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;