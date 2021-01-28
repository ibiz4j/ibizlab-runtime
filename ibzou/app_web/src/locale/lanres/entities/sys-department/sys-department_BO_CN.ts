import SysDepartment_BO_CN_Base from './sys-department_BO_CN_base';

function getLocaleResource(){
    const SysDepartment_BO_CN_OwnData = {};
    const targetData = Object.assign(SysDepartment_BO_CN_Base(), SysDepartment_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;