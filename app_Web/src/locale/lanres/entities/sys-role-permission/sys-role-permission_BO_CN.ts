import SysRolePermission_BO_CN_Base from './sys-role-permission_BO_CN_base';

function getLocaleResource(){
    const SysRolePermission_BO_CN_OwnData = {};
    const targetData = Object.assign(SysRolePermission_BO_CN_Base(), SysRolePermission_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;