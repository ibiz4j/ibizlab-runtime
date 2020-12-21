import JobsRegistry_zh_CN_Base from './jobs-registry_zh_CN_base';

function getLocaleResource(){
    const JobsRegistry_zh_CN_OwnData = {};
    const targetData = Object.assign(JobsRegistry_zh_CN_Base(), JobsRegistry_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;