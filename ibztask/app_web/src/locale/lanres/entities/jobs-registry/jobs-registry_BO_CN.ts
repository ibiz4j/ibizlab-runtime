import JobsRegistry_BO_CN_Base from './jobs-registry_BO_CN_base';

function getLocaleResource(){
    const JobsRegistry_BO_CN_OwnData = {};
    const targetData = Object.assign(JobsRegistry_BO_CN_Base(), JobsRegistry_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;