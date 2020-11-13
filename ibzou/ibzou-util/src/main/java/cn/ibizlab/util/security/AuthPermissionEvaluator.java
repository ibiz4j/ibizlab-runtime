package cn.ibizlab.util.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.SneakyThrows;
import cn.ibizlab.util.annotation.DEField;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.enums.DEPredefinedFieldType;
import cn.ibizlab.util.filter.QueryWrapperContext;
import cn.ibizlab.util.helper.DEFieldCacheMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Consumer;

/**
 * spring security 权限管理类
 * 重写权限控制方法
 */
@Component
public class AuthPermissionEvaluator implements PermissionEvaluator {

    @Value("${ibiz.enablePermissionValid:false}")
    boolean enablePermissionValid;  //是否开启权限校验
    /**
     * 服务接口鉴权
     * @param authentication 用户
     * @param entity 实体
     * @param action 操作
     * @return
     */
    @Override
    @SneakyThrows
    public boolean hasPermission(Authentication authentication, Object entity, Object action) {
        if(!enablePermissionValid){
            return true;
        }
        Object principal = authentication.getPrincipal();
        if(ObjectUtils.isEmpty(principal)){
            return false;
        }
        AuthenticationUser authenticationUser= (AuthenticationUser) authentication.getPrincipal();
        if(authenticationUser.getSuperuser()==1){
            return true;
        }
        String strAction=String.valueOf(action);
        Set<String> userAuthorities = getAuthorities(authentication,strAction);
        if(userAuthorities.size()==0){
            return false;
        }
        if(isAllData(strAction,userAuthorities)){
            return true;
        }
        if(entity instanceof  ArrayList){
            List<EntityBase> entities= (List<EntityBase>) entity;
            for(EntityBase entityBase: entities){
                boolean result=actionValid(entityBase, strAction ,userAuthorities,authenticationUser);
                if(!result){
                    return false;
                }
            }
        }
        else if (entity instanceof QueryWrapperContext){
            QueryWrapperContext queryWrapperContext= (QueryWrapperContext) entity;
            setPermissionCondToSearchContext(getEntity(queryWrapperContext),queryWrapperContext,userAuthorities,authenticationUser);
        }
        else{
            EntityBase entityBase= (EntityBase) entity;
            return actionValid(entityBase , strAction ,userAuthorities,authenticationUser);
        }
        return true;
    }

    /**
     * 获取实体信息
     * @param qc
     * @return
     */
    @SneakyThrows
    private EntityBase getEntity(QueryWrapperContext qc){
        EntityBase entity=null;
        Type type =qc.getClass().getGenericSuperclass();
        if(type instanceof ParameterizedType){
            ParameterizedType parameterizedType= (ParameterizedType) qc.getClass().getGenericSuperclass();
            Type [] typeArr= parameterizedType.getActualTypeArguments();
            if(typeArr.length>0){
                Class<EntityBase> entityClass = (Class) typeArr[0];
                return entityClass.newInstance();
            }
        }
        return entity;
    }

    /**
     * 在searchContext中拼接权限条件
     * @param entity 实体
     * @param qc 查询上下文
     * @param userAuthorities 用户权限
     * @param authenticationUser 当前用户
     */
    @SneakyThrows
    private void setPermissionCondToSearchContext(EntityBase entity, QueryWrapperContext qc , Set<String> userAuthorities ,AuthenticationUser authenticationUser){
        if(entity==null){
            return ;
        }
        Map<String,String> permissionField=getPermissionField(entity);//获取组织、部门预置属性
        String orgField=permissionField.get("orgfield");
        String orgDeptField=permissionField.get("orgsecfield");
        String createManField=permissionField.get("createmanfield");
        Map<String, Set<String>> userInfo = authenticationUser.getOrgInfo();
        Set<String> orgParent = userInfo.get("parentorg");
        Set<String> orgChild = userInfo.get("suborg");
        Set<String> orgDeptParent = userInfo.get("parentdept");
        Set<String> orgDeptChild = userInfo.get("subdept");

        Set<String> userOrg = new HashSet<>();
        Set<String> userOrgDept = new HashSet<>();
        Set<String> userCreateMan = new HashSet<>();
        for(String authority:userAuthorities){
            if(authority.endsWith("curorg")){   //本单位
                userOrg.add(authenticationUser.getOrgid());
            }
            else if(authority.endsWith("porg")){//上级单位
                userOrg.addAll(orgParent);
            }
            else if(authority.endsWith("sorg")){//下级单位
                userOrg.addAll(orgChild);
            }
            else if(authority.endsWith("curorgdept")){//本部门
                userOrgDept.add(authenticationUser.getMdeptid());
            }
            else if(authority.endsWith("porgdept")){//上级部门
                userOrgDept.addAll(orgDeptParent);
            }
            else if(authority.endsWith("sorgdept")){//下级部门
                userOrgDept.addAll(orgDeptChild);
            }
            else if (authority.endsWith("createman")){
                userCreateMan.add(authority);
            }
        }
        if(userOrg.size()==0 && userOrgDept.size()==0 && userCreateMan.size()==0){
            qc.getSelectCond().apply("1<>1");
        }
        else{
            Consumer<QueryWrapper> consumer = qw -> {
                if(userOrg.size()>0){
                    Consumer<QueryWrapper> org = orgQw -> {
                        orgQw.in(orgField,userOrg);
                    };
                    qw.or(org);
                }
                if(userOrgDept.size()>0){
                    Consumer<QueryWrapper> dept = deptQw -> {
                        deptQw.in(orgDeptField,userOrgDept);
                    };
                    qw.or(dept);
                }
                if(userCreateMan.size()>0){
                    Consumer<QueryWrapper> createMan = createManQw -> {
                        createManQw.eq(createManField,authenticationUser.getUserid());
                    };
                    qw.or(createMan);
                }
            };
            qc.getSelectCond().and(consumer);
        }
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable id, String action, Object params) {
        return true;
    }

