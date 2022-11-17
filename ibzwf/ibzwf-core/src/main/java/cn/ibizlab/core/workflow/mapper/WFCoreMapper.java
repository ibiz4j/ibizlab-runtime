package cn.ibizlab.core.workflow.mapper;

import cn.ibizlab.core.workflow.domain.WFProcessInstance;
import cn.ibizlab.core.workflow.domain.WFProcessNode;
import cn.ibizlab.core.workflow.domain.WFTask;
import cn.ibizlab.core.workflow.filter.WFProcessInstanceSearchContext;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface WFCoreMapper {

    Page<WFTask> searchMyTask(IPage page, @Param("srf") WFTaskSearchContext context, @Param("ew") Wrapper<WFTask> wrapper) ;

    List<Map> searchMyTaskByPage() ;

    List<WFProcessNode> searchMyTaskCnt(@Param("srf") WFTaskSearchContext context, @Param("ew") Wrapper<WFTask> wrapper) ;

    List<Map> searchUserTask(@Param("et")Map param) ;

    Page<WFTask> searchUnReadTask(IPage page, @Param("srf") WFTaskSearchContext context, @Param("ew") Wrapper<WFTask> wrapper) ;

    Page<WFTask> searchMyDoneTask(IPage page, @Param("srf") WFTaskSearchContext context, @Param("ew") Wrapper<WFTask> wrapper) ;

    Page<WFTask> searchMyFinishTask(IPage page, @Param("srf") WFTaskSearchContext context, @Param("ew") Wrapper<WFTask> wrapper) ;

    Object readTask(@Param("et")Map param);

    Page<WFTask> searchMyAllTask(IPage page, @Param("srf") WFTaskSearchContext context, @Param("ew") Wrapper<WFTask> wrapper) ;

    Page<WFTask> searchDoneTask(IPage page, @Param("srf") WFTaskSearchContext context, @Param("ew") Wrapper<WFTask> wrapper) ;

    Page<WFTask> searchFinishTask(IPage page, @Param("srf") WFTaskSearchContext context, @Param("ew") Wrapper<WFTask> wrapper) ;

    Page<WFProcessInstance> searchActiveInstance(IPage page, @Param("srf") WFProcessInstanceSearchContext context, @Param("ew") Wrapper<WFProcessInstance> wrapper) ;

}
