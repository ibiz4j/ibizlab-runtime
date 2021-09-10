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
import cn.ibizlab.core.ou.domain.SysEmployee;
import cn.ibizlab.core.ou.service.ISysEmployeeService;
import cn.ibizlab.core.ou.filter.SysEmployeeSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"人员" })
@RestController("api-sysemployee")
@RequestMapping("")
public class SysEmployeeResource {

    @Autowired
    public ISysEmployeeService sysemployeeService;

    @Autowired
    @Lazy
    public SysEmployeeMapping sysemployeeMapping;

    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedto),'ibzrt-SysEmployee-Create')")
    @ApiOperation(value = "新建人员", tags = {"人员" },  notes = "新建人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees")
    public ResponseEntity<SysEmployeeDTO> create(@Validated @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
		sysemployeeService.create(domain);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedtos),'ibzrt-SysEmployee-Create')")
    @ApiOperation(value = "批量新建人员", tags = {"人员" },  notes = "批量新建人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        sysemployeeService.createBatch(sysemployeeMapping.toDomain(sysemployeedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.sysemployeeMapping.toDomain(returnObject.body),'ibzrt-SysEmployee-Get')")
    @ApiOperation(value = "获取人员", tags = {"人员" },  notes = "获取人员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysemployees/{sysemployee_id}")
    public ResponseEntity<SysEmployeeDTO> get(@PathVariable("sysemployee_id") String sysemployee_id) {
        SysEmployee domain = sysemployeeService.get(sysemployee_id);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.get(#sysemployee_id),'ibzrt-SysEmployee-Remove')")
    @ApiOperation(value = "删除人员", tags = {"人员" },  notes = "删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysemployees/{sysemployee_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("sysemployee_id") String sysemployee_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysemployeeService.remove(sysemployee_id));
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.getSysemployeeByIds(#ids),'ibzrt-SysEmployee-Remove')")
    @ApiOperation(value = "批量删除人员", tags = {"人员" },  notes = "批量删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysemployees/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysemployeeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysemployee" , versionfield = "updatedate")
    @PreAuthorize("hasPermission(this.sysemployeeService.get(#sysemployee_id),'ibzrt-SysEmployee-Update')")
    @ApiOperation(value = "更新人员", tags = {"人员" },  notes = "更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysemployees/{sysemployee_id}")
    public ResponseEntity<SysEmployeeDTO> update(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysEmployeeDTO sysemployeedto) {
		SysEmployee domain  = sysemployeeMapping.toDomain(sysemployeedto);
        domain .setUserid(sysemployee_id);
		sysemployeeService.update(domain );
		SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.getSysemployeeByEntities(this.sysemployeeMapping.toDomain(#sysemployeedtos)),'ibzrt-SysEmployee-Update')")
    @ApiOperation(value = "批量更新人员", tags = {"人员" },  notes = "批量更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysemployees/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        sysemployeeService.updateBatch(sysemployeeMapping.toDomain(sysemployeedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查人员", tags = {"人员" },  notes = "检查人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysEmployeeDTO sysemployeedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysemployeeService.checkKey(sysemployeeMapping.toDomain(sysemployeedto)));
    }

    @ApiOperation(value = "获取人员草稿", tags = {"人员" },  notes = "获取人员草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sysemployees/getdraft")
    public ResponseEntity<SysEmployeeDTO> getDraft(SysEmployeeDTO dto) {
        SysEmployee domain = sysemployeeMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeeMapping.toDto(sysemployeeService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-InitPwd-all')")
    @ApiOperation(value = "初始化密码", tags = {"人员" },  notes = "初始化密码")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/initpwd")
    public ResponseEntity<SysEmployeeDTO> initPwd(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setUserid(sysemployee_id);
        domain = sysemployeeService.initPwd(domain);
        sysemployeedto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeedto);
    }
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-InitPwd-all')")
    @ApiOperation(value = "批量处理[初始化密码]", tags = {"人员" },  notes = "批量处理[初始化密码]")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/initpwdbatch")
    public ResponseEntity<Boolean> initPwdBatch(@RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domains = sysemployeeMapping.toDomain(sysemployeedtos);
        boolean result = sysemployeeService.initPwdBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedto),'ibzrt-SysEmployee-Save')")
    @ApiOperation(value = "保存人员", tags = {"人员" },  notes = "保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/save")
    public ResponseEntity<SysEmployeeDTO> save(@RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        sysemployeeService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeeMapping.toDto(domain));
    }

    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedtos),'ibzrt-SysEmployee-Save')")
    @ApiOperation(value = "批量保存人员", tags = {"人员" },  notes = "批量保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        sysemployeeService.saveBatch(sysemployeeMapping.toDomain(sysemployeedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-searchDefault-all') and hasPermission(#context,'ibzrt-SysEmployee-Get')")
	@ApiOperation(value = "获取DEFAULT", tags = {"人员" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysemployees/fetchdefault")
	public ResponseEntity<List<SysEmployeeDTO>> fetchDefault(SysEmployeeSearchContext context) {
        Page<SysEmployee> domains = sysemployeeService.searchDefault(context) ;
        List<SysEmployeeDTO> list = sysemployeeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-searchDefault-all') and hasPermission(#context,'ibzrt-SysEmployee-Get')")
	@ApiOperation(value = "查询DEFAULT", tags = {"人员" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysemployees/searchdefault")
	public ResponseEntity<Page<SysEmployeeDTO>> searchDefault(@RequestBody SysEmployeeSearchContext context) {
        Page<SysEmployee> domains = sysemployeeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysemployeeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedto),'ibzrt-SysEmployee-Create')")
    @ApiOperation(value = "根据部门建立人员", tags = {"人员" },  notes = "根据部门建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees")
    public ResponseEntity<SysEmployeeDTO> createBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setMdeptid(sysdepartment_id);
		sysemployeeService.create(domain);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedtos),'ibzrt-SysEmployee-Create')")
    @ApiOperation(value = "根据部门批量建立人员", tags = {"人员" },  notes = "根据部门批量建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/batch")
    public ResponseEntity<Boolean> createBatchBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domainlist=sysemployeeMapping.toDomain(sysemployeedtos);
        for(SysEmployee domain:domainlist){
            domain.setMdeptid(sysdepartment_id);
        }
        sysemployeeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.sysemployeeMapping.toDomain(returnObject.body),'ibzrt-SysEmployee-Get')")
    @ApiOperation(value = "根据部门获取人员", tags = {"人员" },  notes = "根据部门获取人员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}")
    public ResponseEntity<SysEmployeeDTO> getBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id) {
        SysEmployee domain = sysemployeeService.get(sysemployee_id);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.get(#sysemployee_id),'ibzrt-SysEmployee-Remove')")
    @ApiOperation(value = "根据部门删除人员", tags = {"人员" },  notes = "根据部门删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}")
    public ResponseEntity<Boolean> removeBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysemployeeService.remove(sysemployee_id));
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.getSysemployeeByIds(#ids),'ibzrt-SysEmployee-Remove')")
    @ApiOperation(value = "根据部门批量删除人员", tags = {"人员" },  notes = "根据部门批量删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/{sysdepartment_id}/sysemployees/batch")
    public ResponseEntity<Boolean> removeBatchBySysDepartment(@RequestBody List<String> ids) {
        sysemployeeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysemployee" , versionfield = "updatedate")
    @PreAuthorize("hasPermission(this.sysemployeeService.get(#sysemployee_id),'ibzrt-SysEmployee-Update')")
    @ApiOperation(value = "根据部门更新人员", tags = {"人员" },  notes = "根据部门更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}")
    public ResponseEntity<SysEmployeeDTO> updateBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setMdeptid(sysdepartment_id);
        domain.setUserid(sysemployee_id);
		sysemployeeService.update(domain);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.getSysemployeeByEntities(this.sysemployeeMapping.toDomain(#sysemployeedtos)),'ibzrt-SysEmployee-Update')")
    @ApiOperation(value = "根据部门批量更新人员", tags = {"人员" },  notes = "根据部门批量更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/{sysdepartment_id}/sysemployees/batch")
    public ResponseEntity<Boolean> updateBatchBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domainlist=sysemployeeMapping.toDomain(sysemployeedtos);
        for(SysEmployee domain:domainlist){
            domain.setMdeptid(sysdepartment_id);
        }
        sysemployeeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门检查人员", tags = {"人员" },  notes = "根据部门检查人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysemployeeService.checkKey(sysemployeeMapping.toDomain(sysemployeedto)));
    }

    @ApiOperation(value = "根据部门获取人员草稿", tags = {"人员" },  notes = "根据部门获取人员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/{sysdepartment_id}/sysemployees/getdraft")
    public ResponseEntity<SysEmployeeDTO> getDraftBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, SysEmployeeDTO dto) {
        SysEmployee domain = sysemployeeMapping.toDomain(dto);
        domain.setMdeptid(sysdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeeMapping.toDto(sysemployeeService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-InitPwd-all')")
    @ApiOperation(value = "根据部门人员", tags = {"人员" },  notes = "根据部门人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/initpwd")
    public ResponseEntity<SysEmployeeDTO> initPwdBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setMdeptid(sysdepartment_id);
        domain = sysemployeeService.initPwd(domain) ;
        sysemployeedto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeedto);
    }
    @ApiOperation(value = "批量处理[根据部门人员]", tags = {"人员" },  notes = "批量处理[根据部门人员]")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/initpwdbatch")
    public ResponseEntity<Boolean> initPwdBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domains = sysemployeeMapping.toDomain(sysemployeedtos);
        boolean result = sysemployeeService.initPwdBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedto),'ibzrt-SysEmployee-Save')")
    @ApiOperation(value = "根据部门保存人员", tags = {"人员" },  notes = "根据部门保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/save")
    public ResponseEntity<SysEmployeeDTO> saveBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setMdeptid(sysdepartment_id);
        sysemployeeService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeeMapping.toDto(domain));
    }

    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedtos),'ibzrt-SysEmployee-Save')")
    @ApiOperation(value = "根据部门批量保存人员", tags = {"人员" },  notes = "根据部门批量保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domainlist=sysemployeeMapping.toDomain(sysemployeedtos);
        for(SysEmployee domain:domainlist){
             domain.setMdeptid(sysdepartment_id);
        }
        sysemployeeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-searchDefault-all') and hasPermission(#context,'ibzrt-SysEmployee-Get')")
	@ApiOperation(value = "根据部门获取DEFAULT", tags = {"人员" } ,notes = "根据部门获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysdepartments/{sysdepartment_id}/sysemployees/fetchdefault")
	public ResponseEntity<List<SysEmployeeDTO>> fetchSysEmployeeDefaultBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id,SysEmployeeSearchContext context) {
        context.setN_mdeptid_eq(sysdepartment_id);
        Page<SysEmployee> domains = sysemployeeService.searchDefault(context) ;
        List<SysEmployeeDTO> list = sysemployeeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-searchDefault-all') and hasPermission(#context,'ibzrt-SysEmployee-Get')")
	@ApiOperation(value = "根据部门查询DEFAULT", tags = {"人员" } ,notes = "根据部门查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysdepartments/{sysdepartment_id}/sysemployees/searchdefault")
	public ResponseEntity<Page<SysEmployeeDTO>> searchSysEmployeeDefaultBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysEmployeeSearchContext context) {
        context.setN_mdeptid_eq(sysdepartment_id);
        Page<SysEmployee> domains = sysemployeeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysemployeeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedto),'ibzrt-SysEmployee-Create')")
    @ApiOperation(value = "根据单位机构建立人员", tags = {"人员" },  notes = "根据单位机构建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees")
    public ResponseEntity<SysEmployeeDTO> createBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setOrgid(sysorganization_id);
		sysemployeeService.create(domain);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedtos),'ibzrt-SysEmployee-Create')")
    @ApiOperation(value = "根据单位机构批量建立人员", tags = {"人员" },  notes = "根据单位机构批量建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/batch")
    public ResponseEntity<Boolean> createBatchBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domainlist=sysemployeeMapping.toDomain(sysemployeedtos);
        for(SysEmployee domain:domainlist){
            domain.setOrgid(sysorganization_id);
        }
        sysemployeeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.sysemployeeMapping.toDomain(returnObject.body),'ibzrt-SysEmployee-Get')")
    @ApiOperation(value = "根据单位机构获取人员", tags = {"人员" },  notes = "根据单位机构获取人员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}")
    public ResponseEntity<SysEmployeeDTO> getBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id) {
        SysEmployee domain = sysemployeeService.get(sysemployee_id);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.get(#sysemployee_id),'ibzrt-SysEmployee-Remove')")
    @ApiOperation(value = "根据单位机构删除人员", tags = {"人员" },  notes = "根据单位机构删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}")
    public ResponseEntity<Boolean> removeBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysemployeeService.remove(sysemployee_id));
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.getSysemployeeByIds(#ids),'ibzrt-SysEmployee-Remove')")
    @ApiOperation(value = "根据单位机构批量删除人员", tags = {"人员" },  notes = "根据单位机构批量删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysemployees/batch")
    public ResponseEntity<Boolean> removeBatchBySysOrganization(@RequestBody List<String> ids) {
        sysemployeeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysemployee" , versionfield = "updatedate")
    @PreAuthorize("hasPermission(this.sysemployeeService.get(#sysemployee_id),'ibzrt-SysEmployee-Update')")
    @ApiOperation(value = "根据单位机构更新人员", tags = {"人员" },  notes = "根据单位机构更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}")
    public ResponseEntity<SysEmployeeDTO> updateBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setOrgid(sysorganization_id);
        domain.setUserid(sysemployee_id);
		sysemployeeService.update(domain);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.getSysemployeeByEntities(this.sysemployeeMapping.toDomain(#sysemployeedtos)),'ibzrt-SysEmployee-Update')")
    @ApiOperation(value = "根据单位机构批量更新人员", tags = {"人员" },  notes = "根据单位机构批量更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysemployees/batch")
    public ResponseEntity<Boolean> updateBatchBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domainlist=sysemployeeMapping.toDomain(sysemployeedtos);
        for(SysEmployee domain:domainlist){
            domain.setOrgid(sysorganization_id);
        }
        sysemployeeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构检查人员", tags = {"人员" },  notes = "根据单位机构检查人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysemployeeService.checkKey(sysemployeeMapping.toDomain(sysemployeedto)));
    }

    @ApiOperation(value = "根据单位机构获取人员草稿", tags = {"人员" },  notes = "根据单位机构获取人员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysemployees/getdraft")
    public ResponseEntity<SysEmployeeDTO> getDraftBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, SysEmployeeDTO dto) {
        SysEmployee domain = sysemployeeMapping.toDomain(dto);
        domain.setOrgid(sysorganization_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeeMapping.toDto(sysemployeeService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-InitPwd-all')")
    @ApiOperation(value = "根据单位机构人员", tags = {"人员" },  notes = "根据单位机构人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/initpwd")
    public ResponseEntity<SysEmployeeDTO> initPwdBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setOrgid(sysorganization_id);
        domain = sysemployeeService.initPwd(domain) ;
        sysemployeedto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeedto);
    }
    @ApiOperation(value = "批量处理[根据单位机构人员]", tags = {"人员" },  notes = "批量处理[根据单位机构人员]")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/initpwdbatch")
    public ResponseEntity<Boolean> initPwdBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domains = sysemployeeMapping.toDomain(sysemployeedtos);
        boolean result = sysemployeeService.initPwdBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedto),'ibzrt-SysEmployee-Save')")
    @ApiOperation(value = "根据单位机构保存人员", tags = {"人员" },  notes = "根据单位机构保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/save")
    public ResponseEntity<SysEmployeeDTO> saveBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setOrgid(sysorganization_id);
        sysemployeeService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeeMapping.toDto(domain));
    }

    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedtos),'ibzrt-SysEmployee-Save')")
    @ApiOperation(value = "根据单位机构批量保存人员", tags = {"人员" },  notes = "根据单位机构批量保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domainlist=sysemployeeMapping.toDomain(sysemployeedtos);
        for(SysEmployee domain:domainlist){
             domain.setOrgid(sysorganization_id);
        }
        sysemployeeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-searchDefault-all') and hasPermission(#context,'ibzrt-SysEmployee-Get')")
	@ApiOperation(value = "根据单位机构获取DEFAULT", tags = {"人员" } ,notes = "根据单位机构获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysorganizations/{sysorganization_id}/sysemployees/fetchdefault")
	public ResponseEntity<List<SysEmployeeDTO>> fetchSysEmployeeDefaultBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id,SysEmployeeSearchContext context) {
        context.setN_orgid_eq(sysorganization_id);
        Page<SysEmployee> domains = sysemployeeService.searchDefault(context) ;
        List<SysEmployeeDTO> list = sysemployeeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-searchDefault-all') and hasPermission(#context,'ibzrt-SysEmployee-Get')")
	@ApiOperation(value = "根据单位机构查询DEFAULT", tags = {"人员" } ,notes = "根据单位机构查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysorganizations/{sysorganization_id}/sysemployees/searchdefault")
	public ResponseEntity<Page<SysEmployeeDTO>> searchSysEmployeeDefaultBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody SysEmployeeSearchContext context) {
        context.setN_orgid_eq(sysorganization_id);
        Page<SysEmployee> domains = sysemployeeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysemployeeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedto),'ibzrt-SysEmployee-Create')")
    @ApiOperation(value = "根据单位机构部门建立人员", tags = {"人员" },  notes = "根据单位机构部门建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees")
    public ResponseEntity<SysEmployeeDTO> createBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setMdeptid(sysdepartment_id);
		sysemployeeService.create(domain);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedtos),'ibzrt-SysEmployee-Create')")
    @ApiOperation(value = "根据单位机构部门批量建立人员", tags = {"人员" },  notes = "根据单位机构部门批量建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/batch")
    public ResponseEntity<Boolean> createBatchBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domainlist=sysemployeeMapping.toDomain(sysemployeedtos);
        for(SysEmployee domain:domainlist){
            domain.setMdeptid(sysdepartment_id);
        }
        sysemployeeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.sysemployeeMapping.toDomain(returnObject.body),'ibzrt-SysEmployee-Get')")
    @ApiOperation(value = "根据单位机构部门获取人员", tags = {"人员" },  notes = "根据单位机构部门获取人员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}")
    public ResponseEntity<SysEmployeeDTO> getBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id) {
        SysEmployee domain = sysemployeeService.get(sysemployee_id);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.get(#sysemployee_id),'ibzrt-SysEmployee-Remove')")
    @ApiOperation(value = "根据单位机构部门删除人员", tags = {"人员" },  notes = "根据单位机构部门删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}")
    public ResponseEntity<Boolean> removeBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysemployeeService.remove(sysemployee_id));
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.getSysemployeeByIds(#ids),'ibzrt-SysEmployee-Remove')")
    @ApiOperation(value = "根据单位机构部门批量删除人员", tags = {"人员" },  notes = "根据单位机构部门批量删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/batch")
    public ResponseEntity<Boolean> removeBatchBySysOrganizationSysDepartment(@RequestBody List<String> ids) {
        sysemployeeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysemployee" , versionfield = "updatedate")
    @PreAuthorize("hasPermission(this.sysemployeeService.get(#sysemployee_id),'ibzrt-SysEmployee-Update')")
    @ApiOperation(value = "根据单位机构部门更新人员", tags = {"人员" },  notes = "根据单位机构部门更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}")
    public ResponseEntity<SysEmployeeDTO> updateBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setMdeptid(sysdepartment_id);
        domain.setUserid(sysemployee_id);
		sysemployeeService.update(domain);
        SysEmployeeDTO dto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysemployeeService.getSysemployeeByEntities(this.sysemployeeMapping.toDomain(#sysemployeedtos)),'ibzrt-SysEmployee-Update')")
    @ApiOperation(value = "根据单位机构部门批量更新人员", tags = {"人员" },  notes = "根据单位机构部门批量更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/batch")
    public ResponseEntity<Boolean> updateBatchBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domainlist=sysemployeeMapping.toDomain(sysemployeedtos);
        for(SysEmployee domain:domainlist){
            domain.setMdeptid(sysdepartment_id);
        }
        sysemployeeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门检查人员", tags = {"人员" },  notes = "根据单位机构部门检查人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysemployeeService.checkKey(sysemployeeMapping.toDomain(sysemployeedto)));
    }

    @ApiOperation(value = "根据单位机构部门获取人员草稿", tags = {"人员" },  notes = "根据单位机构部门获取人员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/getdraft")
    public ResponseEntity<SysEmployeeDTO> getDraftBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, SysEmployeeDTO dto) {
        SysEmployee domain = sysemployeeMapping.toDomain(dto);
        domain.setMdeptid(sysdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeeMapping.toDto(sysemployeeService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-InitPwd-all')")
    @ApiOperation(value = "根据单位机构部门人员", tags = {"人员" },  notes = "根据单位机构部门人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/initpwd")
    public ResponseEntity<SysEmployeeDTO> initPwdBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setMdeptid(sysdepartment_id);
        domain = sysemployeeService.initPwd(domain) ;
        sysemployeedto = sysemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeedto);
    }
    @ApiOperation(value = "批量处理[根据单位机构部门人员]", tags = {"人员" },  notes = "批量处理[根据单位机构部门人员]")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/initpwdbatch")
    public ResponseEntity<Boolean> initPwdBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domains = sysemployeeMapping.toDomain(sysemployeedtos);
        boolean result = sysemployeeService.initPwdBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedto),'ibzrt-SysEmployee-Save')")
    @ApiOperation(value = "根据单位机构部门保存人员", tags = {"人员" },  notes = "根据单位机构部门保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/save")
    public ResponseEntity<SysEmployeeDTO> saveBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysEmployeeDTO sysemployeedto) {
        SysEmployee domain = sysemployeeMapping.toDomain(sysemployeedto);
        domain.setMdeptid(sysdepartment_id);
        sysemployeeService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sysemployeeMapping.toDto(domain));
    }

    @PreAuthorize("hasPermission(this.sysemployeeMapping.toDomain(#sysemployeedtos),'ibzrt-SysEmployee-Save')")
    @ApiOperation(value = "根据单位机构部门批量保存人员", tags = {"人员" },  notes = "根据单位机构部门批量保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysEmployeeDTO> sysemployeedtos) {
        List<SysEmployee> domainlist=sysemployeeMapping.toDomain(sysemployeedtos);
        for(SysEmployee domain:domainlist){
             domain.setMdeptid(sysdepartment_id);
        }
        sysemployeeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-searchDefault-all') and hasPermission(#context,'ibzrt-SysEmployee-Get')")
	@ApiOperation(value = "根据单位机构部门获取DEFAULT", tags = {"人员" } ,notes = "根据单位机构部门获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/fetchdefault")
	public ResponseEntity<List<SysEmployeeDTO>> fetchSysEmployeeDefaultBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id,SysEmployeeSearchContext context) {
        context.setN_mdeptid_eq(sysdepartment_id);
        Page<SysEmployee> domains = sysemployeeService.searchDefault(context) ;
        List<SysEmployeeDTO> list = sysemployeeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-SysEmployee-searchDefault-all') and hasPermission(#context,'ibzrt-SysEmployee-Get')")
	@ApiOperation(value = "根据单位机构部门查询DEFAULT", tags = {"人员" } ,notes = "根据单位机构部门查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/searchdefault")
	public ResponseEntity<Page<SysEmployeeDTO>> searchSysEmployeeDefaultBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysEmployeeSearchContext context) {
        context.setN_mdeptid_eq(sysdepartment_id);
        Page<SysEmployee> domains = sysemployeeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysemployeeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

