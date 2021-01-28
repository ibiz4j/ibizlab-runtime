import JobsLock_BO_CN_Base from './jobs-lock_BO_CN_base';

function getLocaleResource(){
    const JobsLock_BO_CN_OwnData = {};
    const targetData = Object.assign(JobsLock_BO_CN_Base(), JobsLock_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;