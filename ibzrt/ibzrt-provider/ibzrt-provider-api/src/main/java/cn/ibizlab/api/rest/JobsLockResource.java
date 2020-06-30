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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.api.dto.*;
import cn.ibizlab.api.mapping.*;
import cn.ibizlab.core.task.domain.JobsLock;
import cn.ibizlab.core.task.service.IJobsLockService;
import cn.ibizlab.core.task.filter.JobsLockSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"任务锁" })
@RestController("api-jobslock")
@RequestMapping("")
public class JobsLockResource {

    @Autowired
    public IJobsLockService jobslockService;

    @Autowired
    @Lazy
    public JobsLockMapping jobslockMapping;

    @ApiOperation(value = "获取任务锁草稿", tags = {"任务锁" },  notes = "获取任务锁草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/jobslocks/getdraft")
    public ResponseEntity<JobsLockDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(jobslockMapping.toDto(jobslockService.getDraft(new JobsLock())));
    }

    @ApiOperation(value = "保存任务锁", tags = {"任务锁" },  notes = "保存任务锁")
	@RequestMapping(method = RequestMethod.POST, value = "/jobslocks/save")
    public ResponseEntity<Boolean> save(@RequestBody JobsLockDTO jobslockdto) {
        return ResponseEntity.status(HttpStatus.OK).body(jobslockService.save(jobslockMapping.toDomain(jobslockdto)));
    }

    @ApiOperation(value = "批量保存任务锁", tags = {"任务锁" },  notes = "批量保存任务锁")
	@RequestMapping(method = RequestMethod.POST, value = "/jobslocks/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<JobsLockDTO> jobslockdtos) {
        jobslockService.saveBatch(jobslockMapping.toDomain(jobslockdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新任务锁", tags = {"任务锁" },  notes = "更新任务锁")
	@RequestMapping(method = RequestMethod.PUT, value = "/jobslocks/{jobslock_id}")

    public ResponseEntity<JobsLockDTO> update(@PathVariable("jobslock_id") String jobslock_id, @RequestBody JobsLockDTO jobslockdto) {
		JobsLock domain  = jobslockMapping.toDomain(jobslockdto);
        domain .setId(jobslock_id);
		jobslockService.update(domain );
		JobsLockDTO dto = jobslockMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新任务锁", tags = {"任务锁" },  notes = "批量更新任务锁")
	@RequestMapping(method = RequestMethod.PUT, value = "/jobslocks/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<JobsLockDTO> jobslockdtos) {
        jobslockService.updateBatch(jobslockMapping.toDomain(jobslockdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查任务锁", tags = {"任务锁" },  notes = "检查任务锁")
	@RequestMapping(method = RequestMethod.POST, value = "/jobslocks/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody JobsLockDTO jobslockdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(jobslockService.checkKey(jobslockMapping.toDomain(jobslockdto)));
    }

    @ApiOperation(value = "删除任务锁", tags = {"任务锁" },  notes = "删除任务锁")
	@RequestMapping(method = RequestMethod.DELETE, value = "/jobslocks/{jobslock_id}")

    public ResponseEntity<Boolean> remove(@PathVariable("jobslock_id") String jobslock_id) {
         return ResponseEntity.status(HttpStatus.OK).body(jobslockService.remove(jobslock_id));
    }

    @ApiOperation(value = "批量删除任务锁", tags = {"任务锁" },  notes = "批量删除任务锁")
	@RequestMapping(method = RequestMethod.DELETE, value = "/jobslocks/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        jobslockService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取任务锁", tags = {"任务锁" },  notes = "获取任务锁")
	@RequestMapping(method = RequestMethod.GET, value = "/jobslocks/{jobslock_id}")
    public ResponseEntity<JobsLockDTO> get(@PathVariable("jobslock_id") String jobslock_id) {
        JobsLock domain = jobslockService.get(jobslock_id);
        JobsLockDTO dto = jobslockMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "新建任务锁", tags = {"任务锁" },  notes = "新建任务锁")
	@RequestMapping(method = RequestMethod.POST, value = "/jobslocks")

    public ResponseEntity<JobsLockDTO> create(@RequestBody JobsLockDTO jobslockdto) {
        JobsLock domain = jobslockMapping.toDomain(jobslockdto);
		jobslockService.create(domain);
        JobsLockDTO dto = jobslockMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建任务锁", tags = {"任务锁" },  notes = "批量新建任务锁")
	@RequestMapping(method = RequestMethod.POST, value = "/jobslocks/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<JobsLockDTO> jobslockdtos) {
        jobslockService.createBatch(jobslockMapping.toDomain(jobslockdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-JobsLock-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"任务锁" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/jobslocks/fetchdefault")
	public ResponseEntity<List<JobsLockDTO>> fetchDefault(JobsLockSearchContext context) {
        Page<JobsLock> domains = jobslockService.searchDefault(context) ;
        List<JobsLockDTO> list = jobslockMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-JobsLock-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"任务锁" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/jobslocks/searchdefault")
	public ResponseEntity<Page<JobsLockDTO>> searchDefault(@RequestBody JobsLockSearchContext context) {
        Page<JobsLock> domains = jobslockService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(jobslockMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

