import SysDeptMember_en_US_Base from './sys-dept-member_en_US_base';

function getLocaleResource(){
    const SysDeptMember_en_US_OwnData = {};
    const targetData = Object.assign(SysDeptMember_en_US_Base(), SysDeptMember_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;