import { Http,Util } from '@/utils';
import SDFileServiceBase from './sdfile-service-base';


/**
 * 文件服务对象
 *
 * @export
 * @class SDFileService
 * @extends {SDFileServiceBase}
 */
export default class SDFileService extends SDFileServiceBase {

    /**
     * Creates an instance of  SDFileService.
     * 
     * @param {*} [opts={}]
     * @memberof  SDFileService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}