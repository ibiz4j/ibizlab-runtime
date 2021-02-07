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
import cn.ibizlab.core.workflow.domain.WFGroup;
import cn.ibizlab.core.workflow.service.IWFGroupService;
import cn.ibizlab.core.workflow.filter.WFGroupSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"角色/用户组" })
@RestController("api-wfgroup")
@RequestMapping("")
public class WFGroupResource {

    @Autowired
    public IWFGroupService wfgroupService;

    @Autowired
    @Lazy
    public WFGroupMapping wfgroupMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-Create-all')")
    @ApiOperation(value = "新建角色/用户组", tags = {"角色/用户组" },  notes = "新建角色/用户组")
	@RequestMapping(method = RequestMethod.POST, value = "/wfgroups")
    public ResponseEntity<WFGroupDTO> create(@Validated @RequestBody WFGroupDTO wfgroupdto) {
        WFGroup domain = wfgroupMapping.toDomain(wfgroupdto);
		wfgroupService.create(domain);
        WFGroupDTO dto = wfgroupMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-Create-all')")
    @ApiOperation(value = "批量新建角色/用户组", tags = {"角色/用户组" },  notes = "批量新建角色/用户组")
	@RequestMapping(method = RequestMethod.POST, value = "/wfgroups/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFGroupDTO> wfgroupdtos) {
        wfgroupService.createBatch(wfgroupMapping.toDomain(wfgroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-Update-all')")
    @ApiOperation(value = "更新角色/用户组", tags = {"角色/用户组" },  notes = "更新角色/用户组")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfgroups/{wfgroup_id}")
    public ResponseEntity<WFGroupDTO> update(@PathVariable("wfgroup_id") String wfgroup_id, @RequestBody WFGroupDTO wfgroupdto) {
		WFGroup domain  = wfgroupMapping.toDomain(wfgroupdto);
        domain .setId(wfgroup_id);
		wfgroupService.update(domain );
		WFGroupDTO dto = wfgroupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-Update-all')")
    @ApiOperation(value = "批量更新角色/用户组", tags = {"角色/用户组" },  notes = "批量更新角色/用户组")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfgroups/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFGroupDTO> wfgroupdtos) {
        wfgroupService.updateBatch(wfgroupMapping.toDomain(wfgroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-Remove-all')")
    @ApiOperation(value = "删除角色/用户组", tags = {"角色/用户组" },  notes = "删除角色/用户组")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfgroups/{wfgroup_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("wfgroup_id") String wfgroup_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfgroupService.remove(wfgroup_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-Remove-all')")
    @ApiOperation(value = "批量删除角色/用户组", tags = {"角色/用户组" },  notes = "批量删除角色/用户组")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfgroups/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfgroupService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-Get-all')")
    @ApiOperation(value = "获取角色/用户组", tags = {"角色/用户组" },  notes = "获取角色/用户组")
	@RequestMapping(method = RequestMethod.GET, value = "/wfgroups/{wfgroup_id}")
    public ResponseEntity<WFGroupDTO> get(@PathVariable("wfgroup_id") String wfgroup_id) {
        WFGroup domain = wfgroupService.get(wfgroup_id);
        WFGroupDTO dto = wfgroupMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取角色/用户组草稿", tags = {"角色/用户组" },  notes = "获取角色/用户组草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wfgroups/getdraft")
    public ResponseEntity<WFGroupDTO> getDraft(WFGroupDTO dto) {
        WFGroup domain = wfgroupMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(wfgroupMapping.toDto(wfgroupService.getDraft(domain)));
    }

    @ApiOperation(value = "检查角色/用户组", tags = {"角色/用户组" },  notes = "检查角色/用户组")
	@RequestMapping(method = RequestMethod.POST, value = "/wfgroups/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFGroupDTO wfgroupdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfgroupService.checkKey(wfgroupMapping.toDomain(wfgroupdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-Save-all')")
    @ApiOperation(value = "保存角色/用户组", tags = {"角色/用户组" },  notes = "保存角色/用户组")
	@RequestMapping(method = RequestMethod.POST, value = "/wfgroups/save")
    public ResponseEntity<WFGroupDTO> save(@RequestBody WFGroupDTO wfgroupdto) {
        WFGroup domain = wfgroupMapping.toDomain(wfgroupdto);
        wfgroupService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(wfgroupMapping.toDto(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-Save-all')")
    @ApiOperation(value = "批量保存角色/用户组", tags = {"角色/用户组" },  notes = "批量保存角色/用户组")
	@RequestMapping(method = RequestMethod.POST, value = "/wfgroups/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFGroupDTO> wfgroupdtos) {
        wfgroupService.saveBatch(wfgroupMapping.toDomain(wfgroupdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"角色/用户组" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfgroups/fetchdefault")
	public ResponseEntity<List<WFGroupDTO>> fetchDefault(WFGroupSearchContext context) {
        Page<WFGroup> domains = wfgroupService.searchDefault(context) ;
        List<WFGroupDTO> list = wfgroupMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFGroup-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"角色/用户组" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfgroups/searchdefault")
	public ResponseEntity<Page<WFGroupDTO>> searchDefault(@RequestBody WFGroupSearchContext context) {
        Page<WFGroup> domains = wfgroupService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfgroupMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

