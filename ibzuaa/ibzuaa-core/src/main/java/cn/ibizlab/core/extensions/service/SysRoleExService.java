package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.uaa.filter.SysRoleSearchContext;
import cn.ibizlab.core.uaa.service.impl.SysRoleServiceImpl;
import com.alibaba.fastjson.JSONObject;
import liquibase.util.StringUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.core.uaa.domain.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 实体[系统角色] 自定义服务对象
 */
@Slf4j
@Primary
@Service("SysRoleExService")
public class SysRoleExService extends SysRoleServiceImpl {

    @Override
    protected Class currentModelClass() {
        return com.baomidou.mybatisplus.core.toolkit.ReflectionKit.getSuperClassGenericType(this.getClass().getSuperclass(), 1);
    }

    private List<SysRole> allSysRoles;

    public synchronized List<SysRole> getAllSysRoles()
    {
        if(allSysRoles==null) {
            List<SysRole> sysRoles = this.list();
            Boolean bBaseUsers=false;
            for (SysRole role:sysRoles)
                if(role.getRoleid().equalsIgnoreCase("ROLE_USERS")) {
                    bBaseUsers = true;
                    break;
                }
            if(!bBaseUsers)
            {
                SysRole role=new SysRole();
                role.setRoleid("ROLE_USERS");
                role.setRolename("普通用户（默认基础功能）");
                role.setMemo("系统保留基础角色，所有用户均属于此角色，无需手工分配到用户");
                this.create(role);
                sysRoles.add(role);
            }
            allSysRoles=sysRoles;
        }
        return allSysRoles;
    }

    @Override
    public boolean create(SysRole et) {
        allSysRoles=null;
        return super.create(et);
    }

    @Override
    public void createBatch(List<SysRole> list) {
        allSysRoles=null;
        super.createBatch(list);
    }

    @Override
    public boolean update(SysRole et) {
        allSysRoles=null;
        return super.update(et);
    }

    @Override
    public void updateBatch(List<SysRole> list) {
        allSysRoles=null;
        super.updateBatch(list);
    }

    /**
     * [NoRepeat:角色去重查询] 行为扩展：去除父子关系
     * @param et
     * @return
     */
    @Override
    @Transactional
    public SysRole noRepeat(SysRole et) {
        return super.noRepeat(et);
    }

    /**
     * 查询集合 数据查询
     */
    @Override
    @SneakyThrows
    public Page<SysRole> searchNoRepeat(SysRoleSearchContext context) {
        List<SysRole> newResult = new ArrayList<>();
        String sysRoleId = (String) context.getParams().get("sys_roleid");
        context.setN_sys_roleid_notin(sysRoleId);
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysRole> pages = baseMapper.searchNoRepeat(context.getPages(),context,context.getSelectCond());

        if(!ObjectUtils.isEmpty(sysRoleId)){
            List<SysRole> childRoles = new ArrayList<>();
            List<SysRole> grandSonRoles = new ArrayList<>();
            findSRelation(childRoles,pages.getRecords(),sysRoleId);
            if(!ObjectUtils.isEmpty(childRoles)){
                List<SysRole> childRoleTemps = new ArrayList<>(childRoles);
                for (SysRole sr : childRoleTemps){
                    findSRelation(childRoles,pages.getRecords(),sr.getRoleid());
                }
            }else{
                List<JSONObject> sysRoles =  baseMapper.selectBySQL("select sys_roleId,proleId from ibzRole where proleId is not null",new HashMap());
                findGSRelation(grandSonRoles,sysRoles,sysRoleId);
                List<SysRole> grandSonRoleTemps = new ArrayList<>(grandSonRoles);
                for (SysRole sr : grandSonRoleTemps){
                    findSRelation(grandSonRoles,pages.getRecords(),sr.getRoleid());
                }
                newResult.addAll(grandSonRoles);
            }
            newResult.addAll(childRoles);
            newResult.addAll(Objects.requireNonNull(findPRelation(sysRoleId, new ArrayList<>())));
            newResult = newResult.stream().distinct().collect(Collectors.toList());
        }
        for (SysRole sysRole : newResult) {
            for (int j = 0; j < pages.getRecords().size(); j++) {
                if (pages.getRecords().get(j).getRoleid().equals(sysRole.getRoleid())) {
                    pages.getRecords().remove(j);
                }
            }
        }
        return new PageImpl<>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 递归获取某个子节点的所有父节点
     * @param contextId 上下文中当前子节点id
     * @param pList 父id集合
     */
    private List<SysRole> findPRelation(String contextId,List<SysRole> pList){
        SysRole currentSysRole = baseMapper.selectById(contextId);
        // 查出当前id的所有父级别id
        if (!ObjectUtils.isEmpty(currentSysRole)){
            String proleId =  currentSysRole.getProleid();
            if(!StringUtils.isEmpty(proleId)){
                pList.add(currentSysRole);
                return findPRelation(proleId,pList);
            }else {
                return pList;
            }
        }
        return null;
    }

    /**
     * 递归获取某个父节点下的所有子节点
     * @param childRole 返回的结果
     * @param roleList  数据库查询出来的所有角色集合
     * @param pId      父id
     */
    private void findSRelation(List<SysRole> childRole,List<SysRole> roleList, String pId) {
        for (SysRole role : roleList) {
            if (!StringUtils.isEmpty(role.getProleid())) {
                if (role.getProleid().equals(pId)) {
                    findSRelation(childRole,roleList,role.getRoleid());
                    childRole.add(role);
                    }
                }
            }
        }

    /**
     * 递归获取子节点下的子节点
     * @param grandSonRole 返回的结果
     * @param objectsList  数据库查询出来的所有角色集合
     * @param pId      父id
     */
    private void findGSRelation(List<SysRole> grandSonRole,List<JSONObject> objectsList, String pId) {
        List<SysRole> sysRoles = new ArrayList<>();
        SysRole sysRole;

        for (JSONObject jsonObject : objectsList) {
            sysRole = new SysRole();
            sysRole.setRoleid(jsonObject.get("sys_roleId").toString());
            sysRole.setProleid(jsonObject.get("proleId") == null ? "" : jsonObject.get("proleId").toString());
            sysRoles.add(sysRole);
        }

        for (SysRole role : sysRoles) {
            if (!StringUtils.isEmpty(role.getProleid())) {
                if (role.getProleid().equals(pId)) {
                    findGSRelation(grandSonRole,objectsList,role.getRoleid());
                    grandSonRole.add(role);
                }
            }
        }
    }
}

