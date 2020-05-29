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
     * Creates an instance of  SaveDeptMemberLogicBase.
     * 
     * @param {*} [opts={}]
     * @memberof  SaveDeptMemberLogicBase
     */
    constructor(opts: any = {}) {
        
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
        const targetService:IBZDeptMemberService = new IBZDeptMemberService();
        if (targetService['Save'] && targetService['Save'] instanceof Function) {
            result = await targetService['Save'](context,params, false);
        }
        if(result && result.status == 200){
            Object.assign(params,result.data);
        return params;
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
        Object.assign(params,{deptid:params.mdeptid});
        Object.assign(context,{ibzdeptmember:params.mdeptid ? params.mdeptid : null});
        Object.assign(params,{userid:params.userid});
        Object.assign(context,{ibzdeptmember:params.userid ? params.userid : null});
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