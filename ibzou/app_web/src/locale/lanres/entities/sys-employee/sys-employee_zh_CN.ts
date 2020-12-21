import SysEmployee_zh_CN_Base from './sys-employee_zh_CN_base';

function getLocaleResource(){
    const SysEmployee_zh_CN_OwnData = {};
    const targetData = Object.assign(SysEmployee_zh_CN_Base(), SysEmployee_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;