package cn.ibizlab.api.rest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSONObject;
import javax.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.api.dto.*;
import cn.ibizlab.api.mapping.*;
import cn.ibizlab.core.task.domain.JobsLog;
import cn.ibizlab.core.task.service.IJobsLogService;
import cn.ibizlab.core.task.filter.JobsLogSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"任务调度日志" })
@RestController("api-jobslog")
@RequestMapping("")
public class JobsLogResource {

    @Autowired
    public IJobsLogService jobslogService;

    @Autowired
    @Lazy
    public JobsLogMapping jobslogMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-Create-all')")
    @ApiOperation(value = "新建任务调度日志", tags = {"任务调度日志" },  notes = "新建任务调度日志")
	@RequestMapping(method = RequestMethod.POST, value = "/jobslogs")
    public ResponseEntity<JobsLogDTO> create(@Validated @RequestBody JobsLogDTO jobslogdto) {
        JobsLog domain = jobslogMapping.toDomain(jobslogdto);
		jobslogService.create(domain);
        JobsLogDTO dto = jobslogMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-Create-all')")
    @ApiOperation(value = "批量新建任务调度日志", tags = {"任务调度日志" },  notes = "批量新建任务调度日志")
	@RequestMapping(method = RequestMethod.POST, value = "/jobslogs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<JobsLogDTO> jobslogdtos) {
        jobslogService.createBatch(jobslogMapping.toDomain(jobslogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-Update-all')")
    @ApiOperation(value = "更新任务调度日志", tags = {"任务调度日志" },  notes = "更新任务调度日志")
	@RequestMapping(method = RequestMethod.PUT, value = "/jobslogs/{jobslog_id}")
    public ResponseEntity<JobsLogDTO> update(@PathVariable("jobslog_id") String jobslog_id, @RequestBody JobsLogDTO jobslogdto) {
		JobsLog domain  = jobslogMapping.toDomain(jobslogdto);
        domain .setId(jobslog_id);
		jobslogService.update(domain );
		JobsLogDTO dto = jobslogMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-Update-all')")
    @ApiOperation(value = "批量更新任务调度日志", tags = {"任务调度日志" },  notes = "批量更新任务调度日志")
	@RequestMapping(method = RequestMethod.PUT, value = "/jobslogs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<JobsLogDTO> jobslogdtos) {
        jobslogService.updateBatch(jobslogMapping.toDomain(jobslogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-Remove-all')")
    @ApiOperation(value = "删除任务调度日志", tags = {"任务调度日志" },  notes = "删除任务调度日志")
	@RequestMapping(method = RequestMethod.DELETE, value = "/jobslogs/{jobslog_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("jobslog_id") String jobslog_id) {
         return ResponseEntity.status(HttpStatus.OK).body(jobslogService.remove(jobslog_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-Remove-all')")
    @ApiOperation(value = "批量删除任务调度日志", tags = {"任务调度日志" },  notes = "批量删除任务调度日志")
	@RequestMapping(method = RequestMethod.DELETE, value = "/jobslogs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        jobslogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-Get-all')")
    @ApiOperation(value = "获取任务调度日志", tags = {"任务调度日志" },  notes = "获取任务调度日志")
	@RequestMapping(method = RequestMethod.GET, value = "/jobslogs/{jobslog_id}")
    public ResponseEntity<JobsLogDTO> get(@PathVariable("jobslog_id") String jobslog_id) {
        JobsLog domain = jobslogService.get(jobslog_id);
        JobsLogDTO dto = jobslogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取任务调度日志草稿", tags = {"任务调度日志" },  notes = "获取任务调度日志草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/jobslogs/getdraft")
    public ResponseEntity<JobsLogDTO> getDraft(JobsLogDTO dto) {
        JobsLog domain = jobslogMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(jobslogMapping.toDto(jobslogService.getDraft(domain)));
    }

    @ApiOperation(value = "检查任务调度日志", tags = {"任务调度日志" },  notes = "检查任务调度日志")
	@RequestMapping(method = RequestMethod.POST, value = "/jobslogs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody JobsLogDTO jobslogdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(jobslogService.checkKey(jobslogMapping.toDomain(jobslogdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-Save-all')")
    @ApiOperation(value = "保存任务调度日志", tags = {"任务调度日志" },  notes = "保存任务调度日志")
	@RequestMapping(method = RequestMethod.POST, value = "/jobslogs/save")
    public ResponseEntity<Boolean> save(@RequestBody JobsLogDTO jobslogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(jobslogService.save(jobslogMapping.toDomain(jobslogdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-Save-all')")
    @ApiOperation(value = "批量保存任务调度日志", tags = {"任务调度日志" },  notes = "批量保存任务调度日志")
	@RequestMapping(method = RequestMethod.POST, value = "/jobslogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<JobsLogDTO> jobslogdtos) {
        jobslogService.saveBatch(jobslogMapping.toDomain(jobslogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"任务调度日志" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/jobslogs/fetchdefault")
	public ResponseEntity<List<JobsLogDTO>> fetchDefault(JobsLogSearchContext context) {
        Page<JobsLog> domains = jobslogService.searchDefault(context) ;
        List<JobsLogDTO> list = jobslogMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsLog-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"任务调度日志" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/jobslogs/searchdefault")
	public ResponseEntity<Page<JobsLogDTO>> searchDefault(@RequestBody JobsLogSearchContext context) {
        Page<JobsLog> domains = jobslogService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(jobslogMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

