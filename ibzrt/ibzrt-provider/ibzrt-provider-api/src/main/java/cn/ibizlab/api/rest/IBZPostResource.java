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
import cn.ibizlab.core.ou.domain.IBZPost;
import cn.ibizlab.core.ou.service.IIBZPostService;
import cn.ibizlab.core.ou.filter.IBZPostSearchContext;

@Slf4j
@Api(tags = {"岗位" })
@RestController("api-ibzpost")
@RequestMapping("")
public class IBZPostResource {

    @Autowired
    public IIBZPostService ibzpostService;

    @Autowired
    @Lazy
    public IBZPostMapping ibzpostMapping;

    @ApiOperation(value = "获取岗位", tags = {"岗位" },  notes = "获取岗位")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzposts/{ibzpost_id}")
    public ResponseEntity<IBZPostDTO> get(@PathVariable("ibzpost_id") String ibzpost_id) {
        IBZPost domain = ibzpostService.get(ibzpost_id);
        IBZPostDTO dto = ibzpostMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "保存岗位", tags = {"岗位" },  notes = "保存岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzposts/save")
    public ResponseEntity<Boolean> save(@RequestBody IBZPostDTO ibzpostdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ibzpostService.save(ibzpostMapping.toDomain(ibzpostdto)));
    }

    @ApiOperation(value = "批量保存岗位", tags = {"岗位" },  notes = "批量保存岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzposts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<IBZPostDTO> ibzpostdtos) {
        ibzpostService.saveBatch(ibzpostMapping.toDomain(ibzpostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "更新岗位", tags = {"岗位" },  notes = "更新岗位")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzposts/{ibzpost_id}")

    public ResponseEntity<IBZPostDTO> update(@PathVariable("ibzpost_id") String ibzpost_id, @RequestBody IBZPostDTO ibzpostdto) {
		IBZPost domain  = ibzpostMapping.toDomain(ibzpostdto);
        domain .setPostid(ibzpost_id);
		ibzpostService.update(domain );
		IBZPostDTO dto = ibzpostMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新岗位", tags = {"岗位" },  notes = "批量更新岗位")
	@RequestMapping(method = RequestMethod.PUT, value = "/ibzposts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<IBZPostDTO> ibzpostdtos) {
        ibzpostService.updateBatch(ibzpostMapping.toDomain(ibzpostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查岗位", tags = {"岗位" },  notes = "检查岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzposts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody IBZPostDTO ibzpostdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ibzpostService.checkKey(ibzpostMapping.toDomain(ibzpostdto)));
    }

    @ApiOperation(value = "删除岗位", tags = {"岗位" },  notes = "删除岗位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzposts/{ibzpost_id}")

    public ResponseEntity<Boolean> remove(@PathVariable("ibzpost_id") String ibzpost_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ibzpostService.remove(ibzpost_id));
    }

    @ApiOperation(value = "批量删除岗位", tags = {"岗位" },  notes = "批量删除岗位")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ibzposts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ibzpostService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取岗位草稿", tags = {"岗位" },  notes = "获取岗位草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/ibzposts/getdraft")
    public ResponseEntity<IBZPostDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ibzpostMapping.toDto(ibzpostService.getDraft(new IBZPost())));
    }

    @ApiOperation(value = "新建岗位", tags = {"岗位" },  notes = "新建岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzposts")

    public ResponseEntity<IBZPostDTO> create(@RequestBody IBZPostDTO ibzpostdto) {
        IBZPost domain = ibzpostMapping.toDomain(ibzpostdto);
		ibzpostService.create(domain);
        IBZPostDTO dto = ibzpostMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建岗位", tags = {"岗位" },  notes = "批量新建岗位")
	@RequestMapping(method = RequestMethod.POST, value = "/ibzposts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<IBZPostDTO> ibzpostdtos) {
        ibzpostService.createBatch(ibzpostMapping.toDomain(ibzpostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZPost-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"岗位" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ibzposts/fetchdefault")
	public ResponseEntity<List<IBZPostDTO>> fetchDefault(IBZPostSearchContext context) {
        Page<IBZPost> domains = ibzpostService.searchDefault(context) ;
        List<IBZPostDTO> list = ibzpostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-IBZPost-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"岗位" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ibzposts/searchdefault")
	public ResponseEntity<Page<IBZPostDTO>> searchDefault(@RequestBody IBZPostSearchContext context) {
        Page<IBZPost> domains = ibzpostService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ibzpostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

