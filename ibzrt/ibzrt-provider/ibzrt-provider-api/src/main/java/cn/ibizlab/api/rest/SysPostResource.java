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
import cn.ibizlab.core.ou.domain.SysPost;
import cn.ibizlab.core.ou.service.ISysPostService;
import cn.ibizlab.core.ou.filter.SysPostSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"岗位" })
@RestController("api-syspost")
@RequestMapping("")
public class SysPostResource {

    @Autowired
    public ISysPostService syspostService;

    @Autowired
    @Lazy
    public SysPostMapping syspostMapping;

    @ApiOperation(value = "新建岗位", tags = {"岗位" },  notes = "新建岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/sysposts")
    public ResponseEntity<SysPostDTO> create(@Validated @RequestBody SysPostDTO syspostdto) {
        SysPost domain = syspostMapping.toDomain(syspostdto);
		syspostService.create(domain);
        SysPostDTO dto = syspostMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建岗位", tags = {"岗位" },  notes = "批量新建岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/sysposts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SysPostDTO> syspostdtos) {
        syspostService.createBatch(syspostMapping.toDomain(syspostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新岗位", tags = {"岗位" },  notes = "更新岗位")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysposts/{syspost_id}")
    public ResponseEntity<SysPostDTO> update(@PathVariable("syspost_id") String syspost_id, @RequestBody SysPostDTO syspostdto) {
		SysPost domain  = syspostMapping.toDomain(syspostdto);
        domain .setPostid(syspost_id);
		syspostService.update(domain );
		SysPostDTO dto = syspostMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新岗位", tags = {"岗位" },  notes = "批量更新岗位")
	@RequestMapping(method = RequestMethod.PUT, value = "/sysposts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SysPostDTO> syspostdtos) {
        syspostService.updateBatch(syspostMapping.toDomain(syspostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "删除岗位", tags = {"岗位" },  notes = "删除岗位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysposts/{syspost_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("syspost_id") String syspost_id) {
         return ResponseEntity.status(HttpStatus.OK).body(syspostService.remove(syspost_id));
    }

    @ApiOperation(value = "批量删除岗位", tags = {"岗位" },  notes = "批量删除岗位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sysposts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        syspostService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取岗位", tags = {"岗位" },  notes = "获取岗位")
	@RequestMapping(method = RequestMethod.GET, value = "/sysposts/{syspost_id}")
    public ResponseEntity<SysPostDTO> get(@PathVariable("syspost_id") String syspost_id) {
        SysPost domain = syspostService.get(syspost_id);
        SysPostDTO dto = syspostMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取岗位草稿", tags = {"岗位" },  notes = "获取岗位草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sysposts/getdraft")
    public ResponseEntity<SysPostDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(syspostMapping.toDto(syspostService.getDraft(new SysPost())));
    }

    @ApiOperation(value = "检查岗位", tags = {"岗位" },  notes = "检查岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/sysposts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SysPostDTO syspostdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(syspostService.checkKey(syspostMapping.toDomain(syspostdto)));
    }

    @ApiOperation(value = "保存岗位", tags = {"岗位" },  notes = "保存岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/sysposts/save")
    public ResponseEntity<Boolean> save(@RequestBody SysPostDTO syspostdto) {
        return ResponseEntity.status(HttpStatus.OK).body(syspostService.save(syspostMapping.toDomain(syspostdto)));
    }

    @ApiOperation(value = "批量保存岗位", tags = {"岗位" },  notes = "批量保存岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/sysposts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SysPostDTO> syspostdtos) {
        syspostService.saveBatch(syspostMapping.toDomain(syspostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"岗位" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sysposts/fetchdefault")
	public ResponseEntity<List<SysPostDTO>> fetchDefault(SysPostSearchContext context) {
        Page<SysPost> domains = syspostService.searchDefault(context) ;
        List<SysPostDTO> list = syspostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"岗位" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sysposts/searchdefault")
	public ResponseEntity<Page<SysPostDTO>> searchDefault(@RequestBody SysPostSearchContext context) {
        Page<SysPost> domains = syspostService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(syspostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}

