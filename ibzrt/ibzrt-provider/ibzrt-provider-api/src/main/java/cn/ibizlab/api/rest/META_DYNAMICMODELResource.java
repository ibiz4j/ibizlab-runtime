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
import cn.ibizlab.core.disk.domain.META_DYNAMICMODEL;
import cn.ibizlab.core.disk.service.IMETA_DYNAMICMODELService;
import cn.ibizlab.core.disk.filter.META_DYNAMICMODELSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"动态模型" })
@RestController("api-meta_dynamicmodel")
@RequestMapping("")
public class META_DYNAMICMODELResource {

    @Autowired
    public IMETA_DYNAMICMODELService meta_dynamicmodelService;

    @Autowired
    @Lazy
    public META_DYNAMICMODELMapping meta_dynamicmodelMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Create-all')")
    @ApiOperation(value = "新建动态模型", tags = {"动态模型" },  notes = "新建动态模型")
	@RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels")
    public ResponseEntity<META_DYNAMICMODELDTO> create(@Validated @RequestBody META_DYNAMICMODELDTO meta_dynamicmodeldto) {
        META_DYNAMICMODEL domain = meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldto);
		meta_dynamicmodelService.create(domain);
        META_DYNAMICMODELDTO dto = meta_dynamicmodelMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Create-all')")
    @ApiOperation(value = "批量新建动态模型", tags = {"动态模型" },  notes = "批量新建动态模型")
	@RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<META_DYNAMICMODELDTO> meta_dynamicmodeldtos) {
        meta_dynamicmodelService.createBatch(meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Update-all')")
    @ApiOperation(value = "更新动态模型", tags = {"动态模型" },  notes = "更新动态模型")
	@RequestMapping(method = RequestMethod.PUT, value = "/meta_dynamicmodels/{meta_dynamicmodel_id}")
    public ResponseEntity<META_DYNAMICMODELDTO> update(@PathVariable("meta_dynamicmodel_id") String meta_dynamicmodel_id, @RequestBody META_DYNAMICMODELDTO meta_dynamicmodeldto) {
		META_DYNAMICMODEL domain  = meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldto);
        domain .setConfigid(meta_dynamicmodel_id);
		meta_dynamicmodelService.update(domain );
		META_DYNAMICMODELDTO dto = meta_dynamicmodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Update-all')")
    @ApiOperation(value = "批量更新动态模型", tags = {"动态模型" },  notes = "批量更新动态模型")
	@RequestMapping(method = RequestMethod.PUT, value = "/meta_dynamicmodels/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<META_DYNAMICMODELDTO> meta_dynamicmodeldtos) {
        meta_dynamicmodelService.updateBatch(meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Remove-all')")
    @ApiOperation(value = "删除动态模型", tags = {"动态模型" },  notes = "删除动态模型")
	@RequestMapping(method = RequestMethod.DELETE, value = "/meta_dynamicmodels/{meta_dynamicmodel_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("meta_dynamicmodel_id") String meta_dynamicmodel_id) {
         return ResponseEntity.status(HttpStatus.OK).body(meta_dynamicmodelService.remove(meta_dynamicmodel_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Remove-all')")
    @ApiOperation(value = "批量删除动态模型", tags = {"动态模型" },  notes = "批量删除动态模型")
	@RequestMapping(method = RequestMethod.DELETE, value = "/meta_dynamicmodels/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        meta_dynamicmodelService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Get-all')")
    @ApiOperation(value = "获取动态模型", tags = {"动态模型" },  notes = "获取动态模型")
	@RequestMapping(method = RequestMethod.GET, value = "/meta_dynamicmodels/{meta_dynamicmodel_id}")
    public ResponseEntity<META_DYNAMICMODELDTO> get(@PathVariable("meta_dynamicmodel_id") String meta_dynamicmodel_id) {
        META_DYNAMICMODEL domain = meta_dynamicmodelService.get(meta_dynamicmodel_id);
        META_DYNAMICMODELDTO dto = meta_dynamicmodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取动态模型草稿", tags = {"动态模型" },  notes = "获取动态模型草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/meta_dynamicmodels/getdraft")
    public ResponseEntity<META_DYNAMICMODELDTO> getDraft(META_DYNAMICMODELDTO dto) {
        META_DYNAMICMODEL domain = meta_dynamicmodelMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(meta_dynamicmodelMapping.toDto(meta_dynamicmodelService.getDraft(domain)));
    }

    @ApiOperation(value = "检查动态模型", tags = {"动态模型" },  notes = "检查动态模型")
	@RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody META_DYNAMICMODELDTO meta_dynamicmodeldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(meta_dynamicmodelService.checkKey(meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Init-all')")
    @ApiOperation(value = "初始化副本实例", tags = {"动态模型" },  notes = "初始化副本实例")
	@RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/{meta_dynamicmodel_id}/init")
    public ResponseEntity<META_DYNAMICMODELDTO> init(@PathVariable("meta_dynamicmodel_id") String meta_dynamicmodel_id, @RequestBody META_DYNAMICMODELDTO meta_dynamicmodeldto) {
        META_DYNAMICMODEL domain = meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldto);
        domain.setConfigid(meta_dynamicmodel_id);
        domain = meta_dynamicmodelService.init(domain);
        meta_dynamicmodeldto = meta_dynamicmodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(meta_dynamicmodeldto);
    }
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Init-all')")
    @ApiOperation(value = "批量处理[初始化副本实例]", tags = {"动态模型" },  notes = "批量处理[初始化副本实例]")
	@RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/initbatch")
    public ResponseEntity<Boolean> initBatch(@RequestBody List<META_DYNAMICMODELDTO> meta_dynamicmodeldtos) {
        List<META_DYNAMICMODEL> domains = meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldtos);
        boolean result = meta_dynamicmodelService.initBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Publish-all')")
    @ApiOperation(value = "发布模型", tags = {"动态模型" },  notes = "发布模型")
	@RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/{meta_dynamicmodel_id}/publish")
    public ResponseEntity<META_DYNAMICMODELDTO> publish(@PathVariable("meta_dynamicmodel_id") String meta_dynamicmodel_id, @RequestBody META_DYNAMICMODELDTO meta_dynamicmodeldto) {
        META_DYNAMICMODEL domain = meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldto);
        domain.setConfigid(meta_dynamicmodel_id);
        domain = meta_dynamicmodelService.publish(domain);
        meta_dynamicmodeldto = meta_dynamicmodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(meta_dynamicmodeldto);
    }
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Publish-all')")
    @ApiOperation(value = "批量处理[发布模型]", tags = {"动态模型" },  notes = "批量处理[发布模型]")
	@RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/publishbatch")
    public ResponseEntity<Boolean> publishBatch(@RequestBody List<META_DYNAMICMODELDTO> meta_dynamicmodeldtos) {
        List<META_DYNAMICMODEL> domains = meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldtos);
        boolean result = meta_dynamicmodelService.publishBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Save-all')")
    @ApiOperation(value = "保存动态模型", tags = {"动态模型" },  notes = "保存动态模型")
	@RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/save")
    public ResponseEntity<META_DYNAMICMODELDTO> save(@RequestBody META_DYNAMICMODELDTO meta_dynamicmodeldto) {
        META_DYNAMICMODEL domain = meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldto);
        meta_dynamicmodelService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(meta_dynamicmodelMapping.toDto(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-Save-all')")
    @ApiOperation(value = "批量保存动态模型", tags = {"动态模型" },  notes = "批量保存动态模型")
	@RequestMapping(method = RequestMethod.POST, value = "/meta_dynamicmodels/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<META_DYNAMICMODELDTO> meta_dynamicmodeldtos) {
        meta_dynamicmodelService.saveBatch(meta_dynamicmodelMapping.toDomain(meta_dynamicmodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-searchDefault-all')")
	@ApiOperation(value = "获取数据集", tags = {"动态模型" } ,notes = "获取数据集")
    @RequestMapping(method= RequestMethod.GET , value="/meta_dynamicmodels/fetchdefault")
	public ResponseEntity<List<META_DYNAMICMODELDTO>> fetchDefault(META_DYNAMICMODELSearchContext context) {
        Page<META_DYNAMICMODEL> domains = meta_dynamicmodelService.searchDefault(context) ;
        List<META_DYNAMICMODELDTO> list = meta_dynamicmodelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-searchDefault-all')")
	@ApiOperation(value = "查询数据集", tags = {"动态模型" } ,notes = "查询数据集")
    @RequestMapping(method= RequestMethod.POST , value="/meta_dynamicmodels/searchdefault")
	public ResponseEntity<Page<META_DYNAMICMODELDTO>> searchDefault(@RequestBody META_DYNAMICMODELSearchContext context) {
        Page<META_DYNAMICMODEL> domains = meta_dynamicmodelService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(meta_dynamicmodelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-searchDynaInst-all')")
	@ApiOperation(value = "获取主实例数据查询", tags = {"动态模型" } ,notes = "获取主实例数据查询")
    @RequestMapping(method= RequestMethod.GET , value="/meta_dynamicmodels/fetchdynainst")
	public ResponseEntity<List<META_DYNAMICMODELDTO>> fetchDynaInst(META_DYNAMICMODELSearchContext context) {
        Page<META_DYNAMICMODEL> domains = meta_dynamicmodelService.searchDynaInst(context) ;
        List<META_DYNAMICMODELDTO> list = meta_dynamicmodelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-META_DYNAMICMODEL-searchDynaInst-all')")
	@ApiOperation(value = "查询主实例数据查询", tags = {"动态模型" } ,notes = "查询主实例数据查询")
    @RequestMapping(method= RequestMethod.POST , value="/meta_dynamicmodels/searchdynainst")
	public ResponseEntity<Page<META_DYNAMICMODELDTO>> searchDynaInst(@RequestBody META_DYNAMICMODELSearchContext context) {
        Page<META_DYNAMICMODEL> domains = meta_dynamicmodelService.searchDynaInst(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(meta_dynamicmodelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

