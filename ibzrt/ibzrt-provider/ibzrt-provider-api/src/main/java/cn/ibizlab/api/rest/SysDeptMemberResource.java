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
import cn.ibizlab.core.ou.domain.SysDeptMember;
import cn.ibizlab.core.ou.service.ISysDeptMemberService;
import cn.ibizlab.core.ou.filter.SysDeptMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"部门成员" })
@RestController("api-sysdeptmember")
@RequestMapping("")
public class SysDeptMemberResource {

    @Autowired
    public ISysDeptMemberService sysdeptmemberService;

    @Autowired
    @Lazy
    public SysDeptMemberMapping sysdeptmemberMapping;

    @ApiOperation(value = "新建部门成员", tags = {"部门成员" },  notes = "新建部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers")
    public ResponseEntity<SysDeptMemberDTO> create(@RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
		sysdeptmemberService.create(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建部门成员", tags = {"部门成员" },  notes = "批量新建部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        sysdeptmemberService.createBatch(sysdeptmemberMapping.toDomain(sysdeptmemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新部门成员", tags = {"部门成员" },  notes = "更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> update(@PathVariable("sysdeptmember_id") String sysdeptmember_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
		SysDeptMember domain  = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain .setMemberid(sysdeptmember_id);
		sysdeptmemberService.update(domain );
		SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新部门成员", tags = {"部门成员" },  notes = "批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        sysdeptmemberService.updateBatch(sysdeptmemberMapping.toDomain(sysdeptmemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "删除部门成员", tags = {"部门成员" },  notes = "删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("sysdeptmember_id") String sysdeptmember_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.remove(sysdeptmember_id));
    }

    @ApiOperation(value = "批量删除部门成员", tags = {"部门成员" },  notes = "批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取部门成员", tags = {"部门成员" },  notes = "获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> get(@PathVariable("sysdeptmember_id") String sysdeptmember_id) {
        SysDeptMember domain = sysdeptmemberService.get(sysdeptmember_id);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取部门成员草稿", tags = {"部门成员" },  notes = "获取部门成员草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sysdeptmembers/getdraft")
    public ResponseEntity<SysDeptMemberDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberMapping.toDto(sysdeptmemberService.getDraft(new SysDeptMember())));
    }

    @ApiOperation(value = "检查部门成员", tags = {"部门成员" },  notes = "检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.checkKey(sysdeptmemberMapping.toDomain(sysdeptmemberdto)));
    }

    @ApiOperation(value = "保存部门成员", tags = {"部门成员" },  notes = "保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers/save")
    public ResponseEntity<Boolean> save(@RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.save(sysdeptmemberMapping.toDomain(sysdeptmemberdto)));
    }

    @ApiOperation(value = "批量保存部门成员", tags = {"部门成员" },  notes = "批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        sysdeptmemberService.saveBatch(sysdeptmemberMapping.toDomain(sysdeptmemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"部门成员" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysdeptmembers/fetchdefault")
	public ResponseEntity<List<SysDeptMemberDTO>> fetchDefault(SysDeptMemberSearchContext context) {
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
        List<SysDeptMemberDTO> list = sysdeptmemberMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"部门成员" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysdeptmembers/searchdefault")
	public ResponseEntity<Page<SysDeptMemberDTO>> searchDefault(@RequestBody SysDeptMemberSearchContext context) {
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据部门建立部门成员", tags = {"部门成员" },  notes = "根据部门建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers")
    public ResponseEntity<SysDeptMemberDTO> createBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysdepartment_id);
		sysdeptmemberService.create(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门批量建立部门成员", tags = {"部门成员" },  notes = "根据部门批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysdepartment_id);
        }
        sysdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门更新部门成员", tags = {"部门成员" },  notes = "根据部门更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> updateBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysdepartment_id);
        domain.setMemberid(sysdeptmember_id);
		sysdeptmemberService.update(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门批量更新部门成员", tags = {"部门成员" },  notes = "根据部门批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysdepartment_id);
        }
        sysdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门删除部门成员", tags = {"部门成员" },  notes = "根据部门删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<Boolean> removeBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.remove(sysdeptmember_id));
    }

