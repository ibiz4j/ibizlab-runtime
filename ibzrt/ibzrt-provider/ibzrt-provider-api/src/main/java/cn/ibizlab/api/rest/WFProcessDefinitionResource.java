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
import cn.ibizlab.core.workflow.domain.WFProcessDefinition;
import cn.ibizlab.core.workflow.service.IWFProcessDefinitionService;
import cn.ibizlab.core.workflow.filter.WFProcessDefinitionSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"流程定义" })
@RestController("api-wfprocessdefinition")
@RequestMapping("")
public class WFProcessDefinitionResource {

    @Autowired
    public IWFProcessDefinitionService wfprocessdefinitionService;

    @Autowired
    @Lazy
    public WFProcessDefinitionMapping wfprocessdefinitionMapping;

    @ApiOperation(value = "新建流程定义", tags = {"流程定义" },  notes = "新建流程定义")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions")

    public ResponseEntity<WFProcessDefinitionDTO> create(@RequestBody WFProcessDefinitionDTO wfprocessdefinitiondto) {
        WFProcessDefinition domain = wfprocessdefinitionMapping.toDomain(wfprocessdefinitiondto);
		wfprocessdefinitionService.create(domain);
        WFProcessDefinitionDTO dto = wfprocessdefinitionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建流程定义", tags = {"流程定义" },  notes = "批量新建流程定义")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFProcessDefinitionDTO> wfprocessdefinitiondtos) {
        wfprocessdefinitionService.createBatch(wfprocessdefinitionMapping.toDomain(wfprocessdefinitiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新流程定义", tags = {"流程定义" },  notes = "更新流程定义")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfprocessdefinitions/{wfprocessdefinition_id}")

    public ResponseEntity<WFProcessDefinitionDTO> update(@PathVariable("wfprocessdefinition_id") String wfprocessdefinition_id, @RequestBody WFProcessDefinitionDTO wfprocessdefinitiondto) {
		WFProcessDefinition domain  = wfprocessdefinitionMapping.toDomain(wfprocessdefinitiondto);
        domain .setDefinitionkey(wfprocessdefinition_id);
		wfprocessdefinitionService.update(domain );
		WFProcessDefinitionDTO dto = wfprocessdefinitionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新流程定义", tags = {"流程定义" },  notes = "批量更新流程定义")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfprocessdefinitions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFProcessDefinitionDTO> wfprocessdefinitiondtos) {
        wfprocessdefinitionService.updateBatch(wfprocessdefinitionMapping.toDomain(wfprocessdefinitiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "删除流程定义", tags = {"流程定义" },  notes = "删除流程定义")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessdefinitions/{wfprocessdefinition_id}")

    public ResponseEntity<Boolean> remove(@PathVariable("wfprocessdefinition_id") String wfprocessdefinition_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfprocessdefinitionService.remove(wfprocessdefinition_id));
    }

    @ApiOperation(value = "批量删除流程定义", tags = {"流程定义" },  notes = "批量删除流程定义")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessdefinitions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfprocessdefinitionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取流程定义", tags = {"流程定义" },  notes = "获取流程定义")
	@RequestMapping(method = RequestMethod.GET, value = "/wfprocessdefinitions/{wfprocessdefinition_id}")
    public ResponseEntity<WFProcessDefinitionDTO> get(@PathVariable("wfprocessdefinition_id") String wfprocessdefinition_id) {
        WFProcessDefinition domain = wfprocessdefinitionService.get(wfprocessdefinition_id);
        WFProcessDefinitionDTO dto = wfprocessdefinitionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取流程定义草稿", tags = {"流程定义" },  notes = "获取流程定义草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wfprocessdefinitions/getdraft")
    public ResponseEntity<WFProcessDefinitionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfprocessdefinitionMapping.toDto(wfprocessdefinitionService.getDraft(new WFProcessDefinition())));
    }

    @ApiOperation(value = "检查流程定义", tags = {"流程定义" },  notes = "检查流程定义")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFProcessDefinitionDTO wfprocessdefinitiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfprocessdefinitionService.checkKey(wfprocessdefinitionMapping.toDomain(wfprocessdefinitiondto)));
    }

    @ApiOperation(value = "保存流程定义", tags = {"流程定义" },  notes = "保存流程定义")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions/save")
    public ResponseEntity<Boolean> save(@RequestBody WFProcessDefinitionDTO wfprocessdefinitiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfprocessdefinitionService.save(wfprocessdefinitionMapping.toDomain(wfprocessdefinitiondto)));
    }

    @ApiOperation(value = "批量保存流程定义", tags = {"流程定义" },  notes = "批量保存流程定义")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessdefinitions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFProcessDefinitionDTO> wfprocessdefinitiondtos) {
        wfprocessdefinitionService.saveBatch(wfprocessdefinitionMapping.toDomain(wfprocessdefinitiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"流程定义" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfprocessdefinitions/fetchdefault")
	public ResponseEntity<List<WFProcessDefinitionDTO>> fetchDefault(WFProcessDefinitionSearchContext context) {
        Page<WFProcessDefinition> domains = wfprocessdefinitionService.searchDefault(context) ;
        List<WFProcessDefinitionDTO> list = wfprocessdefinitionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"流程定义" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfprocessdefinitions/searchdefault")
	public ResponseEntity<Page<WFProcessDefinitionDTO>> searchDefault(@RequestBody WFProcessDefinitionSearchContext context) {
        Page<WFProcessDefinition> domains = wfprocessdefinitionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfprocessdefinitionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

