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
import cn.ibizlab.core.workflow.domain.WFProcessInstance;
import cn.ibizlab.core.workflow.service.IWFProcessInstanceService;
import cn.ibizlab.core.workflow.filter.WFProcessInstanceSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"流程实例" })
@RestController("api-wfprocessinstance")
@RequestMapping("")
public class WFProcessInstanceResource {

    @Autowired
    public IWFProcessInstanceService wfprocessinstanceService;

    @Autowired
    @Lazy
    public WFProcessInstanceMapping wfprocessinstanceMapping;

    @ApiOperation(value = "新建流程实例", tags = {"流程实例" },  notes = "新建流程实例")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances")
    public ResponseEntity<WFProcessInstanceDTO> create(@Validated @RequestBody WFProcessInstanceDTO wfprocessinstancedto) {
        WFProcessInstance domain = wfprocessinstanceMapping.toDomain(wfprocessinstancedto);
		wfprocessinstanceService.create(domain);
        WFProcessInstanceDTO dto = wfprocessinstanceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建流程实例", tags = {"流程实例" },  notes = "批量新建流程实例")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFProcessInstanceDTO> wfprocessinstancedtos) {
        wfprocessinstanceService.createBatch(wfprocessinstanceMapping.toDomain(wfprocessinstancedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取流程实例", tags = {"流程实例" },  notes = "获取流程实例")
	@RequestMapping(method = RequestMethod.GET, value = "/wfprocessinstances/{wfprocessinstance_id}")
    public ResponseEntity<WFProcessInstanceDTO> get(@PathVariable("wfprocessinstance_id") String wfprocessinstance_id) {
        WFProcessInstance domain = wfprocessinstanceService.get(wfprocessinstance_id);
        WFProcessInstanceDTO dto = wfprocessinstanceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "删除流程实例", tags = {"流程实例" },  notes = "删除流程实例")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessinstances/{wfprocessinstance_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("wfprocessinstance_id") String wfprocessinstance_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfprocessinstanceService.remove(wfprocessinstance_id));
    }

    @ApiOperation(value = "批量删除流程实例", tags = {"流程实例" },  notes = "批量删除流程实例")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessinstances/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfprocessinstanceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新流程实例", tags = {"流程实例" },  notes = "更新流程实例")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfprocessinstances/{wfprocessinstance_id}")
    public ResponseEntity<WFProcessInstanceDTO> update(@PathVariable("wfprocessinstance_id") String wfprocessinstance_id, @RequestBody WFProcessInstanceDTO wfprocessinstancedto) {
		WFProcessInstance domain  = wfprocessinstanceMapping.toDomain(wfprocessinstancedto);
        domain .setId(wfprocessinstance_id);
		wfprocessinstanceService.update(domain );
		WFProcessInstanceDTO dto = wfprocessinstanceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新流程实例", tags = {"流程实例" },  notes = "批量更新流程实例")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfprocessinstances/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFProcessInstanceDTO> wfprocessinstancedtos) {
        wfprocessinstanceService.updateBatch(wfprocessinstanceMapping.toDomain(wfprocessinstancedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查流程实例", tags = {"流程实例" },  notes = "检查流程实例")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFProcessInstanceDTO wfprocessinstancedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfprocessinstanceService.checkKey(wfprocessinstanceMapping.toDomain(wfprocessinstancedto)));
    }

    @ApiOperation(value = "获取流程实例草稿", tags = {"流程实例" },  notes = "获取流程实例草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wfprocessinstances/getdraft")
    public ResponseEntity<WFProcessInstanceDTO> getDraft(WFProcessInstanceDTO dto) {
        WFProcessInstance domain = wfprocessinstanceMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(wfprocessinstanceMapping.toDto(wfprocessinstanceService.getDraft(domain)));
    }

    @ApiOperation(value = "流程跳转", tags = {"流程实例" },  notes = "流程跳转")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/{wfprocessinstance_id}/jump")
    public ResponseEntity<WFProcessInstanceDTO> jump(@PathVariable("wfprocessinstance_id") String wfprocessinstance_id, @RequestBody WFProcessInstanceDTO wfprocessinstancedto) {
        WFProcessInstance domain = wfprocessinstanceMapping.toDomain(wfprocessinstancedto);
        domain.setId(wfprocessinstance_id);
        domain = wfprocessinstanceService.jump(domain);
        wfprocessinstancedto = wfprocessinstanceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(wfprocessinstancedto);
    }
    @ApiOperation(value = "批量处理[流程跳转]", tags = {"流程实例" },  notes = "批量处理[流程跳转]")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/jumpbatch")
    public ResponseEntity<Boolean> jumpBatch(@RequestBody List<WFProcessInstanceDTO> wfprocessinstancedtos) {
        List<WFProcessInstance> domains = wfprocessinstanceMapping.toDomain(wfprocessinstancedtos);
        boolean result = wfprocessinstanceService.jumpBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "重启流程", tags = {"流程实例" },  notes = "重启流程")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/{wfprocessinstance_id}/restart")
    public ResponseEntity<WFProcessInstanceDTO> restart(@PathVariable("wfprocessinstance_id") String wfprocessinstance_id, @RequestBody WFProcessInstanceDTO wfprocessinstancedto) {
        WFProcessInstance domain = wfprocessinstanceMapping.toDomain(wfprocessinstancedto);
        domain.setId(wfprocessinstance_id);
        domain = wfprocessinstanceService.restart(domain);
        wfprocessinstancedto = wfprocessinstanceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(wfprocessinstancedto);
    }
    @ApiOperation(value = "批量处理[重启流程]", tags = {"流程实例" },  notes = "批量处理[重启流程]")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/restartbatch")
    public ResponseEntity<Boolean> restartBatch(@RequestBody List<WFProcessInstanceDTO> wfprocessinstancedtos) {
        List<WFProcessInstance> domains = wfprocessinstanceMapping.toDomain(wfprocessinstancedtos);
        boolean result = wfprocessinstanceService.restartBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @ApiOperation(value = "保存流程实例", tags = {"流程实例" },  notes = "保存流程实例")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/save")
    public ResponseEntity<WFProcessInstanceDTO> save(@RequestBody WFProcessInstanceDTO wfprocessinstancedto) {
        WFProcessInstance domain = wfprocessinstanceMapping.toDomain(wfprocessinstancedto);
        wfprocessinstanceService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(wfprocessinstanceMapping.toDto(domain));
    }

    @ApiOperation(value = "批量保存流程实例", tags = {"流程实例" },  notes = "批量保存流程实例")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessinstances/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFProcessInstanceDTO> wfprocessinstancedtos) {
        wfprocessinstanceService.saveBatch(wfprocessinstanceMapping.toDomain(wfprocessinstancedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取流程中实例", tags = {"流程实例" } ,notes = "获取流程中实例")
    @RequestMapping(method= RequestMethod.GET , value="/wfprocessinstances/fetchactiveprocessinstance")
	public ResponseEntity<List<WFProcessInstanceDTO>> fetchActiveProcessInstance(WFProcessInstanceSearchContext context) {
        Page<WFProcessInstance> domains = wfprocessinstanceService.searchActiveProcessInstance(context) ;
        List<WFProcessInstanceDTO> list = wfprocessinstanceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询流程中实例", tags = {"流程实例" } ,notes = "查询流程中实例")
    @RequestMapping(method= RequestMethod.POST , value="/wfprocessinstances/searchactiveprocessinstance")
	public ResponseEntity<Page<WFProcessInstanceDTO>> searchActiveProcessInstance(@RequestBody WFProcessInstanceSearchContext context) {
        Page<WFProcessInstance> domains = wfprocessinstanceService.searchActiveProcessInstance(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfprocessinstanceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "获取DEFAULT", tags = {"流程实例" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfprocessinstances/fetchdefault")
	public ResponseEntity<List<WFProcessInstanceDTO>> fetchDefault(WFProcessInstanceSearchContext context) {
        Page<WFProcessInstance> domains = wfprocessinstanceService.searchDefault(context) ;
        List<WFProcessInstanceDTO> list = wfprocessinstanceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"流程实例" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfprocessinstances/searchdefault")
	public ResponseEntity<Page<WFProcessInstanceDTO>> searchDefault(@RequestBody WFProcessInstanceSearchContext context) {
        Page<WFProcessInstance> domains = wfprocessinstanceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfprocessinstanceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

