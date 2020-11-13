package cn.ibizlab.util.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.util.annotation.Audit;
import cn.ibizlab.util.annotation.DEField;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.domain.IBZDataAudit;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import cn.ibizlab.util.mapper.IBZDataAuditMapper;
import cn.ibizlab.util.security.AuthenticationUser;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 实体[DataAudit] 服务对象接口实现
 */
@Service
@Slf4j
public class SimpleAuditService extends ServiceImpl<IBZDataAuditMapper, IBZDataAudit> implements IBZDataAuditService {

    private final ExpressionParser parser = new SpelExpressionParser();

    private static List cacheMap = Collections.synchronizedList(new ArrayList());

    /**
     * 定时保存审计记录
     */
    @Scheduled(fixedRate = 10000)
    public void saveAudit() {
        if(cacheMap.size()>0) {
            log.info(String.format("正在保存审计数据，当前审计集合数量为[%s]",cacheMap.size()));
            List temp=new ArrayList();
            if(cacheMap.size()<500) {
              temp.addAll(cacheMap);
            }
            else {
              temp.addAll(cacheMap.subList(0,500));
            }
            this.saveBatch(temp);
            cacheMap.removeAll(temp);
            log.info(String.format("保存完成，当前审计集合数量为[%s]",cacheMap.size()));
        }
    }

    /**
     * 新建审计日志
     * @param request
     * @param entity
     * @param idValue
     * @param auditFields
     */
    @Override
    public void createAudit(HttpServletRequest request, EntityBase entity, Object idValue, Map<String, Audit> auditFields) {
        IBZDataAudit dataAudit = new IBZDataAudit();
        dataAudit.setOppersonid(AuthenticationUser.getAuthenticationUser().getUserid());
        dataAudit.setOppersonname(String.format("%s[%s]",AuthenticationUser.getAuthenticationUser().getPersonname(),AuthenticationUser.getAuthenticationUser().getOrgname()));
        dataAudit.setAudittype("CREATE");
        dataAudit.setAuditobject(entity.getClass().getSimpleName());
        dataAudit.setAuditobjectdata(idValue);
        dataAudit.setOptime(new Timestamp(new Date().getTime()));
        if(request != null) {
            dataAudit.setIpaddress(getIpAddress(request, AuthenticationUser.getAuthenticationUser()));
        }
        dataAudit.setAuditinfo(getAuditInfo(entity, auditFields));
        dataAudit.setIsdatachanged(1);
        cacheMap.add(dataAudit);
    }

    /**
     * 更新审计日志
     * @param request
     * @param beforeEntity
     * @param serviceObj
     * @param idValue
     * @param auditFields
     */
    @SneakyThrows
    public void updateAudit(HttpServletRequest request, EntityBase beforeEntity, Object serviceObj, Object idValue, Map<String, Audit> auditFields) {
        //获取更新后的实体
        EntityBase afterEntity = getEntity(serviceObj, idValue);
        //获取更新后的审计内容
        String auditInfo = getUpdateAuditInfo(beforeEntity, afterEntity, auditFields);//比较更新前后差异内容
        int isDataChanged = 1;
        //审计内容是否发生变化
        if(StringUtils.isEmpty(auditInfo)) {
            isDataChanged = 0;
        }
        IBZDataAudit dataAudit = new IBZDataAudit();
        dataAudit.setOppersonid(AuthenticationUser.getAuthenticationUser().getUserid());
        dataAudit.setOppersonname(String.format("%s[%s]", AuthenticationUser.getAuthenticationUser().getPersonname(), AuthenticationUser.getAuthenticationUser().getOrgname()));
        dataAudit.setAudittype("UPDATE");
        dataAudit.setAuditobject(afterEntity.getClass().getSimpleName());
        dataAudit.setAuditobjectdata(idValue);
        dataAudit.setOptime(new Timestamp(new Date().getTime()));
        if(request!=null) {
            dataAudit.setIpaddress(getIpAddress(request, AuthenticationUser.getAuthenticationUser()));
        }
        dataAudit.setAuditinfo(auditInfo);
        dataAudit.setIsdatachanged(isDataChanged);
        cacheMap.add(dataAudit);
    }

    /**
     * 删除审计日志
     * @param request
     * @param entity
     * @param idValue
     * @param auditFields
     */
    public void removeAudit(HttpServletRequest request, EntityBase entity, Object idValue, Map<String, Audit> auditFields) {
        IBZDataAudit dataAudit = new IBZDataAudit();
        dataAudit.setOppersonid(AuthenticationUser.getAuthenticationUser().getUserid());
        dataAudit.setOppersonname(String.format("%s[%s]", AuthenticationUser.getAuthenticationUser().getPersonname(), AuthenticationUser.getAuthenticationUser().getOrgname()));
        dataAudit.setAudittype("REMOVE");
        dataAudit.setAuditobject(entity.getClass().getSimpleName());
        dataAudit.setAuditobjectdata(idValue);
        dataAudit.setOptime(new Timestamp(new Date().getTime()));
        if(request!=null) {
            dataAudit.setIpaddress(getIpAddress(request, AuthenticationUser.getAuthenticationUser()));
        }
        dataAudit.setAuditinfo(getAuditInfo(entity, auditFields));
        dataAudit.setIsdatachanged(1);
        cacheMap.add(dataAudit);
    }

