import JobsLog_zh_CN_Base from './jobs-log_zh_CN_base';

function getLocaleResource(){
    const JobsLog_zh_CN_OwnData = {};
    const targetData = Object.assign(JobsLog_zh_CN_Base(), JobsLog_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;