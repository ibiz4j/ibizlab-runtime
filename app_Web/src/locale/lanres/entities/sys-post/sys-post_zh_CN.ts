import SysPost_zh_CN_Base from './sys-post_zh_CN_base';

function getLocaleResource(){
    const SysPost_zh_CN_OwnData = {};
    const targetData = Object.assign(SysPost_zh_CN_Base(), SysPost_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;