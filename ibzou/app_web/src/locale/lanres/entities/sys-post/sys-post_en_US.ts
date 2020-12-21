import SysPost_en_US_Base from './sys-post_en_US_base';

function getLocaleResource(){
    const SysPost_en_US_OwnData = {};
    const targetData = Object.assign(SysPost_en_US_Base(), SysPost_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;