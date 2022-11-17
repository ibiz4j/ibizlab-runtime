package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.workflow.domain.WFProcessInstance;
import cn.ibizlab.core.workflow.extensions.service.WFCoreService;
import cn.ibizlab.core.workflow.filter.WFProcessInstanceSearchContext;
import cn.ibizlab.core.workflow.service.impl.WFProcessInstanceServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.flowable.ui.common.service.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 实体[流程实例] 自定义服务对象
 */
@Slf4j
@Primary
@Service("WFProcessInstanceExService")
public class WFProcessInstanceExService extends WFProcessInstanceServiceImpl {

    @Autowired
    WFCoreService wfCoreService;

    @Autowired
    private RuntimeService runtimeService;

    /**
     * [Jump:流程跳转] 行为扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public WFProcessInstance jump(WFProcessInstance et) {

        Object users = et.get("wfusers") ;
        if(ObjectUtils.isEmpty(users)){
            throw new BadRequestException("未传入流程步骤用户");
        }

        //参数格式转换
        Set <String> userSets = new LinkedHashSet();
        JSONArray.parseArray(users.toString()).forEach(item -> {
            JSONObject obj = (JSONObject) item;
            Object userId = obj.get("srfkey");
            if(!ObjectUtils.isEmpty(userId)){
                userSets.add(userId.toString());
            }
        });

        et.set("wfusers",String.join(",",userSets));
        wfCoreService.jump(et);

        return et;
    }
    /**
     * [Restart:重启流程] 行为扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public WFProcessInstance restart(WFProcessInstance et) {

        String strProcessInstanceBusinessKey = et.getBusinesskey();
        if(StringUtils.isEmpty(strProcessInstanceBusinessKey)){
            throw new BadRequestException("未传入业务标识");
        }

        String strSystemId = null;
        String strEntityId = null;
        String strBusinessKey = null;

        if(strProcessInstanceBusinessKey.contains(":")){
            String [] arrays = strProcessInstanceBusinessKey.split(":");
            if(arrays.length == 3){
                strSystemId = arrays[0];
                strEntityId = arrays[1];
                strBusinessKey = arrays[2];
                if(strBusinessKey.indexOf(":k-")>0)
                    strBusinessKey = strBusinessKey.split(":k-")[1];
            }
        }

        if(StringUtils.isEmpty(strSystemId) || StringUtils.isEmpty(strEntityId) || StringUtils.isEmpty(strBusinessKey)){
            throw new BadRequestException("未传入流程参数失败");
        }

        wfCoreService.restart(strSystemId,strEntityId,strBusinessKey,et);

        return et;
    }


    @Override
    public Page<WFProcessInstance> searchActiveProcessInstance(WFProcessInstanceSearchContext context) {
        return wfCoreService.searchActiveInstance(context);
    }

}

