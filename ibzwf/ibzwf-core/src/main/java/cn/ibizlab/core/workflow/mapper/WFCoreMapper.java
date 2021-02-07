package cn.ibizlab.core.workflow.mapper;

import cn.ibizlab.core.workflow.domain.WFProcessNode;
import cn.ibizlab.core.workflow.domain.WFTask;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface WFCoreMapper {

    Page<WFTask> searchMyTask(IPage page, @Param("srf") WFTaskSearchContext context, @Param("ew") Wrapper<WFTask> wrapper) ;

    List<Map> searchMyTaskByPage() ;

    List<WFProcessNode> searchMyTaskCnt(@Param("srf") WFTaskSearchContext context, @Param("ew") Wrapper<WFTask> wrapper) ;

}
