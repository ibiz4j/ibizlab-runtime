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
import cn.ibizlab.core.ou.domain.IBZDeptMember;
import cn.ibizlab.core.ou.service.IIBZDeptMemberService;
import cn.ibizlab.core.ou.filter.IBZDeptMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"部门成员" })
@RestController("api-ibzdeptmember")
@RequestMapping("")
public class IBZDeptMemberResource {

    @Autowired
    public IIBZDeptMemberService ibzdeptmemberService;

    @Autowired
    @Lazy
    public IBZDeptMemberMapping ibzdeptmemberMapping;

    @ApiOperation(value = "更新部门成员", tags = {"部门成员" },  notes = "更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<IBZDeptMemberDTO> update(@PathVariable("ibzdeptmember_id") String ibzdeptmember_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
		IBZDeptMember domain  = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain .setMemberid(ibzdeptmember_id);
		ibzdeptmemberService.update(domain );
		IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新部门成员", tags = {"部门成员" },  notes = "批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        ibzdeptmemberService.updateBatch(ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取部门成员", tags = {"部门成员" },  notes = "获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzdeptmembers/{ibzdeptmember_id}")
    public ResponseEntity<IBZDeptMemberDTO> get(@PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
        IBZDeptMember domain = ibzdeptmemberService.get(ibzdeptmember_id);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查部门成员", tags = {"部门成员" },  notes = "检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.checkKey(ibzdeptmemberMapping.toDomain(ibzdeptmemberdto)));
    }

    @ApiOperation(value = "删除部门成员", tags = {"部门成员" },  notes = "删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<Boolean> remove(@PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.remove(ibzdeptmember_id));
    }

    @ApiOperation(value = "批量删除部门成员", tags = {"部门成员" },  notes = "批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ibzdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "新建部门成员", tags = {"部门成员" },  notes = "新建部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers")

    public ResponseEntity<IBZDeptMemberDTO> create(@RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
		ibzdeptmemberService.create(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建部门成员", tags = {"部门成员" },  notes = "批量新建部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        ibzdeptmemberService.createBatch(ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取部门成员草稿", tags = {"部门成员" },  notes = "获取部门成员草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzdeptmembers/getdraft")
    public ResponseEntity<IBZDeptMemberDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberMapping.toDto(ibzdeptmemberService.getDraft(new IBZDeptMember())));
    }

    @ApiOperation(value = "保存部门成员", tags = {"部门成员" },  notes = "保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers/save")
    public ResponseEntity<Boolean> save(@RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.save(ibzdeptmemberMapping.toDomain(ibzdeptmemberdto)));
    }

    @ApiOperation(value = "批量保存部门成员", tags = {"部门成员" },  notes = "批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        ibzdeptmemberService.saveBatch(ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"部门成员" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzdeptmembers/fetchdefault")
	public ResponseEntity<List<IBZDeptMemberDTO>> fetchDefault(IBZDeptMemberSearchContext context) {
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
        List<IBZDeptMemberDTO> list = ibzdeptmemberMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"部门成员" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzdeptmembers/searchdefault")
	public ResponseEntity<Page<IBZDeptMemberDTO>> searchDefault(@RequestBody IBZDeptMemberSearchContext context) {
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据部门更新部门成员", tags = {"部门成员" },  notes = "根据部门更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<IBZDeptMemberDTO> updateByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzdepartment_id);
        domain.setMemberid(ibzdeptmember_id);
		ibzdeptmemberService.update(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门批量更新部门成员", tags = {"部门成员" },  notes = "根据部门批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzdepartment_id);
        }
        ibzdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门获取部门成员", tags = {"部门成员" },  notes = "根据部门获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/{ibzdeptmember_id}")
    public ResponseEntity<IBZDeptMemberDTO> getByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
        IBZDeptMember domain = ibzdeptmemberService.get(ibzdeptmember_id);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门检查部门成员", tags = {"部门成员" },  notes = "根据部门检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.checkKey(ibzdeptmemberMapping.toDomain(ibzdeptmemberdto)));
    }

    @ApiOperation(value = "根据部门删除部门成员", tags = {"部门成员" },  notes = "根据部门删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<Boolean> removeByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.remove(ibzdeptmember_id));
    }

