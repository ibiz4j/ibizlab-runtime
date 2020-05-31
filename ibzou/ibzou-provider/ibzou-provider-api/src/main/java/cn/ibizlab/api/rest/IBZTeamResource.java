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
import cn.ibizlab.core.ou.domain.IBZTeam;
import cn.ibizlab.core.ou.service.IIBZTeamService;
import cn.ibizlab.core.ou.filter.IBZTeamSearchContext;

@Slf4j
@Api(tags = {"组" })
@RestController("api-ibzteam")
@RequestMapping("")
public class IBZTeamResource {

    @Autowired
    public IIBZTeamService ibzteamService;

    @Autowired
    @Lazy
    public IBZTeamMapping ibzteamMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Update-all')")
    @ApiOperation(value = "更新组", tags = {"组" },  notes = "更新组")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzteams/{ibzteam_id}")
    @Transactional
    public ResponseEntity<IBZTeamDTO> update(@PathVariable("ibzteam_id") String ibzteam_id, @RequestBody IBZTeamDTO ibzteamdto) {
		IBZTeam domain  = ibzteamMapping.toDomain(ibzteamdto);
        domain .setTeamid(ibzteam_id);
		ibzteamService.update(domain );
		IBZTeamDTO dto = ibzteamMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Update-all')")
    @ApiOperation(value = "批量更新组", tags = {"组" },  notes = "批量更新组")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzteams/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<IBZTeamDTO> ibzteamdtos) {
        ibzteamService.updateBatch(ibzteamMapping.toDomain(ibzteamdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Remove-all')")
    @ApiOperation(value = "删除组", tags = {"组" },  notes = "删除组")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzteams/{ibzteam_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ibzteam_id") String ibzteam_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ibzteamService.remove(ibzteam_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Remove-all')")
    @ApiOperation(value = "批量删除组", tags = {"组" },  notes = "批量删除组")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzteams/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ibzteamService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Get-all')")
    @ApiOperation(value = "获取组", tags = {"组" },  notes = "获取组")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzteams/{ibzteam_id}")
    public ResponseEntity<IBZTeamDTO> get(@PathVariable("ibzteam_id") String ibzteam_id) {
        IBZTeam domain = ibzteamService.get(ibzteam_id);
        IBZTeamDTO dto = ibzteamMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Save-all')")
    @ApiOperation(value = "保存组", tags = {"组" },  notes = "保存组")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteams/save")
    public ResponseEntity<Boolean> save(@RequestBody IBZTeamDTO ibzteamdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ibzteamService.save(ibzteamMapping.toDomain(ibzteamdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Save-all')")
    @ApiOperation(value = "批量保存组", tags = {"组" },  notes = "批量保存组")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteams/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<IBZTeamDTO> ibzteamdtos) {
        ibzteamService.saveBatch(ibzteamMapping.toDomain(ibzteamdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取组草稿", tags = {"组" },  notes = "获取组草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzteams/getdraft")
    public ResponseEntity<IBZTeamDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ibzteamMapping.toDto(ibzteamService.getDraft(new IBZTeam())));
    }

    @ApiOperation(value = "检查组", tags = {"组" },  notes = "检查组")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteams/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody IBZTeamDTO ibzteamdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzteamService.checkKey(ibzteamMapping.toDomain(ibzteamdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Create-all')")
    @ApiOperation(value = "新建组", tags = {"组" },  notes = "新建组")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteams")
    @Transactional
    public ResponseEntity<IBZTeamDTO> create(@RequestBody IBZTeamDTO ibzteamdto) {
        IBZTeam domain = ibzteamMapping.toDomain(ibzteamdto);
		ibzteamService.create(domain);
        IBZTeamDTO dto = ibzteamMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Create-all')")
    @ApiOperation(value = "批量新建组", tags = {"组" },  notes = "批量新建组")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzteams/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<IBZTeamDTO> ibzteamdtos) {
        ibzteamService.createBatch(ibzteamMapping.toDomain(ibzteamdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"组" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzteams/fetchdefault")
	public ResponseEntity<List<IBZTeamDTO>> fetchDefault(IBZTeamSearchContext context) {
        Page<IBZTeam> domains = ibzteamService.searchDefault(context) ;
        List<IBZTeamDTO> list = ibzteamMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzou-IBZTeam-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"组" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzteams/searchdefault")
	public ResponseEntity<Page<IBZTeamDTO>> searchDefault(@RequestBody IBZTeamSearchContext context) {
        Page<IBZTeam> domains = ibzteamService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzteamMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

