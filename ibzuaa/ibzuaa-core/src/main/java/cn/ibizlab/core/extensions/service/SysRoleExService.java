package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.uaa.filter.SysRoleSearchContext;
import cn.ibizlab.core.uaa.service.impl.SysRoleServiceImpl;
import liquibase.pro.packaged.S;
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
            List<SysRole> childRole = new ArrayList<>();
            List<SysRole> grandSonRole = new ArrayList<>();
            findSRelation(childRole,pages.getRecords(),sysRoleId);
            grandSonRole.addAll(childRole);
            for (SysRole sr : grandSonRole){
                findSRelation(childRole,pages.getRecords(),sr.getRoleid());
            }
            newResult.addAll(childRole);
            newResult.addAll(findPRelation(sysRoleId,new ArrayList<>()));
            newResult = newResult.stream().distinct().collect(Collectors.toList());
        }
        for (int i = 0 ;i < newResult.size();i++){
            for (int j = 0;j < pages.getRecords().size();j++){
                if(pages.getRecords().get(j).getRoleid().equals(newResult.get(i).getRoleid())){
                    pages.getRecords().remove(j);
                }
            }
        }
        return new PageImpl<>(pages.getRecords(), context.getPageable(), pages.getTotal() - newResult.size());
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
    }

