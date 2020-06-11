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
import cn.ibizlab.core.ou.domain.IBZEmployee;
import cn.ibizlab.core.ou.service.IIBZEmployeeService;
import cn.ibizlab.core.ou.filter.IBZEmployeeSearchContext;

@Slf4j
@Api(tags = {"人员" })
@RestController("api-ibzemployee")
@RequestMapping("")
public class IBZEmployeeResource {

    @Autowired
    public IIBZEmployeeService ibzemployeeService;

    @Autowired
    @Lazy
    public IBZEmployeeMapping ibzemployeeMapping;

    @ApiOperation(value = "删除人员", tags = {"人员" },  notes = "删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzemployees/{ibzemployee_id}")

    public ResponseEntity<Boolean> remove(@PathVariable("ibzemployee_id") String ibzemployee_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.remove(ibzemployee_id));
    }

    @ApiOperation(value = "批量删除人员", tags = {"人员" },  notes = "批量删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzemployees/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ibzemployeeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新人员", tags = {"人员" },  notes = "更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzemployees/{ibzemployee_id}")

    public ResponseEntity<IBZEmployeeDTO> update(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
		IBZEmployee domain  = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain .setUserid(ibzemployee_id);
		ibzemployeeService.update(domain );
		IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新人员", tags = {"人员" },  notes = "批量更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzemployees/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        ibzemployeeService.updateBatch(ibzemployeeMapping.toDomain(ibzemployeedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查人员", tags = {"人员" },  notes = "检查人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody IBZEmployeeDTO ibzemployeedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.checkKey(ibzemployeeMapping.toDomain(ibzemployeedto)));
    }

    @ApiOperation(value = "获取人员", tags = {"人员" },  notes = "获取人员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzemployees/{ibzemployee_id}")
    public ResponseEntity<IBZEmployeeDTO> get(@PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZEmployee domain = ibzemployeeService.get(ibzemployee_id);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "保存人员", tags = {"人员" },  notes = "保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/save")
    public ResponseEntity<Boolean> save(@RequestBody IBZEmployeeDTO ibzemployeedto) {
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.save(ibzemployeeMapping.toDomain(ibzemployeedto)));
    }

    @ApiOperation(value = "批量保存人员", tags = {"人员" },  notes = "批量保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        ibzemployeeService.saveBatch(ibzemployeeMapping.toDomain(ibzemployeedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "初始化密码", tags = {"人员" },  notes = "初始化密码")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/initpwd")

    public ResponseEntity<IBZEmployeeDTO> initPwd(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee ibzemployee = ibzemployeeMapping.toDomain(ibzemployeedto);
        ibzemployee.setUserid(ibzemployee_id);
        ibzemployee = ibzemployeeService.initPwd(ibzemployee);
        ibzemployeedto = ibzemployeeMapping.toDto(ibzemployee);
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeedto);
    }

    @ApiOperation(value = "获取人员草稿", tags = {"人员" },  notes = "获取人员草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzemployees/getdraft")
    public ResponseEntity<IBZEmployeeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeMapping.toDto(ibzemployeeService.getDraft(new IBZEmployee())));
    }

    @ApiOperation(value = "新建人员", tags = {"人员" },  notes = "新建人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees")

    public ResponseEntity<IBZEmployeeDTO> create(@RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
		ibzemployeeService.create(domain);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建人员", tags = {"人员" },  notes = "批量新建人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        ibzemployeeService.createBatch(ibzemployeeMapping.toDomain(ibzemployeedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"人员" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzemployees/fetchdefault")
	public ResponseEntity<List<IBZEmployeeDTO>> fetchDefault(IBZEmployeeSearchContext context) {
        Page<IBZEmployee> domains = ibzemployeeService.searchDefault(context) ;
        List<IBZEmployeeDTO> list = ibzemployeeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"人员" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzemployees/searchdefault")
	public ResponseEntity<Page<IBZEmployeeDTO>> searchDefault(@RequestBody IBZEmployeeSearchContext context) {
        Page<IBZEmployee> domains = ibzemployeeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzemployeeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据部门删除人员", tags = {"人员" },  notes = "根据部门删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}")

    public ResponseEntity<Boolean> removeByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.remove(ibzemployee_id));
    }

    @ApiOperation(value = "根据部门批量删除人员", tags = {"人员" },  notes = "根据部门批量删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/batch")
    public ResponseEntity<Boolean> removeBatchByIBZDepartment(@RequestBody List<String> ids) {
        ibzemployeeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门更新人员", tags = {"人员" },  notes = "根据部门更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}")

    public ResponseEntity<IBZEmployeeDTO> updateByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setMdeptid(ibzdepartment_id);
        domain.setUserid(ibzemployee_id);
		ibzemployeeService.update(domain);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门批量更新人员", tags = {"人员" },  notes = "根据部门批量更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/batch")
    public ResponseEntity<Boolean> updateBatchByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        List<IBZEmployee> domainlist=ibzemployeeMapping.toDomain(ibzemployeedtos);
        for(IBZEmployee domain:domainlist){
            domain.setMdeptid(ibzdepartment_id);
        }
        ibzemployeeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门检查人员", tags = {"人员" },  notes = "根据部门检查人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.checkKey(ibzemployeeMapping.toDomain(ibzemployeedto)));
    }

    @ApiOperation(value = "根据部门获取人员", tags = {"人员" },  notes = "根据部门获取人员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}")
    public ResponseEntity<IBZEmployeeDTO> getByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZEmployee domain = ibzemployeeService.get(ibzemployee_id);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门保存人员", tags = {"人员" },  notes = "根据部门保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/save")
    public ResponseEntity<Boolean> saveByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setMdeptid(ibzdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.save(domain));
    }

    @ApiOperation(value = "根据部门批量保存人员", tags = {"人员" },  notes = "根据部门批量保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        List<IBZEmployee> domainlist=ibzemployeeMapping.toDomain(ibzemployeedtos);
        for(IBZEmployee domain:domainlist){
             domain.setMdeptid(ibzdepartment_id);
        }
        ibzemployeeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员", tags = {"人员" },  notes = "根据部门人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/initpwd")

    public ResponseEntity<IBZEmployeeDTO> initPwdByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setMdeptid(ibzdepartment_id);
        domain = ibzemployeeService.initPwd(domain) ;
        ibzemployeedto = ibzemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeedto);
    }

    @ApiOperation(value = "根据部门获取人员草稿", tags = {"人员" },  notes = "根据部门获取人员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/getdraft")
    public ResponseEntity<IBZEmployeeDTO> getDraftByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id) {
        IBZEmployee domain = new IBZEmployee();
        domain.setMdeptid(ibzdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeMapping.toDto(ibzemployeeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据部门建立人员", tags = {"人员" },  notes = "根据部门建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees")

    public ResponseEntity<IBZEmployeeDTO> createByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setMdeptid(ibzdepartment_id);
		ibzemployeeService.create(domain);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门批量建立人员", tags = {"人员" },  notes = "根据部门批量建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/batch")
    public ResponseEntity<Boolean> createBatchByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        List<IBZEmployee> domainlist=ibzemployeeMapping.toDomain(ibzemployeedtos);
        for(IBZEmployee domain:domainlist){
            domain.setMdeptid(ibzdepartment_id);
        }
        ibzemployeeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据部门获取DEFAULT", tags = {"人员" } ,notes = "根据部门获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzdepartments/{ibzdepartment_id}/ibzemployees/fetchdefault")
	public ResponseEntity<List<IBZEmployeeDTO>> fetchIBZEmployeeDefaultByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id,IBZEmployeeSearchContext context) {
        context.setN_mdeptid_eq(ibzdepartment_id);
        Page<IBZEmployee> domains = ibzemployeeService.searchDefault(context) ;
        List<IBZEmployeeDTO> list = ibzemployeeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据部门查询DEFAULT", tags = {"人员" } ,notes = "根据部门查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzdepartments/{ibzdepartment_id}/ibzemployees/searchdefault")
	public ResponseEntity<Page<IBZEmployeeDTO>> searchIBZEmployeeDefaultByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZEmployeeSearchContext context) {
        context.setN_mdeptid_eq(ibzdepartment_id);
        Page<IBZEmployee> domains = ibzemployeeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzemployeeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构删除人员", tags = {"人员" },  notes = "根据单位机构删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}")

    public ResponseEntity<Boolean> removeByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.remove(ibzemployee_id));
    }

    @ApiOperation(value = "根据单位机构批量删除人员", tags = {"人员" },  notes = "根据单位机构批量删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/batch")
    public ResponseEntity<Boolean> removeBatchByIBZOrganization(@RequestBody List<String> ids) {
        ibzemployeeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构更新人员", tags = {"人员" },  notes = "根据单位机构更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}")

    public ResponseEntity<IBZEmployeeDTO> updateByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setOrgid(ibzorganization_id);
        domain.setUserid(ibzemployee_id);
		ibzemployeeService.update(domain);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构批量更新人员", tags = {"人员" },  notes = "根据单位机构批量更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/batch")
    public ResponseEntity<Boolean> updateBatchByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        List<IBZEmployee> domainlist=ibzemployeeMapping.toDomain(ibzemployeedtos);
        for(IBZEmployee domain:domainlist){
            domain.setOrgid(ibzorganization_id);
        }
        ibzemployeeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构检查人员", tags = {"人员" },  notes = "根据单位机构检查人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.checkKey(ibzemployeeMapping.toDomain(ibzemployeedto)));
    }

    @ApiOperation(value = "根据单位机构获取人员", tags = {"人员" },  notes = "根据单位机构获取人员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}")
    public ResponseEntity<IBZEmployeeDTO> getByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZEmployee domain = ibzemployeeService.get(ibzemployee_id);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构保存人员", tags = {"人员" },  notes = "根据单位机构保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/save")
    public ResponseEntity<Boolean> saveByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setOrgid(ibzorganization_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.save(domain));
    }

    @ApiOperation(value = "根据单位机构批量保存人员", tags = {"人员" },  notes = "根据单位机构批量保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        List<IBZEmployee> domainlist=ibzemployeeMapping.toDomain(ibzemployeedtos);
        for(IBZEmployee domain:domainlist){
             domain.setOrgid(ibzorganization_id);
        }
        ibzemployeeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员", tags = {"人员" },  notes = "根据单位机构人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/initpwd")

    public ResponseEntity<IBZEmployeeDTO> initPwdByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setOrgid(ibzorganization_id);
        domain = ibzemployeeService.initPwd(domain) ;
        ibzemployeedto = ibzemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeedto);
    }

    @ApiOperation(value = "根据单位机构获取人员草稿", tags = {"人员" },  notes = "根据单位机构获取人员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/getdraft")
    public ResponseEntity<IBZEmployeeDTO> getDraftByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id) {
        IBZEmployee domain = new IBZEmployee();
        domain.setOrgid(ibzorganization_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeMapping.toDto(ibzemployeeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构建立人员", tags = {"人员" },  notes = "根据单位机构建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees")

    public ResponseEntity<IBZEmployeeDTO> createByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setOrgid(ibzorganization_id);
		ibzemployeeService.create(domain);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构批量建立人员", tags = {"人员" },  notes = "根据单位机构批量建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/batch")
    public ResponseEntity<Boolean> createBatchByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        List<IBZEmployee> domainlist=ibzemployeeMapping.toDomain(ibzemployeedtos);
        for(IBZEmployee domain:domainlist){
            domain.setOrgid(ibzorganization_id);
        }
        ibzemployeeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据单位机构获取DEFAULT", tags = {"人员" } ,notes = "根据单位机构获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/{ibzorganization_id}/ibzemployees/fetchdefault")
	public ResponseEntity<List<IBZEmployeeDTO>> fetchIBZEmployeeDefaultByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id,IBZEmployeeSearchContext context) {
        context.setN_orgid_eq(ibzorganization_id);
        Page<IBZEmployee> domains = ibzemployeeService.searchDefault(context) ;
        List<IBZEmployeeDTO> list = ibzemployeeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据单位机构查询DEFAULT", tags = {"人员" } ,notes = "根据单位机构查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/{ibzorganization_id}/ibzemployees/searchdefault")
	public ResponseEntity<Page<IBZEmployeeDTO>> searchIBZEmployeeDefaultByIBZOrganization(@PathVariable("ibzorganization_id") String ibzorganization_id, @RequestBody IBZEmployeeSearchContext context) {
        context.setN_orgid_eq(ibzorganization_id);
        Page<IBZEmployee> domains = ibzemployeeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzemployeeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构部门删除人员", tags = {"人员" },  notes = "根据单位机构部门删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}")

    public ResponseEntity<Boolean> removeByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.remove(ibzemployee_id));
    }

    @ApiOperation(value = "根据单位机构部门批量删除人员", tags = {"人员" },  notes = "根据单位机构部门批量删除人员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/batch")
    public ResponseEntity<Boolean> removeBatchByIBZOrganizationIBZDepartment(@RequestBody List<String> ids) {
        ibzemployeeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门更新人员", tags = {"人员" },  notes = "根据单位机构部门更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}")

    public ResponseEntity<IBZEmployeeDTO> updateByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setMdeptid(ibzdepartment_id);
        domain.setUserid(ibzemployee_id);
		ibzemployeeService.update(domain);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门批量更新人员", tags = {"人员" },  notes = "根据单位机构部门批量更新人员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/batch")
    public ResponseEntity<Boolean> updateBatchByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        List<IBZEmployee> domainlist=ibzemployeeMapping.toDomain(ibzemployeedtos);
        for(IBZEmployee domain:domainlist){
            domain.setMdeptid(ibzdepartment_id);
        }
        ibzemployeeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门检查人员", tags = {"人员" },  notes = "根据单位机构部门检查人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.checkKey(ibzemployeeMapping.toDomain(ibzemployeedto)));
    }

    @ApiOperation(value = "根据单位机构部门获取人员", tags = {"人员" },  notes = "根据单位机构部门获取人员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}")
    public ResponseEntity<IBZEmployeeDTO> getByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZEmployee domain = ibzemployeeService.get(ibzemployee_id);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门保存人员", tags = {"人员" },  notes = "根据单位机构部门保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/save")
    public ResponseEntity<Boolean> saveByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setMdeptid(ibzdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeService.save(domain));
    }

    @ApiOperation(value = "根据单位机构部门批量保存人员", tags = {"人员" },  notes = "根据单位机构部门批量保存人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        List<IBZEmployee> domainlist=ibzemployeeMapping.toDomain(ibzemployeedtos);
        for(IBZEmployee domain:domainlist){
             domain.setMdeptid(ibzdepartment_id);
        }
        ibzemployeeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员", tags = {"人员" },  notes = "根据单位机构部门人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/initpwd")

    public ResponseEntity<IBZEmployeeDTO> initPwdByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setMdeptid(ibzdepartment_id);
        domain = ibzemployeeService.initPwd(domain) ;
        ibzemployeedto = ibzemployeeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeedto);
    }

    @ApiOperation(value = "根据单位机构部门获取人员草稿", tags = {"人员" },  notes = "根据单位机构部门获取人员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/getdraft")
    public ResponseEntity<IBZEmployeeDTO> getDraftByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id) {
        IBZEmployee domain = new IBZEmployee();
        domain.setMdeptid(ibzdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzemployeeMapping.toDto(ibzemployeeService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构部门建立人员", tags = {"人员" },  notes = "根据单位机构部门建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees")

    public ResponseEntity<IBZEmployeeDTO> createByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZEmployeeDTO ibzemployeedto) {
        IBZEmployee domain = ibzemployeeMapping.toDomain(ibzemployeedto);
        domain.setMdeptid(ibzdepartment_id);
		ibzemployeeService.create(domain);
        IBZEmployeeDTO dto = ibzemployeeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门批量建立人员", tags = {"人员" },  notes = "根据单位机构部门批量建立人员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/batch")
    public ResponseEntity<Boolean> createBatchByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZEmployeeDTO> ibzemployeedtos) {
        List<IBZEmployee> domainlist=ibzemployeeMapping.toDomain(ibzemployeedtos);
        for(IBZEmployee domain:domainlist){
            domain.setMdeptid(ibzdepartment_id);
        }
        ibzemployeeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据单位机构部门获取DEFAULT", tags = {"人员" } ,notes = "根据单位机构部门获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/fetchdefault")
	public ResponseEntity<List<IBZEmployeeDTO>> fetchIBZEmployeeDefaultByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id,IBZEmployeeSearchContext context) {
        context.setN_mdeptid_eq(ibzdepartment_id);
        Page<IBZEmployee> domains = ibzemployeeService.searchDefault(context) ;
        List<IBZEmployeeDTO> list = ibzemployeeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据单位机构部门查询DEFAULT", tags = {"人员" } ,notes = "根据单位机构部门查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/searchdefault")
	public ResponseEntity<Page<IBZEmployeeDTO>> searchIBZEmployeeDefaultByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZEmployeeSearchContext context) {
        context.setN_mdeptid_eq(ibzdepartment_id);
        Page<IBZEmployee> domains = ibzemployeeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzemployeeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

