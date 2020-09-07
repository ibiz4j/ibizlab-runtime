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
import cn.ibizlab.core.ou.domain.SysDepartment;
import cn.ibizlab.core.ou.service.ISysDepartmentService;
import cn.ibizlab.core.ou.filter.SysDepartmentSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"部门" })
@RestController("api-sysdepartment")
@RequestMapping("")
public class SysDepartmentResource {

    @Autowired
    public ISysDepartmentService sysdepartmentService;

    @Autowired
    @Lazy
    public SysDepartmentMapping sysdepartmentMapping;

    @PreAuthorize("hasPermission(this.sysdepartmentMapping.toDomain(#sysdepartmentdto),'ibzou-SysDepartment-Create')")
    @ApiOperation(value = "新建部门", tags = {"部门" },  notes = "新建部门")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments")
    public ResponseEntity<SysDepartmentDTO> create(@RequestBody SysDepartmentDTO sysdepartmentdto) {
        SysDepartment domain = sysdepartmentMapping.toDomain(sysdepartmentdto);
		sysdepartmentService.create(domain);
        SysDepartmentDTO dto = sysdepartmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysdepartmentMapping.toDomain(#sysdepartmentdtos),'ibzou-SysDepartment-Create')")
    @ApiOperation(value = "批量新建部门", tags = {"部门" },  notes = "批量新建部门")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysDepartmentDTO> sysdepartmentdtos) {
        sysdepartmentService.createBatch(sysdepartmentMapping.toDomain(sysdepartmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysdepartment" , versionfield = "updatedate")
    @PreAuthorize("hasPermission(this.sysdepartmentService.get(#sysdepartment_id),'ibzou-SysDepartment-Update')")
    @ApiOperation(value = "更新部门", tags = {"部门" },  notes = "更新部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/{sysdepartment_id}")
    public ResponseEntity<SysDepartmentDTO> update(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysDepartmentDTO sysdepartmentdto) {
		SysDepartment domain  = sysdepartmentMapping.toDomain(sysdepartmentdto);
        domain .setDeptid(sysdepartment_id);
		sysdepartmentService.update(domain );
		SysDepartmentDTO dto = sysdepartmentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysdepartmentService.getSysdepartmentByEntities(this.sysdepartmentMapping.toDomain(#sysdepartmentdtos)),'ibzou-SysDepartment-Update')")
    @ApiOperation(value = "批量更新部门", tags = {"部门" },  notes = "批量更新部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysDepartmentDTO> sysdepartmentdtos) {
        sysdepartmentService.updateBatch(sysdepartmentMapping.toDomain(sysdepartmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.sysdepartmentService.get(#sysdepartment_id),'ibzou-SysDepartment-Remove')")
    @ApiOperation(value = "删除部门", tags = {"部门" },  notes = "删除部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/{sysdepartment_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("sysdepartment_id") String sysdepartment_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysdepartmentService.remove(sysdepartment_id));
    }

    @PreAuthorize("hasPermission(this.sysdepartmentService.getSysdepartmentByIds(#ids),'ibzou-SysDepartment-Remove')")
    @ApiOperation(value = "批量删除部门", tags = {"部门" },  notes = "批量删除部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysdepartmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.sysdepartmentMapping.toDomain(returnObject.body),'ibzou-SysDepartment-Get')")
    @ApiOperation(value = "获取部门", tags = {"部门" },  notes = "获取部门")
	@RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/{sysdepartment_id}")
    public ResponseEntity<SysDepartmentDTO> get(@PathVariable("sysdepartment_id") String sysdepartment_id) {
        SysDepartment domain = sysdepartmentService.get(sysdepartment_id);
        SysDepartmentDTO dto = sysdepartmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取部门草稿", tags = {"部门" },  notes = "获取部门草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/getdraft")
    public ResponseEntity<SysDepartmentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sysdepartmentMapping.toDto(sysdepartmentService.getDraft(new SysDepartment())));
    }

    @ApiOperation(value = "检查部门", tags = {"部门" },  notes = "检查部门")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysDepartmentDTO sysdepartmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysdepartmentService.checkKey(sysdepartmentMapping.toDomain(sysdepartmentdto)));
    }

    @PreAuthorize("hasPermission(this.sysdepartmentMapping.toDomain(#sysdepartmentdto),'ibzou-SysDepartment-Save')")
    @ApiOperation(value = "保存部门", tags = {"部门" },  notes = "保存部门")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/save")
    public ResponseEntity<Boolean> save(@RequestBody SysDepartmentDTO sysdepartmentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(sysdepartmentService.save(sysdepartmentMapping.toDomain(sysdepartmentdto)));
    }

    @PreAuthorize("hasPermission(this.sysdepartmentMapping.toDomain(#sysdepartmentdtos),'ibzou-SysDepartment-Save')")
    @ApiOperation(value = "批量保存部门", tags = {"部门" },  notes = "批量保存部门")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysDepartmentDTO> sysdepartmentdtos) {
        sysdepartmentService.saveBatch(sysdepartmentMapping.toDomain(sysdepartmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-SysDepartment-searchDefault-all') and hasPermission(#context,'ibzou-SysDepartment-Get')")
	@ApiOperation(value = "获取DEFAULT", tags = {"部门" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysdepartments/fetchdefault")
	public ResponseEntity<List<SysDepartmentDTO>> fetchDefault(SysDepartmentSearchContext context) {
        Page<SysDepartment> domains = sysdepartmentService.searchDefault(context) ;
        List<SysDepartmentDTO> list = sysdepartmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-SysDepartment-searchDefault-all') and hasPermission(#context,'ibzou-SysDepartment-Get')")
	@ApiOperation(value = "查询DEFAULT", tags = {"部门" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysdepartments/searchdefault")
	public ResponseEntity<Page<SysDepartmentDTO>> searchDefault(@RequestBody SysDepartmentSearchContext context) {
        Page<SysDepartment> domains = sysdepartmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysdepartmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.sysdepartmentMapping.toDomain(#sysdepartmentdto),'ibzou-SysDepartment-Create')")
    @ApiOperation(value = "根据单位机构建立部门", tags = {"部门" },  notes = "根据单位机构建立部门")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments")
    public ResponseEntity<SysDepartmentDTO> createBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody SysDepartmentDTO sysdepartmentdto) {
        SysDepartment domain = sysdepartmentMapping.toDomain(sysdepartmentdto);
        domain.setOrgid(sysorganization_id);
		sysdepartmentService.create(domain);
        SysDepartmentDTO dto = sysdepartmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysdepartmentMapping.toDomain(#sysdepartmentdtos),'ibzou-SysDepartment-Create')")
    @ApiOperation(value = "根据单位机构批量建立部门", tags = {"部门" },  notes = "根据单位机构批量建立部门")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/batch")
    public ResponseEntity<Boolean> createBatchBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody List<SysDepartmentDTO> sysdepartmentdtos) {
        List<SysDepartment> domainlist=sysdepartmentMapping.toDomain(sysdepartmentdtos);
        for(SysDepartment domain:domainlist){
            domain.setOrgid(sysorganization_id);
        }
        sysdepartmentService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "sysdepartment" , versionfield = "updatedate")
    @PreAuthorize("hasPermission(this.sysdepartmentService.get(#sysdepartment_id),'ibzou-SysDepartment-Update')")
    @ApiOperation(value = "根据单位机构更新部门", tags = {"部门" },  notes = "根据单位机构更新部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}")
    public ResponseEntity<SysDepartmentDTO> updateBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysDepartmentDTO sysdepartmentdto) {
        SysDepartment domain = sysdepartmentMapping.toDomain(sysdepartmentdto);
        domain.setOrgid(sysorganization_id);
        domain.setDeptid(sysdepartment_id);
		sysdepartmentService.update(domain);
        SysDepartmentDTO dto = sysdepartmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sysdepartmentService.getSysdepartmentByEntities(this.sysdepartmentMapping.toDomain(#sysdepartmentdtos)),'ibzou-SysDepartment-Update')")
    @ApiOperation(value = "根据单位机构批量更新部门", tags = {"部门" },  notes = "根据单位机构批量更新部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysdepartments/batch")
    public ResponseEntity<Boolean> updateBatchBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody List<SysDepartmentDTO> sysdepartmentdtos) {
        List<SysDepartment> domainlist=sysdepartmentMapping.toDomain(sysdepartmentdtos);
        for(SysDepartment domain:domainlist){
            domain.setOrgid(sysorganization_id);
        }
        sysdepartmentService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.sysdepartmentService.get(#sysdepartment_id),'ibzou-SysDepartment-Remove')")
    @ApiOperation(value = "根据单位机构删除部门", tags = {"部门" },  notes = "根据单位机构删除部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}")
    public ResponseEntity<Boolean> removeBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysdepartmentService.remove(sysdepartment_id));
    }

    @PreAuthorize("hasPermission(this.sysdepartmentService.getSysdepartmentByIds(#ids),'ibzou-SysDepartment-Remove')")
    @ApiOperation(value = "根据单位机构批量删除部门", tags = {"部门" },  notes = "根据单位机构批量删除部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysdepartments/batch")
    public ResponseEntity<Boolean> removeBatchBySysOrganization(@RequestBody List<String> ids) {
        sysdepartmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.sysdepartmentMapping.toDomain(returnObject.body),'ibzou-SysDepartment-Get')")
    @ApiOperation(value = "根据单位机构获取部门", tags = {"部门" },  notes = "根据单位机构获取部门")
	@RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}")
    public ResponseEntity<SysDepartmentDTO> getBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id) {
        SysDepartment domain = sysdepartmentService.get(sysdepartment_id);
        SysDepartmentDTO dto = sysdepartmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构获取部门草稿", tags = {"部门" },  notes = "根据单位机构获取部门草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysdepartments/getdraft")
    public ResponseEntity<SysDepartmentDTO> getDraftBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id) {
        SysDepartment domain = new SysDepartment();
        domain.setOrgid(sysorganization_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdepartmentMapping.toDto(sysdepartmentService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构检查部门", tags = {"部门" },  notes = "根据单位机构检查部门")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody SysDepartmentDTO sysdepartmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysdepartmentService.checkKey(sysdepartmentMapping.toDomain(sysdepartmentdto)));
    }

    @PreAuthorize("hasPermission(this.sysdepartmentMapping.toDomain(#sysdepartmentdto),'ibzou-SysDepartment-Save')")
    @ApiOperation(value = "根据单位机构保存部门", tags = {"部门" },  notes = "根据单位机构保存部门")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/save")
    public ResponseEntity<Boolean> saveBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody SysDepartmentDTO sysdepartmentdto) {
        SysDepartment domain = sysdepartmentMapping.toDomain(sysdepartmentdto);
        domain.setOrgid(sysorganization_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdepartmentService.save(domain));
    }

    @PreAuthorize("hasPermission(this.sysdepartmentMapping.toDomain(#sysdepartmentdtos),'ibzou-SysDepartment-Save')")
    @ApiOperation(value = "根据单位机构批量保存部门", tags = {"部门" },  notes = "根据单位机构批量保存部门")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody List<SysDepartmentDTO> sysdepartmentdtos) {
        List<SysDepartment> domainlist=sysdepartmentMapping.toDomain(sysdepartmentdtos);
        for(SysDepartment domain:domainlist){
             domain.setOrgid(sysorganization_id);
        }
        sysdepartmentService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-SysDepartment-searchDefault-all') and hasPermission(#context,'ibzou-SysDepartment-Get')")
	@ApiOperation(value = "根据单位机构获取DEFAULT", tags = {"部门" } ,notes = "根据单位机构获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysorganizations/{sysorganization_id}/sysdepartments/fetchdefault")
	public ResponseEntity<List<SysDepartmentDTO>> fetchSysDepartmentDefaultBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id,SysDepartmentSearchContext context) {
        context.setN_orgid_eq(sysorganization_id);
        Page<SysDepartment> domains = sysdepartmentService.searchDefault(context) ;
        List<SysDepartmentDTO> list = sysdepartmentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-SysDepartment-searchDefault-all') and hasPermission(#context,'ibzou-SysDepartment-Get')")
	@ApiOperation(value = "根据单位机构查询DEFAULT", tags = {"部门" } ,notes = "根据单位机构查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysorganizations/{sysorganization_id}/sysdepartments/searchdefault")
	public ResponseEntity<Page<SysDepartmentDTO>> searchSysDepartmentDefaultBySysOrganization(@PathVariable("sysorganization_id") String sysorganization_id, @RequestBody SysDepartmentSearchContext context) {
        context.setN_orgid_eq(sysorganization_id);
        Page<SysDepartment> domains = sysdepartmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysdepartmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

