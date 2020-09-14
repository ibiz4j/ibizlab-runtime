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
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.service.ISysPermissionService;
import cn.ibizlab.core.uaa.filter.SysPermissionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"权限/资源" })
@RestController("api-syspermission")
@RequestMapping("")
public class SysPermissionResource {

    @Autowired
    public ISysPermissionService syspermissionService;

    @Autowired
    @Lazy
    public SysPermissionMapping syspermissionMapping;

    @ApiOperation(value = "新建权限/资源", tags = {"权限/资源" },  notes = "新建权限/资源")
	@RequestMapping(method = RequestMethod.POST, value = "/syspermissions")
    public ResponseEntity<SysPermissionDTO> create(@Validated @RequestBody SysPermissionDTO syspermissiondto) {
        SysPermission domain = syspermissionMapping.toDomain(syspermissiondto);
		syspermissionService.create(domain);
        SysPermissionDTO dto = syspermissionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建权限/资源", tags = {"权限/资源" },  notes = "批量新建权限/资源")
	@RequestMapping(method = RequestMethod.POST, value = "/syspermissions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysPermissionDTO> syspermissiondtos) {
        syspermissionService.createBatch(syspermissionMapping.toDomain(syspermissiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "syspermission" , versionfield = "updatedate")
    @ApiOperation(value = "更新权限/资源", tags = {"权限/资源" },  notes = "更新权限/资源")
	@RequestMapping(method = RequestMethod.PUT, value = "/syspermissions/{syspermission_id}")
    public ResponseEntity<SysPermissionDTO> update(@PathVariable("syspermission_id") String syspermission_id, @RequestBody SysPermissionDTO syspermissiondto) {
		SysPermission domain  = syspermissionMapping.toDomain(syspermissiondto);
        domain .setPermissionid(syspermission_id);
		syspermissionService.update(domain );
		SysPermissionDTO dto = syspermissionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新权限/资源", tags = {"权限/资源" },  notes = "批量更新权限/资源")
	@RequestMapping(method = RequestMethod.PUT, value = "/syspermissions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysPermissionDTO> syspermissiondtos) {
        syspermissionService.updateBatch(syspermissionMapping.toDomain(syspermissiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "删除权限/资源", tags = {"权限/资源" },  notes = "删除权限/资源")
	@RequestMapping(method = RequestMethod.DELETE, value = "/syspermissions/{syspermission_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("syspermission_id") String syspermission_id) {
         return ResponseEntity.status(HttpStatus.OK).body(syspermissionService.remove(syspermission_id));
    }

    @ApiOperation(value = "批量删除权限/资源", tags = {"权限/资源" },  notes = "批量删除权限/资源")
	@RequestMapping(method = RequestMethod.DELETE, value = "/syspermissions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        syspermissionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取权限/资源", tags = {"权限/资源" },  notes = "获取权限/资源")
	@RequestMapping(method = RequestMethod.GET, value = "/syspermissions/{syspermission_id}")
    public ResponseEntity<SysPermissionDTO> get(@PathVariable("syspermission_id") String syspermission_id) {
        SysPermission domain = syspermissionService.get(syspermission_id);
        SysPermissionDTO dto = syspermissionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取权限/资源草稿", tags = {"权限/资源" },  notes = "获取权限/资源草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/syspermissions/getdraft")
    public ResponseEntity<SysPermissionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(syspermissionMapping.toDto(syspermissionService.getDraft(new SysPermission())));
    }

    @ApiOperation(value = "检查权限/资源", tags = {"权限/资源" },  notes = "检查权限/资源")
	@RequestMapping(method = RequestMethod.POST, value = "/syspermissions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysPermissionDTO syspermissiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(syspermissionService.checkKey(syspermissionMapping.toDomain(syspermissiondto)));
    }

    @ApiOperation(value = "保存权限/资源", tags = {"权限/资源" },  notes = "保存权限/资源")
	@RequestMapping(method = RequestMethod.POST, value = "/syspermissions/save")
    public ResponseEntity<Boolean> save(@RequestBody SysPermissionDTO syspermissiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(syspermissionService.save(syspermissionMapping.toDomain(syspermissiondto)));
    }

    @ApiOperation(value = "批量保存权限/资源", tags = {"权限/资源" },  notes = "批量保存权限/资源")
	@RequestMapping(method = RequestMethod.POST, value = "/syspermissions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysPermissionDTO> syspermissiondtos) {
        syspermissionService.saveBatch(syspermissionMapping.toDomain(syspermissiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"权限/资源" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/syspermissions/fetchdefault")
	public ResponseEntity<List<SysPermissionDTO>> fetchDefault(SysPermissionSearchContext context) {
        Page<SysPermission> domains = syspermissionService.searchDefault(context) ;
        List<SysPermissionDTO> list = syspermissionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"权限/资源" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/syspermissions/searchdefault")
	public ResponseEntity<Page<SysPermissionDTO>> searchDefault(@RequestBody SysPermissionSearchContext context) {
        Page<SysPermission> domains = syspermissionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(syspermissionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

