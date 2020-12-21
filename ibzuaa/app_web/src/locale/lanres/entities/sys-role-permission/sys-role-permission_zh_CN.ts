import SysRolePermission_zh_CN_Base from './sys-role-permission_zh_CN_base';

function getLocaleResource(){
    const SysRolePermission_zh_CN_OwnData = {};
    const targetData = Object.assign(SysRolePermission_zh_CN_Base(), SysRolePermission_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;