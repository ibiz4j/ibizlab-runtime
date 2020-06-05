import IBZDeptMemberService from '@/service/ibzdept-member/ibzdept-member-service';
import { Verify } from '@/utils/verify/verify';


/**
 * 保存人事关系
 *
 * @export
 * @class SaveDeptMemberLogicBase
 */
export default class SaveDeptMemberLogicBase {

    /**
     * 名称
     * 
     * @memberof  SaveDeptMemberLogicBase
     */
    private name:string ="saveDeptMember";

    /**
     * 唯一标识
     * 
     * @memberof  SaveDeptMemberLogicBase
     */
    private id:string = "E3FF4728-CD18-4940-BAEF-8A71111A5D05";

    /**
     * 默认参数名称
     * 
     * @memberof  SaveDeptMemberLogicBase
     */
    private defaultParamName:string = "Default";

    /**
     * 参数集合
     * 
     * @memberof  SaveDeptMemberLogicBase
     */
    private paramsMap:Map<string,any> = new Map();

    /**
     * Creates an instance of  SaveDeptMemberLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SaveDeptMemberLogicBase
     */
    constructor(opts: any = {}) {
        this.initParams(opts);
    }

    /**
     * 初始化参数集合
     * 
     * @param {*} [opts={}]
     * @memberof  SaveDeptMemberLogicBase
     */
    public initParams(opts:any){
        this.paramsMap.set('Default',opts);
        this.paramsMap.set('member',{});
    }


    /**
     * 计算0节点结果
     * 
     * @param params 传入参数
     */
    public compute0Cond(params:any):boolean{
        return true;
    }

    /**
     * 计算1节点结果
     * 
     * @param params 传入参数
     */
    public compute1Cond(params:any):boolean{
        return true;
    }

    /**
     * 执行逻辑
     * 
     * @param context 应用上下文
     * @param params 传入参数
     */
    public onExecute(context:any,params:any,isloading:boolean){
        return this.executeBegin(context,params,isloading);
    }


    /**
    * 保存成员
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executeDeaction1(context:any,params:any,isloading:boolean){
        // 行为处理节点
        let result: any;
        let actionParam:any = this.paramsMap.get('member');
        const targetService:IBZDeptMemberService = new IBZDeptMemberService();
        if (targetService['Save'] && targetService['Save'] instanceof Function) {
            result = await targetService['Save'](actionParam.context,actionParam.data, false);
        }
        if(result && result.status == 200){
            Object.assign(actionParam.data,result.data);
        return this.paramsMap.get(this.defaultParamName).data;
        }
    }

    /**
    * 准备成员
    * 
    * @param context 应用上下文
    * @param params 传入参数
    */
    private async executePrepareparam1(context:any,params:any,isloading:boolean){
        // 准备参数节点
    let tempDstParam0Context:any = this.paramsMap.get('member').context?this.paramsMap.get('member').context:{};
    let tempDstParam0Data:any = this.paramsMap.get('member').data?this.paramsMap.get('member').data:{};
    let tempSrcParam0Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam0Data,{deptid:tempSrcParam0Data['mdeptid']});
    this.paramsMap.set('member',{data:tempDstParam0Data,context:tempDstParam0Context});
    let tempDstParam1Context:any = this.paramsMap.get('member').context?this.paramsMap.get('member').context:{};
    let tempDstParam1Data:any = this.paramsMap.get('member').data?this.paramsMap.get('member').data:{};
    let tempSrcParam1Data:any = this.paramsMap.get('Default').data?this.paramsMap.get('Default').data:{};
    Object.assign(tempDstParam1Data,{userid:tempSrcParam1Data['userid']});
    this.paramsMap.set('member',{data:tempDstParam1Data,context:tempDstParam1Context});
        if(this.compute1Cond(params)){
            return this.executeDeaction1(context,params,isloading);   
        }
    }

    /**
    * 开始
    * 
    * @param params 传入参数
    */
    private async executeBegin(context:any,params:any,isloading:boolean){
        //开始节点
        if(this.compute0Cond(params)){
            return this.executePrepareparam1(context,params,isloading);   
        }
    }


}