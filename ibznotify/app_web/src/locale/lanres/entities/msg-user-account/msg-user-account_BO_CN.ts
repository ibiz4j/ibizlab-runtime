import MsgUserAccount_BO_CN_Base from './msg-user-account_BO_CN_base';

function getLocaleResource(){
    const MsgUserAccount_BO_CN_OwnData = {};
    const targetData = Object.assign(MsgUserAccount_BO_CN_Base(), MsgUserAccount_BO_CN_OwnData);
    return targetData;
}

export default getLocaleResource;