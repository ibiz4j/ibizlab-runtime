package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.api.dto.DictCatalogDTO;
import cn.ibizlab.api.mapping.DictCatalogMapping;
import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.domain.DictOption;
import cn.ibizlab.core.dict.extensions.service.DictCoreService;
import cn.ibizlab.core.dict.extensions.vo.Catalog;
import cn.ibizlab.core.dict.extensions.vo.CodeItem;
import cn.ibizlab.core.dict.extensions.vo.CodeList;
import cn.ibizlab.core.dict.extensions.vo.Option;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;
import cn.ibizlab.core.dict.service.IDictCatalogService;
import cn.ibizlab.core.dict.service.IDictOptionService;
import cn.ibizlab.util.annotation.VersionCheck;
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

    @RequestMapping(method = RequestMethod.POST, value = "/dictionarys/catalogs/{code}/options")
    public ResponseEntity<List<Option>> getOptions(@PathVariable("code") String code,@RequestBody List<String> values) {
        List<Option> list = new ArrayList<>();
        optionService.list(Wrappers.<DictOption>lambdaQuery().eq(DictOption::getCatalog,code).in(DictOption::getValue,values).orderByAsc(DictOption::getShoworder)).forEach(item ->
                {
                    Map<String,Object> extension = new HashMap<>();
                    if(!StringUtils.isEmpty(item.getExtension()))
                        extension = JSONObject.parseObject(item.getExtension(),Map.class);
                    list.add(new Option().setValue(item.getValue()).setId(item.getValue())
                            .setDisabled(((item.getDisabled()!=null && item.getDisabled()==1)||(item.getExpired()!=null && item.getExpired()==1))?true:false)
                            .setFilter(item.getFilter()).setIconClass(item.getIconClass()).setLabel(item.getLabel()).setParent(item.getParent()).setExtension(extension)
                    );
                }
        );
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dictionarys/codelist/{code}")
    public ResponseEntity<CodeList> getCodeList(@PathVariable("code") String code) {
        CodeList catalog = dictCoreService.getCodeListCatalog(code);
        return ResponseEntity.status(HttpStatus.OK).body(catalog);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/dictionarys/codelist/{code}/items")
    public ResponseEntity<List<CodeItem>> getCodeItems(@PathVariable("code") String code, @RequestBody List<String> values) {
        List<CodeItem> list = new ArrayList<>();
        optionService.list(Wrappers.<DictOption>lambdaQuery().eq(DictOption::getCatalog,code).in(DictOption::getValue,values).orderByAsc(DictOption::getShoworder)).forEach(item ->
                {
                    Map<String,Object> extension = new HashMap<>();
                    if(!StringUtils.isEmpty(item.getExtension()))
                        extension = JSONObject.parseObject(item.getExtension(),Map.class);
                    list.add(new CodeItem().setValue(item.getValue()).setId(item.getValue())
                            .setDisabled(((item.getDisabled()!=null && item.getDisabled()==1)||(item.getExpired()!=null && item.getExpired()==1))?true:false)
                            .setFilter(item.getFilter()).setIconClass(item.getIconClass()).setLabel(item.getLabel()).setParent(item.getParent()).setExtension(extension)
                    );
                }
        );
        return ResponseEntity.status(HttpStatus.OK).body(list);
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

