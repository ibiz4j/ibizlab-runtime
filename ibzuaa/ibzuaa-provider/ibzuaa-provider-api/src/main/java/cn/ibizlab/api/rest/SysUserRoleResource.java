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
import cn.ibizlab.core.uaa.domain.SysUserRole;
import cn.ibizlab.core.uaa.service.ISysUserRoleService;
import cn.ibizlab.core.uaa.filter.SysUserRoleSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"用户角色关系" })
@RestController("api-sysuserrole")
@RequestMapping("")
public class SysUserRoleResource {

    @Autowired
    public ISysUserRoleService sysuserroleService;

    @Autowired
    @Lazy
    public SysUserRoleMapping sysuserroleMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Create-all')")
    @ApiOperation(value = "新建用户角色关系", tags = {"用户角色关系" },  notes = "新建用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysuserroles")
    public ResponseEntity<SysUserRoleDTO> create(@RequestBody SysUserRoleDTO sysuserroledto) {
        SysUserRole domain = sysuserroleMapping.toDomain(sysuserroledto);
		sysuserroleService.create(domain);
        SysUserRoleDTO dto = sysuserroleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Create-all')")
    @ApiOperation(value = "批量新建用户角色关系", tags = {"用户角色关系" },  notes = "批量新建用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysuserroles/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysUserRoleDTO> sysuserroledtos) {
        sysuserroleService.createBatch(sysuserroleMapping.toDomain(sysuserroledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysuserrole" , versionfield = "updatedate")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Update-all')")
    @ApiOperation(value = "更新用户角色关系", tags = {"用户角色关系" },  notes = "更新用户角色关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysuserroles/{sysuserrole_id}")
    public ResponseEntity<SysUserRoleDTO> update(@PathVariable("sysuserrole_id") String sysuserrole_id, @RequestBody SysUserRoleDTO sysuserroledto) {
		SysUserRole domain  = sysuserroleMapping.toDomain(sysuserroledto);
        domain .setUserroleid(sysuserrole_id);
		sysuserroleService.update(domain );
		SysUserRoleDTO dto = sysuserroleMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Update-all')")
    @ApiOperation(value = "批量更新用户角色关系", tags = {"用户角色关系" },  notes = "批量更新用户角色关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysuserroles/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysUserRoleDTO> sysuserroledtos) {
        sysuserroleService.updateBatch(sysuserroleMapping.toDomain(sysuserroledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Remove-all')")
    @ApiOperation(value = "删除用户角色关系", tags = {"用户角色关系" },  notes = "删除用户角色关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysuserroles/{sysuserrole_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("sysuserrole_id") String sysuserrole_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysuserroleService.remove(sysuserrole_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Remove-all')")
    @ApiOperation(value = "批量删除用户角色关系", tags = {"用户角色关系" },  notes = "批量删除用户角色关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysuserroles/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysuserroleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Get-all')")
    @ApiOperation(value = "获取用户角色关系", tags = {"用户角色关系" },  notes = "获取用户角色关系")
	@RequestMapping(method = RequestMethod.GET, value = "/sysuserroles/{sysuserrole_id}")
    public ResponseEntity<SysUserRoleDTO> get(@PathVariable("sysuserrole_id") String sysuserrole_id) {
        SysUserRole domain = sysuserroleService.get(sysuserrole_id);
        SysUserRoleDTO dto = sysuserroleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取用户角色关系草稿", tags = {"用户角色关系" },  notes = "获取用户角色关系草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sysuserroles/getdraft")
    public ResponseEntity<SysUserRoleDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sysuserroleMapping.toDto(sysuserroleService.getDraft(new SysUserRole())));
    }

    @ApiOperation(value = "检查用户角色关系", tags = {"用户角色关系" },  notes = "检查用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysuserroles/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysUserRoleDTO sysuserroledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysuserroleService.checkKey(sysuserroleMapping.toDomain(sysuserroledto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Save-all')")
    @ApiOperation(value = "保存用户角色关系", tags = {"用户角色关系" },  notes = "保存用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysuserroles/save")
    public ResponseEntity<Boolean> save(@RequestBody SysUserRoleDTO sysuserroledto) {
        return ResponseEntity.status(HttpStatus.OK).body(sysuserroleService.save(sysuserroleMapping.toDomain(sysuserroledto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Save-all')")
    @ApiOperation(value = "批量保存用户角色关系", tags = {"用户角色关系" },  notes = "批量保存用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysuserroles/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysUserRoleDTO> sysuserroledtos) {
        sysuserroleService.saveBatch(sysuserroleMapping.toDomain(sysuserroledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"用户角色关系" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysuserroles/fetchdefault")
	public ResponseEntity<List<SysUserRoleDTO>> fetchDefault(SysUserRoleSearchContext context) {
        Page<SysUserRole> domains = sysuserroleService.searchDefault(context) ;
        List<SysUserRoleDTO> list = sysuserroleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"用户角色关系" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysuserroles/searchdefault")
	public ResponseEntity<Page<SysUserRoleDTO>> searchDefault(@RequestBody SysUserRoleSearchContext context) {
        Page<SysUserRole> domains = sysuserroleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysuserroleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Create-all')")
    @ApiOperation(value = "根据系统角色建立用户角色关系", tags = {"用户角色关系" },  notes = "根据系统角色建立用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysuserroles")
    public ResponseEntity<SysUserRoleDTO> createBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody SysUserRoleDTO sysuserroledto) {
        SysUserRole domain = sysuserroleMapping.toDomain(sysuserroledto);
        domain.setRoleid(sysrole_id);
		sysuserroleService.create(domain);
        SysUserRoleDTO dto = sysuserroleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Create-all')")
    @ApiOperation(value = "根据系统角色批量建立用户角色关系", tags = {"用户角色关系" },  notes = "根据系统角色批量建立用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysuserroles/batch")
    public ResponseEntity<Boolean> createBatchBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody List<SysUserRoleDTO> sysuserroledtos) {
        List<SysUserRole> domainlist=sysuserroleMapping.toDomain(sysuserroledtos);
        for(SysUserRole domain:domainlist){
            domain.setRoleid(sysrole_id);
        }
        sysuserroleService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysuserrole" , versionfield = "updatedate")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Update-all')")
    @ApiOperation(value = "根据系统角色更新用户角色关系", tags = {"用户角色关系" },  notes = "根据系统角色更新用户角色关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysroles/{sysrole_id}/sysuserroles/{sysuserrole_id}")
    public ResponseEntity<SysUserRoleDTO> updateBySysRole(@PathVariable("sysrole_id") String sysrole_id, @PathVariable("sysuserrole_id") String sysuserrole_id, @RequestBody SysUserRoleDTO sysuserroledto) {
        SysUserRole domain = sysuserroleMapping.toDomain(sysuserroledto);
        domain.setRoleid(sysrole_id);
        domain.setUserroleid(sysuserrole_id);
		sysuserroleService.update(domain);
        SysUserRoleDTO dto = sysuserroleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Update-all')")
    @ApiOperation(value = "根据系统角色批量更新用户角色关系", tags = {"用户角色关系" },  notes = "根据系统角色批量更新用户角色关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysroles/{sysrole_id}/sysuserroles/batch")
    public ResponseEntity<Boolean> updateBatchBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody List<SysUserRoleDTO> sysuserroledtos) {
        List<SysUserRole> domainlist=sysuserroleMapping.toDomain(sysuserroledtos);
        for(SysUserRole domain:domainlist){
            domain.setRoleid(sysrole_id);
        }
        sysuserroleService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Remove-all')")
    @ApiOperation(value = "根据系统角色删除用户角色关系", tags = {"用户角色关系" },  notes = "根据系统角色删除用户角色关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysroles/{sysrole_id}/sysuserroles/{sysuserrole_id}")
    public ResponseEntity<Boolean> removeBySysRole(@PathVariable("sysrole_id") String sysrole_id, @PathVariable("sysuserrole_id") String sysuserrole_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysuserroleService.remove(sysuserrole_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Remove-all')")
    @ApiOperation(value = "根据系统角色批量删除用户角色关系", tags = {"用户角色关系" },  notes = "根据系统角色批量删除用户角色关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysroles/{sysrole_id}/sysuserroles/batch")
    public ResponseEntity<Boolean> removeBatchBySysRole(@RequestBody List<String> ids) {
        sysuserroleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Get-all')")
    @ApiOperation(value = "根据系统角色获取用户角色关系", tags = {"用户角色关系" },  notes = "根据系统角色获取用户角色关系")
	@RequestMapping(method = RequestMethod.GET, value = "/sysroles/{sysrole_id}/sysuserroles/{sysuserrole_id}")
    public ResponseEntity<SysUserRoleDTO> getBySysRole(@PathVariable("sysrole_id") String sysrole_id, @PathVariable("sysuserrole_id") String sysuserrole_id) {
        SysUserRole domain = sysuserroleService.get(sysuserrole_id);
        SysUserRoleDTO dto = sysuserroleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据系统角色获取用户角色关系草稿", tags = {"用户角色关系" },  notes = "根据系统角色获取用户角色关系草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysroles/{sysrole_id}/sysuserroles/getdraft")
    public ResponseEntity<SysUserRoleDTO> getDraftBySysRole(@PathVariable("sysrole_id") String sysrole_id) {
        SysUserRole domain = new SysUserRole();
        domain.setRoleid(sysrole_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysuserroleMapping.toDto(sysuserroleService.getDraft(domain)));
    }

    @ApiOperation(value = "根据系统角色检查用户角色关系", tags = {"用户角色关系" },  notes = "根据系统角色检查用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysuserroles/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody SysUserRoleDTO sysuserroledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysuserroleService.checkKey(sysuserroleMapping.toDomain(sysuserroledto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Save-all')")
    @ApiOperation(value = "根据系统角色保存用户角色关系", tags = {"用户角色关系" },  notes = "根据系统角色保存用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysuserroles/save")
    public ResponseEntity<Boolean> saveBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody SysUserRoleDTO sysuserroledto) {
        SysUserRole domain = sysuserroleMapping.toDomain(sysuserroledto);
        domain.setRoleid(sysrole_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysuserroleService.save(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Save-all')")
    @ApiOperation(value = "根据系统角色批量保存用户角色关系", tags = {"用户角色关系" },  notes = "根据系统角色批量保存用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysroles/{sysrole_id}/sysuserroles/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody List<SysUserRoleDTO> sysuserroledtos) {
        List<SysUserRole> domainlist=sysuserroleMapping.toDomain(sysuserroledtos);
        for(SysUserRole domain:domainlist){
             domain.setRoleid(sysrole_id);
        }
        sysuserroleService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-searchDefault-all')")
	@ApiOperation(value = "根据系统角色获取DEFAULT", tags = {"用户角色关系" } ,notes = "根据系统角色获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysroles/{sysrole_id}/sysuserroles/fetchdefault")
	public ResponseEntity<List<SysUserRoleDTO>> fetchSysUserRoleDefaultBySysRole(@PathVariable("sysrole_id") String sysrole_id,SysUserRoleSearchContext context) {
        context.setN_sys_roleid_eq(sysrole_id);
        Page<SysUserRole> domains = sysuserroleService.searchDefault(context) ;
        List<SysUserRoleDTO> list = sysuserroleMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-searchDefault-all')")
	@ApiOperation(value = "根据系统角色查询DEFAULT", tags = {"用户角色关系" } ,notes = "根据系统角色查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysroles/{sysrole_id}/sysuserroles/searchdefault")
	public ResponseEntity<Page<SysUserRoleDTO>> searchSysUserRoleDefaultBySysRole(@PathVariable("sysrole_id") String sysrole_id, @RequestBody SysUserRoleSearchContext context) {
        context.setN_sys_roleid_eq(sysrole_id);
        Page<SysUserRole> domains = sysuserroleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysuserroleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Create-all')")
    @ApiOperation(value = "根据系统用户建立用户角色关系", tags = {"用户角色关系" },  notes = "根据系统用户建立用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysusers/{sysuser_id}/sysuserroles")
    public ResponseEntity<SysUserRoleDTO> createBySysUser(@PathVariable("sysuser_id") String sysuser_id, @RequestBody SysUserRoleDTO sysuserroledto) {
        SysUserRole domain = sysuserroleMapping.toDomain(sysuserroledto);
        domain.setUserid(sysuser_id);
		sysuserroleService.create(domain);
        SysUserRoleDTO dto = sysuserroleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Create-all')")
    @ApiOperation(value = "根据系统用户批量建立用户角色关系", tags = {"用户角色关系" },  notes = "根据系统用户批量建立用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysusers/{sysuser_id}/sysuserroles/batch")
    public ResponseEntity<Boolean> createBatchBySysUser(@PathVariable("sysuser_id") String sysuser_id, @RequestBody List<SysUserRoleDTO> sysuserroledtos) {
        List<SysUserRole> domainlist=sysuserroleMapping.toDomain(sysuserroledtos);
        for(SysUserRole domain:domainlist){
            domain.setUserid(sysuser_id);
        }
        sysuserroleService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysuserrole" , versionfield = "updatedate")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Update-all')")
    @ApiOperation(value = "根据系统用户更新用户角色关系", tags = {"用户角色关系" },  notes = "根据系统用户更新用户角色关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysusers/{sysuser_id}/sysuserroles/{sysuserrole_id}")
    public ResponseEntity<SysUserRoleDTO> updateBySysUser(@PathVariable("sysuser_id") String sysuser_id, @PathVariable("sysuserrole_id") String sysuserrole_id, @RequestBody SysUserRoleDTO sysuserroledto) {
        SysUserRole domain = sysuserroleMapping.toDomain(sysuserroledto);
        domain.setUserid(sysuser_id);
        domain.setUserroleid(sysuserrole_id);
		sysuserroleService.update(domain);
        SysUserRoleDTO dto = sysuserroleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Update-all')")
    @ApiOperation(value = "根据系统用户批量更新用户角色关系", tags = {"用户角色关系" },  notes = "根据系统用户批量更新用户角色关系")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysusers/{sysuser_id}/sysuserroles/batch")
    public ResponseEntity<Boolean> updateBatchBySysUser(@PathVariable("sysuser_id") String sysuser_id, @RequestBody List<SysUserRoleDTO> sysuserroledtos) {
        List<SysUserRole> domainlist=sysuserroleMapping.toDomain(sysuserroledtos);
        for(SysUserRole domain:domainlist){
            domain.setUserid(sysuser_id);
        }
        sysuserroleService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Remove-all')")
    @ApiOperation(value = "根据系统用户删除用户角色关系", tags = {"用户角色关系" },  notes = "根据系统用户删除用户角色关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysusers/{sysuser_id}/sysuserroles/{sysuserrole_id}")
    public ResponseEntity<Boolean> removeBySysUser(@PathVariable("sysuser_id") String sysuser_id, @PathVariable("sysuserrole_id") String sysuserrole_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysuserroleService.remove(sysuserrole_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Remove-all')")
    @ApiOperation(value = "根据系统用户批量删除用户角色关系", tags = {"用户角色关系" },  notes = "根据系统用户批量删除用户角色关系")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysusers/{sysuser_id}/sysuserroles/batch")
    public ResponseEntity<Boolean> removeBatchBySysUser(@RequestBody List<String> ids) {
        sysuserroleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Get-all')")
    @ApiOperation(value = "根据系统用户获取用户角色关系", tags = {"用户角色关系" },  notes = "根据系统用户获取用户角色关系")
	@RequestMapping(method = RequestMethod.GET, value = "/sysusers/{sysuser_id}/sysuserroles/{sysuserrole_id}")
    public ResponseEntity<SysUserRoleDTO> getBySysUser(@PathVariable("sysuser_id") String sysuser_id, @PathVariable("sysuserrole_id") String sysuserrole_id) {
        SysUserRole domain = sysuserroleService.get(sysuserrole_id);
        SysUserRoleDTO dto = sysuserroleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据系统用户获取用户角色关系草稿", tags = {"用户角色关系" },  notes = "根据系统用户获取用户角色关系草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysusers/{sysuser_id}/sysuserroles/getdraft")
    public ResponseEntity<SysUserRoleDTO> getDraftBySysUser(@PathVariable("sysuser_id") String sysuser_id) {
        SysUserRole domain = new SysUserRole();
        domain.setUserid(sysuser_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysuserroleMapping.toDto(sysuserroleService.getDraft(domain)));
    }

    @ApiOperation(value = "根据系统用户检查用户角色关系", tags = {"用户角色关系" },  notes = "根据系统用户检查用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysusers/{sysuser_id}/sysuserroles/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysUser(@PathVariable("sysuser_id") String sysuser_id, @RequestBody SysUserRoleDTO sysuserroledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysuserroleService.checkKey(sysuserroleMapping.toDomain(sysuserroledto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Save-all')")
    @ApiOperation(value = "根据系统用户保存用户角色关系", tags = {"用户角色关系" },  notes = "根据系统用户保存用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysusers/{sysuser_id}/sysuserroles/save")
    public ResponseEntity<Boolean> saveBySysUser(@PathVariable("sysuser_id") String sysuser_id, @RequestBody SysUserRoleDTO sysuserroledto) {
        SysUserRole domain = sysuserroleMapping.toDomain(sysuserroledto);
        domain.setUserid(sysuser_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysuserroleService.save(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-Save-all')")
    @ApiOperation(value = "根据系统用户批量保存用户角色关系", tags = {"用户角色关系" },  notes = "根据系统用户批量保存用户角色关系")
	@RequestMapping(method = RequestMethod.POST, value = "/sysusers/{sysuser_id}/sysuserroles/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysUser(@PathVariable("sysuser_id") String sysuser_id, @RequestBody List<SysUserRoleDTO> sysuserroledtos) {
        List<SysUserRole> domainlist=sysuserroleMapping.toDomain(sysuserroledtos);
        for(SysUserRole domain:domainlist){
             domain.setUserid(sysuser_id);
        }
        sysuserroleService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-searchDefault-all')")
	@ApiOperation(value = "根据系统用户获取DEFAULT", tags = {"用户角色关系" } ,notes = "根据系统用户获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysusers/{sysuser_id}/sysuserroles/fetchdefault")
	public ResponseEntity<List<SysUserRoleDTO>> fetchSysUserRoleDefaultBySysUser(@PathVariable("sysuser_id") String sysuser_id,SysUserRoleSearchContext context) {
        context.setN_sys_userid_eq(sysuser_id);
        Page<SysUserRole> domains = sysuserroleService.searchDefault(context) ;
        List<SysUserRoleDTO> list = sysuserroleMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserRole-searchDefault-all')")
	@ApiOperation(value = "根据系统用户查询DEFAULT", tags = {"用户角色关系" } ,notes = "根据系统用户查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysusers/{sysuser_id}/sysuserroles/searchdefault")
	public ResponseEntity<Page<SysUserRoleDTO>> searchSysUserRoleDefaultBySysUser(@PathVariable("sysuser_id") String sysuser_id, @RequestBody SysUserRoleSearchContext context) {
        context.setN_sys_userid_eq(sysuser_id);
        Page<SysUserRole> domains = sysuserroleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysuserroleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

