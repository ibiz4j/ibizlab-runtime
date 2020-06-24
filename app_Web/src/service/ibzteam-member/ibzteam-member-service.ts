import { Http,Util } from '@/utils';
import IBZTeamMemberServiceBase from './ibzteam-member-service-base';


/**
 * 组成员服务对象
 *
 * @export
 * @class IBZTeamMemberService
 * @extends {IBZTeamMemberServiceBase}
 */
export default class IBZTeamMemberService extends IBZTeamMemberServiceBase {

    /**
     * Creates an instance of  IBZTeamMemberService.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZTeamMemberService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}