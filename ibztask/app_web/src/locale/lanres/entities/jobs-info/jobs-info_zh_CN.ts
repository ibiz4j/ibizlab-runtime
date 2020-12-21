import JobsInfo_zh_CN_Base from './jobs-info_zh_CN_base';

function getLocaleResource(){
    const JobsInfo_zh_CN_OwnData = {};
    const targetData = Object.assign(JobsInfo_zh_CN_Base(), JobsInfo_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;