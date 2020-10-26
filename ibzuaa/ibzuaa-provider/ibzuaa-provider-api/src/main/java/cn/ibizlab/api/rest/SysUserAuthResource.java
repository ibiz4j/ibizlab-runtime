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
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;
import cn.ibizlab.core.uaa.filter.SysUserAuthSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"账号绑定" })
@RestController("api-sysuserauth")
@RequestMapping("")
public class SysUserAuthResource {

    @Autowired
    public ISysUserAuthService sysuserauthService;

    @Autowired
    @Lazy
    public SysUserAuthMapping sysuserauthMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-Create-all')")
    @ApiOperation(value = "新建账号绑定", tags = {"账号绑定" },  notes = "新建账号绑定")
	@RequestMapping(method = RequestMethod.POST, value = "/sysuserauths")
    public ResponseEntity<SysUserAuthDTO> create(@Validated @RequestBody SysUserAuthDTO sysuserauthdto) {
        SysUserAuth domain = sysuserauthMapping.toDomain(sysuserauthdto);
		sysuserauthService.create(domain);
        SysUserAuthDTO dto = sysuserauthMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-Create-all')")
    @ApiOperation(value = "批量新建账号绑定", tags = {"账号绑定" },  notes = "批量新建账号绑定")
	@RequestMapping(method = RequestMethod.POST, value = "/sysuserauths/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysUserAuthDTO> sysuserauthdtos) {
        sysuserauthService.createBatch(sysuserauthMapping.toDomain(sysuserauthdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-Update-all')")
    @ApiOperation(value = "更新账号绑定", tags = {"账号绑定" },  notes = "更新账号绑定")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysuserauths/{sysuserauth_id}")
    public ResponseEntity<SysUserAuthDTO> update(@PathVariable("sysuserauth_id") String sysuserauth_id, @RequestBody SysUserAuthDTO sysuserauthdto) {
		SysUserAuth domain  = sysuserauthMapping.toDomain(sysuserauthdto);
        domain .setId(sysuserauth_id);
		sysuserauthService.update(domain );
		SysUserAuthDTO dto = sysuserauthMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-Update-all')")
    @ApiOperation(value = "批量更新账号绑定", tags = {"账号绑定" },  notes = "批量更新账号绑定")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysuserauths/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysUserAuthDTO> sysuserauthdtos) {
        sysuserauthService.updateBatch(sysuserauthMapping.toDomain(sysuserauthdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-Remove-all')")
    @ApiOperation(value = "删除账号绑定", tags = {"账号绑定" },  notes = "删除账号绑定")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysuserauths/{sysuserauth_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("sysuserauth_id") String sysuserauth_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysuserauthService.remove(sysuserauth_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-Remove-all')")
    @ApiOperation(value = "批量删除账号绑定", tags = {"账号绑定" },  notes = "批量删除账号绑定")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysuserauths/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysuserauthService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-Get-all')")
    @ApiOperation(value = "获取账号绑定", tags = {"账号绑定" },  notes = "获取账号绑定")
	@RequestMapping(method = RequestMethod.GET, value = "/sysuserauths/{sysuserauth_id}")
    public ResponseEntity<SysUserAuthDTO> get(@PathVariable("sysuserauth_id") String sysuserauth_id) {
        SysUserAuth domain = sysuserauthService.get(sysuserauth_id);
        SysUserAuthDTO dto = sysuserauthMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取账号绑定草稿", tags = {"账号绑定" },  notes = "获取账号绑定草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sysuserauths/getdraft")
    public ResponseEntity<SysUserAuthDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sysuserauthMapping.toDto(sysuserauthService.getDraft(new SysUserAuth())));
    }

    @ApiOperation(value = "检查账号绑定", tags = {"账号绑定" },  notes = "检查账号绑定")
	@RequestMapping(method = RequestMethod.POST, value = "/sysuserauths/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysUserAuthDTO sysuserauthdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysuserauthService.checkKey(sysuserauthMapping.toDomain(sysuserauthdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-Save-all')")
    @ApiOperation(value = "保存账号绑定", tags = {"账号绑定" },  notes = "保存账号绑定")
	@RequestMapping(method = RequestMethod.POST, value = "/sysuserauths/save")
    public ResponseEntity<Boolean> save(@RequestBody SysUserAuthDTO sysuserauthdto) {
        return ResponseEntity.status(HttpStatus.OK).body(sysuserauthService.save(sysuserauthMapping.toDomain(sysuserauthdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-Save-all')")
    @ApiOperation(value = "批量保存账号绑定", tags = {"账号绑定" },  notes = "批量保存账号绑定")
	@RequestMapping(method = RequestMethod.POST, value = "/sysuserauths/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysUserAuthDTO> sysuserauthdtos) {
        sysuserauthService.saveBatch(sysuserauthMapping.toDomain(sysuserauthdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"账号绑定" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysuserauths/fetchdefault")
	public ResponseEntity<List<SysUserAuthDTO>> fetchDefault(SysUserAuthSearchContext context) {
        Page<SysUserAuth> domains = sysuserauthService.searchDefault(context) ;
        List<SysUserAuthDTO> list = sysuserauthMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzuaa-SysUserAuth-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"账号绑定" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysuserauths/searchdefault")
	public ResponseEntity<Page<SysUserAuthDTO>> searchDefault(@RequestBody SysUserAuthSearchContext context) {
        Page<SysUserAuth> domains = sysuserauthService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysuserauthMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}

