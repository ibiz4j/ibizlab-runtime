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
import cn.ibizlab.core.ou.domain.IBZTeamMember;
import cn.ibizlab.core.ou.service.IIBZTeamMemberService;
import cn.ibizlab.core.ou.filter.IBZTeamMemberSearchContext;

@Slf4j
@Api(tags = {"组成员" })
@RestController("api-ibzteammember")
@RequestMapping("")
public class IBZTeamMemberResource {

    @Autowired
    public IIBZTeamMemberService ibzteammemberService;

    @Autowired
    @Lazy
    public IBZTeamMemberMapping ibzteammemberMapping;

    @ApiOperation(value = "删除组成员", tags = {"组成员" },  notes = "删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<Boolean> remove(@PathVariable("ibzteammember_id") String ibzteammember_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.remove(ibzteammember_id));
    }

    @ApiOperation(value = "批量删除组成员", tags = {"组成员" },  notes = "批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzteammembers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ibzteammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查组成员", tags = {"组成员" },  notes = "检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.checkKey(ibzteammemberMapping.toDomain(ibzteammemberdto)));
    }

    @ApiOperation(value = "获取组成员", tags = {"组成员" },  notes = "获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzteammembers/{ibzteammember_id}")
    public ResponseEntity<IBZTeamMemberDTO> get(@PathVariable("ibzteammember_id") String ibzteammember_id) {
        IBZTeamMember domain = ibzteammemberService.get(ibzteammember_id);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取组成员草稿", tags = {"组成员" },  notes = "获取组成员草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzteammembers/getdraft")
    public ResponseEntity<IBZTeamMemberDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberMapping.toDto(ibzteammemberService.getDraft(new IBZTeamMember())));
    }

    @ApiOperation(value = "新建组成员", tags = {"组成员" },  notes = "新建组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers")

    public ResponseEntity<IBZTeamMemberDTO> create(@RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
		ibzteammemberService.create(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建组成员", tags = {"组成员" },  notes = "批量新建组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        ibzteammemberService.createBatch(ibzteammemberMapping.toDomain(ibzteammemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "保存组成员", tags = {"组成员" },  notes = "保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers/save")
    public ResponseEntity<Boolean> save(@RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.save(ibzteammemberMapping.toDomain(ibzteammemberdto)));
    }

    @ApiOperation(value = "批量保存组成员", tags = {"组成员" },  notes = "批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteammembers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        ibzteammemberService.saveBatch(ibzteammemberMapping.toDomain(ibzteammemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新组成员", tags = {"组成员" },  notes = "更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<IBZTeamMemberDTO> update(@PathVariable("ibzteammember_id") String ibzteammember_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
		IBZTeamMember domain  = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain .setTeammemberid(ibzteammember_id);
		ibzteammemberService.update(domain );
		IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新组成员", tags = {"组成员" },  notes = "批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzteammembers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        ibzteammemberService.updateBatch(ibzteammemberMapping.toDomain(ibzteammemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"组成员" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzteammembers/fetchdefault")
	public ResponseEntity<List<IBZTeamMemberDTO>> fetchDefault(IBZTeamMemberSearchContext context) {
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
        List<IBZTeamMemberDTO> list = ibzteammemberMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"组成员" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzteammembers/searchdefault")
	public ResponseEntity<Page<IBZTeamMemberDTO>> searchDefault(@RequestBody IBZTeamMemberSearchContext context) {
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzteammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据人员删除组成员", tags = {"组成员" },  notes = "根据人员删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<Boolean> removeByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.remove(ibzteammember_id));
    }

    @ApiOperation(value = "根据人员批量删除组成员", tags = {"组成员" },  notes = "根据人员批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZEmployee(@RequestBody List<String> ids) {
        ibzteammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员检查组成员", tags = {"组成员" },  notes = "根据人员检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.checkKey(ibzteammemberMapping.toDomain(ibzteammemberdto)));
    }

    @ApiOperation(value = "根据人员获取组成员", tags = {"组成员" },  notes = "根据人员获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")
    public ResponseEntity<IBZTeamMemberDTO> getByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id) {
        IBZTeamMember domain = ibzteammemberService.get(ibzteammember_id);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员获取组成员草稿", tags = {"组成员" },  notes = "根据人员获取组成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers/getdraft")
    public ResponseEntity<IBZTeamMemberDTO> getDraftByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZTeamMember domain = new IBZTeamMember();
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberMapping.toDto(ibzteammemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员建立组成员", tags = {"组成员" },  notes = "根据人员建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers")

    public ResponseEntity<IBZTeamMemberDTO> createByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
		ibzteammemberService.create(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员批量建立组成员", tags = {"组成员" },  notes = "根据人员批量建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员保存组成员", tags = {"组成员" },  notes = "根据人员保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers/save")
    public ResponseEntity<Boolean> saveByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.save(domain));
    }

    @ApiOperation(value = "根据人员批量保存组成员", tags = {"组成员" },  notes = "根据人员批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
             domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员更新组成员", tags = {"组成员" },  notes = "根据人员更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<IBZTeamMemberDTO> updateByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
        domain.setTeammemberid(ibzteammember_id);
		ibzteammemberService.update(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员批量更新组成员", tags = {"组成员" },  notes = "根据人员批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "根据人员获取DEFAULT", tags = {"组成员" } ,notes = "根据人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzemployees/{ibzemployee_id}/ibzteammembers/fetchdefault")
	public ResponseEntity<List<IBZTeamMemberDTO>> fetchIBZTeamMemberDefaultByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id,IBZTeamMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
        List<IBZTeamMemberDTO> list = ibzteammemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "根据人员查询DEFAULT", tags = {"组成员" } ,notes = "根据人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzemployees/{ibzemployee_id}/ibzteammembers/searchdefault")
	public ResponseEntity<Page<IBZTeamMemberDTO>> searchIBZTeamMemberDefaultByIBZEmployee(@PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzteammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据组删除组成员", tags = {"组成员" },  notes = "根据组删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzteams/{ibzteam_id}/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<Boolean> removeByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id, @PathVariable("ibzteammember_id") String ibzteammember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.remove(ibzteammember_id));
    }

    @ApiOperation(value = "根据组批量删除组成员", tags = {"组成员" },  notes = "根据组批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzteams/{ibzteam_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZTeam(@RequestBody List<String> ids) {
        ibzteammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组检查组成员", tags = {"组成员" },  notes = "根据组检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteams/{ibzteam_id}/ibzteammembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.checkKey(ibzteammemberMapping.toDomain(ibzteammemberdto)));
    }

    @ApiOperation(value = "根据组获取组成员", tags = {"组成员" },  notes = "根据组获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzteams/{ibzteam_id}/ibzteammembers/{ibzteammember_id}")
    public ResponseEntity<IBZTeamMemberDTO> getByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id, @PathVariable("ibzteammember_id") String ibzteammember_id) {
        IBZTeamMember domain = ibzteammemberService.get(ibzteammember_id);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组获取组成员草稿", tags = {"组成员" },  notes = "根据组获取组成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzteams/{ibzteam_id}/ibzteammembers/getdraft")
    public ResponseEntity<IBZTeamMemberDTO> getDraftByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id) {
        IBZTeamMember domain = new IBZTeamMember();
        domain.setTeamid(ibzteam_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberMapping.toDto(ibzteammemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据组建立组成员", tags = {"组成员" },  notes = "根据组建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteams/{ibzteam_id}/ibzteammembers")

    public ResponseEntity<IBZTeamMemberDTO> createByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setTeamid(ibzteam_id);
		ibzteammemberService.create(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组批量建立组成员", tags = {"组成员" },  notes = "根据组批量建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteams/{ibzteam_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
            domain.setTeamid(ibzteam_id);
        }
        ibzteammemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组保存组成员", tags = {"组成员" },  notes = "根据组保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteams/{ibzteam_id}/ibzteammembers/save")
    public ResponseEntity<Boolean> saveByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setTeamid(ibzteam_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.save(domain));
    }

    @ApiOperation(value = "根据组批量保存组成员", tags = {"组成员" },  notes = "根据组批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteams/{ibzteam_id}/ibzteammembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
             domain.setTeamid(ibzteam_id);
        }
        ibzteammemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组更新组成员", tags = {"组成员" },  notes = "根据组更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzteams/{ibzteam_id}/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<IBZTeamMemberDTO> updateByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id, @PathVariable("ibzteammember_id") String ibzteammember_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setTeamid(ibzteam_id);
        domain.setTeammemberid(ibzteammember_id);
		ibzteammemberService.update(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据组批量更新组成员", tags = {"组成员" },  notes = "根据组批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzteams/{ibzteam_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
            domain.setTeamid(ibzteam_id);
        }
        ibzteammemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "根据组获取DEFAULT", tags = {"组成员" } ,notes = "根据组获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzteams/{ibzteam_id}/ibzteammembers/fetchdefault")
	public ResponseEntity<List<IBZTeamMemberDTO>> fetchIBZTeamMemberDefaultByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id,IBZTeamMemberSearchContext context) {
        context.setN_teamid_eq(ibzteam_id);
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
        List<IBZTeamMemberDTO> list = ibzteammemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "根据组查询DEFAULT", tags = {"组成员" } ,notes = "根据组查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzteams/{ibzteam_id}/ibzteammembers/searchdefault")
	public ResponseEntity<Page<IBZTeamMemberDTO>> searchIBZTeamMemberDefaultByIBZTeam(@PathVariable("ibzteam_id") String ibzteam_id, @RequestBody IBZTeamMemberSearchContext context) {
        context.setN_teamid_eq(ibzteam_id);
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzteammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据部门人员删除组成员", tags = {"组成员" },  notes = "根据部门人员删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<Boolean> removeByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.remove(ibzteammember_id));
    }

    @ApiOperation(value = "根据部门人员批量删除组成员", tags = {"组成员" },  notes = "根据部门人员批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZDepartmentIBZEmployee(@RequestBody List<String> ids) {
        ibzteammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员检查组成员", tags = {"组成员" },  notes = "根据部门人员检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.checkKey(ibzteammemberMapping.toDomain(ibzteammemberdto)));
    }

    @ApiOperation(value = "根据部门人员获取组成员", tags = {"组成员" },  notes = "根据部门人员获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")
    public ResponseEntity<IBZTeamMemberDTO> getByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id) {
        IBZTeamMember domain = ibzteammemberService.get(ibzteammember_id);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员获取组成员草稿", tags = {"组成员" },  notes = "根据部门人员获取组成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/getdraft")
    public ResponseEntity<IBZTeamMemberDTO> getDraftByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZTeamMember domain = new IBZTeamMember();
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberMapping.toDto(ibzteammemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据部门人员建立组成员", tags = {"组成员" },  notes = "根据部门人员建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers")

    public ResponseEntity<IBZTeamMemberDTO> createByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
		ibzteammemberService.create(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员批量建立组成员", tags = {"组成员" },  notes = "根据部门人员批量建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员保存组成员", tags = {"组成员" },  notes = "根据部门人员保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/save")
    public ResponseEntity<Boolean> saveByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.save(domain));
    }

    @ApiOperation(value = "根据部门人员批量保存组成员", tags = {"组成员" },  notes = "根据部门人员批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
             domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门人员更新组成员", tags = {"组成员" },  notes = "根据部门人员更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<IBZTeamMemberDTO> updateByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
        domain.setTeammemberid(ibzteammember_id);
		ibzteammemberService.update(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据部门人员批量更新组成员", tags = {"组成员" },  notes = "根据部门人员批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "根据部门人员获取DEFAULT", tags = {"组成员" } ,notes = "根据部门人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/fetchdefault")
	public ResponseEntity<List<IBZTeamMemberDTO>> fetchIBZTeamMemberDefaultByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id,IBZTeamMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
        List<IBZTeamMemberDTO> list = ibzteammemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "根据部门人员查询DEFAULT", tags = {"组成员" } ,notes = "根据部门人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/searchdefault")
	public ResponseEntity<Page<IBZTeamMemberDTO>> searchIBZTeamMemberDefaultByIBZDepartmentIBZEmployee(@PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzteammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构人员删除组成员", tags = {"组成员" },  notes = "根据单位机构人员删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<Boolean> removeByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.remove(ibzteammember_id));
    }

    @ApiOperation(value = "根据单位机构人员批量删除组成员", tags = {"组成员" },  notes = "根据单位机构人员批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZOrganizationIBZEmployee(@RequestBody List<String> ids) {
        ibzteammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员检查组成员", tags = {"组成员" },  notes = "根据单位机构人员检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.checkKey(ibzteammemberMapping.toDomain(ibzteammemberdto)));
    }

    @ApiOperation(value = "根据单位机构人员获取组成员", tags = {"组成员" },  notes = "根据单位机构人员获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")
    public ResponseEntity<IBZTeamMemberDTO> getByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id) {
        IBZTeamMember domain = ibzteammemberService.get(ibzteammember_id);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员获取组成员草稿", tags = {"组成员" },  notes = "根据单位机构人员获取组成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/getdraft")
    public ResponseEntity<IBZTeamMemberDTO> getDraftByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZTeamMember domain = new IBZTeamMember();
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberMapping.toDto(ibzteammemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构人员建立组成员", tags = {"组成员" },  notes = "根据单位机构人员建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers")

    public ResponseEntity<IBZTeamMemberDTO> createByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
		ibzteammemberService.create(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员批量建立组成员", tags = {"组成员" },  notes = "根据单位机构人员批量建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员保存组成员", tags = {"组成员" },  notes = "根据单位机构人员保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/save")
    public ResponseEntity<Boolean> saveByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.save(domain));
    }

    @ApiOperation(value = "根据单位机构人员批量保存组成员", tags = {"组成员" },  notes = "根据单位机构人员批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
             domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构人员更新组成员", tags = {"组成员" },  notes = "根据单位机构人员更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<IBZTeamMemberDTO> updateByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
        domain.setTeammemberid(ibzteammember_id);
		ibzteammemberService.update(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构人员批量更新组成员", tags = {"组成员" },  notes = "根据单位机构人员批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "根据单位机构人员获取DEFAULT", tags = {"组成员" } ,notes = "根据单位机构人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/fetchdefault")
	public ResponseEntity<List<IBZTeamMemberDTO>> fetchIBZTeamMemberDefaultByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id,IBZTeamMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
        List<IBZTeamMemberDTO> list = ibzteammemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "根据单位机构人员查询DEFAULT", tags = {"组成员" } ,notes = "根据单位机构人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/{ibzorganization_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/searchdefault")
	public ResponseEntity<Page<IBZTeamMemberDTO>> searchIBZTeamMemberDefaultByIBZOrganizationIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzteammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据单位机构部门人员删除组成员", tags = {"组成员" },  notes = "根据单位机构部门人员删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<Boolean> removeByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.remove(ibzteammember_id));
    }

    @ApiOperation(value = "根据单位机构部门人员批量删除组成员", tags = {"组成员" },  notes = "根据单位机构部门人员批量删除组成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> removeBatchByIBZOrganizationIBZDepartmentIBZEmployee(@RequestBody List<String> ids) {
        ibzteammemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员检查组成员", tags = {"组成员" },  notes = "根据单位机构部门人员检查组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.checkKey(ibzteammemberMapping.toDomain(ibzteammemberdto)));
    }

    @ApiOperation(value = "根据单位机构部门人员获取组成员", tags = {"组成员" },  notes = "根据单位机构部门人员获取组成员")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")
    public ResponseEntity<IBZTeamMemberDTO> getByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id) {
        IBZTeamMember domain = ibzteammemberService.get(ibzteammember_id);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员获取组成员草稿", tags = {"组成员" },  notes = "根据单位机构部门人员获取组成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/getdraft")
    public ResponseEntity<IBZTeamMemberDTO> getDraftByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id) {
        IBZTeamMember domain = new IBZTeamMember();
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberMapping.toDto(ibzteammemberService.getDraft(domain)));
    }

    @ApiOperation(value = "根据单位机构部门人员建立组成员", tags = {"组成员" },  notes = "根据单位机构部门人员建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers")

    public ResponseEntity<IBZTeamMemberDTO> createByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
		ibzteammemberService.create(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员批量建立组成员", tags = {"组成员" },  notes = "根据单位机构部门人员批量建立组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> createBatchByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员保存组成员", tags = {"组成员" },  notes = "根据单位机构部门人员保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/save")
    public ResponseEntity<Boolean> saveByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
        return ResponseEntity.status(HttpStatus.OK).body(ibzteammemberService.save(domain));
    }

    @ApiOperation(value = "根据单位机构部门人员批量保存组成员", tags = {"组成员" },  notes = "根据单位机构部门人员批量保存组成员")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
             domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据单位机构部门人员更新组成员", tags = {"组成员" },  notes = "根据单位机构部门人员更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/{ibzteammember_id}")

    public ResponseEntity<IBZTeamMemberDTO> updateByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @PathVariable("ibzteammember_id") String ibzteammember_id, @RequestBody IBZTeamMemberDTO ibzteammemberdto) {
        IBZTeamMember domain = ibzteammemberMapping.toDomain(ibzteammemberdto);
        domain.setUserid(ibzemployee_id);
        domain.setTeammemberid(ibzteammember_id);
		ibzteammemberService.update(domain);
        IBZTeamMemberDTO dto = ibzteammemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据单位机构部门人员批量更新组成员", tags = {"组成员" },  notes = "根据单位机构部门人员批量更新组成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/batch")
    public ResponseEntity<Boolean> updateBatchByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody List<IBZTeamMemberDTO> ibzteammemberdtos) {
        List<IBZTeamMember> domainlist=ibzteammemberMapping.toDomain(ibzteammemberdtos);
        for(IBZTeamMember domain:domainlist){
            domain.setUserid(ibzemployee_id);
        }
        ibzteammemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "根据单位机构部门人员获取DEFAULT", tags = {"组成员" } ,notes = "根据单位机构部门人员获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/fetchdefault")
	public ResponseEntity<List<IBZTeamMemberDTO>> fetchIBZTeamMemberDefaultByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id,IBZTeamMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
        List<IBZTeamMemberDTO> list = ibzteammemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZTeamMember-searchDefault-all')")
	@ApiOperation(value = "根据单位机构部门人员查询DEFAULT", tags = {"组成员" } ,notes = "根据单位机构部门人员查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzorganizations/{ibzorganization_id}/ibzdepartments/{ibzdepartment_id}/ibzemployees/{ibzemployee_id}/ibzteammembers/searchdefault")
	public ResponseEntity<Page<IBZTeamMemberDTO>> searchIBZTeamMemberDefaultByIBZOrganizationIBZDepartmentIBZEmployee(@PathVariable("ibzorganization_id") String ibzorganization_id, @PathVariable("ibzdepartment_id") String ibzdepartment_id, @PathVariable("ibzemployee_id") String ibzemployee_id, @RequestBody IBZTeamMemberSearchContext context) {
        context.setN_userid_eq(ibzemployee_id);
        Page<IBZTeamMember> domains = ibzteammemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzteammemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

