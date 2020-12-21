import JobsLog_en_US_Base from './jobs-log_en_US_base';

function getLocaleResource(){
    const JobsLog_en_US_OwnData = {};
    const targetData = Object.assign(JobsLog_en_US_Base(), JobsLog_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;