    private String getAuditInfo(EntityBase entity, Map<String, Audit> auditFields) {
        String auditResult = "";
        if(auditFields.size() == 0) {
            return auditResult;
        }
        Map<String, DEField> deFields = DEFieldCacheMap.getDEFields(entity.getClass());
        if(deFields.size() == 0) {
            return auditResult;
        }
        JSONArray auditFieldArray = new JSONArray();
        for (Map.Entry<String, Audit> auditField : auditFields.entrySet()) {
            Object objFieldName = auditField.getKey();
            String fieldName = String.valueOf(objFieldName);
            DEField deField = null;
            if(deFields.containsKey(fieldName)) {
                deField = deFields.get(fieldName);
            }
            if(ObjectUtils.isEmpty(deField)) {
                continue;
            }
            Object value = dataTransfer(entity.get(fieldName), deField.fieldType(), deField.format());
            if(!StringUtils.isEmpty(value)) {
                JSONObject auditFieldObj = new JSONObject();
                auditFieldObj.put("field", deField.value());
                auditFieldObj.put("value", value);
                if(!StringUtils.isEmpty(deField.dict())) {
                    auditFieldObj.put("dict", deField.dict());
                }
                auditFieldArray.add(auditFieldObj);
            }
        }
        if(auditFieldArray.size()>0) {
            auditResult = auditFieldArray.toString();
        }
        return auditResult;
    }

    /**
     * 获取更新审计内容
     * @param oldData
     * @param newData
     * @param auditFields
     * @return
     */
    private String getUpdateAuditInfo(EntityBase oldData, EntityBase newData, Map<String, Audit> auditFields){
        String auditResult = "";
        JSONArray auditFieldArray = new JSONArray();
        if(auditFields.size() == 0) {
            return auditResult;
        }

        Map<String, DEField> deFields = DEFieldCacheMap.getDEFields(oldData.getClass());
        if(deFields.size() == 0){
            return auditResult;
        }

        for (Map.Entry<String, Audit> auditField : auditFields.entrySet()) {
            Object objFieldName = auditField.getKey();//获取注解字段
            String fieldName = String.valueOf(objFieldName); //属性名称
            DEField deField = null;
            if(deFields.containsKey(fieldName)) {
                deField = deFields.get(fieldName);
            }
            if(ObjectUtils.isEmpty(deField)) {
                continue;
            }
            Object oldValue = oldData.get(fieldName);//老属性值
            Object newValue = newData.get(fieldName);//新属性值
            if(!compare(oldValue, newValue)) {
                oldValue = dataTransfer(oldValue, deField.fieldType(), deField.format());//属性值转换
                newValue = dataTransfer(newValue, deField.fieldType(), deField.format());//属性值转换
                JSONObject auditFieldObj = new JSONObject();
                auditFieldObj.put("field", deField.value());
                auditFieldObj.put("beforevalue", oldValue);
                auditFieldObj.put("value", newValue);
                if(!StringUtils.isEmpty(deField.dict())) {
                    auditFieldObj.put("dict", deField.dict());
                }
                auditFieldArray.add(auditFieldObj);
            }
        }
        if(auditFieldArray.size()>0) {
            auditResult = auditFieldArray.toString();
        }
        return auditResult;
    }

    /**
     * 数据转换
     * @param value 转换值
     * @param dataType 转换字段类型
     * @param strFormat   转换字段格式化文本
     * @return
     */
    private String dataTransfer(Object value, String dataType, String strFormat) {
        if(value==null) {
            return "";
        }
        String transResult=value.toString();
        if((dataType.equals("DATE") || dataType.equals("DATETIME") || dataType.equals("TIME")) && (!StringUtils.isEmpty(strFormat))) {  //时间类型转换
            Timestamp timestamp = (Timestamp)value;
            Date date = timestamp;
            SimpleDateFormat format = new SimpleDateFormat(strFormat);
            transResult = format.format(date);
        }
        return transResult;
    }

    /**
     * 对象比较
     * @param sourceObj 比较源对象
     * @param targetObj 比较目标对象
     * @return
     */
    private boolean compare(Object sourceObj, Object targetObj) {
        if(sourceObj == null && targetObj == null) {
            return true;
        }
        if(sourceObj == null && targetObj != null) {
            return false;
        }
        return sourceObj.equals(targetObj);
    }

    /**
     * 获取实体
     * @param service
     * @param id
     * @return
     */
    @SneakyThrows
    private EntityBase getEntity(Object service, Object id) {
        EntityBase entity = null;
        if(!ObjectUtils.isEmpty(service)) {
            EvaluationContext oldContext = new StandardEvaluationContext();
            oldContext.setVariable("service",service);
            oldContext.setVariable("id",id);
            Expression oldExp = parser.parseExpression("#service.get(#id)");
            return oldExp.getValue(oldContext, EntityBase.class);
        }
        return entity;
    }

    /**
     * 获取Ip地址
     * @param request
     * @return
     */
    public String getIpAddress(HttpServletRequest request, AuthenticationUser authenticationUser) {
        //客户端有提交ip，以提交的ip为准
        if(authenticationUser != null && !StringUtils.isEmpty(authenticationUser.getAddr())) {
            return authenticationUser.getAddr();
        }
        if(request == null) {
            return "";
        }
        String Xip = request.getHeader("X-Real-IP");
        String XFor = request.getHeader("X-Forwarded-For");
        if(!StringUtils.isEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = XFor.indexOf(",");
            if(index != -1){
                return XFor.substring(0,index);
            }else{
                return XFor;
            }
        }
        XFor = Xip;
        if(!StringUtils.isEmpty(XFor) && !"unKnown".equalsIgnoreCase(XFor)) {
            return XFor;
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(XFor) || "unknown".equalsIgnoreCase(XFor)) {
            XFor = request.getRemoteAddr();
        }
        return XFor;
    }
}