import JobsRegistry_en_US_Base from './jobs-registry_en_US_base';

function getLocaleResource(){
    const JobsRegistry_en_US_OwnData = {};
    const targetData = Object.assign(JobsRegistry_en_US_Base(), JobsRegistry_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;