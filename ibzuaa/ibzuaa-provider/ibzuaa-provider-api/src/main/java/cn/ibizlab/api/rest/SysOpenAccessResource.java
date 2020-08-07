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
import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.service.ISysOpenAccessService;
import cn.ibizlab.core.uaa.filter.SysOpenAccessSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"第三方认证平台" })
@RestController("api-sysopenaccess")
@RequestMapping("")
public class SysOpenAccessResource {

    @Autowired
    public ISysOpenAccessService sysopenaccessService;

    @Autowired
    @Lazy
    public SysOpenAccessMapping sysopenaccessMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-Create-all')")
    @ApiOperation(value = "新建第三方认证平台", tags = {"第三方认证平台" },  notes = "新建第三方认证平台")
	@RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses")
    @Transactional
    public ResponseEntity<SysOpenAccessDTO> create(@RequestBody SysOpenAccessDTO sysopenaccessdto) {
        SysOpenAccess domain = sysopenaccessMapping.toDomain(sysopenaccessdto);
		sysopenaccessService.create(domain);
        SysOpenAccessDTO dto = sysopenaccessMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-Create-all')")
    @ApiOperation(value = "批量新建第三方认证平台", tags = {"第三方认证平台" },  notes = "批量新建第三方认证平台")
	@RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysOpenAccessDTO> sysopenaccessdtos) {
        sysopenaccessService.createBatch(sysopenaccessMapping.toDomain(sysopenaccessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-Update-all')")
    @ApiOperation(value = "更新第三方认证平台", tags = {"第三方认证平台" },  notes = "更新第三方认证平台")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysopenaccesses/{sysopenaccess_id}")
    @Transactional
    public ResponseEntity<SysOpenAccessDTO> update(@PathVariable("sysopenaccess_id") String sysopenaccess_id, @RequestBody SysOpenAccessDTO sysopenaccessdto) {
		SysOpenAccess domain  = sysopenaccessMapping.toDomain(sysopenaccessdto);
        domain .setId(sysopenaccess_id);
		sysopenaccessService.update(domain );
		SysOpenAccessDTO dto = sysopenaccessMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-Update-all')")
    @ApiOperation(value = "批量更新第三方认证平台", tags = {"第三方认证平台" },  notes = "批量更新第三方认证平台")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysopenaccesses/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysOpenAccessDTO> sysopenaccessdtos) {
        sysopenaccessService.updateBatch(sysopenaccessMapping.toDomain(sysopenaccessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-Remove-all')")
    @ApiOperation(value = "删除第三方认证平台", tags = {"第三方认证平台" },  notes = "删除第三方认证平台")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysopenaccesses/{sysopenaccess_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("sysopenaccess_id") String sysopenaccess_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysopenaccessService.remove(sysopenaccess_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-Remove-all')")
    @ApiOperation(value = "批量删除第三方认证平台", tags = {"第三方认证平台" },  notes = "批量删除第三方认证平台")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysopenaccesses/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysopenaccessService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-Get-all')")
    @ApiOperation(value = "获取第三方认证平台", tags = {"第三方认证平台" },  notes = "获取第三方认证平台")
	@RequestMapping(method = RequestMethod.GET, value = "/sysopenaccesses/{sysopenaccess_id}")
    public ResponseEntity<SysOpenAccessDTO> get(@PathVariable("sysopenaccess_id") String sysopenaccess_id) {
        SysOpenAccess domain = sysopenaccessService.get(sysopenaccess_id);
        SysOpenAccessDTO dto = sysopenaccessMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取第三方认证平台草稿", tags = {"第三方认证平台" },  notes = "获取第三方认证平台草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sysopenaccesses/getdraft")
    public ResponseEntity<SysOpenAccessDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sysopenaccessMapping.toDto(sysopenaccessService.getDraft(new SysOpenAccess())));
    }

    @ApiOperation(value = "检查第三方认证平台", tags = {"第三方认证平台" },  notes = "检查第三方认证平台")
	@RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysOpenAccessDTO sysopenaccessdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysopenaccessService.checkKey(sysopenaccessMapping.toDomain(sysopenaccessdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-Save-all')")
    @ApiOperation(value = "保存第三方认证平台", tags = {"第三方认证平台" },  notes = "保存第三方认证平台")
	@RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses/save")
    public ResponseEntity<Boolean> save(@RequestBody SysOpenAccessDTO sysopenaccessdto) {
        return ResponseEntity.status(HttpStatus.OK).body(sysopenaccessService.save(sysopenaccessMapping.toDomain(sysopenaccessdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-Save-all')")
    @ApiOperation(value = "批量保存第三方认证平台", tags = {"第三方认证平台" },  notes = "批量保存第三方认证平台")
	@RequestMapping(method = RequestMethod.POST, value = "/sysopenaccesses/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysOpenAccessDTO> sysopenaccessdtos) {
        sysopenaccessService.saveBatch(sysopenaccessMapping.toDomain(sysopenaccessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"第三方认证平台" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysopenaccesses/fetchdefault")
	public ResponseEntity<List<SysOpenAccessDTO>> fetchDefault(SysOpenAccessSearchContext context) {
        Page<SysOpenAccess> domains = sysopenaccessService.searchDefault(context) ;
        List<SysOpenAccessDTO> list = sysopenaccessMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysOpenAccess-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"第三方认证平台" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysopenaccesses/searchdefault")
	public ResponseEntity<Page<SysOpenAccessDTO>> searchDefault(@RequestBody SysOpenAccessSearchContext context) {
        Page<SysOpenAccess> domains = sysopenaccessService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysopenaccessMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

