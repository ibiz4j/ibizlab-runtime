import SysUser_en_US_Base from './sys-user_en_US_base';

function getLocaleResource(){
    const SysUser_en_US_OwnData = {};
    const targetData = Object.assign(SysUser_en_US_Base(), SysUser_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;