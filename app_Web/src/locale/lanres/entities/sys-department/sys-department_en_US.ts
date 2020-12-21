import SysDepartment_en_US_Base from './sys-department_en_US_base';

function getLocaleResource(){
    const SysDepartment_en_US_OwnData = {};
    const targetData = Object.assign(SysDepartment_en_US_Base(), SysDepartment_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;