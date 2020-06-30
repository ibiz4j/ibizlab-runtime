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
import cn.ibizlab.core.workflow.domain.WFUser;
import cn.ibizlab.core.workflow.service.IWFUserService;
import cn.ibizlab.core.workflow.filter.WFUserSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"用户" })
@RestController("api-wfuser")
@RequestMapping("")
public class WFUserResource {

    @Autowired
    public IWFUserService wfuserService;

    @Autowired
    @Lazy
    public WFUserMapping wfuserMapping;

    @ApiOperation(value = "更新用户", tags = {"用户" },  notes = "更新用户")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusers/{wfuser_id}")

    public ResponseEntity<WFUserDTO> update(@PathVariable("wfuser_id") String wfuser_id, @RequestBody WFUserDTO wfuserdto) {
		WFUser domain  = wfuserMapping.toDomain(wfuserdto);
        domain .setId(wfuser_id);
		wfuserService.update(domain );
		WFUserDTO dto = wfuserMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新用户", tags = {"用户" },  notes = "批量更新用户")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfusers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFUserDTO> wfuserdtos) {
        wfuserService.updateBatch(wfuserMapping.toDomain(wfuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取用户草稿", tags = {"用户" },  notes = "获取用户草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusers/getdraft")
    public ResponseEntity<WFUserDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfuserMapping.toDto(wfuserService.getDraft(new WFUser())));
    }

    @ApiOperation(value = "获取用户", tags = {"用户" },  notes = "获取用户")
	@RequestMapping(method = RequestMethod.GET, value = "/wfusers/{wfuser_id}")
    public ResponseEntity<WFUserDTO> get(@PathVariable("wfuser_id") String wfuser_id) {
        WFUser domain = wfuserService.get(wfuser_id);
        WFUserDTO dto = wfuserMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "新建用户", tags = {"用户" },  notes = "新建用户")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers")

    public ResponseEntity<WFUserDTO> create(@RequestBody WFUserDTO wfuserdto) {
        WFUser domain = wfuserMapping.toDomain(wfuserdto);
		wfuserService.create(domain);
        WFUserDTO dto = wfuserMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建用户", tags = {"用户" },  notes = "批量新建用户")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFUserDTO> wfuserdtos) {
        wfuserService.createBatch(wfuserMapping.toDomain(wfuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查用户", tags = {"用户" },  notes = "检查用户")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFUserDTO wfuserdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfuserService.checkKey(wfuserMapping.toDomain(wfuserdto)));
    }

    @ApiOperation(value = "保存用户", tags = {"用户" },  notes = "保存用户")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/save")
    public ResponseEntity<Boolean> save(@RequestBody WFUserDTO wfuserdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfuserService.save(wfuserMapping.toDomain(wfuserdto)));
    }

    @ApiOperation(value = "批量保存用户", tags = {"用户" },  notes = "批量保存用户")
	@RequestMapping(method = RequestMethod.POST, value = "/wfusers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFUserDTO> wfuserdtos) {
        wfuserService.saveBatch(wfuserMapping.toDomain(wfuserdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "删除用户", tags = {"用户" },  notes = "删除用户")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusers/{wfuser_id}")

    public ResponseEntity<Boolean> remove(@PathVariable("wfuser_id") String wfuser_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfuserService.remove(wfuser_id));
    }

    @ApiOperation(value = "批量删除用户", tags = {"用户" },  notes = "批量删除用户")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfusers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfuserService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFUser-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"用户" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/wfusers/fetchdefault")
	public ResponseEntity<List<WFUserDTO>> fetchDefault(WFUserSearchContext context) {
        Page<WFUser> domains = wfuserService.searchDefault(context) ;
        List<WFUserDTO> list = wfuserMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-WFUser-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"用户" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/wfusers/searchdefault")
	public ResponseEntity<Page<WFUserDTO>> searchDefault(@RequestBody WFUserSearchContext context) {
        Page<WFUser> domains = wfuserService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfuserMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

