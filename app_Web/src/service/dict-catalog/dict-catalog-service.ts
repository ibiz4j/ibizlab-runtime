import { Http,Util } from '@/utils';
import DictCatalogServiceBase from './dict-catalog-service-base';


/**
 * 字典服务对象
 *
 * @export
 * @class DictCatalogService
 * @extends {DictCatalogServiceBase}
 */
export default class DictCatalogService extends DictCatalogServiceBase {

    /**
     * Creates an instance of  DictCatalogService.
     * 
     * @param {*} [opts={}]
     * @memberof  DictCatalogService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}