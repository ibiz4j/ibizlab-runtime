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
import cn.ibizlab.core.task.domain.JobsInfo;
import cn.ibizlab.core.task.service.IJobsInfoService;
import cn.ibizlab.core.task.filter.JobsInfoSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"任务信息" })
@RestController("api-jobsinfo")
@RequestMapping("")
public class JobsInfoResource {

    @Autowired
    public IJobsInfoService jobsinfoService;

    @Autowired
    @Lazy
    public JobsInfoMapping jobsinfoMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Create-all')")
    @ApiOperation(value = "新建任务信息", tags = {"任务信息" },  notes = "新建任务信息")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsinfos")
    public ResponseEntity<JobsInfoDTO> create(@Validated @RequestBody JobsInfoDTO jobsinfodto) {
        JobsInfo domain = jobsinfoMapping.toDomain(jobsinfodto);
		jobsinfoService.create(domain);
        JobsInfoDTO dto = jobsinfoMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Create-all')")
    @ApiOperation(value = "批量新建任务信息", tags = {"任务信息" },  notes = "批量新建任务信息")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<JobsInfoDTO> jobsinfodtos) {
        jobsinfoService.createBatch(jobsinfoMapping.toDomain(jobsinfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Update-all')")
    @ApiOperation(value = "更新任务信息", tags = {"任务信息" },  notes = "更新任务信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/jobsinfos/{jobsinfo_id}")
    public ResponseEntity<JobsInfoDTO> update(@PathVariable("jobsinfo_id") String jobsinfo_id, @RequestBody JobsInfoDTO jobsinfodto) {
		JobsInfo domain  = jobsinfoMapping.toDomain(jobsinfodto);
        domain .setId(jobsinfo_id);
		jobsinfoService.update(domain );
		JobsInfoDTO dto = jobsinfoMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Update-all')")
    @ApiOperation(value = "批量更新任务信息", tags = {"任务信息" },  notes = "批量更新任务信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/jobsinfos/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<JobsInfoDTO> jobsinfodtos) {
        jobsinfoService.updateBatch(jobsinfoMapping.toDomain(jobsinfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Remove-all')")
    @ApiOperation(value = "删除任务信息", tags = {"任务信息" },  notes = "删除任务信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/jobsinfos/{jobsinfo_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("jobsinfo_id") String jobsinfo_id) {
         return ResponseEntity.status(HttpStatus.OK).body(jobsinfoService.remove(jobsinfo_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Remove-all')")
    @ApiOperation(value = "批量删除任务信息", tags = {"任务信息" },  notes = "批量删除任务信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/jobsinfos/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        jobsinfoService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Get-all')")
    @ApiOperation(value = "获取任务信息", tags = {"任务信息" },  notes = "获取任务信息")
	@RequestMapping(method = RequestMethod.GET, value = "/jobsinfos/{jobsinfo_id}")
    public ResponseEntity<JobsInfoDTO> get(@PathVariable("jobsinfo_id") String jobsinfo_id) {
        JobsInfo domain = jobsinfoService.get(jobsinfo_id);
        JobsInfoDTO dto = jobsinfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取任务信息草稿", tags = {"任务信息" },  notes = "获取任务信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/jobsinfos/getdraft")
    public ResponseEntity<JobsInfoDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(jobsinfoMapping.toDto(jobsinfoService.getDraft(new JobsInfo())));
    }

    @ApiOperation(value = "检查任务信息", tags = {"任务信息" },  notes = "检查任务信息")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody JobsInfoDTO jobsinfodto) {
        return  ResponseEntity.status(HttpStatus.OK).body(jobsinfoService.checkKey(jobsinfoMapping.toDomain(jobsinfodto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Execute-all')")
    @ApiOperation(value = "执行", tags = {"任务信息" },  notes = "执行")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/{jobsinfo_id}/execute")
    public ResponseEntity<JobsInfoDTO> execute(@PathVariable("jobsinfo_id") String jobsinfo_id, @RequestBody JobsInfoDTO jobsinfodto) {
        JobsInfo domain = jobsinfoMapping.toDomain(jobsinfodto);
        domain.setId(jobsinfo_id);
        domain = jobsinfoService.execute(domain);
        jobsinfodto = jobsinfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(jobsinfodto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Save-all')")
    @ApiOperation(value = "保存任务信息", tags = {"任务信息" },  notes = "保存任务信息")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/save")
    public ResponseEntity<Boolean> save(@RequestBody JobsInfoDTO jobsinfodto) {
        return ResponseEntity.status(HttpStatus.OK).body(jobsinfoService.save(jobsinfoMapping.toDomain(jobsinfodto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Save-all')")
    @ApiOperation(value = "批量保存任务信息", tags = {"任务信息" },  notes = "批量保存任务信息")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<JobsInfoDTO> jobsinfodtos) {
        jobsinfoService.saveBatch(jobsinfoMapping.toDomain(jobsinfodtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Start-all')")
    @ApiOperation(value = "开始", tags = {"任务信息" },  notes = "开始")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/{jobsinfo_id}/start")
    public ResponseEntity<JobsInfoDTO> start(@PathVariable("jobsinfo_id") String jobsinfo_id, @RequestBody JobsInfoDTO jobsinfodto) {
        JobsInfo domain = jobsinfoMapping.toDomain(jobsinfodto);
        domain.setId(jobsinfo_id);
        domain = jobsinfoService.start(domain);
        jobsinfodto = jobsinfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(jobsinfodto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-Stop-all')")
    @ApiOperation(value = "停止", tags = {"任务信息" },  notes = "停止")
	@RequestMapping(method = RequestMethod.POST, value = "/jobsinfos/{jobsinfo_id}/stop")
    public ResponseEntity<JobsInfoDTO> stop(@PathVariable("jobsinfo_id") String jobsinfo_id, @RequestBody JobsInfoDTO jobsinfodto) {
        JobsInfo domain = jobsinfoMapping.toDomain(jobsinfodto);
        domain.setId(jobsinfo_id);
        domain = jobsinfoService.stop(domain);
        jobsinfodto = jobsinfoMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(jobsinfodto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"任务信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/jobsinfos/fetchdefault")
	public ResponseEntity<List<JobsInfoDTO>> fetchDefault(JobsInfoSearchContext context) {
        Page<JobsInfo> domains = jobsinfoService.searchDefault(context) ;
        List<JobsInfoDTO> list = jobsinfoMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibztask-JobsInfo-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"任务信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/jobsinfos/searchdefault")
	public ResponseEntity<Page<JobsInfoDTO>> searchDefault(@RequestBody JobsInfoSearchContext context) {
        Page<JobsInfo> domains = jobsinfoService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(jobsinfoMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

