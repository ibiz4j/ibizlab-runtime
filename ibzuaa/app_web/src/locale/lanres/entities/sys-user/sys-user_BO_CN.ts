import SysUser_BO_CN_Base from './sys-user_BO_CN_base';

function getLocaleResource(){
    const SysUser_BO_CN_OwnData = {};
    const targetData = Object.assign(SysUser_BO_CN_Base(), SysUser_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;