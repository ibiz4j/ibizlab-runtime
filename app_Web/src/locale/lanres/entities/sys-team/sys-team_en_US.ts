import SysTeam_en_US_Base from './sys-team_en_US_base';

function getLocaleResource(){
    const SysTeam_en_US_OwnData = {};
    const targetData = Object.assign(SysTeam_en_US_Base(), SysTeam_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;