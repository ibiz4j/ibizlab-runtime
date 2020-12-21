import SysRolePermission_en_US_Base from './sys-role-permission_en_US_base';

function getLocaleResource(){
    const SysRolePermission_en_US_OwnData = {};
    const targetData = Object.assign(SysRolePermission_en_US_Base(), SysRolePermission_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;