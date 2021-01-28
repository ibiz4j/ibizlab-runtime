import SysEmployee_BO_CN_Base from './sys-employee_BO_CN_base';

function getLocaleResource(){
    const SysEmployee_BO_CN_OwnData = {};
    const targetData = Object.assign(SysEmployee_BO_CN_Base(), SysEmployee_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;