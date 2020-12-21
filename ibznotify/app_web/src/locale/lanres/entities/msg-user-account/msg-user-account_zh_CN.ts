import MsgUserAccount_zh_CN_Base from './msg-user-account_zh_CN_base';

function getLocaleResource(){
    const MsgUserAccount_zh_CN_OwnData = {};
    const targetData = Object.assign(MsgUserAccount_zh_CN_Base(), MsgUserAccount_zh_CN_OwnData);
    return targetData;
}

export default getLocaleResource;