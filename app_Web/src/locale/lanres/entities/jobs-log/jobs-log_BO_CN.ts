import JobsLog_BO_CN_Base from './jobs-log_BO_CN_base';

function getLocaleResource(){
    const JobsLog_BO_CN_OwnData = {};
    const targetData = Object.assign(JobsLog_BO_CN_Base(), JobsLog_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;