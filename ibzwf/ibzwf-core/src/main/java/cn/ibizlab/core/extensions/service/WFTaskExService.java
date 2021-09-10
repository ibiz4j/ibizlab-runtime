package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import cn.ibizlab.core.workflow.mapper.WFCoreMapper;
import cn.ibizlab.core.workflow.service.impl.WFTaskServiceImpl;
import lombok.extern.slf4j.Slf4j;
import cn.ibizlab.core.workflow.domain.WFTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Primary;
import java.util.*;

/**
 * 实体[工作流任务] 自定义服务对象
 */
@Slf4j
@Primary
@Service("WFTaskExService")
public class WFTaskExService extends WFTaskServiceImpl {

    @Autowired
    private WFCoreMapper wfCoreMapper;

    /**
     * [UserCustom:用户自定义] 行为扩展
     * @param et
     * @return
     */
    @Override
    @Transactional
    public WFTask userCustom(WFTask et) {
        return super.userCustom(et);
    }

    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<WFTask> searchDefault(WFTaskSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages
                = wfCoreMapper.searchMyTask(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 已办任务
     */
    @Override
    public Page<WFTask> searchDoneTask(WFTaskSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages
                = wfCoreMapper.searchDoneTask(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 办结任务
     */
    @Override
    public Page<WFTask> searchFinishTask(WFTaskSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages
                = wfCoreMapper.searchFinishTask(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待办任务
     */
    @Override
    public Page<WFTask> searchTodoTask(WFTaskSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages
                = wfCoreMapper.searchMyTask(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 待阅任务
     */
    @Override
    public Page<WFTask> searchToreadTask(WFTaskSearchContext context) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<WFTask> pages
                = wfCoreMapper.searchUnReadTask(context.getPages(),context,context.getSelectCond());
        return new PageImpl<WFTask>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }
}

