import SDFile_BO_CN_Base from './sdfile_BO_CN_base';

function getLocaleResource(){
    const SDFile_BO_CN_OwnData = {};
    const targetData = Object.assign(SDFile_BO_CN_Base(), SDFile_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;