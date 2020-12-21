import SDFile_en_US_Base from './sdfile_en_US_base';

function getLocaleResource(){
    const SDFile_en_US_OwnData = {};
    const targetData = Object.assign(SDFile_en_US_Base(), SDFile_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;