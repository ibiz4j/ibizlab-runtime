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
import cn.ibizlab.core.dict.domain.DictOption;
import cn.ibizlab.core.dict.service.IDictOptionService;
import cn.ibizlab.core.dict.filter.DictOptionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"字典项" })
@RestController("api-dictoption")
@RequestMapping("")
public class DictOptionResource {

    @Autowired
    public IDictOptionService dictoptionService;

    @Autowired
    @Lazy
    public DictOptionMapping dictoptionMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Create-all')")
    @ApiOperation(value = "新建字典项", tags = {"字典项" },  notes = "新建字典项")
	@RequestMapping(method = RequestMethod.POST, value = "/dictoptions")
    public ResponseEntity<DictOptionDTO> create(@Validated @RequestBody DictOptionDTO dictoptiondto) {
        DictOption domain = dictoptionMapping.toDomain(dictoptiondto);
		dictoptionService.create(domain);
        DictOptionDTO dto = dictoptionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Create-all')")
    @ApiOperation(value = "批量新建字典项", tags = {"字典项" },  notes = "批量新建字典项")
	@RequestMapping(method = RequestMethod.POST, value = "/dictoptions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DictOptionDTO> dictoptiondtos) {
        dictoptionService.createBatch(dictoptionMapping.toDomain(dictoptiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "dictoption" , versionfield = "updatedate")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Update-all')")
    @ApiOperation(value = "更新字典项", tags = {"字典项" },  notes = "更新字典项")
	@RequestMapping(method = RequestMethod.PUT, value = "/dictoptions/{dictoption_id}")
    public ResponseEntity<DictOptionDTO> update(@PathVariable("dictoption_id") String dictoption_id, @RequestBody DictOptionDTO dictoptiondto) {
		DictOption domain  = dictoptionMapping.toDomain(dictoptiondto);
        domain .setValueKey(dictoption_id);
		dictoptionService.update(domain );
		DictOptionDTO dto = dictoptionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Update-all')")
    @ApiOperation(value = "批量更新字典项", tags = {"字典项" },  notes = "批量更新字典项")
	@RequestMapping(method = RequestMethod.PUT, value = "/dictoptions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DictOptionDTO> dictoptiondtos) {
        dictoptionService.updateBatch(dictoptionMapping.toDomain(dictoptiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Remove-all')")
    @ApiOperation(value = "删除字典项", tags = {"字典项" },  notes = "删除字典项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dictoptions/{dictoption_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("dictoption_id") String dictoption_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dictoptionService.remove(dictoption_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Remove-all')")
    @ApiOperation(value = "批量删除字典项", tags = {"字典项" },  notes = "批量删除字典项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dictoptions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dictoptionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Get-all')")
    @ApiOperation(value = "获取字典项", tags = {"字典项" },  notes = "获取字典项")
	@RequestMapping(method = RequestMethod.GET, value = "/dictoptions/{dictoption_id}")
    public ResponseEntity<DictOptionDTO> get(@PathVariable("dictoption_id") String dictoption_id) {
        DictOption domain = dictoptionService.get(dictoption_id);
        DictOptionDTO dto = dictoptionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取字典项草稿", tags = {"字典项" },  notes = "获取字典项草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/dictoptions/getdraft")
    public ResponseEntity<DictOptionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dictoptionMapping.toDto(dictoptionService.getDraft(new DictOption())));
    }

    @ApiOperation(value = "检查字典项", tags = {"字典项" },  notes = "检查字典项")
	@RequestMapping(method = RequestMethod.POST, value = "/dictoptions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DictOptionDTO dictoptiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dictoptionService.checkKey(dictoptionMapping.toDomain(dictoptiondto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Save-all')")
    @ApiOperation(value = "保存字典项", tags = {"字典项" },  notes = "保存字典项")
	@RequestMapping(method = RequestMethod.POST, value = "/dictoptions/save")
    public ResponseEntity<Boolean> save(@RequestBody DictOptionDTO dictoptiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(dictoptionService.save(dictoptionMapping.toDomain(dictoptiondto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Save-all')")
    @ApiOperation(value = "批量保存字典项", tags = {"字典项" },  notes = "批量保存字典项")
	@RequestMapping(method = RequestMethod.POST, value = "/dictoptions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DictOptionDTO> dictoptiondtos) {
        dictoptionService.saveBatch(dictoptionMapping.toDomain(dictoptiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"字典项" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dictoptions/fetchdefault")
	public ResponseEntity<List<DictOptionDTO>> fetchDefault(DictOptionSearchContext context) {
        Page<DictOption> domains = dictoptionService.searchDefault(context) ;
        List<DictOptionDTO> list = dictoptionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"字典项" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/dictoptions/searchdefault")
	public ResponseEntity<Page<DictOptionDTO>> searchDefault(@RequestBody DictOptionSearchContext context) {
        Page<DictOption> domains = dictoptionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dictoptionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Create-all')")
    @ApiOperation(value = "根据字典建立字典项", tags = {"字典项" },  notes = "根据字典建立字典项")
	@RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/{dictcatalog_id}/dictoptions")
    public ResponseEntity<DictOptionDTO> createByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id, @RequestBody DictOptionDTO dictoptiondto) {
        DictOption domain = dictoptionMapping.toDomain(dictoptiondto);
        domain.setCatalogId(dictcatalog_id);
		dictoptionService.create(domain);
        DictOptionDTO dto = dictoptionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Create-all')")
    @ApiOperation(value = "根据字典批量建立字典项", tags = {"字典项" },  notes = "根据字典批量建立字典项")
	@RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/{dictcatalog_id}/dictoptions/batch")
    public ResponseEntity<Boolean> createBatchByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id, @RequestBody List<DictOptionDTO> dictoptiondtos) {
        List<DictOption> domainlist=dictoptionMapping.toDomain(dictoptiondtos);
        for(DictOption domain:domainlist){
            domain.setCatalogId(dictcatalog_id);
        }
        dictoptionService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @VersionCheck(entity = "dictoption" , versionfield = "updatedate")
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Update-all')")
    @ApiOperation(value = "根据字典更新字典项", tags = {"字典项" },  notes = "根据字典更新字典项")
	@RequestMapping(method = RequestMethod.PUT, value = "/dictcatalogs/{dictcatalog_id}/dictoptions/{dictoption_id}")
    public ResponseEntity<DictOptionDTO> updateByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id, @PathVariable("dictoption_id") String dictoption_id, @RequestBody DictOptionDTO dictoptiondto) {
        DictOption domain = dictoptionMapping.toDomain(dictoptiondto);
        domain.setCatalogId(dictcatalog_id);
        domain.setValueKey(dictoption_id);
		dictoptionService.update(domain);
        DictOptionDTO dto = dictoptionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Update-all')")
    @ApiOperation(value = "根据字典批量更新字典项", tags = {"字典项" },  notes = "根据字典批量更新字典项")
	@RequestMapping(method = RequestMethod.PUT, value = "/dictcatalogs/{dictcatalog_id}/dictoptions/batch")
    public ResponseEntity<Boolean> updateBatchByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id, @RequestBody List<DictOptionDTO> dictoptiondtos) {
        List<DictOption> domainlist=dictoptionMapping.toDomain(dictoptiondtos);
        for(DictOption domain:domainlist){
            domain.setCatalogId(dictcatalog_id);
        }
        dictoptionService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Remove-all')")
    @ApiOperation(value = "根据字典删除字典项", tags = {"字典项" },  notes = "根据字典删除字典项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dictcatalogs/{dictcatalog_id}/dictoptions/{dictoption_id}")
    public ResponseEntity<Boolean> removeByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id, @PathVariable("dictoption_id") String dictoption_id) {
		return ResponseEntity.status(HttpStatus.OK).body(dictoptionService.remove(dictoption_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Remove-all')")
    @ApiOperation(value = "根据字典批量删除字典项", tags = {"字典项" },  notes = "根据字典批量删除字典项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dictcatalogs/{dictcatalog_id}/dictoptions/batch")
    public ResponseEntity<Boolean> removeBatchByDictCatalog(@RequestBody List<String> ids) {
        dictoptionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Get-all')")
    @ApiOperation(value = "根据字典获取字典项", tags = {"字典项" },  notes = "根据字典获取字典项")
	@RequestMapping(method = RequestMethod.GET, value = "/dictcatalogs/{dictcatalog_id}/dictoptions/{dictoption_id}")
    public ResponseEntity<DictOptionDTO> getByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id, @PathVariable("dictoption_id") String dictoption_id) {
        DictOption domain = dictoptionService.get(dictoption_id);
        DictOptionDTO dto = dictoptionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据字典获取字典项草稿", tags = {"字典项" },  notes = "根据字典获取字典项草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/dictcatalogs/{dictcatalog_id}/dictoptions/getdraft")
    public ResponseEntity<DictOptionDTO> getDraftByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id) {
        DictOption domain = new DictOption();
        domain.setCatalogId(dictcatalog_id);
        return ResponseEntity.status(HttpStatus.OK).body(dictoptionMapping.toDto(dictoptionService.getDraft(domain)));
    }

    @ApiOperation(value = "根据字典检查字典项", tags = {"字典项" },  notes = "根据字典检查字典项")
	@RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/{dictcatalog_id}/dictoptions/checkkey")
    public ResponseEntity<Boolean> checkKeyByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id, @RequestBody DictOptionDTO dictoptiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dictoptionService.checkKey(dictoptionMapping.toDomain(dictoptiondto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Save-all')")
    @ApiOperation(value = "根据字典保存字典项", tags = {"字典项" },  notes = "根据字典保存字典项")
	@RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/{dictcatalog_id}/dictoptions/save")
    public ResponseEntity<Boolean> saveByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id, @RequestBody DictOptionDTO dictoptiondto) {
        DictOption domain = dictoptionMapping.toDomain(dictoptiondto);
        domain.setCatalogId(dictcatalog_id);
        return ResponseEntity.status(HttpStatus.OK).body(dictoptionService.save(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-Save-all')")
    @ApiOperation(value = "根据字典批量保存字典项", tags = {"字典项" },  notes = "根据字典批量保存字典项")
	@RequestMapping(method = RequestMethod.POST, value = "/dictcatalogs/{dictcatalog_id}/dictoptions/savebatch")
    public ResponseEntity<Boolean> saveBatchByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id, @RequestBody List<DictOptionDTO> dictoptiondtos) {
        List<DictOption> domainlist=dictoptionMapping.toDomain(dictoptiondtos);
        for(DictOption domain:domainlist){
             domain.setCatalogId(dictcatalog_id);
        }
        dictoptionService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-searchDefault-all')")
	@ApiOperation(value = "根据字典获取DEFAULT", tags = {"字典项" } ,notes = "根据字典获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dictcatalogs/{dictcatalog_id}/dictoptions/fetchdefault")
	public ResponseEntity<List<DictOptionDTO>> fetchDictOptionDefaultByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id,DictOptionSearchContext context) {
        context.setN_cid_eq(dictcatalog_id);
        Page<DictOption> domains = dictoptionService.searchDefault(context) ;
        List<DictOptionDTO> list = dictoptionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzdict-DictOption-searchDefault-all')")
	@ApiOperation(value = "根据字典查询DEFAULT", tags = {"字典项" } ,notes = "根据字典查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/dictcatalogs/{dictcatalog_id}/dictoptions/searchdefault")
	public ResponseEntity<Page<DictOptionDTO>> searchDictOptionDefaultByDictCatalog(@PathVariable("dictcatalog_id") String dictcatalog_id, @RequestBody DictOptionSearchContext context) {
        context.setN_cid_eq(dictcatalog_id);
        Page<DictOption> domains = dictoptionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dictoptionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

