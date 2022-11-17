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
import cn.ibizlab.core.workflow.domain.WFProcessNode;
import cn.ibizlab.core.workflow.service.IWFProcessNodeService;
import cn.ibizlab.core.workflow.filter.WFProcessNodeSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"流程定义节点" })
@RestController("api-wfprocessnode")
@RequestMapping("")
public class WFProcessNodeResource {

    @Autowired
    public IWFProcessNodeService wfprocessnodeService;

    @Autowired
    @Lazy
    public WFProcessNodeMapping wfprocessnodeMapping;

    @ApiOperation(value = "新建流程定义节点", tags = {"流程定义节点" },  notes = "新建流程定义节点")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes")
    public ResponseEntity<WFProcessNodeDTO> create(@Validated @RequestBody WFProcessNodeDTO wfprocessnodedto) {
        WFProcessNode domain = wfprocessnodeMapping.toDomain(wfprocessnodedto);
		wfprocessnodeService.create(domain);
        WFProcessNodeDTO dto = wfprocessnodeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建流程定义节点", tags = {"流程定义节点" },  notes = "批量新建流程定义节点")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFProcessNodeDTO> wfprocessnodedtos) {
        wfprocessnodeService.createBatch(wfprocessnodeMapping.toDomain(wfprocessnodedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取流程定义节点", tags = {"流程定义节点" },  notes = "获取流程定义节点")
	@RequestMapping(method = RequestMethod.GET, value = "/wfprocessnodes/{wfprocessnode_id}")
    public ResponseEntity<WFProcessNodeDTO> get(@PathVariable("wfprocessnode_id") String wfprocessnode_id) {
        WFProcessNode domain = wfprocessnodeService.get(wfprocessnode_id);
        WFProcessNodeDTO dto = wfprocessnodeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "删除流程定义节点", tags = {"流程定义节点" },  notes = "删除流程定义节点")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessnodes/{wfprocessnode_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("wfprocessnode_id") String wfprocessnode_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfprocessnodeService.remove(wfprocessnode_id));
    }

    @ApiOperation(value = "批量删除流程定义节点", tags = {"流程定义节点" },  notes = "批量删除流程定义节点")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfprocessnodes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfprocessnodeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新流程定义节点", tags = {"流程定义节点" },  notes = "更新流程定义节点")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfprocessnodes/{wfprocessnode_id}")
    public ResponseEntity<WFProcessNodeDTO> update(@PathVariable("wfprocessnode_id") String wfprocessnode_id, @RequestBody WFProcessNodeDTO wfprocessnodedto) {
		WFProcessNode domain  = wfprocessnodeMapping.toDomain(wfprocessnodedto);
        domain .setUsertaskid(wfprocessnode_id);
		wfprocessnodeService.update(domain );
		WFProcessNodeDTO dto = wfprocessnodeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新流程定义节点", tags = {"流程定义节点" },  notes = "批量更新流程定义节点")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfprocessnodes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFProcessNodeDTO> wfprocessnodedtos) {
        wfprocessnodeService.updateBatch(wfprocessnodeMapping.toDomain(wfprocessnodedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查流程定义节点", tags = {"流程定义节点" },  notes = "检查流程定义节点")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFProcessNodeDTO wfprocessnodedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfprocessnodeService.checkKey(wfprocessnodeMapping.toDomain(wfprocessnodedto)));
    }

    @ApiOperation(value = "获取流程定义节点草稿", tags = {"流程定义节点" },  notes = "获取流程定义节点草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wfprocessnodes/getdraft")
    public ResponseEntity<WFProcessNodeDTO> getDraft(WFProcessNodeDTO dto) {
        WFProcessNode domain = wfprocessnodeMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(wfprocessnodeMapping.toDto(wfprocessnodeService.getDraft(domain)));
    }

    @ApiOperation(value = "保存流程定义节点", tags = {"流程定义节点" },  notes = "保存流程定义节点")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes/save")
    public ResponseEntity<WFProcessNodeDTO> save(@RequestBody WFProcessNodeDTO wfprocessnodedto) {
        WFProcessNode domain = wfprocessnodeMapping.toDomain(wfprocessnodedto);
        wfprocessnodeService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(wfprocessnodeMapping.toDto(domain));
    }

    @ApiOperation(value = "批量保存流程定义节点", tags = {"流程定义节点" },  notes = "批量保存流程定义节点")
	@RequestMapping(method = RequestMethod.POST, value = "/wfprocessnodes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFProcessNodeDTO> wfprocessnodedtos) {
        wfprocessnodeService.saveBatch(wfprocessnodeMapping.toDomain(wfprocessnodedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"流程定义节点" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfprocessnodes/fetchdefault")
	public ResponseEntity<List<WFProcessNodeDTO>> fetchDefault(WFProcessNodeSearchContext context) {
        Page<WFProcessNode> domains = wfprocessnodeService.searchDefault(context) ;
        List<WFProcessNodeDTO> list = wfprocessnodeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"流程定义节点" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfprocessnodes/searchdefault")
	public ResponseEntity<Page<WFProcessNodeDTO>> searchDefault(@RequestBody WFProcessNodeSearchContext context) {
        Page<WFProcessNode> domains = wfprocessnodeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfprocessnodeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "获取查询当前实例流程节点", tags = {"流程定义节点" } ,notes = "获取查询当前实例流程节点")
    @RequestMapping(method= RequestMethod.GET , value="/wfprocessnodes/fetchprocessnode")
	public ResponseEntity<List<WFProcessNodeDTO>> fetchProcessNode(WFProcessNodeSearchContext context) {
        Page<WFProcessNode> domains = wfprocessnodeService.searchProcessNode(context) ;
        List<WFProcessNodeDTO> list = wfprocessnodeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询查询当前实例流程节点", tags = {"流程定义节点" } ,notes = "查询查询当前实例流程节点")
    @RequestMapping(method= RequestMethod.POST , value="/wfprocessnodes/searchprocessnode")
	public ResponseEntity<Page<WFProcessNodeDTO>> searchProcessNode(@RequestBody WFProcessNodeSearchContext context) {
        Page<WFProcessNode> domains = wfprocessnodeService.searchProcessNode(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfprocessnodeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

