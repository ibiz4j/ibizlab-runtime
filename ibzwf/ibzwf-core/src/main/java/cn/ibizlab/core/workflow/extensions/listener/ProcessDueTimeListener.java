package cn.ibizlab.core.workflow.extensions.listener;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.flowable.engine.impl.persistence.entity.CommentEntity;
import org.flowable.engine.impl.persistence.entity.CommentEntityImpl;

import java.util.Date;

@Slf4j
public class ProcessDueTimeListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) {
        CommentEntity comment = new CommentEntityImpl();
        comment.setId(IdWorker.getIdStr());
        comment.setProcessInstanceId(execution.getProcessInstanceId());
        comment.setAction(execution.getCurrentFlowElement().getName()+"超时自动跳过");
        comment.setTime(new Date());
        log.debug(comment.toString());
    }
}