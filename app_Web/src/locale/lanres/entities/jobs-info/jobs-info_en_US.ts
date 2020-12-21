import JobsInfo_en_US_Base from './jobs-info_en_US_base';

function getLocaleResource(){
    const JobsInfo_en_US_OwnData = {};
    const targetData = Object.assign(JobsInfo_en_US_Base(), JobsInfo_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;