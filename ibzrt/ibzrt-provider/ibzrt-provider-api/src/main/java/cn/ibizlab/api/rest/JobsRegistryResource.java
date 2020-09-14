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
import cn.ibizlab.core.task.domain.JobsRegistry;
import cn.ibizlab.core.task.service.IJobsRegistryService;
import cn.ibizlab.core.task.filter.JobsRegistrySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"任务注册信息" })
@RestController("api-jobsregistry")
@RequestMapping("")
public class JobsRegistryResource {

    @Autowired
    public IJobsRegistryService jobsregistryService;

    @Autowired
    @Lazy
    public JobsRegistryMapping jobsregistryMapping;

    @ApiOperation(value = "新建任务注册信息", tags = {"任务注册信息" },  notes = "新建任务注册信息")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsregistries")
    public ResponseEntity<JobsRegistryDTO> create(@Validated @RequestBody JobsRegistryDTO jobsregistrydto) {
        JobsRegistry domain = jobsregistryMapping.toDomain(jobsregistrydto);
		jobsregistryService.create(domain);
        JobsRegistryDTO dto = jobsregistryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建任务注册信息", tags = {"任务注册信息" },  notes = "批量新建任务注册信息")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsregistries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<JobsRegistryDTO> jobsregistrydtos) {
        jobsregistryService.createBatch(jobsregistryMapping.toDomain(jobsregistrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新任务注册信息", tags = {"任务注册信息" },  notes = "更新任务注册信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/jobsregistries/{jobsregistry_id}")
    public ResponseEntity<JobsRegistryDTO> update(@PathVariable("jobsregistry_id") String jobsregistry_id, @RequestBody JobsRegistryDTO jobsregistrydto) {
		JobsRegistry domain  = jobsregistryMapping.toDomain(jobsregistrydto);
        domain .setId(jobsregistry_id);
		jobsregistryService.update(domain );
		JobsRegistryDTO dto = jobsregistryMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新任务注册信息", tags = {"任务注册信息" },  notes = "批量更新任务注册信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/jobsregistries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<JobsRegistryDTO> jobsregistrydtos) {
        jobsregistryService.updateBatch(jobsregistryMapping.toDomain(jobsregistrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "删除任务注册信息", tags = {"任务注册信息" },  notes = "删除任务注册信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/jobsregistries/{jobsregistry_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("jobsregistry_id") String jobsregistry_id) {
         return ResponseEntity.status(HttpStatus.OK).body(jobsregistryService.remove(jobsregistry_id));
    }

    @ApiOperation(value = "批量删除任务注册信息", tags = {"任务注册信息" },  notes = "批量删除任务注册信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/jobsregistries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        jobsregistryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取任务注册信息", tags = {"任务注册信息" },  notes = "获取任务注册信息")
	@RequestMapping(method = RequestMethod.GET, value = "/jobsregistries/{jobsregistry_id}")
    public ResponseEntity<JobsRegistryDTO> get(@PathVariable("jobsregistry_id") String jobsregistry_id) {
        JobsRegistry domain = jobsregistryService.get(jobsregistry_id);
        JobsRegistryDTO dto = jobsregistryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取任务注册信息草稿", tags = {"任务注册信息" },  notes = "获取任务注册信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/jobsregistries/getdraft")
    public ResponseEntity<JobsRegistryDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(jobsregistryMapping.toDto(jobsregistryService.getDraft(new JobsRegistry())));
    }

    @ApiOperation(value = "检查任务注册信息", tags = {"任务注册信息" },  notes = "检查任务注册信息")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsregistries/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody JobsRegistryDTO jobsregistrydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(jobsregistryService.checkKey(jobsregistryMapping.toDomain(jobsregistrydto)));
    }

    @ApiOperation(value = "保存任务注册信息", tags = {"任务注册信息" },  notes = "保存任务注册信息")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsregistries/save")
    public ResponseEntity<Boolean> save(@RequestBody JobsRegistryDTO jobsregistrydto) {
        return ResponseEntity.status(HttpStatus.OK).body(jobsregistryService.save(jobsregistryMapping.toDomain(jobsregistrydto)));
    }

    @ApiOperation(value = "批量保存任务注册信息", tags = {"任务注册信息" },  notes = "批量保存任务注册信息")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsregistries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<JobsRegistryDTO> jobsregistrydtos) {
        jobsregistryService.saveBatch(jobsregistryMapping.toDomain(jobsregistrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"任务注册信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/jobsregistries/fetchdefault")
	public ResponseEntity<List<JobsRegistryDTO>> fetchDefault(JobsRegistrySearchContext context) {
        Page<JobsRegistry> domains = jobsregistryService.searchDefault(context) ;
        List<JobsRegistryDTO> list = jobsregistryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"任务注册信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/jobsregistries/searchdefault")
	public ResponseEntity<Page<JobsRegistryDTO>> searchDefault(@RequestBody JobsRegistrySearchContext context) {
        Page<JobsRegistry> domains = jobsregistryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(jobsregistryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

