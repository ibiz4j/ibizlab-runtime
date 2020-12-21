import app_en_US_Base from './en-US-base';

function getLocaleResource(){
    const app_en_US_OwnData = {};
    const targetData = Object.assign(app_en_US_Base(), app_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;