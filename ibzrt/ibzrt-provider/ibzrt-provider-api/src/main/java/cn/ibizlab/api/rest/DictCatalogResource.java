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
import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.service.IDictCatalogService;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"字典" })
@RestController("api-dictcatalog")
@RequestMapping("")
public class DictCatalogResource {

    @Autowired
    public IDictCatalogService dictcatalogService;

    @Autowired
    @Lazy
    public DictCatalogMapping dictcatalogMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-Create-all')")
    @ApiOperation(value = "新建字典", tags = {"字典" },  notes = "新建字典")
	@RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs")
    public ResponseEntity<DictCatalogDTO> create(@Validated @RequestBody DictCatalogDTO dictcatalogdto) {
        DictCatalog domain = dictcatalogMapping.toDomain(dictcatalogdto);
		dictcatalogService.create(domain);
        DictCatalogDTO dto = dictcatalogMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-Create-all')")
    @ApiOperation(value = "批量新建字典", tags = {"字典" },  notes = "批量新建字典")
	@RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DictCatalogDTO> dictcatalogdtos) {
        dictcatalogService.createBatch(dictcatalogMapping.toDomain(dictcatalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "dictcatalog" , versionfield = "updatedate")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-Update-all')")
    @ApiOperation(value = "更新字典", tags = {"字典" },  notes = "更新字典")
	@RequestMapping(method = RequestMethod.PUT, value = "/dictcatalogs/{dictcatalog_id}")
    public ResponseEntity<DictCatalogDTO> update(@PathVariable("dictcatalog_id") String dictcatalog_id, @RequestBody DictCatalogDTO dictcatalogdto) {
		DictCatalog domain  = dictcatalogMapping.toDomain(dictcatalogdto);
        domain .setId(dictcatalog_id);
		dictcatalogService.update(domain );
		DictCatalogDTO dto = dictcatalogMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-Update-all')")
    @ApiOperation(value = "批量更新字典", tags = {"字典" },  notes = "批量更新字典")
	@RequestMapping(method = RequestMethod.PUT, value = "/dictcatalogs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DictCatalogDTO> dictcatalogdtos) {
        dictcatalogService.updateBatch(dictcatalogMapping.toDomain(dictcatalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-Remove-all')")
    @ApiOperation(value = "删除字典", tags = {"字典" },  notes = "删除字典")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dictcatalogs/{dictcatalog_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("dictcatalog_id") String dictcatalog_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dictcatalogService.remove(dictcatalog_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-Remove-all')")
    @ApiOperation(value = "批量删除字典", tags = {"字典" },  notes = "批量删除字典")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dictcatalogs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dictcatalogService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-Get-all')")
    @ApiOperation(value = "获取字典", tags = {"字典" },  notes = "获取字典")
	@RequestMapping(method = RequestMethod.GET, value = "/dictcatalogs/{dictcatalog_id}")
    public ResponseEntity<DictCatalogDTO> get(@PathVariable("dictcatalog_id") String dictcatalog_id) {
        DictCatalog domain = dictcatalogService.get(dictcatalog_id);
        DictCatalogDTO dto = dictcatalogMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取字典草稿", tags = {"字典" },  notes = "获取字典草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/dictcatalogs/getdraft")
    public ResponseEntity<DictCatalogDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dictcatalogMapping.toDto(dictcatalogService.getDraft(new DictCatalog())));
    }

    @ApiOperation(value = "检查字典", tags = {"字典" },  notes = "检查字典")
	@RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DictCatalogDTO dictcatalogdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dictcatalogService.checkKey(dictcatalogMapping.toDomain(dictcatalogdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-Save-all')")
    @ApiOperation(value = "保存字典", tags = {"字典" },  notes = "保存字典")
	@RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/save")
    public ResponseEntity<Boolean> save(@RequestBody DictCatalogDTO dictcatalogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(dictcatalogService.save(dictcatalogMapping.toDomain(dictcatalogdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-Save-all')")
    @ApiOperation(value = "批量保存字典", tags = {"字典" },  notes = "批量保存字典")
	@RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DictCatalogDTO> dictcatalogdtos) {
        dictcatalogService.saveBatch(dictcatalogMapping.toDomain(dictcatalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"字典" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dictcatalogs/fetchdefault")
	public ResponseEntity<List<DictCatalogDTO>> fetchDefault(DictCatalogSearchContext context) {
        Page<DictCatalog> domains = dictcatalogService.searchDefault(context) ;
        List<DictCatalogDTO> list = dictcatalogMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-DictCatalog-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"字典" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/dictcatalogs/searchdefault")
	public ResponseEntity<Page<DictCatalogDTO>> searchDefault(@RequestBody DictCatalogSearchContext context) {
        Page<DictCatalog> domains = dictcatalogService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dictcatalogMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}

