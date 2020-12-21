import SysOrganization_en_US_Base from './sys-organization_en_US_base';

function getLocaleResource(){
    const SysOrganization_en_US_OwnData = {};
    const targetData = Object.assign(SysOrganization_en_US_Base(), SysOrganization_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;