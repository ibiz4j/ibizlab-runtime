import components_en_US_Base from './components_en_US_base';

function getLocaleResource(){
    const components_en_US_OwnData = {};
    const targetData = Object.assign(components_en_US_Base(), components_en_US_OwnData);
    return targetData;
}
export default getLocaleResource;