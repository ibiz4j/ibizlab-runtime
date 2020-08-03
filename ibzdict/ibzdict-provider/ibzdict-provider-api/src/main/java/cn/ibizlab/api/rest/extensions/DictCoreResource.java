package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.api.dto.DictCatalogDTO;
import cn.ibizlab.api.mapping.DictCatalogMapping;
import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;
import cn.ibizlab.core.dict.service.IDictCatalogService;
import cn.ibizlab.util.annotation.VersionCheck;
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
    public IDictCatalogService dictcatalogService;

    @Autowired
    @Lazy
    public DictCatalogMapping dictcatalogMapping;


}

