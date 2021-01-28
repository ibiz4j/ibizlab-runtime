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
import cn.ibizlab.core.uaa.domain.SysRolePermission;
import cn.ibizlab.core.uaa.service.ISysRolePermissionService;
import cn.ibizlab.core.uaa.filter.SysRolePermissionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"角色权限关系" })
@RestController("api-sysrolepermission")
@RequestMapping("")
public class SysRolePermissionResource {

    @Autowired
    public ISysRolePermissionService sysrolepermissionService;

    @Autowired
    @Lazy
    public SysRolePermissionMapping sysrolepermissionMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Create-all')")
    @ApiOperation(value = "新建角色权限关系", tags = {"角色权限关系" },  notes = "新建角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions")
    public ResponseEntity<SysRolePermissionDTO> create(@Validated @RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        SysRolePermission domain = sysrolepermissionMapping.toDomain(sysrolepermissiondto);
		sysrolepermissionService.create(domain);
        SysRolePermissionDTO dto = sysrolepermissionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Create-all')")
    @ApiOperation(value = "批量新建角色权限关系", tags = {"角色权限关系" },  notes = "批量新建角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysRolePermissionDTO> sysrolepermissiondtos) {
        sysrolepermissionService.createBatch(sysrolepermissionMapping.toDomain(sysrolepermissiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysrolepermission" , versionfield = "updatedate")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Update-all')")
    @ApiOperation(value = "更新角色权限关系", tags = {"角色权限关系" },  notes = "更新角色权限关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysrolepermissions/{sysrolepermission_id}")
    public ResponseEntity<SysRolePermissionDTO> update(@PathVariable("sysrolepermission_id") String sysrolepermission_id, @RequestBody SysRolePermissionDTO sysrolepermissiondto) {
		SysRolePermission domain  = sysrolepermissionMapping.toDomain(sysrolepermissiondto);
        domain .setRolepermissionid(sysrolepermission_id);
		sysrolepermissionService.update(domain );
		SysRolePermissionDTO dto = sysrolepermissionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Update-all')")
    @ApiOperation(value = "批量更新角色权限关系", tags = {"角色权限关系" },  notes = "批量更新角色权限关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysrolepermissions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysRolePermissionDTO> sysrolepermissiondtos) {
        sysrolepermissionService.updateBatch(sysrolepermissionMapping.toDomain(sysrolepermissiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Remove-all')")
    @ApiOperation(value = "删除角色权限关系", tags = {"角色权限关系" },  notes = "删除角色权限关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysrolepermissions/{sysrolepermission_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("sysrolepermission_id") String sysrolepermission_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionService.remove(sysrolepermission_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Remove-all')")
    @ApiOperation(value = "批量删除角色权限关系", tags = {"角色权限关系" },  notes = "批量删除角色权限关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysrolepermissions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysrolepermissionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Get-all')")
    @ApiOperation(value = "获取角色权限关系", tags = {"角色权限关系" },  notes = "获取角色权限关系")
	@RequestMapping(method = RequestMethod.GET, value = "/sysrolepermissions/{sysrolepermission_id}")
    public ResponseEntity<SysRolePermissionDTO> get(@PathVariable("sysrolepermission_id") String sysrolepermission_id) {
        SysRolePermission domain = sysrolepermissionService.get(sysrolepermission_id);
        SysRolePermissionDTO dto = sysrolepermissionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取角色权限关系草稿", tags = {"角色权限关系" },  notes = "获取角色权限关系草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sysrolepermissions/getdraft")
    public ResponseEntity<SysRolePermissionDTO> getDraft(SysRolePermissionDTO dto) {
        SysRolePermission domain = sysrolepermissionMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionMapping.toDto(sysrolepermissionService.getDraft(domain)));
    }

    @ApiOperation(value = "检查角色权限关系", tags = {"角色权限关系" },  notes = "检查角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionService.checkKey(sysrolepermissionMapping.toDomain(sysrolepermissiondto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Save-all')")
    @ApiOperation(value = "保存角色权限关系", tags = {"角色权限关系" },  notes = "保存角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions/save")
    public ResponseEntity<Boolean> save(@RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionService.save(sysrolepermissionMapping.toDomain(sysrolepermissiondto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Save-all')")
    @ApiOperation(value = "批量保存角色权限关系", tags = {"角色权限关系" },  notes = "批量保存角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysrolepermissions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysRolePermissionDTO> sysrolepermissiondtos) {
        sysrolepermissionService.saveBatch(sysrolepermissionMapping.toDomain(sysrolepermissiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"角色权限关系" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysrolepermissions/fetchdefault")
	public ResponseEntity<List<SysRolePermissionDTO>> fetchDefault(SysRolePermissionSearchContext context) {
        Page<SysRolePermission> domains = sysrolepermissionService.searchDefault(context) ;
        List<SysRolePermissionDTO> list = sysrolepermissionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"角色权限关系" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysrolepermissions/searchdefault")
	public ResponseEntity<Page<SysRolePermissionDTO>> searchDefault(@RequestBody SysRolePermissionSearchContext context) {
        Page<SysRolePermission> domains = sysrolepermissionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysrolepermissionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Create-all')")
    @ApiOperation(value = "根据权限/资源建立角色权限关系", tags = {"角色权限关系" },  notes = "根据权限/资源建立角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/syspermissions/{syspermission_id}/sysrolepermissions")
    public ResponseEntity<SysRolePermissionDTO> createBySysPermission(@PathVariable("syspermission_id") String syspermission_id, @RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        SysRolePermission domain = sysrolepermissionMapping.toDomain(sysrolepermissiondto);
        domain.setPermissionid(syspermission_id);
		sysrolepermissionService.create(domain);
        SysRolePermissionDTO dto = sysrolepermissionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Create-all')")
    @ApiOperation(value = "根据权限/资源批量建立角色权限关系", tags = {"角色权限关系" },  notes = "根据权限/资源批量建立角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/syspermissions/{syspermission_id}/sysrolepermissions/batch")
    public ResponseEntity<Boolean> createBatchBySysPermission(@PathVariable("syspermission_id") String syspermission_id, @RequestBody List<SysRolePermissionDTO> sysrolepermissiondtos) {
        List<SysRolePermission> domainlist=sysrolepermissionMapping.toDomain(sysrolepermissiondtos);
        for(SysRolePermission domain:domainlist){
            domain.setPermissionid(syspermission_id);
        }
        sysrolepermissionService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysrolepermission" , versionfield = "updatedate")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Update-all')")
    @ApiOperation(value = "根据权限/资源更新角色权限关系", tags = {"角色权限关系" },  notes = "根据权限/资源更新角色权限关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/syspermissions/{syspermission_id}/sysrolepermissions/{sysrolepermission_id}")
    public ResponseEntity<SysRolePermissionDTO> updateBySysPermission(@PathVariable("syspermission_id") String syspermission_id, @PathVariable("sysrolepermission_id") String sysrolepermission_id, @RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        SysRolePermission domain = sysrolepermissionMapping.toDomain(sysrolepermissiondto);
        domain.setPermissionid(syspermission_id);
        domain.setRolepermissionid(sysrolepermission_id);
		sysrolepermissionService.update(domain);
        SysRolePermissionDTO dto = sysrolepermissionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Update-all')")
    @ApiOperation(value = "根据权限/资源批量更新角色权限关系", tags = {"角色权限关系" },  notes = "根据权限/资源批量更新角色权限关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/syspermissions/{syspermission_id}/sysrolepermissions/batch")
    public ResponseEntity<Boolean> updateBatchBySysPermission(@PathVariable("syspermission_id") String syspermission_id, @RequestBody List<SysRolePermissionDTO> sysrolepermissiondtos) {
        List<SysRolePermission> domainlist=sysrolepermissionMapping.toDomain(sysrolepermissiondtos);
        for(SysRolePermission domain:domainlist){
            domain.setPermissionid(syspermission_id);
        }
        sysrolepermissionService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Remove-all')")
    @ApiOperation(value = "根据权限/资源删除角色权限关系", tags = {"角色权限关系" },  notes = "根据权限/资源删除角色权限关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/syspermissions/{syspermission_id}/sysrolepermissions/{sysrolepermission_id}")
    public ResponseEntity<Boolean> removeBySysPermission(@PathVariable("syspermission_id") String syspermission_id, @PathVariable("sysrolepermission_id") String sysrolepermission_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionService.remove(sysrolepermission_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Remove-all')")
    @ApiOperation(value = "根据权限/资源批量删除角色权限关系", tags = {"角色权限关系" },  notes = "根据权限/资源批量删除角色权限关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/syspermissions/{syspermission_id}/sysrolepermissions/batch")
    public ResponseEntity<Boolean> removeBatchBySysPermission(@RequestBody List<String> ids) {
        sysrolepermissionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Get-all')")
    @ApiOperation(value = "根据权限/资源获取角色权限关系", tags = {"角色权限关系" },  notes = "根据权限/资源获取角色权限关系")
	@RequestMapping(method = RequestMethod.GET, value = "/syspermissions/{syspermission_id}/sysrolepermissions/{sysrolepermission_id}")
    public ResponseEntity<SysRolePermissionDTO> getBySysPermission(@PathVariable("syspermission_id") String syspermission_id, @PathVariable("sysrolepermission_id") String sysrolepermission_id) {
        SysRolePermission domain = sysrolepermissionService.get(sysrolepermission_id);
        SysRolePermissionDTO dto = sysrolepermissionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据权限/资源获取角色权限关系草稿", tags = {"角色权限关系" },  notes = "根据权限/资源获取角色权限关系草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/syspermissions/{syspermission_id}/sysrolepermissions/getdraft")
    public ResponseEntity<SysRolePermissionDTO> getDraftBySysPermission(@PathVariable("syspermission_id") String syspermission_id, SysRolePermissionDTO dto) {
        SysRolePermission domain = sysrolepermissionMapping.toDomain(dto);
        domain.setPermissionid(syspermission_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionMapping.toDto(sysrolepermissionService.getDraft(domain)));
    }

    @ApiOperation(value = "根据权限/资源检查角色权限关系", tags = {"角色权限关系" },  notes = "根据权限/资源检查角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/syspermissions/{syspermission_id}/sysrolepermissions/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysPermission(@PathVariable("syspermission_id") String syspermission_id, @RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionService.checkKey(sysrolepermissionMapping.toDomain(sysrolepermissiondto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Save-all')")
    @ApiOperation(value = "根据权限/资源保存角色权限关系", tags = {"角色权限关系" },  notes = "根据权限/资源保存角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/syspermissions/{syspermission_id}/sysrolepermissions/save")
    public ResponseEntity<Boolean> saveBySysPermission(@PathVariable("syspermission_id") String syspermission_id, @RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        SysRolePermission domain = sysrolepermissionMapping.toDomain(sysrolepermissiondto);
        domain.setPermissionid(syspermission_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionService.save(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Save-all')")
    @ApiOperation(value = "根据权限/资源批量保存角色权限关系", tags = {"角色权限关系" },  notes = "根据权限/资源批量保存角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/syspermissions/{syspermission_id}/sysrolepermissions/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysPermission(@PathVariable("syspermission_id") String syspermission_id, @RequestBody List<SysRolePermissionDTO> sysrolepermissiondtos) {
        List<SysRolePermission> domainlist=sysrolepermissionMapping.toDomain(sysrolepermissiondtos);
        for(SysRolePermission domain:domainlist){
             domain.setPermissionid(syspermission_id);
        }
        sysrolepermissionService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-searchDefault-all')")
	@ApiOperation(value = "根据权限/资源获取DEFAULT", tags = {"角色权限关系" } ,notes = "根据权限/资源获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/syspermissions/{syspermission_id}/sysrolepermissions/fetchdefault")
	public ResponseEntity<List<SysRolePermissionDTO>> fetchSysRolePermissionDefaultBySysPermission(@PathVariable("syspermission_id") String syspermission_id,SysRolePermissionSearchContext context) {
        context.setN_sys_permissionid_eq(syspermission_id);
        Page<SysRolePermission> domains = sysrolepermissionService.searchDefault(context) ;
        List<SysRolePermissionDTO> list = sysrolepermissionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-searchDefault-all')")
	@ApiOperation(value = "根据权限/资源查询DEFAULT", tags = {"角色权限关系" } ,notes = "根据权限/资源查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/syspermissions/{syspermission_id}/sysrolepermissions/searchdefault")
	public ResponseEntity<Page<SysRolePermissionDTO>> searchSysRolePermissionDefaultBySysPermission(@PathVariable("syspermission_id") String syspermission_id, @RequestBody SysRolePermissionSearchContext context) {
        context.setN_sys_permissionid_eq(syspermission_id);
        Page<SysRolePermission> domains = sysrolepermissionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysrolepermissionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Create-all')")
    @ApiOperation(value = "根据系统角色建立角色权限关系", tags = {"角色权限关系" },  notes = "根据系统角色建立角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysrolepermissions")
    public ResponseEntity<SysRolePermissionDTO> createBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        SysRolePermission domain = sysrolepermissionMapping.toDomain(sysrolepermissiondto);
        domain.setRoleid(sysrole_id);
		sysrolepermissionService.create(domain);
        SysRolePermissionDTO dto = sysrolepermissionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Create-all')")
    @ApiOperation(value = "根据系统角色批量建立角色权限关系", tags = {"角色权限关系" },  notes = "根据系统角色批量建立角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysrolepermissions/batch")
    public ResponseEntity<Boolean> createBatchBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody List<SysRolePermissionDTO> sysrolepermissiondtos) {
        List<SysRolePermission> domainlist=sysrolepermissionMapping.toDomain(sysrolepermissiondtos);
        for(SysRolePermission domain:domainlist){
            domain.setRoleid(sysrole_id);
        }
        sysrolepermissionService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysrolepermission" , versionfield = "updatedate")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Update-all')")
    @ApiOperation(value = "根据系统角色更新角色权限关系", tags = {"角色权限关系" },  notes = "根据系统角色更新角色权限关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysroles/{sysrole_id}/sysrolepermissions/{sysrolepermission_id}")
    public ResponseEntity<SysRolePermissionDTO> updateBySysRole(@PathVariable("sysrole_id") String sysrole_id, @PathVariable("sysrolepermission_id") String sysrolepermission_id, @RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        SysRolePermission domain = sysrolepermissionMapping.toDomain(sysrolepermissiondto);
        domain.setRoleid(sysrole_id);
        domain.setRolepermissionid(sysrolepermission_id);
		sysrolepermissionService.update(domain);
        SysRolePermissionDTO dto = sysrolepermissionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Update-all')")
    @ApiOperation(value = "根据系统角色批量更新角色权限关系", tags = {"角色权限关系" },  notes = "根据系统角色批量更新角色权限关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysroles/{sysrole_id}/sysrolepermissions/batch")
    public ResponseEntity<Boolean> updateBatchBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody List<SysRolePermissionDTO> sysrolepermissiondtos) {
        List<SysRolePermission> domainlist=sysrolepermissionMapping.toDomain(sysrolepermissiondtos);
        for(SysRolePermission domain:domainlist){
            domain.setRoleid(sysrole_id);
        }
        sysrolepermissionService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Remove-all')")
    @ApiOperation(value = "根据系统角色删除角色权限关系", tags = {"角色权限关系" },  notes = "根据系统角色删除角色权限关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysroles/{sysrole_id}/sysrolepermissions/{sysrolepermission_id}")
    public ResponseEntity<Boolean> removeBySysRole(@PathVariable("sysrole_id") String sysrole_id, @PathVariable("sysrolepermission_id") String sysrolepermission_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionService.remove(sysrolepermission_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Remove-all')")
    @ApiOperation(value = "根据系统角色批量删除角色权限关系", tags = {"角色权限关系" },  notes = "根据系统角色批量删除角色权限关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysroles/{sysrole_id}/sysrolepermissions/batch")
    public ResponseEntity<Boolean> removeBatchBySysRole(@RequestBody List<String> ids) {
        sysrolepermissionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Get-all')")
    @ApiOperation(value = "根据系统角色获取角色权限关系", tags = {"角色权限关系" },  notes = "根据系统角色获取角色权限关系")
	@RequestMapping(method = RequestMethod.GET, value = "/sysroles/{sysrole_id}/sysrolepermissions/{sysrolepermission_id}")
    public ResponseEntity<SysRolePermissionDTO> getBySysRole(@PathVariable("sysrole_id") String sysrole_id, @PathVariable("sysrolepermission_id") String sysrolepermission_id) {
        SysRolePermission domain = sysrolepermissionService.get(sysrolepermission_id);
        SysRolePermissionDTO dto = sysrolepermissionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据系统角色获取角色权限关系草稿", tags = {"角色权限关系" },  notes = "根据系统角色获取角色权限关系草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysroles/{sysrole_id}/sysrolepermissions/getdraft")
    public ResponseEntity<SysRolePermissionDTO> getDraftBySysRole(@PathVariable("sysrole_id") String sysrole_id, SysRolePermissionDTO dto) {
        SysRolePermission domain = sysrolepermissionMapping.toDomain(dto);
        domain.setRoleid(sysrole_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionMapping.toDto(sysrolepermissionService.getDraft(domain)));
    }

    @ApiOperation(value = "根据系统角色检查角色权限关系", tags = {"角色权限关系" },  notes = "根据系统角色检查角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysrolepermissions/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionService.checkKey(sysrolepermissionMapping.toDomain(sysrolepermissiondto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Save-all')")
    @ApiOperation(value = "根据系统角色保存角色权限关系", tags = {"角色权限关系" },  notes = "根据系统角色保存角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysrolepermissions/save")
    public ResponseEntity<Boolean> saveBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody SysRolePermissionDTO sysrolepermissiondto) {
        SysRolePermission domain = sysrolepermissionMapping.toDomain(sysrolepermissiondto);
        domain.setRoleid(sysrole_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysrolepermissionService.save(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-Save-all')")
    @ApiOperation(value = "根据系统角色批量保存角色权限关系", tags = {"角色权限关系" },  notes = "根据系统角色批量保存角色权限关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysrolepermissions/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody List<SysRolePermissionDTO> sysrolepermissiondtos) {
        List<SysRolePermission> domainlist=sysrolepermissionMapping.toDomain(sysrolepermissiondtos);
        for(SysRolePermission domain:domainlist){
             domain.setRoleid(sysrole_id);
        }
        sysrolepermissionService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-searchDefault-all')")
	@ApiOperation(value = "根据系统角色获取DEFAULT", tags = {"角色权限关系" } ,notes = "根据系统角色获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysroles/{sysrole_id}/sysrolepermissions/fetchdefault")
	public ResponseEntity<List<SysRolePermissionDTO>> fetchSysRolePermissionDefaultBySysRole(@PathVariable("sysrole_id") String sysrole_id,SysRolePermissionSearchContext context) {
        context.setN_sys_roleid_eq(sysrole_id);
        Page<SysRolePermission> domains = sysrolepermissionService.searchDefault(context) ;
        List<SysRolePermissionDTO> list = sysrolepermissionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysRolePermission-searchDefault-all')")
	@ApiOperation(value = "根据系统角色查询DEFAULT", tags = {"角色权限关系" } ,notes = "根据系统角色查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysroles/{sysrole_id}/sysrolepermissions/searchdefault")
	public ResponseEntity<Page<SysRolePermissionDTO>> searchSysRolePermissionDefaultBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody SysRolePermissionSearchContext context) {
        context.setN_sys_roleid_eq(sysrole_id);
        Page<SysRolePermission> domains = sysrolepermissionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysrolepermissionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

