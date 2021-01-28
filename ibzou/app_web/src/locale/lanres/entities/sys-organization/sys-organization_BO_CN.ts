import SysOrganization_BO_CN_Base from './sys-organization_BO_CN_base';

function getLocaleResource(){
    const SysOrganization_BO_CN_OwnData = {};
    const targetData = Object.assign(SysOrganization_BO_CN_Base(), SysOrganization_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;