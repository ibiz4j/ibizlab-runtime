import SysPost_BO_CN_Base from './sys-post_BO_CN_base';

function getLocaleResource(){
    const SysPost_BO_CN_OwnData = {};
    const targetData = Object.assign(SysPost_BO_CN_Base(), SysPost_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;