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
import cn.ibizlab.core.ou.domain.SysTeamMember;
import cn.ibizlab.core.ou.service.ISysTeamMemberService;
import cn.ibizlab.core.ou.filter.SysTeamMemberSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"组成员" })
@RestController("api-systeammember")
@RequestMapping("")
public class SysTeamMemberResource {

    @Autowired
    public ISysTeamMemberService systeammemberService;

    @Autowired
    @Lazy
    public SysTeamMemberMapping systeammemberMapping;

    @ApiOperation(value = "新建组成员", tags = {"组成员" },  notes = "新建组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/systeammembers")
    public ResponseEntity<SysTeamMemberDTO> create(@Validated @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
		systeammemberService.create(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建组成员", tags = {"组成员" },  notes = "批量新建组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/systeammembers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        systeammemberService.createBatch(systeammemberMapping.toDomain(systeammemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新组成员", tags = {"组成员" },  notes = "更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> update(@PathVariable("systeammember_id") String systeammember_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
		SysTeamMember domain  = systeammemberMapping.toDomain(systeammemberdto);
        domain .setTeammemberid(systeammember_id);
		systeammemberService.update(domain );
		SysTeamMemberDTO dto = systeammemberMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新组成员", tags = {"组成员" },  notes = "批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/systeammembers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        systeammemberService.updateBatch(systeammemberMapping.toDomain(systeammemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "删除组成员", tags = {"组成员" },  notes = "删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/systeammembers/{systeammember_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("systeammember_id") String systeammember_id) {
         return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.remove(systeammember_id));
    }

    @ApiOperation(value = "批量删除组成员", tags = {"组成员" },  notes = "批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/systeammembers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        systeammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取组成员", tags = {"组成员" },  notes = "获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> get(@PathVariable("systeammember_id") String systeammember_id) {
        SysTeamMember domain = systeammemberService.get(systeammember_id);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取组成员草稿", tags = {"组成员" },  notes = "获取组成员草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/systeammembers/getdraft")
    public ResponseEntity<SysTeamMemberDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberMapping.toDto(systeammemberService.getDraft(new SysTeamMember())));
    }

    @ApiOperation(value = "检查组成员", tags = {"组成员" },  notes = "检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/systeammembers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysTeamMemberDTO systeammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(systeammemberService.checkKey(systeammemberMapping.toDomain(systeammemberdto)));
    }

    @ApiOperation(value = "保存组成员", tags = {"组成员" },  notes = "保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/systeammembers/save")
    public ResponseEntity<Boolean> save(@RequestBody SysTeamMemberDTO systeammemberdto) {
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.save(systeammemberMapping.toDomain(systeammemberdto)));
    }

    @ApiOperation(value = "批量保存组成员", tags = {"组成员" },  notes = "批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/systeammembers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        systeammemberService.saveBatch(systeammemberMapping.toDomain(systeammemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"组成员" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/systeammembers/fetchdefault")
	public ResponseEntity<List<SysTeamMemberDTO>> fetchDefault(SysTeamMemberSearchContext context) {
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
        List<SysTeamMemberDTO> list = systeammemberMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"组成员" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/systeammembers/searchdefault")
	public ResponseEntity<Page<SysTeamMemberDTO>> searchDefault(@RequestBody SysTeamMemberSearchContext context) {
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(systeammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    @ApiOperation(value = "根据人员建立组成员", tags = {"组成员" },  notes = "根据人员建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/systeammembers")
    public ResponseEntity<SysTeamMemberDTO> createBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
		systeammemberService.create(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员批量建立组成员", tags = {"组成员" },  notes = "根据人员批量建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> createBatchBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        systeammemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员更新组成员", tags = {"组成员" },  notes = "根据人员更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> updateBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
        domain.setTeammemberid(systeammember_id);
		systeammemberService.update(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员批量更新组成员", tags = {"组成员" },  notes = "根据人员批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        systeammemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员删除组成员", tags = {"组成员" },  notes = "根据人员删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<Boolean> removeBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.remove(systeammember_id));
    }

    @ApiOperation(value = "根据人员批量删除组成员", tags = {"组成员" },  notes = "根据人员批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysEmployee(@RequestBody List<String> ids) {
        systeammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员获取组成员", tags = {"组成员" },  notes = "根据人员获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> getBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id) {
        SysTeamMember domain = systeammemberService.get(systeammember_id);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员获取组成员草稿", tags = {"组成员" },  notes = "根据人员获取组成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysemployees/{sysemployee_id}/systeammembers/getdraft")
    public ResponseEntity<SysTeamMemberDTO> getDraftBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id) {
        SysTeamMember domain = new SysTeamMember();
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberMapping.toDto(systeammemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员检查组成员", tags = {"组成员" },  notes = "根据人员检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/systeammembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(systeammemberService.checkKey(systeammemberMapping.toDomain(systeammemberdto)));
    }

    @ApiOperation(value = "根据人员保存组成员", tags = {"组成员" },  notes = "根据人员保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/systeammembers/save")
    public ResponseEntity<Boolean> saveBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.save(domain));
    }

    @ApiOperation(value = "根据人员批量保存组成员", tags = {"组成员" },  notes = "根据人员批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysemployees/{sysemployee_id}/systeammembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
             domain.setUserid(sysemployee_id);
        }
        systeammemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据人员获取DEFAULT", tags = {"组成员" } ,notes = "根据人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysemployees/{sysemployee_id}/systeammembers/fetchdefault")
	public ResponseEntity<List<SysTeamMemberDTO>> fetchSysTeamMemberDefaultBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id,SysTeamMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
        List<SysTeamMemberDTO> list = systeammemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据人员查询DEFAULT", tags = {"组成员" } ,notes = "根据人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysemployees/{sysemployee_id}/systeammembers/searchdefault")
	public ResponseEntity<Page<SysTeamMemberDTO>> searchSysTeamMemberDefaultBySysEmployee(@PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(systeammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据组建立组成员", tags = {"组成员" },  notes = "根据组建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/systeams/{systeam_id}/systeammembers")
    public ResponseEntity<SysTeamMemberDTO> createBySysTeam(@PathVariable("systeam_id") String systeam_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setTeamid(systeam_id);
		systeammemberService.create(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组批量建立组成员", tags = {"组成员" },  notes = "根据组批量建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/systeams/{systeam_id}/systeammembers/batch")
    public ResponseEntity<Boolean> createBatchBySysTeam(@PathVariable("systeam_id") String systeam_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
            domain.setTeamid(systeam_id);
        }
        systeammemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组更新组成员", tags = {"组成员" },  notes = "根据组更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/systeams/{systeam_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> updateBySysTeam(@PathVariable("systeam_id") String systeam_id, @PathVariable("systeammember_id") String systeammember_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setTeamid(systeam_id);
        domain.setTeammemberid(systeammember_id);
		systeammemberService.update(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组批量更新组成员", tags = {"组成员" },  notes = "根据组批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/systeams/{systeam_id}/systeammembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysTeam(@PathVariable("systeam_id") String systeam_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
            domain.setTeamid(systeam_id);
        }
        systeammemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组删除组成员", tags = {"组成员" },  notes = "根据组删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/systeams/{systeam_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<Boolean> removeBySysTeam(@PathVariable("systeam_id") String systeam_id, @PathVariable("systeammember_id") String systeammember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.remove(systeammember_id));
    }

    @ApiOperation(value = "根据组批量删除组成员", tags = {"组成员" },  notes = "根据组批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/systeams/{systeam_id}/systeammembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysTeam(@RequestBody List<String> ids) {
        systeammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组获取组成员", tags = {"组成员" },  notes = "根据组获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/systeams/{systeam_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> getBySysTeam(@PathVariable("systeam_id") String systeam_id, @PathVariable("systeammember_id") String systeammember_id) {
        SysTeamMember domain = systeammemberService.get(systeammember_id);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组获取组成员草稿", tags = {"组成员" },  notes = "根据组获取组成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/systeams/{systeam_id}/systeammembers/getdraft")
    public ResponseEntity<SysTeamMemberDTO> getDraftBySysTeam(@PathVariable("systeam_id") String systeam_id) {
        SysTeamMember domain = new SysTeamMember();
        domain.setTeamid(systeam_id);
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberMapping.toDto(systeammemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据组检查组成员", tags = {"组成员" },  notes = "根据组检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/systeams/{systeam_id}/systeammembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysTeam(@PathVariable("systeam_id") String systeam_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(systeammemberService.checkKey(systeammemberMapping.toDomain(systeammemberdto)));
    }

    @ApiOperation(value = "根据组保存组成员", tags = {"组成员" },  notes = "根据组保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/systeams/{systeam_id}/systeammembers/save")
    public ResponseEntity<Boolean> saveBySysTeam(@PathVariable("systeam_id") String systeam_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setTeamid(systeam_id);
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.save(domain));
    }

    @ApiOperation(value = "根据组批量保存组成员", tags = {"组成员" },  notes = "根据组批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/systeams/{systeam_id}/systeammembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysTeam(@PathVariable("systeam_id") String systeam_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
             domain.setTeamid(systeam_id);
        }
        systeammemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据组获取DEFAULT", tags = {"组成员" } ,notes = "根据组获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/systeams/{systeam_id}/systeammembers/fetchdefault")
	public ResponseEntity<List<SysTeamMemberDTO>> fetchSysTeamMemberDefaultBySysTeam(@PathVariable("systeam_id") String systeam_id,SysTeamMemberSearchContext context) {
        context.setN_teamid_eq(systeam_id);
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
        List<SysTeamMemberDTO> list = systeammemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据组查询DEFAULT", tags = {"组成员" } ,notes = "根据组查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/systeams/{systeam_id}/systeammembers/searchdefault")
	public ResponseEntity<Page<SysTeamMemberDTO>> searchSysTeamMemberDefaultBySysTeam(@PathVariable("systeam_id") String systeam_id, @RequestBody SysTeamMemberSearchContext context) {
        context.setN_teamid_eq(systeam_id);
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(systeammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据部门人员建立组成员", tags = {"组成员" },  notes = "根据部门人员建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers")
    public ResponseEntity<SysTeamMemberDTO> createBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
		systeammemberService.create(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员批量建立组成员", tags = {"组成员" },  notes = "根据部门人员批量建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> createBatchBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        systeammemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员更新组成员", tags = {"组成员" },  notes = "根据部门人员更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> updateBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
        domain.setTeammemberid(systeammember_id);
		systeammemberService.update(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员批量更新组成员", tags = {"组成员" },  notes = "根据部门人员批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        systeammemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员删除组成员", tags = {"组成员" },  notes = "根据部门人员删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<Boolean> removeBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.remove(systeammember_id));
    }

    @ApiOperation(value = "根据部门人员批量删除组成员", tags = {"组成员" },  notes = "根据部门人员批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysDepartmentSysEmployee(@RequestBody List<String> ids) {
        systeammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员获取组成员", tags = {"组成员" },  notes = "根据部门人员获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> getBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id) {
        SysTeamMember domain = systeammemberService.get(systeammember_id);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员获取组成员草稿", tags = {"组成员" },  notes = "根据部门人员获取组成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/getdraft")
    public ResponseEntity<SysTeamMemberDTO> getDraftBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id) {
        SysTeamMember domain = new SysTeamMember();
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberMapping.toDto(systeammemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据部门人员检查组成员", tags = {"组成员" },  notes = "根据部门人员检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(systeammemberService.checkKey(systeammemberMapping.toDomain(systeammemberdto)));
    }

    @ApiOperation(value = "根据部门人员保存组成员", tags = {"组成员" },  notes = "根据部门人员保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/save")
    public ResponseEntity<Boolean> saveBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.save(domain));
    }

    @ApiOperation(value = "根据部门人员批量保存组成员", tags = {"组成员" },  notes = "根据部门人员批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
             domain.setUserid(sysemployee_id);
        }
        systeammemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据部门人员获取DEFAULT", tags = {"组成员" } ,notes = "根据部门人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/fetchdefault")
	public ResponseEntity<List<SysTeamMemberDTO>> fetchSysTeamMemberDefaultBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id,SysTeamMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
        List<SysTeamMemberDTO> list = systeammemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据部门人员查询DEFAULT", tags = {"组成员" } ,notes = "根据部门人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/searchdefault")
	public ResponseEntity<Page<SysTeamMemberDTO>> searchSysTeamMemberDefaultBySysDepartmentSysEmployee(@PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(systeammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构人员建立组成员", tags = {"组成员" },  notes = "根据单位机构人员建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers")
    public ResponseEntity<SysTeamMemberDTO> createBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
		systeammemberService.create(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员批量建立组成员", tags = {"组成员" },  notes = "根据单位机构人员批量建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> createBatchBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        systeammemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员更新组成员", tags = {"组成员" },  notes = "根据单位机构人员更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> updateBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
        domain.setTeammemberid(systeammember_id);
		systeammemberService.update(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员批量更新组成员", tags = {"组成员" },  notes = "根据单位机构人员批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        systeammemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员删除组成员", tags = {"组成员" },  notes = "根据单位机构人员删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<Boolean> removeBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.remove(systeammember_id));
    }

    @ApiOperation(value = "根据单位机构人员批量删除组成员", tags = {"组成员" },  notes = "根据单位机构人员批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysOrganizationSysEmployee(@RequestBody List<String> ids) {
        systeammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员获取组成员", tags = {"组成员" },  notes = "根据单位机构人员获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> getBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id) {
        SysTeamMember domain = systeammemberService.get(systeammember_id);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员获取组成员草稿", tags = {"组成员" },  notes = "根据单位机构人员获取组成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/getdraft")
    public ResponseEntity<SysTeamMemberDTO> getDraftBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id) {
        SysTeamMember domain = new SysTeamMember();
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberMapping.toDto(systeammemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构人员检查组成员", tags = {"组成员" },  notes = "根据单位机构人员检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(systeammemberService.checkKey(systeammemberMapping.toDomain(systeammemberdto)));
    }

    @ApiOperation(value = "根据单位机构人员保存组成员", tags = {"组成员" },  notes = "根据单位机构人员保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/save")
    public ResponseEntity<Boolean> saveBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.save(domain));
    }

    @ApiOperation(value = "根据单位机构人员批量保存组成员", tags = {"组成员" },  notes = "根据单位机构人员批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
             domain.setUserid(sysemployee_id);
        }
        systeammemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据单位机构人员获取DEFAULT", tags = {"组成员" } ,notes = "根据单位机构人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/fetchdefault")
	public ResponseEntity<List<SysTeamMemberDTO>> fetchSysTeamMemberDefaultBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id,SysTeamMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
        List<SysTeamMemberDTO> list = systeammemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据单位机构人员查询DEFAULT", tags = {"组成员" } ,notes = "根据单位机构人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysorganizations/{sysorganization_id}/sysemployees/{sysemployee_id}/systeammembers/searchdefault")
	public ResponseEntity<Page<SysTeamMemberDTO>> searchSysTeamMemberDefaultBySysOrganizationSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(systeammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构部门人员建立组成员", tags = {"组成员" },  notes = "根据单位机构部门人员建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers")
    public ResponseEntity<SysTeamMemberDTO> createBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
		systeammemberService.create(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员批量建立组成员", tags = {"组成员" },  notes = "根据单位机构部门人员批量建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> createBatchBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        systeammemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员更新组成员", tags = {"组成员" },  notes = "根据单位机构部门人员更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> updateBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
        domain.setTeammemberid(systeammember_id);
		systeammemberService.update(domain);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员批量更新组成员", tags = {"组成员" },  notes = "根据单位机构部门人员批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> updateBatchBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
            domain.setUserid(sysemployee_id);
        }
        systeammemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员删除组成员", tags = {"组成员" },  notes = "根据单位机构部门人员删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<Boolean> removeBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.remove(systeammember_id));
    }

    @ApiOperation(value = "根据单位机构部门人员批量删除组成员", tags = {"组成员" },  notes = "根据单位机构部门人员批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/batch")
    public ResponseEntity<Boolean> removeBatchBySysOrganizationSysDepartmentSysEmployee(@RequestBody List<String> ids) {
        systeammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员获取组成员", tags = {"组成员" },  notes = "根据单位机构部门人员获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/{systeammember_id}")
    public ResponseEntity<SysTeamMemberDTO> getBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @PathVariable("systeammember_id") String systeammember_id) {
        SysTeamMember domain = systeammemberService.get(systeammember_id);
        SysTeamMemberDTO dto = systeammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员获取组成员草稿", tags = {"组成员" },  notes = "根据单位机构部门人员获取组成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/getdraft")
    public ResponseEntity<SysTeamMemberDTO> getDraftBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id) {
        SysTeamMember domain = new SysTeamMember();
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberMapping.toDto(systeammemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构部门人员检查组成员", tags = {"组成员" },  notes = "根据单位机构部门人员检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/checkkey")
    public ResponseEntity<Boolean> checkKeyBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(systeammemberService.checkKey(systeammemberMapping.toDomain(systeammemberdto)));
    }

    @ApiOperation(value = "根据单位机构部门人员保存组成员", tags = {"组成员" },  notes = "根据单位机构部门人员保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/save")
    public ResponseEntity<Boolean> saveBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberDTO systeammemberdto) {
        SysTeamMember domain = systeammemberMapping.toDomain(systeammemberdto);
        domain.setUserid(sysemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(systeammemberService.save(domain));
    }

    @ApiOperation(value = "根据单位机构部门人员批量保存组成员", tags = {"组成员" },  notes = "根据单位机构部门人员批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/savebatch")
    public ResponseEntity<Boolean> saveBatchBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody List<SysTeamMemberDTO> systeammemberdtos) {
        List<SysTeamMember> domainlist=systeammemberMapping.toDomain(systeammemberdtos);
        for(SysTeamMember domain:domainlist){
             domain.setUserid(sysemployee_id);
        }
        systeammemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "根据单位机构部门人员获取DEFAULT", tags = {"组成员" } ,notes = "根据单位机构部门人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/fetchdefault")
	public ResponseEntity<List<SysTeamMemberDTO>> fetchSysTeamMemberDefaultBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id,SysTeamMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
        List<SysTeamMemberDTO> list = systeammemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "根据单位机构部门人员查询DEFAULT", tags = {"组成员" } ,notes = "根据单位机构部门人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysorganizations/{sysorganization_id}/sysdepartments/{sysdepartment_id}/sysemployees/{sysemployee_id}/systeammembers/searchdefault")
	public ResponseEntity<Page<SysTeamMemberDTO>> searchSysTeamMemberDefaultBySysOrganizationSysDepartmentSysEmployee(@PathVariable("sysorganization_id") String sysorganization_id, @PathVariable("sysdepartment_id") String sysdepartment_id, @PathVariable("sysemployee_id") String sysemployee_id, @RequestBody SysTeamMemberSearchContext context) {
        context.setN_userid_eq(sysemployee_id);
        Page<SysTeamMember> domains = systeammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(systeammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