    /**
     * 获取用户权限资源
     * @param authentication
     * @param action
     * @return
     */
    private Set<String> getAuthorities(Authentication authentication , String action){
        Collection authorities=authentication.getAuthorities();
        Set<String> userAuthorities = new HashSet();
        Iterator it = authorities.iterator();
        while(it.hasNext()) {
            GrantedAuthority authority = (GrantedAuthority)it.next();
            if(authority.getAuthority().contains(action)){
                userAuthorities.add(authority.getAuthority());
            }
        }
        return userAuthorities;
    }

    /**
     * 是否为全部数据
     * @param action
     * @param entityDataRange
     * @return
     */
    private boolean isAllData(String action , Set<String> entityDataRange) {
        for(String dataRange : entityDataRange ){
            if(dataRange.endsWith(String.format("%s-all",action))){
                return true;
            }
        }
        return false;
    }

    /**
     * 实体行为权限校验
     * @param entity
     * @param userAuthorities
     * @return
     */
    private boolean actionValid(EntityBase entity, String action , Set<String> userAuthorities ,AuthenticationUser authenticationUser){

        Map<String,String> permissionField=getPermissionField(entity);//获取组织、部门预置属性
        String orgField=permissionField.get("orgfield");
        String orgDeptField=permissionField.get("orgsecfield");
        String createManField=permissionField.get("createmanfield");
        Map<String, Set<String>> userInfo = authenticationUser.getOrgInfo();
        Set<String> orgParent = userInfo.get("parentorg");
        Set<String> orgChild = userInfo.get("suborg");
        Set<String> orgDeptParent = userInfo.get("parentdept");
        Set<String> orgDeptChild = userInfo.get("subdept");

        Object orgFieldValue=entity.get(orgField);
        Object orgDeptFieldValue=entity.get(orgDeptField);
        Object crateManFieldValue=entity.get(createManField);

        Set<String> userOrg = new HashSet<>();
        Set<String> userOrgDept = new HashSet<>();

        for(String authority:userAuthorities){
            if(authority.endsWith("curorg")){   //本单位
                userOrg.add(authenticationUser.getOrgid());
            }
            else if(authority.endsWith("porg")){//上级单位
                userOrg.addAll(orgParent);
            }
            else if(authority.endsWith("sorg")){//下级单位
                userOrg.addAll(orgChild);
            }
            else if(authority.endsWith("curorgdept")){//本部门
                userOrgDept.add(authenticationUser.getMdeptid());
            }
            else if(authority.endsWith("porgdept")){//上级部门
                userOrgDept.addAll(orgDeptParent);
            }
            else if(authority.endsWith("sorgdept")){//下级部门
                userOrgDept.addAll(orgDeptChild);
            }
        }

        if(action.endsWith("Create") || action.endsWith("Save")){
            if(!ObjectUtils.isEmpty(orgFieldValue) && !userOrg.contains(orgFieldValue)){
                return false;
            }
            if(!ObjectUtils.isEmpty(orgDeptFieldValue) && !userOrgDept.contains(orgDeptFieldValue)){
                return false;
            }
            if(!ObjectUtils.isEmpty(crateManFieldValue) && !authenticationUser.getUserid().equals(crateManFieldValue)){
                return false;
            }
            return true;
        }
        else{
            if(!ObjectUtils.isEmpty(orgFieldValue) && userOrg.contains(orgFieldValue)){
                return true;
            }
            if(!ObjectUtils.isEmpty(orgDeptFieldValue) && userOrgDept.contains(orgDeptFieldValue)){
                return true;
            }
            if(!ObjectUtils.isEmpty(crateManFieldValue) && authenticationUser.getUserid().equals(crateManFieldValue)){
                return true;
            }
            return false;
        }
    }

    /**
     * 获取实体权限字段 orgid/orgsecid
     * @param entityBase
     * @return
     */
    private Map<String,String> getPermissionField(EntityBase entityBase){

        Map<String,String> permissionFiled=new HashMap<>();
        String orgField="orgid";  //组织属性
        String orgDeptField="orgsecid"; //部门属性
        String createManField="createman"; //创建人属性

        DEFieldCacheMap.getFieldMap(entityBase.getClass().getName());
        Map <String, DEField> preFields= DEFieldCacheMap.getDEFields(entityBase.getClass()); //从缓存中获取当前类预置属性

        for (Map.Entry<String,DEField> entry : preFields.entrySet()){
            String fieldName=entry.getKey();//获取注解字段
            DEField fieldAnnotation=entry.getValue();//获取注解值
            DEPredefinedFieldType prefieldType=fieldAnnotation.preType();
            //用户配置系统预置属性-组织机构标识
            if(prefieldType==prefieldType.ORGID){
                orgField=fieldName;
            }
            //用户配置系统预置属性-部门标识
            if(prefieldType==prefieldType.ORGSECTORID){
                orgDeptField=fieldName;
            }
            //用户配置系统预置属性-部门标识
            if(prefieldType==prefieldType.CREATEMAN){
                createManField=fieldName;
            }
        }
        permissionFiled.put("orgfield",orgField);
        permissionFiled.put("orgsecfield",orgDeptField);
        permissionFiled.put("createmanfield",createManField);
        return permissionFiled;
    }
}