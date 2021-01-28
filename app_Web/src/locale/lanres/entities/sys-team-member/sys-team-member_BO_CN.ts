import SysTeamMember_BO_CN_Base from './sys-team-member_BO_CN_base';

function getLocaleResource(){
    const SysTeamMember_BO_CN_OwnData = {};
    const targetData = Object.assign(SysTeamMember_BO_CN_Base(), SysTeamMember_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;