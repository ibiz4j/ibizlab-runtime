import SysTeamMember_en_US_Base from './sys-team-member_en_US_base';

function getLocaleResource(){
    const SysTeamMember_en_US_OwnData = {};
    const targetData = Object.assign(SysTeamMember_en_US_Base(), SysTeamMember_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;