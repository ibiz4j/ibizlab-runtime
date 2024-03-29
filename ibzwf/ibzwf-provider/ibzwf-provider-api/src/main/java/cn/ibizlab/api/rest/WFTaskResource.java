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
import cn.ibizlab.core.workflow.domain.WFTask;
import cn.ibizlab.core.workflow.service.IWFTaskService;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"工作流任务" })
@RestController("api-wftask")
@RequestMapping("")
public class WFTaskResource {

    @Autowired
    public IWFTaskService wftaskService;

    @Autowired
    @Lazy
    public WFTaskMapping wftaskMapping;

    @ApiOperation(value = "新建工作流任务", tags = {"工作流任务" },  notes = "新建工作流任务")
	@RequestMapping(method = RequestMethod.POST, value = "/wftasks")
    public ResponseEntity<WFTaskDTO> create(@Validated @RequestBody WFTaskDTO wftaskdto) {
        WFTask domain = wftaskMapping.toDomain(wftaskdto);
		wftaskService.create(domain);
        WFTaskDTO dto = wftaskMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建工作流任务", tags = {"工作流任务" },  notes = "批量新建工作流任务")
	@RequestMapping(method = RequestMethod.POST, value = "/wftasks/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFTaskDTO> wftaskdtos) {
        wftaskService.createBatch(wftaskMapping.toDomain(wftaskdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取工作流任务", tags = {"工作流任务" },  notes = "获取工作流任务")
	@RequestMapping(method = RequestMethod.GET, value = "/wftasks/{wftask_id}")
    public ResponseEntity<WFTaskDTO> get(@PathVariable("wftask_id") String wftask_id) {
        WFTask domain = wftaskService.get(wftask_id);
        WFTaskDTO dto = wftaskMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "删除工作流任务", tags = {"工作流任务" },  notes = "删除工作流任务")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wftasks/{wftask_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("wftask_id") String wftask_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wftaskService.remove(wftask_id));
    }

    @ApiOperation(value = "批量删除工作流任务", tags = {"工作流任务" },  notes = "批量删除工作流任务")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wftasks/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wftaskService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新工作流任务", tags = {"工作流任务" },  notes = "更新工作流任务")
	@RequestMapping(method = RequestMethod.PUT, value = "/wftasks/{wftask_id}")
    public ResponseEntity<WFTaskDTO> update(@PathVariable("wftask_id") String wftask_id, @RequestBody WFTaskDTO wftaskdto) {
		WFTask domain  = wftaskMapping.toDomain(wftaskdto);
        domain .setId(wftask_id);
		wftaskService.update(domain );
		WFTaskDTO dto = wftaskMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新工作流任务", tags = {"工作流任务" },  notes = "批量更新工作流任务")
	@RequestMapping(method = RequestMethod.PUT, value = "/wftasks/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFTaskDTO> wftaskdtos) {
        wftaskService.updateBatch(wftaskMapping.toDomain(wftaskdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查工作流任务", tags = {"工作流任务" },  notes = "检查工作流任务")
	@RequestMapping(method = RequestMethod.POST, value = "/wftasks/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFTaskDTO wftaskdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wftaskService.checkKey(wftaskMapping.toDomain(wftaskdto)));
    }

    @ApiOperation(value = "获取工作流任务草稿", tags = {"工作流任务" },  notes = "获取工作流任务草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wftasks/getdraft")
    public ResponseEntity<WFTaskDTO> getDraft(WFTaskDTO dto) {
        WFTask domain = wftaskMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(wftaskMapping.toDto(wftaskService.getDraft(domain)));
    }

    @ApiOperation(value = "保存工作流任务", tags = {"工作流任务" },  notes = "保存工作流任务")
	@RequestMapping(method = RequestMethod.POST, value = "/wftasks/save")
    public ResponseEntity<WFTaskDTO> save(@RequestBody WFTaskDTO wftaskdto) {
        WFTask domain = wftaskMapping.toDomain(wftaskdto);
        wftaskService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(wftaskMapping.toDto(domain));
    }

    @ApiOperation(value = "批量保存工作流任务", tags = {"工作流任务" },  notes = "批量保存工作流任务")
	@RequestMapping(method = RequestMethod.POST, value = "/wftasks/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFTaskDTO> wftaskdtos) {
        wftaskService.saveBatch(wftaskMapping.toDomain(wftaskdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "用户自定义", tags = {"工作流任务" },  notes = "用户自定义")
	@RequestMapping(method = RequestMethod.POST, value = "/wftasks/{wftask_id}/usercustom")
    public ResponseEntity<WFTaskDTO> userCustom(@PathVariable("wftask_id") String wftask_id, @RequestBody WFTaskDTO wftaskdto) {
        WFTask domain = wftaskMapping.toDomain(wftaskdto);
        domain.setId(wftask_id);
        domain = wftaskService.userCustom(domain);
        wftaskdto = wftaskMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(wftaskdto);
    }
    @ApiOperation(value = "批量处理[用户自定义]", tags = {"工作流任务" },  notes = "批量处理[用户自定义]")
	@RequestMapping(method = RequestMethod.POST, value = "/wftasks/usercustombatch")
    public ResponseEntity<Boolean> userCustomBatch(@RequestBody List<WFTaskDTO> wftaskdtos) {
        List<WFTask> domains = wftaskMapping.toDomain(wftaskdtos);
        boolean result = wftaskService.userCustomBatch(domains);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"工作流任务" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wftasks/fetchdefault")
	public ResponseEntity<List<WFTaskDTO>> fetchDefault(WFTaskSearchContext context) {
        Page<WFTask> domains = wftaskService.searchDefault(context) ;
        List<WFTaskDTO> list = wftaskMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"工作流任务" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wftasks/searchdefault")
	public ResponseEntity<Page<WFTaskDTO>> searchDefault(@RequestBody WFTaskSearchContext context) {
        Page<WFTask> domains = wftaskService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wftaskMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "获取已办任务", tags = {"工作流任务" } ,notes = "获取已办任务")
    @RequestMapping(method= RequestMethod.GET , value="/wftasks/fetchdonetask")
	public ResponseEntity<List<WFTaskDTO>> fetchDoneTask(WFTaskSearchContext context) {
        Page<WFTask> domains = wftaskService.searchDoneTask(context) ;
        List<WFTaskDTO> list = wftaskMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询已办任务", tags = {"工作流任务" } ,notes = "查询已办任务")
    @RequestMapping(method= RequestMethod.POST , value="/wftasks/searchdonetask")
	public ResponseEntity<Page<WFTaskDTO>> searchDoneTask(@RequestBody WFTaskSearchContext context) {
        Page<WFTask> domains = wftaskService.searchDoneTask(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wftaskMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "获取办结任务", tags = {"工作流任务" } ,notes = "获取办结任务")
    @RequestMapping(method= RequestMethod.GET , value="/wftasks/fetchfinishtask")
	public ResponseEntity<List<WFTaskDTO>> fetchFinishTask(WFTaskSearchContext context) {
        Page<WFTask> domains = wftaskService.searchFinishTask(context) ;
        List<WFTaskDTO> list = wftaskMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询办结任务", tags = {"工作流任务" } ,notes = "查询办结任务")
    @RequestMapping(method= RequestMethod.POST , value="/wftasks/searchfinishtask")
	public ResponseEntity<Page<WFTaskDTO>> searchFinishTask(@RequestBody WFTaskSearchContext context) {
        Page<WFTask> domains = wftaskService.searchFinishTask(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wftaskMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "获取待办任务", tags = {"工作流任务" } ,notes = "获取待办任务")
    @RequestMapping(method= RequestMethod.GET , value="/wftasks/fetchtodotask")
	public ResponseEntity<List<WFTaskDTO>> fetchTodoTask(WFTaskSearchContext context) {
        Page<WFTask> domains = wftaskService.searchTodoTask(context) ;
        List<WFTaskDTO> list = wftaskMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询待办任务", tags = {"工作流任务" } ,notes = "查询待办任务")
    @RequestMapping(method= RequestMethod.POST , value="/wftasks/searchtodotask")
	public ResponseEntity<Page<WFTaskDTO>> searchTodoTask(@RequestBody WFTaskSearchContext context) {
        Page<WFTask> domains = wftaskService.searchTodoTask(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wftaskMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "获取待阅任务", tags = {"工作流任务" } ,notes = "获取待阅任务")
    @RequestMapping(method= RequestMethod.GET , value="/wftasks/fetchtoreadtask")
	public ResponseEntity<List<WFTaskDTO>> fetchToreadTask(WFTaskSearchContext context) {
        Page<WFTask> domains = wftaskService.searchToreadTask(context) ;
        List<WFTaskDTO> list = wftaskMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询待阅任务", tags = {"工作流任务" } ,notes = "查询待阅任务")
    @RequestMapping(method= RequestMethod.POST , value="/wftasks/searchtoreadtask")
	public ResponseEntity<Page<WFTaskDTO>> searchToreadTask(@RequestBody WFTaskSearchContext context) {
        Page<WFTask> domains = wftaskService.searchToreadTask(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wftaskMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

