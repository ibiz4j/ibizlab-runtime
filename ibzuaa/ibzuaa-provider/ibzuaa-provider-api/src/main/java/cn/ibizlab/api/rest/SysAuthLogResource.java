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
import cn.ibizlab.core.uaa.domain.SysAuthLog;
import cn.ibizlab.core.uaa.service.ISysAuthLogService;
import cn.ibizlab.core.uaa.filter.SysAuthLogSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"认证日志" })
@RestController("api-sysauthlog")
@RequestMapping("")
public class SysAuthLogResource {

    @Autowired
    public ISysAuthLogService sysauthlogService;

    @Autowired
    @Lazy
    public SysAuthLogMapping sysauthlogMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-Create-all')")
    @ApiOperation(value = "新建认证日志", tags = {"认证日志" },  notes = "新建认证日志")
	@RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs")
    public ResponseEntity<SysAuthLogDTO> create(@Validated @RequestBody SysAuthLogDTO sysauthlogdto) {
        SysAuthLog domain = sysauthlogMapping.toDomain(sysauthlogdto);
		sysauthlogService.create(domain);
        SysAuthLogDTO dto = sysauthlogMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-Create-all')")
    @ApiOperation(value = "批量新建认证日志", tags = {"认证日志" },  notes = "批量新建认证日志")
	@RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysAuthLogDTO> sysauthlogdtos) {
        sysauthlogService.createBatch(sysauthlogMapping.toDomain(sysauthlogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-Update-all')")
    @ApiOperation(value = "更新认证日志", tags = {"认证日志" },  notes = "更新认证日志")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysauthlogs/{sysauthlog_id}")
    public ResponseEntity<SysAuthLogDTO> update(@PathVariable("sysauthlog_id") String sysauthlog_id, @RequestBody SysAuthLogDTO sysauthlogdto) {
		SysAuthLog domain  = sysauthlogMapping.toDomain(sysauthlogdto);
        domain .setLogid(sysauthlog_id);
		sysauthlogService.update(domain );
		SysAuthLogDTO dto = sysauthlogMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-Update-all')")
    @ApiOperation(value = "批量更新认证日志", tags = {"认证日志" },  notes = "批量更新认证日志")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysauthlogs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysAuthLogDTO> sysauthlogdtos) {
        sysauthlogService.updateBatch(sysauthlogMapping.toDomain(sysauthlogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-Remove-all')")
    @ApiOperation(value = "删除认证日志", tags = {"认证日志" },  notes = "删除认证日志")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysauthlogs/{sysauthlog_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("sysauthlog_id") String sysauthlog_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysauthlogService.remove(sysauthlog_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-Remove-all')")
    @ApiOperation(value = "批量删除认证日志", tags = {"认证日志" },  notes = "批量删除认证日志")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysauthlogs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysauthlogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-Get-all')")
    @ApiOperation(value = "获取认证日志", tags = {"认证日志" },  notes = "获取认证日志")
	@RequestMapping(method = RequestMethod.GET, value = "/sysauthlogs/{sysauthlog_id}")
    public ResponseEntity<SysAuthLogDTO> get(@PathVariable("sysauthlog_id") String sysauthlog_id) {
        SysAuthLog domain = sysauthlogService.get(sysauthlog_id);
        SysAuthLogDTO dto = sysauthlogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取认证日志草稿", tags = {"认证日志" },  notes = "获取认证日志草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sysauthlogs/getdraft")
    public ResponseEntity<SysAuthLogDTO> getDraft(SysAuthLogDTO dto) {
        SysAuthLog domain = sysauthlogMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(sysauthlogMapping.toDto(sysauthlogService.getDraft(domain)));
    }

    @ApiOperation(value = "检查认证日志", tags = {"认证日志" },  notes = "检查认证日志")
	@RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysAuthLogDTO sysauthlogdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysauthlogService.checkKey(sysauthlogMapping.toDomain(sysauthlogdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-Save-all')")
    @ApiOperation(value = "保存认证日志", tags = {"认证日志" },  notes = "保存认证日志")
	@RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs/save")
    public ResponseEntity<Boolean> save(@RequestBody SysAuthLogDTO sysauthlogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(sysauthlogService.save(sysauthlogMapping.toDomain(sysauthlogdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-Save-all')")
    @ApiOperation(value = "批量保存认证日志", tags = {"认证日志" },  notes = "批量保存认证日志")
	@RequestMapping(method = RequestMethod.POST, value = "/sysauthlogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysAuthLogDTO> sysauthlogdtos) {
        sysauthlogService.saveBatch(sysauthlogMapping.toDomain(sysauthlogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"认证日志" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysauthlogs/fetchdefault")
	public ResponseEntity<List<SysAuthLogDTO>> fetchDefault(SysAuthLogSearchContext context) {
        Page<SysAuthLog> domains = sysauthlogService.searchDefault(context) ;
        List<SysAuthLogDTO> list = sysauthlogMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysAuthLog-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"认证日志" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysauthlogs/searchdefault")
	public ResponseEntity<Page<SysAuthLogDTO>> searchDefault(@RequestBody SysAuthLogSearchContext context) {
        Page<SysAuthLog> domains = sysauthlogService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysauthlogMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

