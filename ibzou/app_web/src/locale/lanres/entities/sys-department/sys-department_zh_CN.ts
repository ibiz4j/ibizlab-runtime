import SysDepartment_zh_CN_Base from './sys-department_zh_CN_base';

function getLocaleResource(){
    const SysDepartment_zh_CN_OwnData = {};
    const targetData = Object.assign(SysDepartment_zh_CN_Base(), SysDepartment_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;