import SysTeam_BO_CN_Base from './sys-team_BO_CN_base';

function getLocaleResource(){
    const SysTeam_BO_CN_OwnData = {};
    const targetData = Object.assign(SysTeam_BO_CN_Base(), SysTeam_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;