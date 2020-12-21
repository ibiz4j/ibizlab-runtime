import components_zh_CN_Base from './components_zh_CN_base';

function getLocaleResource(){
    const components_zh_CN_OwnData = {};
    const targetData = Object.assign(components_zh_CN_Base(), components_zh_CN_OwnData);
    return targetData;
}
export default getLocaleResource;