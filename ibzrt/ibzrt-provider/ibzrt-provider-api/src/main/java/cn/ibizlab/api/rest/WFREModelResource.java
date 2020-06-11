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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.api.dto.*;
import cn.ibizlab.api.mapping.*;
import cn.ibizlab.core.workflow.domain.WFREModel;
import cn.ibizlab.core.workflow.service.IWFREModelService;
import cn.ibizlab.core.workflow.filter.WFREModelSearchContext;

@Slf4j
@Api(tags = {"流程模型" })
@RestController("api-wfremodel")
@RequestMapping("")
public class WFREModelResource {

    @Autowired
    public IWFREModelService wfremodelService;

    @Autowired
    @Lazy
    public WFREModelMapping wfremodelMapping;

    @ApiOperation(value = "新建流程模型", tags = {"流程模型" },  notes = "新建流程模型")
	@RequestMapping(method = RequestMethod.POST, value = "/wfremodels")

    public ResponseEntity<WFREModelDTO> create(@RequestBody WFREModelDTO wfremodeldto) {
        WFREModel domain = wfremodelMapping.toDomain(wfremodeldto);
		wfremodelService.create(domain);
        WFREModelDTO dto = wfremodelMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建流程模型", tags = {"流程模型" },  notes = "批量新建流程模型")
	@RequestMapping(method = RequestMethod.POST, value = "/wfremodels/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFREModelDTO> wfremodeldtos) {
        wfremodelService.createBatch(wfremodelMapping.toDomain(wfremodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取流程模型", tags = {"流程模型" },  notes = "获取流程模型")
	@RequestMapping(method = RequestMethod.GET, value = "/wfremodels/{wfremodel_id}")
    public ResponseEntity<WFREModelDTO> get(@PathVariable("wfremodel_id") String wfremodel_id) {
        WFREModel domain = wfremodelService.get(wfremodel_id);
        WFREModelDTO dto = wfremodelMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "保存流程模型", tags = {"流程模型" },  notes = "保存流程模型")
	@RequestMapping(method = RequestMethod.POST, value = "/wfremodels/save")
    public ResponseEntity<Boolean> save(@RequestBody WFREModelDTO wfremodeldto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfremodelService.save(wfremodelMapping.toDomain(wfremodeldto)));
    }

    @ApiOperation(value = "批量保存流程模型", tags = {"流程模型" },  notes = "批量保存流程模型")
	@RequestMapping(method = RequestMethod.POST, value = "/wfremodels/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFREModelDTO> wfremodeldtos) {
        wfremodelService.saveBatch(wfremodelMapping.toDomain(wfremodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新流程模型", tags = {"流程模型" },  notes = "更新流程模型")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfremodels/{wfremodel_id}")

    public ResponseEntity<WFREModelDTO> update(@PathVariable("wfremodel_id") String wfremodel_id, @RequestBody WFREModelDTO wfremodeldto) {
		WFREModel domain  = wfremodelMapping.toDomain(wfremodeldto);
        domain .setId(wfremodel_id);
		wfremodelService.update(domain );
		WFREModelDTO dto = wfremodelMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新流程模型", tags = {"流程模型" },  notes = "批量更新流程模型")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfremodels/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFREModelDTO> wfremodeldtos) {
        wfremodelService.updateBatch(wfremodelMapping.toDomain(wfremodeldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取流程模型草稿", tags = {"流程模型" },  notes = "获取流程模型草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wfremodels/getdraft")
    public ResponseEntity<WFREModelDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfremodelMapping.toDto(wfremodelService.getDraft(new WFREModel())));
    }

    @ApiOperation(value = "删除流程模型", tags = {"流程模型" },  notes = "删除流程模型")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfremodels/{wfremodel_id}")

    public ResponseEntity<Boolean> remove(@PathVariable("wfremodel_id") String wfremodel_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfremodelService.remove(wfremodel_id));
    }

    @ApiOperation(value = "批量删除流程模型", tags = {"流程模型" },  notes = "批量删除流程模型")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfremodels/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfremodelService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查流程模型", tags = {"流程模型" },  notes = "检查流程模型")
	@RequestMapping(method = RequestMethod.POST, value = "/wfremodels/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFREModelDTO wfremodeldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfremodelService.checkKey(wfremodelMapping.toDomain(wfremodeldto)));
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"流程模型" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfremodels/fetchdefault")
	public ResponseEntity<List<WFREModelDTO>> fetchDefault(WFREModelSearchContext context) {
        Page<WFREModel> domains = wfremodelService.searchDefault(context) ;
        List<WFREModelDTO> list = wfremodelMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"流程模型" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfremodels/searchdefault")
	public ResponseEntity<Page<WFREModelDTO>> searchDefault(@RequestBody WFREModelSearchContext context) {
        Page<WFREModel> domains = wfremodelService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfremodelMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

