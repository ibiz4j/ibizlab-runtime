import JobsInfo_BO_CN_Base from './jobs-info_BO_CN_base';

function getLocaleResource(){
    const JobsInfo_BO_CN_OwnData = {};
    const targetData = Object.assign(JobsInfo_BO_CN_Base(), JobsInfo_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;