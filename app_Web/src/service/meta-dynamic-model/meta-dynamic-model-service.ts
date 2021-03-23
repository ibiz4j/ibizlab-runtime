import { Http,Util } from '@/utils';
import MetaDynamicModelServiceBase from './meta-dynamic-model-service-base';


/**
 * 动态模型服务对象
 *
 * @export
 * @class MetaDynamicModelService
 * @extends {MetaDynamicModelServiceBase}
 */
export default class MetaDynamicModelService extends MetaDynamicModelServiceBase {

    /**
     * Creates an instance of  MetaDynamicModelService.
     * 
     * @param {*} [opts={}]
     * @memberof  MetaDynamicModelService
     */
    constructor(opts: any = {}) {
        super(opts);
    }


}