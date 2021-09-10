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
import cn.ibizlab.core.notify.domain.MsgOpenAccess;
import cn.ibizlab.core.notify.service.IMsgOpenAccessService;
import cn.ibizlab.core.notify.filter.MsgOpenAccessSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"接入开放平台" })
@RestController("api-msgopenaccess")
@RequestMapping("")
public class MsgOpenAccessResource {

    @Autowired
    public IMsgOpenAccessService msgopenaccessService;

    @Autowired
    @Lazy
    public MsgOpenAccessMapping msgopenaccessMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-Create-all')")
    @ApiOperation(value = "新建接入开放平台", tags = {"接入开放平台" },  notes = "新建接入开放平台")
	@RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses")
    public ResponseEntity<MsgOpenAccessDTO> create(@Validated @RequestBody MsgOpenAccessDTO msgopenaccessdto) {
        MsgOpenAccess domain = msgopenaccessMapping.toDomain(msgopenaccessdto);
		msgopenaccessService.create(domain);
        MsgOpenAccessDTO dto = msgopenaccessMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-Create-all')")
    @ApiOperation(value = "批量新建接入开放平台", tags = {"接入开放平台" },  notes = "批量新建接入开放平台")
	@RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MsgOpenAccessDTO> msgopenaccessdtos) {
        msgopenaccessService.createBatch(msgopenaccessMapping.toDomain(msgopenaccessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-Get-all')")
    @ApiOperation(value = "获取接入开放平台", tags = {"接入开放平台" },  notes = "获取接入开放平台")
	@RequestMapping(method = RequestMethod.GET, value = "/msgopenaccesses/{msgopenaccess_id}")
    public ResponseEntity<MsgOpenAccessDTO> get(@PathVariable("msgopenaccess_id") String msgopenaccess_id) {
        MsgOpenAccess domain = msgopenaccessService.get(msgopenaccess_id);
        MsgOpenAccessDTO dto = msgopenaccessMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-Remove-all')")
    @ApiOperation(value = "删除接入开放平台", tags = {"接入开放平台" },  notes = "删除接入开放平台")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgopenaccesses/{msgopenaccess_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("msgopenaccess_id") String msgopenaccess_id) {
         return ResponseEntity.status(HttpStatus.OK).body(msgopenaccessService.remove(msgopenaccess_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-Remove-all')")
    @ApiOperation(value = "批量删除接入开放平台", tags = {"接入开放平台" },  notes = "批量删除接入开放平台")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgopenaccesses/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        msgopenaccessService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-Update-all')")
    @ApiOperation(value = "更新接入开放平台", tags = {"接入开放平台" },  notes = "更新接入开放平台")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgopenaccesses/{msgopenaccess_id}")
    public ResponseEntity<MsgOpenAccessDTO> update(@PathVariable("msgopenaccess_id") String msgopenaccess_id, @RequestBody MsgOpenAccessDTO msgopenaccessdto) {
		MsgOpenAccess domain  = msgopenaccessMapping.toDomain(msgopenaccessdto);
        domain .setId(msgopenaccess_id);
		msgopenaccessService.update(domain );
		MsgOpenAccessDTO dto = msgopenaccessMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-Update-all')")
    @ApiOperation(value = "批量更新接入开放平台", tags = {"接入开放平台" },  notes = "批量更新接入开放平台")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgopenaccesses/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MsgOpenAccessDTO> msgopenaccessdtos) {
        msgopenaccessService.updateBatch(msgopenaccessMapping.toDomain(msgopenaccessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查接入开放平台", tags = {"接入开放平台" },  notes = "检查接入开放平台")
	@RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody MsgOpenAccessDTO msgopenaccessdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(msgopenaccessService.checkKey(msgopenaccessMapping.toDomain(msgopenaccessdto)));
    }

    @ApiOperation(value = "获取接入开放平台草稿", tags = {"接入开放平台" },  notes = "获取接入开放平台草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/msgopenaccesses/getdraft")
    public ResponseEntity<MsgOpenAccessDTO> getDraft(MsgOpenAccessDTO dto) {
        MsgOpenAccess domain = msgopenaccessMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(msgopenaccessMapping.toDto(msgopenaccessService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-Save-all')")
    @ApiOperation(value = "保存接入开放平台", tags = {"接入开放平台" },  notes = "保存接入开放平台")
	@RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses/save")
    public ResponseEntity<MsgOpenAccessDTO> save(@RequestBody MsgOpenAccessDTO msgopenaccessdto) {
        MsgOpenAccess domain = msgopenaccessMapping.toDomain(msgopenaccessdto);
        msgopenaccessService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(msgopenaccessMapping.toDto(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-Save-all')")
    @ApiOperation(value = "批量保存接入开放平台", tags = {"接入开放平台" },  notes = "批量保存接入开放平台")
	@RequestMapping(method = RequestMethod.POST, value = "/msgopenaccesses/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MsgOpenAccessDTO> msgopenaccessdtos) {
        msgopenaccessService.saveBatch(msgopenaccessMapping.toDomain(msgopenaccessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"接入开放平台" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/msgopenaccesses/fetchdefault")
	public ResponseEntity<List<MsgOpenAccessDTO>> fetchDefault(MsgOpenAccessSearchContext context) {
        Page<MsgOpenAccess> domains = msgopenaccessService.searchDefault(context) ;
        List<MsgOpenAccessDTO> list = msgopenaccessMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgOpenAccess-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"接入开放平台" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/msgopenaccesses/searchdefault")
	public ResponseEntity<Page<MsgOpenAccessDTO>> searchDefault(@RequestBody MsgOpenAccessSearchContext context) {
        Page<MsgOpenAccess> domains = msgopenaccessService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(msgopenaccessMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

