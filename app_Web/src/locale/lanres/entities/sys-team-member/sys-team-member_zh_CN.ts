import SysTeamMember_zh_CN_Base from './sys-team-member_zh_CN_base';

function getLocaleResource(){
    const SysTeamMember_zh_CN_OwnData = {};
    const targetData = Object.assign(SysTeamMember_zh_CN_Base(), SysTeamMember_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;