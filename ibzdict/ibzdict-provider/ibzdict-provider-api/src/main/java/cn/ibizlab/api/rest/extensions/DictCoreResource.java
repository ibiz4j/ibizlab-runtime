package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.api.dto.DictCatalogDTO;
import cn.ibizlab.api.mapping.DictCatalogMapping;
import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.extensions.service.DictCoreService;
import cn.ibizlab.core.dict.extensions.vo.Catalog;
import cn.ibizlab.core.dict.extensions.vo.CodeList;
import cn.ibizlab.core.dict.extensions.vo.Option;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;
import cn.ibizlab.core.dict.service.IDictCatalogService;
import cn.ibizlab.util.annotation.VersionCheck;
import com.alibaba.fastjson.JSONObject;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("")
public class DictCoreResource {

    @Autowired
    private IDictCatalogService dictcatalogService;

    @Autowired
    @Lazy
    private DictCatalogMapping dictcatalogMapping;


    @Autowired
    @Lazy
    private DictCoreService dictCoreService;

    @RequestMapping(method = RequestMethod.GET, value = "/dictionarys/catalogs/{code}")
    public ResponseEntity<Catalog> getCatalogs(@PathVariable("code") String code) {
        Catalog catalog = dictCoreService.getDictCatalog(code);
        return ResponseEntity.status(HttpStatus.OK).body(catalog);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dictionarys/catalogs/{code}/options")
    public ResponseEntity<List<Option>> getOptions(@PathVariable("code") String code) {
        Catalog catalog = dictCoreService.getDictCatalog(code);
        return ResponseEntity.status(HttpStatus.OK).body(catalog.getOptions());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dictionarys/codelist/{code}")
    public ResponseEntity<CodeList> getCodeList(@PathVariable("code") String code) {
        CodeList catalog = dictCoreService.getCodeListCatalog(code);
        return ResponseEntity.status(HttpStatus.OK).body(catalog);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/dictionarys/catalogs")
    public ResponseEntity<Boolean> save(@RequestBody DictCatalogDTO dictcatalogdto) {
        return ResponseEntity.status(HttpStatus.OK).body(dictcatalogService.save(dictcatalogMapping.toDomain(dictcatalogdto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dictionarys/catalogs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DictCatalogDTO> dictcatalogdtos) {
        dictcatalogService.saveBatch(dictcatalogMapping.toDomain(dictcatalogdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

}

