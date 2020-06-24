package cn.ibizlab.util.client;

import org.springframework.stereotype.Component;
import java.util.*;

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
}
