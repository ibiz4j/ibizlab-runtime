import SysEmployee_en_US_Base from './sys-employee_en_US_base';

function getLocaleResource(){
    const SysEmployee_en_US_OwnData = {};
    const targetData = Object.assign(SysEmployee_en_US_Base(), SysEmployee_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;