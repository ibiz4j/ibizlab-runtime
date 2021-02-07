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
import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.service.ISysAppService;
import cn.ibizlab.core.uaa.filter.SysAppSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"应用" })
@RestController("api-sysapp")
@RequestMapping("")
public class SysAppResource {

    @Autowired
    public ISysAppService sysappService;

    @Autowired
    @Lazy
    public SysAppMapping sysappMapping;

    @ApiOperation(value = "新建应用", tags = {"应用" },  notes = "新建应用")
	@RequestMapping(method = RequestMethod.POST, value = "/sysapps")
    public ResponseEntity<SysAppDTO> create(@Validated @RequestBody SysAppDTO sysappdto) {
        SysApp domain = sysappMapping.toDomain(sysappdto);
		sysappService.create(domain);
        SysAppDTO dto = sysappMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建应用", tags = {"应用" },  notes = "批量新建应用")
	@RequestMapping(method = RequestMethod.POST, value = "/sysapps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysAppDTO> sysappdtos) {
        sysappService.createBatch(sysappMapping.toDomain(sysappdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新应用", tags = {"应用" },  notes = "更新应用")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysapps/{sysapp_id}")
    public ResponseEntity<SysAppDTO> update(@PathVariable("sysapp_id") String sysapp_id, @RequestBody SysAppDTO sysappdto) {
		SysApp domain  = sysappMapping.toDomain(sysappdto);
        domain .setId(sysapp_id);
		sysappService.update(domain );
		SysAppDTO dto = sysappMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新应用", tags = {"应用" },  notes = "批量更新应用")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysapps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysAppDTO> sysappdtos) {
        sysappService.updateBatch(sysappMapping.toDomain(sysappdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "删除应用", tags = {"应用" },  notes = "删除应用")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysapps/{sysapp_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("sysapp_id") String sysapp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sysappService.remove(sysapp_id));
    }

    @ApiOperation(value = "批量删除应用", tags = {"应用" },  notes = "批量删除应用")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysapps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sysappService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取应用", tags = {"应用" },  notes = "获取应用")
	@RequestMapping(method = RequestMethod.GET, value = "/sysapps/{sysapp_id}")
    public ResponseEntity<SysAppDTO> get(@PathVariable("sysapp_id") String sysapp_id) {
        SysApp domain = sysappService.get(sysapp_id);
        SysAppDTO dto = sysappMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取应用草稿", tags = {"应用" },  notes = "获取应用草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sysapps/getdraft")
    public ResponseEntity<SysAppDTO> getDraft(SysAppDTO dto) {
        SysApp domain = sysappMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(sysappMapping.toDto(sysappService.getDraft(domain)));
    }

    @ApiOperation(value = "检查应用", tags = {"应用" },  notes = "检查应用")
	@RequestMapping(method = RequestMethod.POST, value = "/sysapps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysAppDTO sysappdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sysappService.checkKey(sysappMapping.toDomain(sysappdto)));
    }

    @ApiOperation(value = "保存应用", tags = {"应用" },  notes = "保存应用")
	@RequestMapping(method = RequestMethod.POST, value = "/sysapps/save")
    public ResponseEntity<SysAppDTO> save(@RequestBody SysAppDTO sysappdto) {
        SysApp domain = sysappMapping.toDomain(sysappdto);
        sysappService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(sysappMapping.toDto(domain));
    }

    @ApiOperation(value = "批量保存应用", tags = {"应用" },  notes = "批量保存应用")
	@RequestMapping(method = RequestMethod.POST, value = "/sysapps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysAppDTO> sysappdtos) {
        sysappService.saveBatch(sysappMapping.toDomain(sysappdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"应用" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysapps/fetchdefault")
	public ResponseEntity<List<SysAppDTO>> fetchDefault(SysAppSearchContext context) {
        Page<SysApp> domains = sysappService.searchDefault(context) ;
        List<SysAppDTO> list = sysappMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"应用" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysapps/searchdefault")
	public ResponseEntity<Page<SysAppDTO>> searchDefault(@RequestBody SysAppSearchContext context) {
        Page<SysApp> domains = sysappService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sysappMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

