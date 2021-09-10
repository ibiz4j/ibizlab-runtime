package cn.ibizlab.util.client;

import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import java.io.Serializable;

@Component
public class IBZWFFallback implements IBZWFFeignClient {

    @Override
    public List<String> getbusinesskeys(String system, String appname, String entity, String processDefinitionKey, String taskDefinitionKey) {
        return null;
    }

    @Override
    public List<String> getbusinesskeysByUserId(String system, String userId, String entity, String processDefinitionKey, String taskDefinitionKey) {
        return null;
    }

    @Override
    public Boolean deployBpmnFile(List<Map<String, Object>> bpmnfiles) {
        return null;
    }

    @Override
    public JSONObject wfstart(String system, String appname, String entity, String businessKey, JSONObject instance) {
        return null;
    }

    @Override
    public Map<String, Map<String, Object>> getTask(String system, String userId, String entity, String instTag, String instTag2 ,String taskType) {
        return null;
    }

    @Override
    public Map<String, Map<String, Object>> getTaskByStep(String system, String userId, String entity, String instTag, String instTag2 , String taskType, String srfwfstep) {
        return null;
    }

    @Override
    public Integer getDataAccessMode(String system, String entity, Serializable businessKey) {
        return null;
    }

    @Override
    public Map<String, Map<String, Object>> getMyTask(String system, String appName, String entity) {
        return null;
    }

}
