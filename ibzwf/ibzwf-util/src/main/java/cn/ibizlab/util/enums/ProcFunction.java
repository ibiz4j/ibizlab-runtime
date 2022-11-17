package cn.ibizlab.util.enums;

/**
 * 工作流辅助功能
 */
public enum ProcFunction {

    SENDBACK("sendback","退回"),
    WITHDRAW("withdraw","撤回"),
    SUPPLYINFO("supplyinfo","补充信息"),
    ADDSTEPBEFORE("addstepbefore","前加签"),
    ADDSTEPAFTER("addstepafter","后加签"),
    TAKEADVICE("takeadvice","征求意见"),
    SENDCOPY("sendcopy","抄送"),
    REASSIGN("reassign","转办"),
    FINISH("finish","完成"),
    JUMP("jump","跳转"),
    TIMEOUT("timeout","超时"),
    RESTART("restart","重启流程");

    ProcFunction(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String value;
    public String text;
}
