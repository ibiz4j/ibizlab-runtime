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
import cn.ibizlab.core.workflow.domain.WFSystem;
import cn.ibizlab.core.workflow.service.IWFSystemService;
import cn.ibizlab.core.workflow.filter.WFSystemSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"系统" })
@RestController("api-wfsystem")
@RequestMapping("")
public class WFSystemResource {

    @Autowired
    public IWFSystemService wfsystemService;

    @Autowired
    @Lazy
    public WFSystemMapping wfsystemMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-Create-all')")
    @ApiOperation(value = "新建系统", tags = {"系统" },  notes = "新建系统")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsystems")
    public ResponseEntity<WFSystemDTO> create(@Validated @RequestBody WFSystemDTO wfsystemdto) {
        WFSystem domain = wfsystemMapping.toDomain(wfsystemdto);
		wfsystemService.create(domain);
        WFSystemDTO dto = wfsystemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-Create-all')")
    @ApiOperation(value = "批量新建系统", tags = {"系统" },  notes = "批量新建系统")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsystems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFSystemDTO> wfsystemdtos) {
        wfsystemService.createBatch(wfsystemMapping.toDomain(wfsystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-Update-all')")
    @ApiOperation(value = "更新系统", tags = {"系统" },  notes = "更新系统")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfsystems/{wfsystem_id}")
    public ResponseEntity<WFSystemDTO> update(@PathVariable("wfsystem_id") String wfsystem_id, @RequestBody WFSystemDTO wfsystemdto) {
		WFSystem domain  = wfsystemMapping.toDomain(wfsystemdto);
        domain .setPssystemid(wfsystem_id);
		wfsystemService.update(domain );
		WFSystemDTO dto = wfsystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-Update-all')")
    @ApiOperation(value = "批量更新系统", tags = {"系统" },  notes = "批量更新系统")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfsystems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFSystemDTO> wfsystemdtos) {
        wfsystemService.updateBatch(wfsystemMapping.toDomain(wfsystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-Remove-all')")
    @ApiOperation(value = "删除系统", tags = {"系统" },  notes = "删除系统")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfsystems/{wfsystem_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("wfsystem_id") String wfsystem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfsystemService.remove(wfsystem_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-Remove-all')")
    @ApiOperation(value = "批量删除系统", tags = {"系统" },  notes = "批量删除系统")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfsystems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfsystemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-Get-all')")
    @ApiOperation(value = "获取系统", tags = {"系统" },  notes = "获取系统")
	@RequestMapping(method = RequestMethod.GET, value = "/wfsystems/{wfsystem_id}")
    public ResponseEntity<WFSystemDTO> get(@PathVariable("wfsystem_id") String wfsystem_id) {
        WFSystem domain = wfsystemService.get(wfsystem_id);
        WFSystemDTO dto = wfsystemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取系统草稿", tags = {"系统" },  notes = "获取系统草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wfsystems/getdraft")
    public ResponseEntity<WFSystemDTO> getDraft(WFSystemDTO dto) {
        WFSystem domain = wfsystemMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(wfsystemMapping.toDto(wfsystemService.getDraft(domain)));
    }

    @ApiOperation(value = "检查系统", tags = {"系统" },  notes = "检查系统")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsystems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFSystemDTO wfsystemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfsystemService.checkKey(wfsystemMapping.toDomain(wfsystemdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-Save-all')")
    @ApiOperation(value = "保存系统", tags = {"系统" },  notes = "保存系统")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsystems/save")
    public ResponseEntity<WFSystemDTO> save(@RequestBody WFSystemDTO wfsystemdto) {
        WFSystem domain = wfsystemMapping.toDomain(wfsystemdto);
        wfsystemService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(wfsystemMapping.toDto(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-Save-all')")
    @ApiOperation(value = "批量保存系统", tags = {"系统" },  notes = "批量保存系统")
	@RequestMapping(method = RequestMethod.POST, value = "/wfsystems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFSystemDTO> wfsystemdtos) {
        wfsystemService.saveBatch(wfsystemMapping.toDomain(wfsystemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"系统" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfsystems/fetchdefault")
	public ResponseEntity<List<WFSystemDTO>> fetchDefault(WFSystemSearchContext context) {
        Page<WFSystem> domains = wfsystemService.searchDefault(context) ;
        List<WFSystemDTO> list = wfsystemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFSystem-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"系统" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfsystems/searchdefault")
	public ResponseEntity<Page<WFSystemDTO>> searchDefault(@RequestBody WFSystemSearchContext context) {
        Page<WFSystem> domains = wfsystemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfsystemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

