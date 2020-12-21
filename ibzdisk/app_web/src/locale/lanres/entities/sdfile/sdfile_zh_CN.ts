import SDFile_zh_CN_Base from './sdfile_zh_CN_base';

function getLocaleResource(){
    const SDFile_zh_CN_OwnData = {};
    const targetData = Object.assign(SDFile_zh_CN_Base(), SDFile_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;