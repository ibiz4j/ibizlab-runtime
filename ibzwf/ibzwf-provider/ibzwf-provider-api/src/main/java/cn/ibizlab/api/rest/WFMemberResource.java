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
import cn.ibizlab.core.workflow.domain.WFMember;
import cn.ibizlab.core.workflow.service.IWFMemberService;
import cn.ibizlab.core.workflow.filter.WFMemberSearchContext;

@Slf4j
@Api(tags = {"成员" })
@RestController("api-wfmember")
@RequestMapping("")
public class WFMemberResource {

    @Autowired
    public IWFMemberService wfmemberService;

    @Autowired
    @Lazy
    public WFMemberMapping wfmemberMapping;

    @ApiOperation(value = "检查成员", tags = {"成员" },  notes = "检查成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfmembers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFMemberDTO wfmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfmemberService.checkKey(wfmemberMapping.toDomain(wfmemberdto)));
    }

    @ApiOperation(value = "获取成员草稿", tags = {"成员" },  notes = "获取成员草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wfmembers/getdraft")
    public ResponseEntity<WFMemberDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfmemberMapping.toDto(wfmemberService.getDraft(new WFMember())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Create-all')")
    @ApiOperation(value = "新建成员", tags = {"成员" },  notes = "新建成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfmembers")
    @Transactional
    public ResponseEntity<WFMemberDTO> create(@RequestBody WFMemberDTO wfmemberdto) {
        WFMember domain = wfmemberMapping.toDomain(wfmemberdto);
		wfmemberService.create(domain);
        WFMemberDTO dto = wfmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Create-all')")
    @ApiOperation(value = "批量新建成员", tags = {"成员" },  notes = "批量新建成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfmembers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFMemberDTO> wfmemberdtos) {
        wfmemberService.createBatch(wfmemberMapping.toDomain(wfmemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Remove-all')")
    @ApiOperation(value = "删除成员", tags = {"成员" },  notes = "删除成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfmembers/{wfmember_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfmember_id") String wfmember_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfmemberService.remove(wfmember_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Remove-all')")
    @ApiOperation(value = "批量删除成员", tags = {"成员" },  notes = "批量删除成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfmembers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Save-all')")
    @ApiOperation(value = "保存成员", tags = {"成员" },  notes = "保存成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfmembers/save")
    public ResponseEntity<Boolean> save(@RequestBody WFMemberDTO wfmemberdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfmemberService.save(wfmemberMapping.toDomain(wfmemberdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Save-all')")
    @ApiOperation(value = "批量保存成员", tags = {"成员" },  notes = "批量保存成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfmembers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFMemberDTO> wfmemberdtos) {
        wfmemberService.saveBatch(wfmemberMapping.toDomain(wfmemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Update-all')")
    @ApiOperation(value = "更新成员", tags = {"成员" },  notes = "更新成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfmembers/{wfmember_id}")
    @Transactional
    public ResponseEntity<WFMemberDTO> update(@PathVariable("wfmember_id") String wfmember_id, @RequestBody WFMemberDTO wfmemberdto) {
		WFMember domain  = wfmemberMapping.toDomain(wfmemberdto);
        domain .setMemberid(wfmember_id);
		wfmemberService.update(domain );
		WFMemberDTO dto = wfmemberMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Update-all')")
    @ApiOperation(value = "批量更新成员", tags = {"成员" },  notes = "批量更新成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfmembers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFMemberDTO> wfmemberdtos) {
        wfmemberService.updateBatch(wfmemberMapping.toDomain(wfmemberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Get-all')")
    @ApiOperation(value = "获取成员", tags = {"成员" },  notes = "获取成员")
	@RequestMapping(method = RequestMethod.GET, value = "/wfmembers/{wfmember_id}")
    public ResponseEntity<WFMemberDTO> get(@PathVariable("wfmember_id") String wfmember_id) {
        WFMember domain = wfmemberService.get(wfmember_id);
        WFMemberDTO dto = wfmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"成员" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfmembers/fetchdefault")
	public ResponseEntity<List<WFMemberDTO>> fetchDefault(WFMemberSearchContext context) {
        Page<WFMember> domains = wfmemberService.searchDefault(context) ;
        List<WFMemberDTO> list = wfmemberMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"成员" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfmembers/searchdefault")
	public ResponseEntity<Page<WFMemberDTO>> searchDefault(@RequestBody WFMemberSearchContext context) {
        Page<WFMember> domains = wfmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据角色/用户组检查成员", tags = {"成员" },  notes = "根据角色/用户组检查成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfgroups/{wfgroup_id}/wfmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id, @RequestBody WFMemberDTO wfmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfmemberService.checkKey(wfmemberMapping.toDomain(wfmemberdto)));
    }

    @ApiOperation(value = "根据角色/用户组获取成员草稿", tags = {"成员" },  notes = "根据角色/用户组获取成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/wfgroups/{wfgroup_id}/wfmembers/getdraft")
    public ResponseEntity<WFMemberDTO> getDraftByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id) {
        WFMember domain = new WFMember();
        domain.setGroupid(wfgroup_id);
        return ResponseEntity.status(HttpStatus.OK).body(wfmemberMapping.toDto(wfmemberService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Create-all')")
    @ApiOperation(value = "根据角色/用户组建立成员", tags = {"成员" },  notes = "根据角色/用户组建立成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfgroups/{wfgroup_id}/wfmembers")
    @Transactional
    public ResponseEntity<WFMemberDTO> createByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id, @RequestBody WFMemberDTO wfmemberdto) {
        WFMember domain = wfmemberMapping.toDomain(wfmemberdto);
        domain.setGroupid(wfgroup_id);
		wfmemberService.create(domain);
        WFMemberDTO dto = wfmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Create-all')")
    @ApiOperation(value = "根据角色/用户组批量建立成员", tags = {"成员" },  notes = "根据角色/用户组批量建立成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfgroups/{wfgroup_id}/wfmembers/batch")
    public ResponseEntity<Boolean> createBatchByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id, @RequestBody List<WFMemberDTO> wfmemberdtos) {
        List<WFMember> domainlist=wfmemberMapping.toDomain(wfmemberdtos);
        for(WFMember domain:domainlist){
            domain.setGroupid(wfgroup_id);
        }
        wfmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Remove-all')")
    @ApiOperation(value = "根据角色/用户组删除成员", tags = {"成员" },  notes = "根据角色/用户组删除成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfgroups/{wfgroup_id}/wfmembers/{wfmember_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id, @PathVariable("wfmember_id") String wfmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(wfmemberService.remove(wfmember_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Remove-all')")
    @ApiOperation(value = "根据角色/用户组批量删除成员", tags = {"成员" },  notes = "根据角色/用户组批量删除成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfgroups/{wfgroup_id}/wfmembers/batch")
    public ResponseEntity<Boolean> removeBatchByWFGroup(@RequestBody List<String> ids) {
        wfmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Save-all')")
    @ApiOperation(value = "根据角色/用户组保存成员", tags = {"成员" },  notes = "根据角色/用户组保存成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfgroups/{wfgroup_id}/wfmembers/save")
    public ResponseEntity<Boolean> saveByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id, @RequestBody WFMemberDTO wfmemberdto) {
        WFMember domain = wfmemberMapping.toDomain(wfmemberdto);
        domain.setGroupid(wfgroup_id);
        return ResponseEntity.status(HttpStatus.OK).body(wfmemberService.save(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Save-all')")
    @ApiOperation(value = "根据角色/用户组批量保存成员", tags = {"成员" },  notes = "根据角色/用户组批量保存成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfgroups/{wfgroup_id}/wfmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id, @RequestBody List<WFMemberDTO> wfmemberdtos) {
        List<WFMember> domainlist=wfmemberMapping.toDomain(wfmemberdtos);
        for(WFMember domain:domainlist){
             domain.setGroupid(wfgroup_id);
        }
        wfmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Update-all')")
    @ApiOperation(value = "根据角色/用户组更新成员", tags = {"成员" },  notes = "根据角色/用户组更新成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfgroups/{wfgroup_id}/wfmembers/{wfmember_id}")
    @Transactional
    public ResponseEntity<WFMemberDTO> updateByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id, @PathVariable("wfmember_id") String wfmember_id, @RequestBody WFMemberDTO wfmemberdto) {
        WFMember domain = wfmemberMapping.toDomain(wfmemberdto);
        domain.setGroupid(wfgroup_id);
        domain.setMemberid(wfmember_id);
		wfmemberService.update(domain);
        WFMemberDTO dto = wfmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Update-all')")
    @ApiOperation(value = "根据角色/用户组批量更新成员", tags = {"成员" },  notes = "根据角色/用户组批量更新成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfgroups/{wfgroup_id}/wfmembers/batch")
    public ResponseEntity<Boolean> updateBatchByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id, @RequestBody List<WFMemberDTO> wfmemberdtos) {
        List<WFMember> domainlist=wfmemberMapping.toDomain(wfmemberdtos);
        for(WFMember domain:domainlist){
            domain.setGroupid(wfgroup_id);
        }
        wfmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Get-all')")
    @ApiOperation(value = "根据角色/用户组获取成员", tags = {"成员" },  notes = "根据角色/用户组获取成员")
	@RequestMapping(method = RequestMethod.GET, value = "/wfgroups/{wfgroup_id}/wfmembers/{wfmember_id}")
    public ResponseEntity<WFMemberDTO> getByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id, @PathVariable("wfmember_id") String wfmember_id) {
        WFMember domain = wfmemberService.get(wfmember_id);
        WFMemberDTO dto = wfmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Default-all')")
	@ApiOperation(value = "根据角色/用户组获取DEFAULT", tags = {"成员" } ,notes = "根据角色/用户组获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfgroups/{wfgroup_id}/wfmembers/fetchdefault")
	public ResponseEntity<List<WFMemberDTO>> fetchWFMemberDefaultByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id,WFMemberSearchContext context) {
        context.setN_groupid_eq(wfgroup_id);
        Page<WFMember> domains = wfmemberService.searchDefault(context) ;
        List<WFMemberDTO> list = wfmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Default-all')")
	@ApiOperation(value = "根据角色/用户组查询DEFAULT", tags = {"成员" } ,notes = "根据角色/用户组查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfgroups/{wfgroup_id}/wfmembers/searchdefault")
	public ResponseEntity<Page<WFMemberDTO>> searchWFMemberDefaultByWFGroup(@PathVariable("wfgroup_id") String wfgroup_id, @RequestBody WFMemberSearchContext context) {
        context.setN_groupid_eq(wfgroup_id);
        Page<WFMember> domains = wfmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据用户检查成员", tags = {"成员" },  notes = "根据用户检查成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/{wfuser_id}/wfmembers/checkkey")
    public ResponseEntity<Boolean> checkKeyByWFUser(@PathVariable("wfuser_id") String wfuser_id, @RequestBody WFMemberDTO wfmemberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfmemberService.checkKey(wfmemberMapping.toDomain(wfmemberdto)));
    }

    @ApiOperation(value = "根据用户获取成员草稿", tags = {"成员" },  notes = "根据用户获取成员草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/wfusers/{wfuser_id}/wfmembers/getdraft")
    public ResponseEntity<WFMemberDTO> getDraftByWFUser(@PathVariable("wfuser_id") String wfuser_id) {
        WFMember domain = new WFMember();
        domain.setUserid(wfuser_id);
        return ResponseEntity.status(HttpStatus.OK).body(wfmemberMapping.toDto(wfmemberService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Create-all')")
    @ApiOperation(value = "根据用户建立成员", tags = {"成员" },  notes = "根据用户建立成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/{wfuser_id}/wfmembers")
    @Transactional
    public ResponseEntity<WFMemberDTO> createByWFUser(@PathVariable("wfuser_id") String wfuser_id, @RequestBody WFMemberDTO wfmemberdto) {
        WFMember domain = wfmemberMapping.toDomain(wfmemberdto);
        domain.setUserid(wfuser_id);
		wfmemberService.create(domain);
        WFMemberDTO dto = wfmemberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Create-all')")
    @ApiOperation(value = "根据用户批量建立成员", tags = {"成员" },  notes = "根据用户批量建立成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/{wfuser_id}/wfmembers/batch")
    public ResponseEntity<Boolean> createBatchByWFUser(@PathVariable("wfuser_id") String wfuser_id, @RequestBody List<WFMemberDTO> wfmemberdtos) {
        List<WFMember> domainlist=wfmemberMapping.toDomain(wfmemberdtos);
        for(WFMember domain:domainlist){
            domain.setUserid(wfuser_id);
        }
        wfmemberService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Remove-all')")
    @ApiOperation(value = "根据用户删除成员", tags = {"成员" },  notes = "根据用户删除成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusers/{wfuser_id}/wfmembers/{wfmember_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByWFUser(@PathVariable("wfuser_id") String wfuser_id, @PathVariable("wfmember_id") String wfmember_id) {
		return ResponseEntity.status(HttpStatus.OK).body(wfmemberService.remove(wfmember_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Remove-all')")
    @ApiOperation(value = "根据用户批量删除成员", tags = {"成员" },  notes = "根据用户批量删除成员")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusers/{wfuser_id}/wfmembers/batch")
    public ResponseEntity<Boolean> removeBatchByWFUser(@RequestBody List<String> ids) {
        wfmemberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Save-all')")
    @ApiOperation(value = "根据用户保存成员", tags = {"成员" },  notes = "根据用户保存成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/{wfuser_id}/wfmembers/save")
    public ResponseEntity<Boolean> saveByWFUser(@PathVariable("wfuser_id") String wfuser_id, @RequestBody WFMemberDTO wfmemberdto) {
        WFMember domain = wfmemberMapping.toDomain(wfmemberdto);
        domain.setUserid(wfuser_id);
        return ResponseEntity.status(HttpStatus.OK).body(wfmemberService.save(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Save-all')")
    @ApiOperation(value = "根据用户批量保存成员", tags = {"成员" },  notes = "根据用户批量保存成员")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/{wfuser_id}/wfmembers/savebatch")
    public ResponseEntity<Boolean> saveBatchByWFUser(@PathVariable("wfuser_id") String wfuser_id, @RequestBody List<WFMemberDTO> wfmemberdtos) {
        List<WFMember> domainlist=wfmemberMapping.toDomain(wfmemberdtos);
        for(WFMember domain:domainlist){
             domain.setUserid(wfuser_id);
        }
        wfmemberService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Update-all')")
    @ApiOperation(value = "根据用户更新成员", tags = {"成员" },  notes = "根据用户更新成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusers/{wfuser_id}/wfmembers/{wfmember_id}")
    @Transactional
    public ResponseEntity<WFMemberDTO> updateByWFUser(@PathVariable("wfuser_id") String wfuser_id, @PathVariable("wfmember_id") String wfmember_id, @RequestBody WFMemberDTO wfmemberdto) {
        WFMember domain = wfmemberMapping.toDomain(wfmemberdto);
        domain.setUserid(wfuser_id);
        domain.setMemberid(wfmember_id);
		wfmemberService.update(domain);
        WFMemberDTO dto = wfmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Update-all')")
    @ApiOperation(value = "根据用户批量更新成员", tags = {"成员" },  notes = "根据用户批量更新成员")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusers/{wfuser_id}/wfmembers/batch")
    public ResponseEntity<Boolean> updateBatchByWFUser(@PathVariable("wfuser_id") String wfuser_id, @RequestBody List<WFMemberDTO> wfmemberdtos) {
        List<WFMember> domainlist=wfmemberMapping.toDomain(wfmemberdtos);
        for(WFMember domain:domainlist){
            domain.setUserid(wfuser_id);
        }
        wfmemberService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Get-all')")
    @ApiOperation(value = "根据用户获取成员", tags = {"成员" },  notes = "根据用户获取成员")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusers/{wfuser_id}/wfmembers/{wfmember_id}")
    public ResponseEntity<WFMemberDTO> getByWFUser(@PathVariable("wfuser_id") String wfuser_id, @PathVariable("wfmember_id") String wfmember_id) {
        WFMember domain = wfmemberService.get(wfmember_id);
        WFMemberDTO dto = wfmemberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Default-all')")
	@ApiOperation(value = "根据用户获取DEFAULT", tags = {"成员" } ,notes = "根据用户获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfusers/{wfuser_id}/wfmembers/fetchdefault")
	public ResponseEntity<List<WFMemberDTO>> fetchWFMemberDefaultByWFUser(@PathVariable("wfuser_id") String wfuser_id,WFMemberSearchContext context) {
        context.setN_userid_eq(wfuser_id);
        Page<WFMember> domains = wfmemberService.searchDefault(context) ;
        List<WFMemberDTO> list = wfmemberMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzwf-WFMember-Default-all')")
	@ApiOperation(value = "根据用户查询DEFAULT", tags = {"成员" } ,notes = "根据用户查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfusers/{wfuser_id}/wfmembers/searchdefault")
	public ResponseEntity<Page<WFMemberDTO>> searchWFMemberDefaultByWFUser(@PathVariable("wfuser_id") String wfuser_id, @RequestBody WFMemberSearchContext context) {
        context.setN_userid_eq(wfuser_id);
        Page<WFMember> domains = wfmemberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfmemberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

