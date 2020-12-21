import SysDeptMember_zh_CN_Base from './sys-dept-member_zh_CN_base';

function getLocaleResource(){
    const SysDeptMember_zh_CN_OwnData = {};
    const targetData = Object.assign(SysDeptMember_zh_CN_Base(), SysDeptMember_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;