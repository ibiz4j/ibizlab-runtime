import JobsLock_zh_CN_Base from './jobs-lock_zh_CN_base';

function getLocaleResource(){
    const JobsLock_zh_CN_OwnData = {};
    const targetData = Object.assign(JobsLock_zh_CN_Base(), JobsLock_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;