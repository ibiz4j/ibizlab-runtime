package cn.ibizlab.api.rest;

import com.baomidou.jobs.JobsConstant;
import com.baomidou.jobs.starter.JobsScheduler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Jobs Api
 *
 * @author jobob
 * @since 2019-07-13
 */
@RestController
public class JobsApiResource implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {
        // to do nothing
    }

    @RequestMapping(JobsConstant.JOBS_API)
    public void api(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        JobsScheduler.invokeAdminService(request, response);
    }
}