    @ApiOperation(value = "根据部门批量删除部门成员", tags = {"部门成员" },  notes = "根据部门批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysDepartment(@RequestBody List<String> ids) {
        sysdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门获取部门成员", tags = {"部门成员" },  notes = "根据部门获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> getBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
        SysDeptMember domain = sysdeptmemberService.get(sysdeptmember_id);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门获取部门成员草稿", tags = {"部门成员" },  notes = "根据部门获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers/getdraft")
    public ResponseEntity<SysDeptMemberDTO> getDraftBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id) {
        SysDeptMember domain = new SysDeptMember();
        domain.setUserid(sysdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberMapping.toDto(sysdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据部门检查部门成员", tags = {"部门成员" },  notes = "根据部门检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.checkKey(sysdeptmemberMapping.toDomain(sysdeptmemberdto)));
    }

    @ApiOperation(value = "根据部门保存部门成员", tags = {"部门成员" },  notes = "根据部门保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers/save")
    public ResponseEntity<Boolean> saveBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据部门批量保存部门成员", tags = {"部门成员" },  notes = "根据部门批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
             domain.setUserid(sysdepartment_id);
        }
        sysdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据部门获取DEFAULT", tags = {"部门成员" } ,notes = "根据部门获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysdepartments/{sysdepartment_id}/sysdeptmembers/fetchdefault")
	public ResponseEntity<List<SysDeptMemberDTO>> fetchSysDeptMemberDefaultBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id,SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysdepartment_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
        List<SysDeptMemberDTO> list = sysdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据部门查询DEFAULT", tags = {"部门成员" } ,notes = "根据部门查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysdepartments/{sysdepartment_id}/sysdeptmembers/searchdefault")
	public ResponseEntity<Page<SysDeptMemberDTO>> searchSysDeptMemberDefaultBySysDepartment(@PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysdepartment_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据人员建立部门成员", tags = {"部门成员" },  notes = "根据人员建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/sysdeptmembers")
    public ResponseEntity<SysDeptMemberDTO> createBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
		sysdeptmemberService.create(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员批量建立部门成员", tags = {"部门成员" },  notes = "根据人员批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员更新部门成员", tags = {"部门成员" },  notes = "根据人员更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> updateBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
        domain.setMemberid(sysdeptmember_id);
		sysdeptmemberService.update(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员批量更新部门成员", tags = {"部门成员" },  notes = "根据人员批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员删除部门成员", tags = {"部门成员" },  notes = "根据人员删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<Boolean> removeBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.remove(sysdeptmember_id));
    }

    @ApiOperation(value = "根据人员批量删除部门成员", tags = {"部门成员" },  notes = "根据人员批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysEmployee(@RequestBody List<String> ids) {
        sysdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员获取部门成员", tags = {"部门成员" },  notes = "根据人员获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> getBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
        SysDeptMember domain = sysdeptmemberService.get(sysdeptmember_id);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员获取部门成员草稿", tags = {"部门成员" },  notes = "根据人员获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysemployees/{sysemployee_id}/sysdeptmembers/getdraft")
    public ResponseEntity<SysDeptMemberDTO> getDraftBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id) {
        SysDeptMember domain = new SysDeptMember();
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberMapping.toDto(sysdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员检查部门成员", tags = {"部门成员" },  notes = "根据人员检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/sysdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.checkKey(sysdeptmemberMapping.toDomain(sysdeptmemberdto)));
    }

    @ApiOperation(value = "根据人员保存部门成员", tags = {"部门成员" },  notes = "根据人员保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/sysdeptmembers/save")
    public ResponseEntity<Boolean> saveBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据人员批量保存部门成员", tags = {"部门成员" },  notes = "根据人员批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/sysdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
             domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据人员获取DEFAULT", tags = {"部门成员" } ,notes = "根据人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysemployees/{sysemployee_id}/sysdeptmembers/fetchdefault")
	public ResponseEntity<List<SysDeptMemberDTO>> fetchSysDeptMemberDefaultBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id,SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
        List<SysDeptMemberDTO> list = sysdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据人员查询DEFAULT", tags = {"部门成员" } ,notes = "根据人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysemployees/{sysemployee_id}/sysdeptmembers/searchdefault")
	public ResponseEntity<Page<SysDeptMemberDTO>> searchSysDeptMemberDefaultBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据部门人员建立部门成员", tags = {"部门成员" },  notes = "根据部门人员建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers")
    public ResponseEntity<SysDeptMemberDTO> createBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
		sysdeptmemberService.create(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员批量建立部门成员", tags = {"部门成员" },  notes = "根据部门人员批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员更新部门成员", tags = {"部门成员" },  notes = "根据部门人员更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> updateBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
        domain.setMemberid(sysdeptmember_id);
		sysdeptmemberService.update(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员批量更新部门成员", tags = {"部门成员" },  notes = "根据部门人员批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员删除部门成员", tags = {"部门成员" },  notes = "根据部门人员删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<Boolean> removeBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.remove(sysdeptmember_id));
    }

    @ApiOperation(value = "根据部门人员批量删除部门成员", tags = {"部门成员" },  notes = "根据部门人员批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysDepartmentSysEmployee(@RequestBody List<String> ids) {
        sysdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员获取部门成员", tags = {"部门成员" },  notes = "根据部门人员获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> getBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
        SysDeptMember domain = sysdeptmemberService.get(sysdeptmember_id);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员获取部门成员草稿", tags = {"部门成员" },  notes = "根据部门人员获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/getdraft")
    public ResponseEntity<SysDeptMemberDTO> getDraftBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id) {
        SysDeptMember domain = new SysDeptMember();
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberMapping.toDto(sysdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据部门人员检查部门成员", tags = {"部门成员" },  notes = "根据部门人员检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.checkKey(sysdeptmemberMapping.toDomain(sysdeptmemberdto)));
    }

    @ApiOperation(value = "根据部门人员保存部门成员", tags = {"部门成员" },  notes = "根据部门人员保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/save")
    public ResponseEntity<Boolean> saveBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据部门人员批量保存部门成员", tags = {"部门成员" },  notes = "根据部门人员批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
             domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据部门人员获取DEFAULT", tags = {"部门成员" } ,notes = "根据部门人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/fetchdefault")
	public ResponseEntity<List<SysDeptMemberDTO>> fetchSysDeptMemberDefaultBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id,SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
        List<SysDeptMemberDTO> list = sysdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据部门人员查询DEFAULT", tags = {"部门成员" } ,notes = "根据部门人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/searchdefault")
	public ResponseEntity<Page<SysDeptMemberDTO>> searchSysDeptMemberDefaultBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构部门建立部门成员", tags = {"部门成员" },  notes = "根据单位机构部门建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers")
    public ResponseEntity<SysDeptMemberDTO> createBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysdepartment_id);
		sysdeptmemberService.create(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门批量建立部门成员", tags = {"部门成员" },  notes = "根据单位机构部门批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysdepartment_id);
        }
        sysdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门更新部门成员", tags = {"部门成员" },  notes = "根据单位机构部门更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> updateBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysdepartment_id);
        domain.setMemberid(sysdeptmember_id);
		sysdeptmemberService.update(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门批量更新部门成员", tags = {"部门成员" },  notes = "根据单位机构部门批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysdepartment_id);
        }
        sysdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门删除部门成员", tags = {"部门成员" },  notes = "根据单位机构部门删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<Boolean> removeBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.remove(sysdeptmember_id));
    }

    @ApiOperation(value = "根据单位机构部门批量删除部门成员", tags = {"部门成员" },  notes = "根据单位机构部门批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysOrganizationSysDepartment(@RequestBody List<String> ids) {
        sysdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门获取部门成员", tags = {"部门成员" },  notes = "根据单位机构部门获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> getBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
        SysDeptMember domain = sysdeptmemberService.get(sysdeptmember_id);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门获取部门成员草稿", tags = {"部门成员" },  notes = "根据单位机构部门获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/getdraft")
    public ResponseEntity<SysDeptMemberDTO> getDraftBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id) {
        SysDeptMember domain = new SysDeptMember();
        domain.setUserid(sysdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberMapping.toDto(sysdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构部门检查部门成员", tags = {"部门成员" },  notes = "根据单位机构部门检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.checkKey(sysdeptmemberMapping.toDomain(sysdeptmemberdto)));
    }

    @ApiOperation(value = "根据单位机构部门保存部门成员", tags = {"部门成员" },  notes = "根据单位机构部门保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/save")
    public ResponseEntity<Boolean> saveBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysdepartment_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据单位机构部门批量保存部门成员", tags = {"部门成员" },  notes = "根据单位机构部门批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
             domain.setUserid(sysdepartment_id);
        }
        sysdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据单位机构部门获取DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构部门获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/fetchdefault")
	public ResponseEntity<List<SysDeptMemberDTO>> fetchSysDeptMemberDefaultBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id,SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysdepartment_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
        List<SysDeptMemberDTO> list = sysdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据单位机构部门查询DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构部门查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysdeptmembers/searchdefault")
	public ResponseEntity<Page<SysDeptMemberDTO>> searchSysDeptMemberDefaultBySysOrganizationSysDepartment(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @RequestBody SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysdepartment_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构人员建立部门成员", tags = {"部门成员" },  notes = "根据单位机构人员建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers")
    public ResponseEntity<SysDeptMemberDTO> createBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
		sysdeptmemberService.create(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员批量建立部门成员", tags = {"部门成员" },  notes = "根据单位机构人员批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员更新部门成员", tags = {"部门成员" },  notes = "根据单位机构人员更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> updateBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
        domain.setMemberid(sysdeptmember_id);
		sysdeptmemberService.update(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员批量更新部门成员", tags = {"部门成员" },  notes = "根据单位机构人员批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员删除部门成员", tags = {"部门成员" },  notes = "根据单位机构人员删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<Boolean> removeBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.remove(sysdeptmember_id));
    }

    @ApiOperation(value = "根据单位机构人员批量删除部门成员", tags = {"部门成员" },  notes = "根据单位机构人员批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysOrganizationSysEmployee(@RequestBody List<String> ids) {
        sysdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员获取部门成员", tags = {"部门成员" },  notes = "根据单位机构人员获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> getBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
        SysDeptMember domain = sysdeptmemberService.get(sysdeptmember_id);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员获取部门成员草稿", tags = {"部门成员" },  notes = "根据单位机构人员获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/getdraft")
    public ResponseEntity<SysDeptMemberDTO> getDraftBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id) {
        SysDeptMember domain = new SysDeptMember();
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberMapping.toDto(sysdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构人员检查部门成员", tags = {"部门成员" },  notes = "根据单位机构人员检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.checkKey(sysdeptmemberMapping.toDomain(sysdeptmemberdto)));
    }

    @ApiOperation(value = "根据单位机构人员保存部门成员", tags = {"部门成员" },  notes = "根据单位机构人员保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/save")
    public ResponseEntity<Boolean> saveBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据单位机构人员批量保存部门成员", tags = {"部门成员" },  notes = "根据单位机构人员批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
             domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据单位机构人员获取DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/fetchdefault")
	public ResponseEntity<List<SysDeptMemberDTO>> fetchSysDeptMemberDefaultBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id,SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
        List<SysDeptMemberDTO> list = sysdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据单位机构人员查询DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/sysdeptmembers/searchdefault")
	public ResponseEntity<Page<SysDeptMemberDTO>> searchSysDeptMemberDefaultBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构部门人员建立部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers")
    public ResponseEntity<SysDeptMemberDTO> createBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
		sysdeptmemberService.create(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员批量建立部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员批量建立部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> createBatchBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员更新部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> updateBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
        domain.setMemberid(sysdeptmember_id);
		sysdeptmemberService.update(domain);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员批量更新部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员批量更新部门成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员删除部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<Boolean> removeBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.remove(sysdeptmember_id));
    }

    @ApiOperation(value = "根据单位机构部门人员批量删除部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员批量删除部门成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysOrganizationSysDepartmentSysEmployee(@RequestBody List<String> ids) {
        sysdeptmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员获取部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员获取部门成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/{sysdeptmember_id}")
    public ResponseEntity<SysDeptMemberDTO> getBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("sysdeptmember_id") String sysdeptmember_id) {
        SysDeptMember domain = sysdeptmemberService.get(sysdeptmember_id);
        SysDeptMemberDTO dto = sysdeptmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员获取部门成员草稿", tags = {"部门成员" },  notes = "根据单位机构部门人员获取部门成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/getdraft")
    public ResponseEntity<SysDeptMemberDTO> getDraftBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id) {
        SysDeptMember domain = new SysDeptMember();
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberMapping.toDto(sysdeptmemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构部门人员检查部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员检查部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.checkKey(sysdeptmemberMapping.toDomain(sysdeptmemberdto)));
    }

    @ApiOperation(value = "根据单位机构部门人员保存部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/save")
    public ResponseEntity<Boolean> saveBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberDTO sysdeptmemberdto) {
        SysDeptMember domain = sysdeptmemberMapping.toDomain(sysdeptmemberdto);
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(sysdeptmemberService.save(domain));
    }

    @ApiOperation(value = "根据单位机构部门人员批量保存部门成员", tags = {"部门成员" },  notes = "根据单位机构部门人员批量保存部门成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysDeptMemberDTO> sysdeptmemberdtos) {
        List<SysDeptMember> domainlist=sysdeptmemberMapping.toDomain(sysdeptmemberdtos);
        for(SysDeptMember domain:domainlist){
             domain.setUserid(sysemployee_id);
        }
        sysdeptmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据单位机构部门人员获取DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构部门人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/fetchdefault")
	public ResponseEntity<List<SysDeptMemberDTO>> fetchSysDeptMemberDefaultBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id,SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
        List<SysDeptMemberDTO> list = sysdeptmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据单位机构部门人员查询DEFAULT", tags = {"部门成员" } ,notes = "根据单位机构部门人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/sysdeptmembers/searchdefault")
	public ResponseEntity<Page<SysDeptMemberDTO>> searchSysDeptMemberDefaultBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysDeptMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysDeptMember> domains = sysdeptmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysdeptmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

