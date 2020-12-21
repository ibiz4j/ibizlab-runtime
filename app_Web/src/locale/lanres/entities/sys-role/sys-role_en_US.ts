import SysRole_en_US_Base from './sys-role_en_US_base';

function getLocaleResource(){
    const SysRole_en_US_OwnData = {};
    const targetData = Object.assign(SysRole_en_US_Base(), SysRole_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;