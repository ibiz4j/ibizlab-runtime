import JobsLock_en_US_Base from './jobs-lock_en_US_base';

function getLocaleResource(){
    const JobsLock_en_US_OwnData = {};
    const targetData = Object.assign(JobsLock_en_US_Base(), JobsLock_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;