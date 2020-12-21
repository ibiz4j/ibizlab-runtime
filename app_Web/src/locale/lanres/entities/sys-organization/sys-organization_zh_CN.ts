import SysOrganization_zh_CN_Base from './sys-organization_zh_CN_base';

function getLocaleResource(){
    const SysOrganization_zh_CN_OwnData = {};
    const targetData = Object.assign(SysOrganization_zh_CN_Base(), SysOrganization_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;