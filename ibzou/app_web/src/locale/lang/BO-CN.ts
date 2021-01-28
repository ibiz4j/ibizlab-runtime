import app_BO_CN_Base from './BO-CN-base';

function getLocaleResource(){
    const app_BO_CN_OwnData = {};
    const targetData = Object.assign(app_BO_CN_Base(), app_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;