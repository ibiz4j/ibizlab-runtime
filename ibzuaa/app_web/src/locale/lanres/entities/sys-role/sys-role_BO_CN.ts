import SysRole_BO_CN_Base from './sys-role_BO_CN_base';

function getLocaleResource(){
    const SysRole_BO_CN_OwnData = {};
    const targetData = Object.assign(SysRole_BO_CN_Base(), SysRole_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;