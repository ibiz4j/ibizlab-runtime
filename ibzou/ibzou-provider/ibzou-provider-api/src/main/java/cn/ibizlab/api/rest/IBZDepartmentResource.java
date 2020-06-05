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
import org.springframework.transaction.annotation.Transactional;
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
import cn.ibizlab.core.ou.domain.IBZDepartment;
import cn.ibizlab.core.ou.service.IIBZDepartmentService;
import cn.ibizlab.core.ou.filter.IBZDepartmentSearchContext;

@Slf4j
@Api(tags = {"部门" })
@RestController("api-ibzdepartment")
@RequestMapping("")
public class IBZDepartmentResource {

    @Autowired
    public IIBZDepartmentService ibzdepartmentService;

    @Autowired
    @Lazy
    public IBZDepartmentMapping ibzdepartmentMapping;

    @PreAuthorize("hasPermission(this.ibzdepartmentMapping.toDomain(#ibzdepartmentdto),'ibzou-IBZDepartment-Create')")
    @ApiOperation(value = "新建部门", tags = {"部门" },  notes = "新建部门")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments")
    @Transactional
    public ResponseEntity<IBZDepartmentDTO> create(@RequestBody IBZDepartmentDTO ibzdepartmentdto) {
        IBZDepartment domain = ibzdepartmentMapping.toDomain(ibzdepartmentdto);
		ibzdepartmentService.create(domain);
        IBZDepartmentDTO dto = ibzdepartmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentMapping.toDomain(#ibzdepartmentdtos),'ibzou-IBZDepartment-Create')")
    @ApiOperation(value = "批量新建部门", tags = {"部门" },  notes = "批量新建部门")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<IBZDepartmentDTO> ibzdepartmentdtos) {
        ibzdepartmentService.createBatch(ibzdepartmentMapping.toDomain(ibzdepartmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ibzdepartmentMapping.toDomain(returnObject.body),'ibzou-IBZDepartment-Get')")
    @ApiOperation(value = "获取部门", tags = {"部门" },  notes = "获取部门")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/{ibzdepartment_id}")
    public ResponseEntity<IBZDepartmentDTO> get(@PathVariable("ibzdepartment_id") String ibzdepartment_id) {
        IBZDepartment domain = ibzdepartmentService.get(ibzdepartment_id);
        IBZDepartmentDTO dto = ibzdepartmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentMapping.toDomain(#ibzdepartmentdto),'ibzou-IBZDepartment-Save')")
    @ApiOperation(value = "保存部门", tags = {"部门" },  notes = "保存部门")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/save")
    public ResponseEntity<Boolean> save(@RequestBody IBZDepartmentDTO ibzdepartmentdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ibzdepartmentService.save(ibzdepartmentMapping.toDomain(ibzdepartmentdto)));
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentMapping.toDomain(#ibzdepartmentdtos),'ibzou-IBZDepartment-Save')")
    @ApiOperation(value = "批量保存部门", tags = {"部门" },  notes = "批量保存部门")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<IBZDepartmentDTO> ibzdepartmentdtos) {
        ibzdepartmentService.saveBatch(ibzdepartmentMapping.toDomain(ibzdepartmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查部门", tags = {"部门" },  notes = "检查部门")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody IBZDepartmentDTO ibzdepartmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzdepartmentService.checkKey(ibzdepartmentMapping.toDomain(ibzdepartmentdto)));
    }

    @ApiOperation(value = "获取部门草稿", tags = {"部门" },  notes = "获取部门草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/getdraft")
    public ResponseEntity<IBZDepartmentDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ibzdepartmentMapping.toDto(ibzdepartmentService.getDraft(new IBZDepartment())));
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentService.get(#ibzdepartment_id),'ibzou-IBZDepartment-Remove')")
    @ApiOperation(value = "删除部门", tags = {"部门" },  notes = "删除部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/{ibzdepartment_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ibzdepartment_id") String ibzdepartment_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ibzdepartmentService.remove(ibzdepartment_id));
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentService.getIbzdepartmentByIds(#ids),'ibzou-IBZDepartment-Remove')")
    @ApiOperation(value = "批量删除部门", tags = {"部门" },  notes = "批量删除部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ibzdepartmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentService.get(#ibzdepartment_id),'ibzou-IBZDepartment-Update')")
    @ApiOperation(value = "更新部门", tags = {"部门" },  notes = "更新部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/{ibzdepartment_id}")
    @Transactional
    public ResponseEntity<IBZDepartmentDTO> update(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZDepartmentDTO ibzdepartmentdto) {
		IBZDepartment domain  = ibzdepartmentMapping.toDomain(ibzdepartmentdto);
        domain .setDeptid(ibzdepartment_id);
		ibzdepartmentService.update(domain );
		IBZDepartmentDTO dto = ibzdepartmentMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentService.getIbzdepartmentByEntities(this.ibzdepartmentMapping.toDomain(#ibzdepartmentdtos)),'ibzou-IBZDepartment-Update')")
    @ApiOperation(value = "批量更新部门", tags = {"部门" },  notes = "批量更新部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<IBZDepartmentDTO> ibzdepartmentdtos) {
        ibzdepartmentService.updateBatch(ibzdepartmentMapping.toDomain(ibzdepartmentdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZDepartment-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"部门" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzdepartments/fetchdefault")
	public ResponseEntity<List<IBZDepartmentDTO>> fetchDefault(IBZDepartmentSearchContext context) {
        Page<IBZDepartment> domains = ibzdepartmentService.searchDefault(context) ;
        List<IBZDepartmentDTO> list = ibzdepartmentMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZDepartment-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"部门" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzdepartments/searchdefault")
	public ResponseEntity<Page<IBZDepartmentDTO>> searchDefault(@RequestBody IBZDepartmentSearchContext context) {
        Page<IBZDepartment> domains = ibzdepartmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzdepartmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.ibzdepartmentMapping.toDomain(#ibzdepartmentdto),'ibzou-IBZDepartment-Create')")
    @ApiOperation(value = "根据单位机构建立部门", tags = {"部门" },  notes = "根据单位机构建立部门")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments")
    @Transactional
    public ResponseEntity<IBZDepartmentDTO> createByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody IBZDepartmentDTO ibzdepartmentdto) {
        IBZDepartment domain = ibzdepartmentMapping.toDomain(ibzdepartmentdto);
        domain.setOrgid(ibzorganization_id);
		ibzdepartmentService.create(domain);
        IBZDepartmentDTO dto = ibzdepartmentMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentMapping.toDomain(#ibzdepartmentdtos),'ibzou-IBZDepartment-Create')")
    @ApiOperation(value = "根据单位机构批量建立部门", tags = {"部门" },  notes = "根据单位机构批量建立部门")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/batch")
    public ResponseEntity<Boolean> createBatchByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody List<IBZDepartmentDTO> ibzdepartmentdtos) {
        List<IBZDepartment> domainlist=ibzdepartmentMapping.toDomain(ibzdepartmentdtos);
        for(IBZDepartment domain:domainlist){
            domain.setOrgid(ibzorganization_id);
        }
        ibzdepartmentService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.ibzdepartmentMapping.toDomain(returnObject.body),'ibzou-IBZDepartment-Get')")
    @ApiOperation(value = "根据单位机构获取部门", tags = {"部门" },  notes = "根据单位机构获取部门")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}")
    public ResponseEntity<IBZDepartmentDTO> getByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id) {
        IBZDepartment domain = ibzdepartmentService.get(ibzdepartment_id);
        IBZDepartmentDTO dto = ibzdepartmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentMapping.toDomain(#ibzdepartmentdto),'ibzou-IBZDepartment-Save')")
    @ApiOperation(value = "根据单位机构保存部门", tags = {"部门" },  notes = "根据单位机构保存部门")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/save")
    public ResponseEntity<Boolean> saveByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody IBZDepartmentDTO ibzdepartmentdto) {
        IBZDepartment domain = ibzdepartmentMapping.toDomain(ibzdepartmentdto);
        domain.setOrgid(ibzorganization_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdepartmentService.save(domain));
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentMapping.toDomain(#ibzdepartmentdtos),'ibzou-IBZDepartment-Save')")
    @ApiOperation(value = "根据单位机构批量保存部门", tags = {"部门" },  notes = "根据单位机构批量保存部门")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody List<IBZDepartmentDTO> ibzdepartmentdtos) {
        List<IBZDepartment> domainlist=ibzdepartmentMapping.toDomain(ibzdepartmentdtos);
        for(IBZDepartment domain:domainlist){
             domain.setOrgid(ibzorganization_id);
        }
        ibzdepartmentService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构检查部门", tags = {"部门" },  notes = "根据单位机构检查部门")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody IBZDepartmentDTO ibzdepartmentdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzdepartmentService.checkKey(ibzdepartmentMapping.toDomain(ibzdepartmentdto)));
    }

    @ApiOperation(value = "根据单位机构获取部门草稿", tags = {"部门" },  notes = "根据单位机构获取部门草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/getdraft")
    public ResponseEntity<IBZDepartmentDTO> getDraftByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id) {
        IBZDepartment domain = new IBZDepartment();
        domain.setOrgid(ibzorganization_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdepartmentMapping.toDto(ibzdepartmentService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentService.get(#ibzdepartment_id),'ibzou-IBZDepartment-Remove')")
    @ApiOperation(value = "根据单位机构删除部门", tags = {"部门" },  notes = "根据单位机构删除部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzdepartmentService.remove(ibzdepartment_id));
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentService.getIbzdepartmentByIds(#ids),'ibzou-IBZDepartment-Remove')")
    @ApiOperation(value = "根据单位机构批量删除部门", tags = {"部门" },  notes = "根据单位机构批量删除部门")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/batch")
    public ResponseEntity<Boolean> removeBatchByIBZOrganization(@RequestBody List<String> ids) {
        ibzdepartmentService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentService.get(#ibzdepartment_id),'ibzou-IBZDepartment-Update')")
    @ApiOperation(value = "根据单位机构更新部门", tags = {"部门" },  notes = "根据单位机构更新部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}")
    @Transactional
    public ResponseEntity<IBZDepartmentDTO> updateByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZDepartmentDTO ibzdepartmentdto) {
        IBZDepartment domain = ibzdepartmentMapping.toDomain(ibzdepartmentdto);
        domain.setOrgid(ibzorganization_id);
        domain.setDeptid(ibzdepartment_id);
		ibzdepartmentService.update(domain);
        IBZDepartmentDTO dto = ibzdepartmentMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ibzdepartmentService.getIbzdepartmentByEntities(this.ibzdepartmentMapping.toDomain(#ibzdepartmentdtos)),'ibzou-IBZDepartment-Update')")
    @ApiOperation(value = "根据单位机构批量更新部门", tags = {"部门" },  notes = "根据单位机构批量更新部门")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/batch")
    public ResponseEntity<Boolean> updateBatchByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody List<IBZDepartmentDTO> ibzdepartmentdtos) {
        List<IBZDepartment> domainlist=ibzdepartmentMapping.toDomain(ibzdepartmentdtos);
        for(IBZDepartment domain:domainlist){
            domain.setOrgid(ibzorganization_id);
        }
        ibzdepartmentService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZDepartment-Default-all')")
	@ApiOperation(value = "根据单位机构获取DEFAULT", tags = {"部门" } ,notes = "根据单位机构获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/{ibzorganization_id}/ibzdepartments/fetchdefault")
	public ResponseEntity<List<IBZDepartmentDTO>> fetchIBZDepartmentDefaultByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id,IBZDepartmentSearchContext context) {
        context.setN_orgid_eq(ibzorganization_id);
        Page<IBZDepartment> domains = ibzdepartmentService.searchDefault(context) ;
        List<IBZDepartmentDTO> list = ibzdepartmentMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZDepartment-Default-all')")
	@ApiOperation(value = "根据单位机构查询DEFAULT", tags = {"部门" } ,notes = "根据单位机构查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/{ibzorganization_id}/ibzdepartments/searchdefault")
	public ResponseEntity<Page<IBZDepartmentDTO>> searchIBZDepartmentDefaultByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody IBZDepartmentSearchContext context) {
        context.setN_orgid_eq(ibzorganization_id);
        Page<IBZDepartment> domains = ibzdepartmentService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzdepartmentMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