    @ApiOperation(value = "根据部门批量删除部门成员", tags = {"部门成员" },  notes = "根据部门批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZDepartment(@RequestBody List<String> ids) {
        ibzdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门建立部门成员", tags = {"部门成员" },  notes = "根据部门建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers")

    public ResponseEntity<IBZDeptMemberDTO> createByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzdepartment_id);
		ibzdeptmemberService.create(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门批量建立部门成员", tags = {"部门成员" },  notes = "根据部门批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzdepartment_id);
        }
        ibzdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门获取部门成员草稿", tags = {"部门成员" },  notes = "根据部门获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/getdraft")
    public ResponseEntity<IBZDeptMemberDTO> getDraftByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id) {
        IBZDeptMember domain = new IBZDeptMember();
        domain.setUserid(ibzdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberMapping.toDto(ibzdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据部门保存部门成员", tags = {"部门成员" },  notes = "根据部门保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/save")
    public ResponseEntity<Boolean> saveByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据部门批量保存部门成员", tags = {"部门成员" },  notes = "根据部门批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
             domain.setUserid(ibzdepartment_id);
        }
        ibzdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据部门获取DEFAULT", tags = {"部门成员" } ,notes = "根据部门获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/fetchdefault")
	public ResponseEntity<List<IBZDeptMemberDTO>> fetchIBZDeptMemberDefaultByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id,IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzdepartment_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
        List<IBZDeptMemberDTO> list = ibzdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据部门查询DEFAULT", tags = {"部门成员" } ,notes = "根据部门查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/searchdefault")
	public ResponseEntity<Page<IBZDeptMemberDTO>> searchIBZDeptMemberDefaultByIBZDepartment(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzdepartment_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据人员更新部门成员", tags = {"部门成员" },  notes = "根据人员更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<IBZDeptMemberDTO> updateByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
        domain.setMemberid(ibzdeptmember_id);
		ibzdeptmemberService.update(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员批量更新部门成员", tags = {"部门成员" },  notes = "根据人员批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员获取部门成员", tags = {"部门成员" },  notes = "根据人员获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")
    public ResponseEntity<IBZDeptMemberDTO> getByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
        IBZDeptMember domain = ibzdeptmemberService.get(ibzdeptmember_id);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员检查部门成员", tags = {"部门成员" },  notes = "根据人员检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.checkKey(ibzdeptmemberMapping.toDomain(ibzdeptmemberdto)));
    }

    @ApiOperation(value = "根据人员删除部门成员", tags = {"部门成员" },  notes = "根据人员删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<Boolean> removeByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.remove(ibzdeptmember_id));
    }

    @ApiOperation(value = "根据人员批量删除部门成员", tags = {"部门成员" },  notes = "根据人员批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZEmployee(@RequestBody List<String> ids) {
        ibzdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员建立部门成员", tags = {"部门成员" },  notes = "根据人员建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers")

    public ResponseEntity<IBZDeptMemberDTO> createByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
		ibzdeptmemberService.create(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员批量建立部门成员", tags = {"部门成员" },  notes = "根据人员批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员获取部门成员草稿", tags = {"部门成员" },  notes = "根据人员获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers/getdraft")
    public ResponseEntity<IBZDeptMemberDTO> getDraftByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZDeptMember domain = new IBZDeptMember();
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberMapping.toDto(ibzdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员保存部门成员", tags = {"部门成员" },  notes = "根据人员保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers/save")
    public ResponseEntity<Boolean> saveByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据人员批量保存部门成员", tags = {"部门成员" },  notes = "根据人员批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/ibzdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
             domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据人员获取DEFAULT", tags = {"部门成员" } ,notes = "根据人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzemployees/{ibzemployee_id}/ibzdeptmembers/fetchdefault")
	public ResponseEntity<List<IBZDeptMemberDTO>> fetchIBZDeptMemberDefaultByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id,IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
        List<IBZDeptMemberDTO> list = ibzdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据人员查询DEFAULT", tags = {"部门成员" } ,notes = "根据人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzemployees/{ibzemployee_id}/ibzdeptmembers/searchdefault")
	public ResponseEntity<Page<IBZDeptMemberDTO>> searchIBZDeptMemberDefaultByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据部门人员更新部门成员", tags = {"部门成员" },  notes = "根据部门人员更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<IBZDeptMemberDTO> updateByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
        domain.setMemberid(ibzdeptmember_id);
		ibzdeptmemberService.update(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员批量更新部门成员", tags = {"部门成员" },  notes = "根据部门人员批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员获取部门成员", tags = {"部门成员" },  notes = "根据部门人员获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")
    public ResponseEntity<IBZDeptMemberDTO> getByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
        IBZDeptMember domain = ibzdeptmemberService.get(ibzdeptmember_id);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员检查部门成员", tags = {"部门成员" },  notes = "根据部门人员检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.checkKey(ibzdeptmemberMapping.toDomain(ibzdeptmemberdto)));
    }

    @ApiOperation(value = "根据部门人员删除部门成员", tags = {"部门成员" },  notes = "根据部门人员删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<Boolean> removeByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.remove(ibzdeptmember_id));
    }

    @ApiOperation(value = "根据部门人员批量删除部门成员", tags = {"部门成员" },  notes = "根据部门人员批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZDepartmentIBZEmployee(@RequestBody List<String> ids) {
        ibzdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员建立部门成员", tags = {"部门成员" },  notes = "根据部门人员建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers")

    public ResponseEntity<IBZDeptMemberDTO> createByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
		ibzdeptmemberService.create(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员批量建立部门成员", tags = {"部门成员" },  notes = "根据部门人员批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员获取部门成员草稿", tags = {"部门成员" },  notes = "根据部门人员获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/getdraft")
    public ResponseEntity<IBZDeptMemberDTO> getDraftByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZDeptMember domain = new IBZDeptMember();
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberMapping.toDto(ibzdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据部门人员保存部门成员", tags = {"部门成员" },  notes = "根据部门人员保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/save")
    public ResponseEntity<Boolean> saveByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据部门人员批量保存部门成员", tags = {"部门成员" },  notes = "根据部门人员批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
             domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据部门人员获取DEFAULT", tags = {"部门成员" } ,notes = "根据部门人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/fetchdefault")
	public ResponseEntity<List<IBZDeptMemberDTO>> fetchIBZDeptMemberDefaultByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id,IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
        List<IBZDeptMemberDTO> list = ibzdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据部门人员查询DEFAULT", tags = {"部门成员" } ,notes = "根据部门人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/searchdefault")
	public ResponseEntity<Page<IBZDeptMemberDTO>> searchIBZDeptMemberDefaultByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构部门更新部门成员", tags = {"部门成员" },  notes = "根据单位机构部门更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<IBZDeptMemberDTO> updateByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzdepartment_id);
        domain.setMemberid(ibzdeptmember_id);
		ibzdeptmemberService.update(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门批量更新部门成员", tags = {"部门成员" },  notes = "根据单位机构部门批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzdepartment_id);
        }
        ibzdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门获取部门成员", tags = {"部门成员" },  notes = "根据单位机构部门获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/{ibzdeptmember_id}")
    public ResponseEntity<IBZDeptMemberDTO> getByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
        IBZDeptMember domain = ibzdeptmemberService.get(ibzdeptmember_id);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门检查部门成员", tags = {"部门成员" },  notes = "根据单位机构部门检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.checkKey(ibzdeptmemberMapping.toDomain(ibzdeptmemberdto)));
    }

    @ApiOperation(value = "根据单位机构部门删除部门成员", tags = {"部门成员" },  notes = "根据单位机构部门删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<Boolean> removeByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.remove(ibzdeptmember_id));
    }

    @ApiOperation(value = "根据单位机构部门批量删除部门成员", tags = {"部门成员" },  notes = "根据单位机构部门批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZOrganizationIBZDepartment(@RequestBody List<String> ids) {
        ibzdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门建立部门成员", tags = {"部门成员" },  notes = "根据单位机构部门建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers")

    public ResponseEntity<IBZDeptMemberDTO> createByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzdepartment_id);
		ibzdeptmemberService.create(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门批量建立部门成员", tags = {"部门成员" },  notes = "根据单位机构部门批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzdepartment_id);
        }
        ibzdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门获取部门成员草稿", tags = {"部门成员" },  notes = "根据单位机构部门获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/getdraft")
    public ResponseEntity<IBZDeptMemberDTO> getDraftByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id) {
        IBZDeptMember domain = new IBZDeptMember();
        domain.setUserid(ibzdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberMapping.toDto(ibzdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构部门保存部门成员", tags = {"部门成员" },  notes = "根据单位机构部门保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/save")
    public ResponseEntity<Boolean> saveByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据单位机构部门批量保存部门成员", tags = {"部门成员" },  notes = "根据单位机构部门批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
             domain.setUserid(ibzdepartment_id);
        }
        ibzdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据单位机构部门获取DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构部门获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/fetchdefault")
	public ResponseEntity<List<IBZDeptMemberDTO>> fetchIBZDeptMemberDefaultByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id,IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzdepartment_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
        List<IBZDeptMemberDTO> list = ibzdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据单位机构部门查询DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构部门查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzdeptmembers/searchdefault")
	public ResponseEntity<Page<IBZDeptMemberDTO>> searchIBZDeptMemberDefaultByIBZOrganizationIBZDepartment(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @RequestBody IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzdepartment_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构人员更新部门成员", tags = {"部门成员" },  notes = "根据单位机构人员更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<IBZDeptMemberDTO> updateByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
        domain.setMemberid(ibzdeptmember_id);
		ibzdeptmemberService.update(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员批量更新部门成员", tags = {"部门成员" },  notes = "根据单位机构人员批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员获取部门成员", tags = {"部门成员" },  notes = "根据单位机构人员获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")
    public ResponseEntity<IBZDeptMemberDTO> getByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
        IBZDeptMember domain = ibzdeptmemberService.get(ibzdeptmember_id);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员检查部门成员", tags = {"部门成员" },  notes = "根据单位机构人员检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.checkKey(ibzdeptmemberMapping.toDomain(ibzdeptmemberdto)));
    }

    @ApiOperation(value = "根据单位机构人员删除部门成员", tags = {"部门成员" },  notes = "根据单位机构人员删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<Boolean> removeByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.remove(ibzdeptmember_id));
    }

    @ApiOperation(value = "根据单位机构人员批量删除部门成员", tags = {"部门成员" },  notes = "根据单位机构人员批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZOrganizationIBZEmployee(@RequestBody List<String> ids) {
        ibzdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员建立部门成员", tags = {"部门成员" },  notes = "根据单位机构人员建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers")

    public ResponseEntity<IBZDeptMemberDTO> createByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
		ibzdeptmemberService.create(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员批量建立部门成员", tags = {"部门成员" },  notes = "根据单位机构人员批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员获取部门成员草稿", tags = {"部门成员" },  notes = "根据单位机构人员获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/getdraft")
    public ResponseEntity<IBZDeptMemberDTO> getDraftByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZDeptMember domain = new IBZDeptMember();
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberMapping.toDto(ibzdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构人员保存部门成员", tags = {"部门成员" },  notes = "根据单位机构人员保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/save")
    public ResponseEntity<Boolean> saveByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据单位机构人员批量保存部门成员", tags = {"部门成员" },  notes = "根据单位机构人员批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
             domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据单位机构人员获取DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/fetchdefault")
	public ResponseEntity<List<IBZDeptMemberDTO>> fetchIBZDeptMemberDefaultByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id,IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
        List<IBZDeptMemberDTO> list = ibzdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据单位机构人员查询DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/searchdefault")
	public ResponseEntity<Page<IBZDeptMemberDTO>> searchIBZDeptMemberDefaultByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构部门人员更新部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<IBZDeptMemberDTO> updateByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
        domain.setMemberid(ibzdeptmember_id);
		ibzdeptmemberService.update(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员批量更新部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员获取部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")
    public ResponseEntity<IBZDeptMemberDTO> getByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
        IBZDeptMember domain = ibzdeptmemberService.get(ibzdeptmember_id);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员检查部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.checkKey(ibzdeptmemberMapping.toDomain(ibzdeptmemberdto)));
    }

    @ApiOperation(value = "根据单位机构部门人员删除部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/{ibzdeptmember_id}")

    public ResponseEntity<Boolean> removeByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzdeptmember_id") String ibzdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.remove(ibzdeptmember_id));
    }

    @ApiOperation(value = "根据单位机构部门人员批量删除部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZOrganizationIBZDepartmentIBZEmployee(@RequestBody List<String> ids) {
        ibzdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员建立部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers")

    public ResponseEntity<IBZDeptMemberDTO> createByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
		ibzdeptmemberService.create(domain);
        IBZDeptMemberDTO dto = ibzdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员批量建立部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员获取部门成员草稿", tags = {"部门成员" },  notes = "根据单位机构部门人员获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/getdraft")
    public ResponseEntity<IBZDeptMemberDTO> getDraftByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZDeptMember domain = new IBZDeptMember();
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberMapping.toDto(ibzdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构部门人员保存部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/save")
    public ResponseEntity<Boolean> saveByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberDTO ibzdeptmemberdto) {
        IBZDeptMember domain = ibzdeptmemberMapping.toDomain(ibzdeptmemberdto);
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据单位机构部门人员批量保存部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZDeptMemberDTO> ibzdeptmemberdtos) {
        List<IBZDeptMember> domainlist=ibzdeptmemberMapping.toDomain(ibzdeptmemberdtos);
        for(IBZDeptMember domain:domainlist){
             domain.setUserid(ibzemployee_id);
        }
        ibzdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据单位机构部门人员获取DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构部门人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/fetchdefault")
	public ResponseEntity<List<IBZDeptMemberDTO>> fetchIBZDeptMemberDefaultByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id,IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
        List<IBZDeptMemberDTO> list = ibzdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZDeptMember-searchDefault-all')")
	@ApiOperation(value = "根据单位机构部门人员查询DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构部门人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzdeptmembers/searchdefault")
	public ResponseEntity<Page<IBZDeptMemberDTO>> searchIBZDeptMemberDefaultByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZDeptMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZDeptMember> domains = ibzdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

