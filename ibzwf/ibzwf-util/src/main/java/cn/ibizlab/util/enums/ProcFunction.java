package cn.ibizlab.util.enums;

/**
 * 工作流辅助功能
 */
public enum ProcFunction {

    SENDBACK("sendback","退回"),
    SUPPLYINFO("supplyinfo","补充信息"),
    ADDSTEPBEFORE("addstepbefore","前加签"),
    ADDSTEPAFTER("addstepafter","后加签"),
    TAKEADVICE("takeadvice","征求意见"),
    SENDCOPY("sendcopy","抄送"),
    TRANSFER("transfer","转办"),
    FINISH("finish","完成");

    ProcFunction(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String value;
    public String text;
}
