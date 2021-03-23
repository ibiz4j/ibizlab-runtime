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
import cn.ibizlab.core.disk.domain.MetaDynamicModel;
import cn.ibizlab.core.disk.service.IMetaDynamicModelService;
import cn.ibizlab.core.disk.filter.MetaDynamicModelSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"动态模型" })
@RestController("api-metadynamicmodel")
@RequestMapping("")
public class MetaDynamicModelResource {

    @Autowired
    public IMetaDynamicModelService metadynamicmodelService;

    @Autowired
    @Lazy
    public MetaDynamicModelMapping metadynamicmodelMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Create-all')")
    @ApiOperation(value = "新建动态模型", tags = {"动态模型" },  notes = "新建动态模型")
	@RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels")
    public ResponseEntity<MetaDynamicModelDTO> create(@Validated @RequestBody MetaDynamicModelDTO metadynamicmodeldto) {
        MetaDynamicModel domain = metadynamicmodelMapping.toDomain(metadynamicmodeldto);
		metadynamicmodelService.create(domain);
        MetaDynamicModelDTO dto = metadynamicmodelMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Create-all')")
    @ApiOperation(value = "批量新建动态模型", tags = {"动态模型" },  notes = "批量新建动态模型")
	@RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MetaDynamicModelDTO> metadynamicmodeldtos) {
        metadynamicmodelService.createBatch(metadynamicmodelMapping.toDomain(metadynamicmodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Update-all')")
    @ApiOperation(value = "更新动态模型", tags = {"动态模型" },  notes = "更新动态模型")
	@RequestMapping(method = RequestMethod.PUT, value = "/metadynamicmodels/{metadynamicmodel_id}")
    public ResponseEntity<MetaDynamicModelDTO> update(@PathVariable("metadynamicmodel_id") String metadynamicmodel_id, @RequestBody MetaDynamicModelDTO metadynamicmodeldto) {
		MetaDynamicModel domain  = metadynamicmodelMapping.toDomain(metadynamicmodeldto);
        domain .setConfigid(metadynamicmodel_id);
		metadynamicmodelService.update(domain );
		MetaDynamicModelDTO dto = metadynamicmodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Update-all')")
    @ApiOperation(value = "批量更新动态模型", tags = {"动态模型" },  notes = "批量更新动态模型")
	@RequestMapping(method = RequestMethod.PUT, value = "/metadynamicmodels/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MetaDynamicModelDTO> metadynamicmodeldtos) {
        metadynamicmodelService.updateBatch(metadynamicmodelMapping.toDomain(metadynamicmodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Remove-all')")
    @ApiOperation(value = "删除动态模型", tags = {"动态模型" },  notes = "删除动态模型")
	@RequestMapping(method = RequestMethod.DELETE, value = "/metadynamicmodels/{metadynamicmodel_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("metadynamicmodel_id") String metadynamicmodel_id) {
         return ResponseEntity.status(HttpStatus.OK).body(metadynamicmodelService.remove(metadynamicmodel_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Remove-all')")
    @ApiOperation(value = "批量删除动态模型", tags = {"动态模型" },  notes = "批量删除动态模型")
	@RequestMapping(method = RequestMethod.DELETE, value = "/metadynamicmodels/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        metadynamicmodelService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Get-all')")
    @ApiOperation(value = "获取动态模型", tags = {"动态模型" },  notes = "获取动态模型")
	@RequestMapping(method = RequestMethod.GET, value = "/metadynamicmodels/{metadynamicmodel_id}")
    public ResponseEntity<MetaDynamicModelDTO> get(@PathVariable("metadynamicmodel_id") String metadynamicmodel_id) {
        MetaDynamicModel domain = metadynamicmodelService.get(metadynamicmodel_id);
        MetaDynamicModelDTO dto = metadynamicmodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取动态模型草稿", tags = {"动态模型" },  notes = "获取动态模型草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/metadynamicmodels/getdraft")
    public ResponseEntity<MetaDynamicModelDTO> getDraft(MetaDynamicModelDTO dto) {
        MetaDynamicModel domain = metadynamicmodelMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(metadynamicmodelMapping.toDto(metadynamicmodelService.getDraft(domain)));
    }

    @ApiOperation(value = "检查动态模型", tags = {"动态模型" },  notes = "检查动态模型")
	@RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody MetaDynamicModelDTO metadynamicmodeldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(metadynamicmodelService.checkKey(metadynamicmodelMapping.toDomain(metadynamicmodeldto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Init-all')")
    @ApiOperation(value = "初始化副本实例", tags = {"动态模型" },  notes = "初始化副本实例")
	@RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/{metadynamicmodel_id}/init")
    public ResponseEntity<MetaDynamicModelDTO> init(@PathVariable("metadynamicmodel_id") String metadynamicmodel_id, @RequestBody MetaDynamicModelDTO metadynamicmodeldto) {
        MetaDynamicModel domain = metadynamicmodelMapping.toDomain(metadynamicmodeldto);
        domain.setConfigid(metadynamicmodel_id);
        domain = metadynamicmodelService.init(domain);
        metadynamicmodeldto = metadynamicmodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(metadynamicmodeldto);
    }
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Init-all')")
    @ApiOperation(value = "批量处理[初始化副本实例]", tags = {"动态模型" },  notes = "批量处理[初始化副本实例]")
	@RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/initbatch")
    public ResponseEntity<Boolean> initBatch(@RequestBody List<MetaDynamicModelDTO> metadynamicmodeldtos) {
        List<MetaDynamicModel> domains = metadynamicmodelMapping.toDomain(metadynamicmodeldtos);
        boolean result = metadynamicmodelService.initBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Publish-all')")
    @ApiOperation(value = "发布模型", tags = {"动态模型" },  notes = "发布模型")
	@RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/{metadynamicmodel_id}/publish")
    public ResponseEntity<MetaDynamicModelDTO> publish(@PathVariable("metadynamicmodel_id") String metadynamicmodel_id, @RequestBody MetaDynamicModelDTO metadynamicmodeldto) {
        MetaDynamicModel domain = metadynamicmodelMapping.toDomain(metadynamicmodeldto);
        domain.setConfigid(metadynamicmodel_id);
        domain = metadynamicmodelService.publish(domain);
        metadynamicmodeldto = metadynamicmodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(metadynamicmodeldto);
    }
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Publish-all')")
    @ApiOperation(value = "批量处理[发布模型]", tags = {"动态模型" },  notes = "批量处理[发布模型]")
	@RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/publishbatch")
    public ResponseEntity<Boolean> publishBatch(@RequestBody List<MetaDynamicModelDTO> metadynamicmodeldtos) {
        List<MetaDynamicModel> domains = metadynamicmodelMapping.toDomain(metadynamicmodeldtos);
        boolean result = metadynamicmodelService.publishBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Save-all')")
    @ApiOperation(value = "保存动态模型", tags = {"动态模型" },  notes = "保存动态模型")
	@RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/save")
    public ResponseEntity<MetaDynamicModelDTO> save(@RequestBody MetaDynamicModelDTO metadynamicmodeldto) {
        MetaDynamicModel domain = metadynamicmodelMapping.toDomain(metadynamicmodeldto);
        metadynamicmodelService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(metadynamicmodelMapping.toDto(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-Save-all')")
    @ApiOperation(value = "批量保存动态模型", tags = {"动态模型" },  notes = "批量保存动态模型")
	@RequestMapping(method = RequestMethod.POST, value = "/metadynamicmodels/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MetaDynamicModelDTO> metadynamicmodeldtos) {
        metadynamicmodelService.saveBatch(metadynamicmodelMapping.toDomain(metadynamicmodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-searchDefault-all')")
	@ApiOperation(value = "获取数据集", tags = {"动态模型" } ,notes = "获取数据集")
    @RequestMapping(method= RequestMethod.GET , value="/metadynamicmodels/fetchdefault")
	public ResponseEntity<List<MetaDynamicModelDTO>> fetchDefault(MetaDynamicModelSearchContext context) {
        Page<MetaDynamicModel> domains = metadynamicmodelService.searchDefault(context) ;
        List<MetaDynamicModelDTO> list = metadynamicmodelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-searchDefault-all')")
	@ApiOperation(value = "查询数据集", tags = {"动态模型" } ,notes = "查询数据集")
    @RequestMapping(method= RequestMethod.POST , value="/metadynamicmodels/searchdefault")
	public ResponseEntity<Page<MetaDynamicModelDTO>> searchDefault(@RequestBody MetaDynamicModelSearchContext context) {
        Page<MetaDynamicModel> domains = metadynamicmodelService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(metadynamicmodelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-searchDynaInst-all')")
	@ApiOperation(value = "获取主实例数据查询", tags = {"动态模型" } ,notes = "获取主实例数据查询")
    @RequestMapping(method= RequestMethod.GET , value="/metadynamicmodels/fetchdynainst")
	public ResponseEntity<List<MetaDynamicModelDTO>> fetchDynaInst(MetaDynamicModelSearchContext context) {
        Page<MetaDynamicModel> domains = metadynamicmodelService.searchDynaInst(context) ;
        List<MetaDynamicModelDTO> list = metadynamicmodelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MetaDynamicModel-searchDynaInst-all')")
	@ApiOperation(value = "查询主实例数据查询", tags = {"动态模型" } ,notes = "查询主实例数据查询")
    @RequestMapping(method= RequestMethod.POST , value="/metadynamicmodels/searchdynainst")
	public ResponseEntity<Page<MetaDynamicModelDTO>> searchDynaInst(@RequestBody MetaDynamicModelSearchContext context) {
        Page<MetaDynamicModel> domains = metadynamicmodelService.searchDynaInst(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(metadynamicmodelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

