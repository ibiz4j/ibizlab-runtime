import SysTeam_zh_CN_Base from './sys-team_zh_CN_base';

function getLocaleResource(){
    const SysTeam_zh_CN_OwnData = {};
    const targetData = Object.assign(SysTeam_zh_CN_Base(), SysTeam_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;