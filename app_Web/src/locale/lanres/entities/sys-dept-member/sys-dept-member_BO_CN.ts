import SysDeptMember_BO_CN_Base from './sys-dept-member_BO_CN_base';

function getLocaleResource(){
    const SysDeptMember_BO_CN_OwnData = {};
    const targetData = Object.assign(SysDeptMember_BO_CN_Base(), SysDeptMember_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;