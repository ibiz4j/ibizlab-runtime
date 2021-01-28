import components_BO_CN_Base from './components_BO_CN_base';

function getLocaleResource(){
    const components_BO_CN_OwnData = {};
    const targetData = Object.assign(components_BO_CN_Base(), components_BO_CN_OwnData);
    return targetData;
}
export default getLocaleResource;