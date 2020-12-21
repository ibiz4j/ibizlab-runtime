import MsgUserAccount_en_US_Base from './msg-user-account_en_US_base';

function getLocaleResource(){
    const MsgUserAccount_en_US_OwnData = {};
    const targetData = Object.assign(MsgUserAccount_en_US_Base(), MsgUserAccount_en_US_OwnData);
    return targetData;
}

export default getLocaleResource;