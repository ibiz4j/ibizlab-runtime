package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.api.dto.DictCatalogDTO;
import cn.ibizlab.api.mapping.DictCatalogMapping;
import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.domain.DictOption;
import cn.ibizlab.core.dict.extensions.service.DictCoreService;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;
import cn.ibizlab.core.dict.filter.DictOptionSearchContext;
import cn.ibizlab.core.dict.service.IDictCatalogService;
import cn.ibizlab.core.dict.service.IDictOptionService;
import cn.ibizlab.util.annotation.VersionCheck;
import cn.ibizlab.util.dict.Catalog;
import cn.ibizlab.util.dict.CodeItem;
import cn.ibizlab.util.dict.CodeList;
import cn.ibizlab.util.dict.Option;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("")
public class DictCoreResource {

    @Autowired
    private IDictCatalogService dictcatalogService;

    @Autowired
    private IDictOptionService optionService;

    @Autowired
    @Lazy
    private DictCatalogMapping dictcatalogMapping;


    @Autowired
    @Lazy
    private DictCoreService dictCoreService;

    @RequestMapping(method = {RequestMethod.GET}, value = {"/dictionaries/catalogs/{code}","/dictionarys/catalogs/{code}"})
    public ResponseEntity<Catalog> getCatalogs(@PathVariable("code") String code,DictOptionSearchContext context) {
        Catalog catalog = null;
        if(context==null||StringUtils.isEmpty(context.getSelectCond().getSqlSegment()))
            catalog = dictCoreService.getDictCatalog(code);
        else
            catalog = dictCoreService.getDictCatalog(code,context);
        return ResponseEntity.status(HttpStatus.OK).body(catalog);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = {"/dictionaries/catalogs/{code}/options","/dictionarys/catalogs/{code}/options"})
    public ResponseEntity<List<Option>> getOptions(@PathVariable("code") String code, DictOptionSearchContext context) {
        Catalog catalog = null;
        if(context==null||StringUtils.isEmpty(context.getSelectCond().getSqlSegment()))
            catalog = dictCoreService.getDictCatalog(code);
        else
            catalog = dictCoreService.getDictCatalog(code,context);
        return ResponseEntity.status(HttpStatus.OK).body(catalog.getOptions());
    }



    @RequestMapping(method = {RequestMethod.GET}, value = {"/dictionaries/codelist/{code}","/dictionarys/codelist/{code}"})
    public ResponseEntity<CodeList> getCodeList(@PathVariable("code") String code,DictOptionSearchContext context) {
        CodeList catalog = null;
        if(context==null||StringUtils.isEmpty(context.getSelectCond().getSqlSegment()))
            catalog = dictCoreService.getCodeListCatalog(code);
        else
            catalog = dictCoreService.getCodeListCatalog(code,context);
        return ResponseEntity.status(HttpStatus.OK).body(catalog);
    }


    @RequestMapping(method = {RequestMethod.GET}, value = {"/dictionaries/codelist/{code}/items","/dictionarys/codelist/{code}/items"})
    public ResponseEntity<List<CodeItem>> getCodeItems(@PathVariable("code") String code, DictOptionSearchContext context) {
        CodeList catalog = null;
        if(context==null||StringUtils.isEmpty(context.getSelectCond().getSqlSegment()))
            catalog = dictCoreService.getCodeListCatalog(code);
        else
            catalog = dictCoreService.getCodeListCatalog(code,context);
        return ResponseEntity.status(HttpStatus.OK).body(catalog.getOptions());
    }


    @RequestMapping(method = {RequestMethod.POST}, value = {"/dictionaries/catalogs/{code}","/dictionarys/catalogs/{code}"})
    public ResponseEntity<Catalog> catalogs(@PathVariable("code") String code, @RequestBody(required = false) DictOptionSearchContext context) {
        Catalog catalog = null;
        if(context==null||StringUtils.isEmpty(context.getSelectCond().getSqlSegment()))
            catalog = dictCoreService.getDictCatalog(code);
        else
            catalog = dictCoreService.getDictCatalog(code,context);
        return ResponseEntity.status(HttpStatus.OK).body(catalog);
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/dictionaries/catalogs/{code}/options","/dictionarys/catalogs/{code}/options"})
    public ResponseEntity<List<Option>> options(@PathVariable("code") String code,@RequestBody(required = false) DictOptionSearchContext context) {
        Catalog catalog = null;
        if(context==null||StringUtils.isEmpty(context.getSelectCond().getSqlSegment()))
            catalog = dictCoreService.getDictCatalog(code);
        else
            catalog = dictCoreService.getDictCatalog(code,context);
        return ResponseEntity.status(HttpStatus.OK).body(catalog.getOptions());
    }



    @RequestMapping(method = {RequestMethod.POST}, value = {"/dictionaries/codelist/{code}","/dictionarys/codelist/{code}"})
    public ResponseEntity<CodeList> codeList(@PathVariable("code") String code,@RequestBody(required = false) DictOptionSearchContext context) {
        CodeList catalog = null;
        if(context==null||StringUtils.isEmpty(context.getSelectCond().getSqlSegment()))
            catalog = dictCoreService.getCodeListCatalog(code);
        else
            catalog = dictCoreService.getCodeListCatalog(code,context);
        return ResponseEntity.status(HttpStatus.OK).body(catalog);
    }


    @RequestMapping(method = {RequestMethod.POST}, value = {"/dictionaries/codelist/{code}/items","/dictionarys/codelist/{code}/items"})
    public ResponseEntity<List<CodeItem>> codeItems(@PathVariable("code") String code, @RequestBody(required = false) DictOptionSearchContext context) {
        CodeList catalog = null;
        if(context==null||StringUtils.isEmpty(context.getSelectCond().getSqlSegment()))
            catalog = dictCoreService.getCodeListCatalog(code);
        else
            catalog = dictCoreService.getCodeListCatalog(code,context);
        return ResponseEntity.status(HttpStatus.OK).body(catalog.getOptions());
    }


    @RequestMapping(method = RequestMethod.POST, value = {"/dictionaries/catalogs","/dictionarys/catalogs"})
    public ResponseEntity<Boolean> save(@RequestBody DictCatalogDTO dictcatalogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(dictcatalogService.save(dictcatalogMapping.toDomain(dictcatalogdto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/dictionaries/catalogs/savebatch","/dictionarys/catalogs/savebatch"})
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DictCatalogDTO> dictcatalogdtos) {
        dictcatalogService.saveBatch(dictcatalogMapping.toDomain(dictcatalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/dictionaries/catalogs/sync","/dictionarys/catalogs/sync"})
    public ResponseEntity<Boolean> syncRuntimeDict(@RequestBody List<DictCatalog> catalogs){
        dictCoreService.syncRuntimeDict(catalogs);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

}

