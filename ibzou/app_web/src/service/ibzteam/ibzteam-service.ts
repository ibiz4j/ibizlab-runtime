import { Http,Util } from '@/utils';
import IBZTeamServiceBase from './ibzteam-service-base';


/**
 * 组服务对象
 *
 * @export
 * @class IBZTeamService
 * @extends {IBZTeamServiceBase}
 */
export default class IBZTeamService extends IBZTeamServiceBase {

    /**
     * Creates an instance of  IBZTeamService.
     * 
     * @param {*} [opts={}]
     * @memberof  IBZTeamService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}