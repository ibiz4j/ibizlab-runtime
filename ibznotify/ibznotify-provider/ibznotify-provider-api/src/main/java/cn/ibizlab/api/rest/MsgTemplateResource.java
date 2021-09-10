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
import cn.ibizlab.core.notify.domain.MsgTemplate;
import cn.ibizlab.core.notify.service.IMsgTemplateService;
import cn.ibizlab.core.notify.filter.MsgTemplateSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"消息模板" })
@RestController("api-msgtemplate")
@RequestMapping("")
public class MsgTemplateResource {

    @Autowired
    public IMsgTemplateService msgtemplateService;

    @Autowired
    @Lazy
    public MsgTemplateMapping msgtemplateMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-Create-all')")
    @ApiOperation(value = "新建消息模板", tags = {"消息模板" },  notes = "新建消息模板")
	@RequestMapping(method = RequestMethod.POST, value = "/msgtemplates")
    public ResponseEntity<MsgTemplateDTO> create(@Validated @RequestBody MsgTemplateDTO msgtemplatedto) {
        MsgTemplate domain = msgtemplateMapping.toDomain(msgtemplatedto);
		msgtemplateService.create(domain);
        MsgTemplateDTO dto = msgtemplateMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-Create-all')")
    @ApiOperation(value = "批量新建消息模板", tags = {"消息模板" },  notes = "批量新建消息模板")
	@RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MsgTemplateDTO> msgtemplatedtos) {
        msgtemplateService.createBatch(msgtemplateMapping.toDomain(msgtemplatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-Get-all')")
    @ApiOperation(value = "获取消息模板", tags = {"消息模板" },  notes = "获取消息模板")
	@RequestMapping(method = RequestMethod.GET, value = "/msgtemplates/{msgtemplate_id}")
    public ResponseEntity<MsgTemplateDTO> get(@PathVariable("msgtemplate_id") String msgtemplate_id) {
        MsgTemplate domain = msgtemplateService.get(msgtemplate_id);
        MsgTemplateDTO dto = msgtemplateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-Remove-all')")
    @ApiOperation(value = "删除消息模板", tags = {"消息模板" },  notes = "删除消息模板")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgtemplates/{msgtemplate_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("msgtemplate_id") String msgtemplate_id) {
         return ResponseEntity.status(HttpStatus.OK).body(msgtemplateService.remove(msgtemplate_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-Remove-all')")
    @ApiOperation(value = "批量删除消息模板", tags = {"消息模板" },  notes = "批量删除消息模板")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgtemplates/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        msgtemplateService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-Update-all')")
    @ApiOperation(value = "更新消息模板", tags = {"消息模板" },  notes = "更新消息模板")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgtemplates/{msgtemplate_id}")
    public ResponseEntity<MsgTemplateDTO> update(@PathVariable("msgtemplate_id") String msgtemplate_id, @RequestBody MsgTemplateDTO msgtemplatedto) {
		MsgTemplate domain  = msgtemplateMapping.toDomain(msgtemplatedto);
        domain .setTid(msgtemplate_id);
		msgtemplateService.update(domain );
		MsgTemplateDTO dto = msgtemplateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-Update-all')")
    @ApiOperation(value = "批量更新消息模板", tags = {"消息模板" },  notes = "批量更新消息模板")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgtemplates/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MsgTemplateDTO> msgtemplatedtos) {
        msgtemplateService.updateBatch(msgtemplateMapping.toDomain(msgtemplatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查消息模板", tags = {"消息模板" },  notes = "检查消息模板")
	@RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody MsgTemplateDTO msgtemplatedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(msgtemplateService.checkKey(msgtemplateMapping.toDomain(msgtemplatedto)));
    }

    @ApiOperation(value = "获取消息模板草稿", tags = {"消息模板" },  notes = "获取消息模板草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/msgtemplates/getdraft")
    public ResponseEntity<MsgTemplateDTO> getDraft(MsgTemplateDTO dto) {
        MsgTemplate domain = msgtemplateMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(msgtemplateMapping.toDto(msgtemplateService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-Save-all')")
    @ApiOperation(value = "保存消息模板", tags = {"消息模板" },  notes = "保存消息模板")
	@RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/save")
    public ResponseEntity<MsgTemplateDTO> save(@RequestBody MsgTemplateDTO msgtemplatedto) {
        MsgTemplate domain = msgtemplateMapping.toDomain(msgtemplatedto);
        msgtemplateService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(msgtemplateMapping.toDto(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-Save-all')")
    @ApiOperation(value = "批量保存消息模板", tags = {"消息模板" },  notes = "批量保存消息模板")
	@RequestMapping(method = RequestMethod.POST, value = "/msgtemplates/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MsgTemplateDTO> msgtemplatedtos) {
        msgtemplateService.saveBatch(msgtemplateMapping.toDomain(msgtemplatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-searchDefault-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"消息模板" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/msgtemplates/fetchdefault")
	public ResponseEntity<List<MsgTemplateDTO>> fetchDefault(MsgTemplateSearchContext context) {
        Page<MsgTemplate> domains = msgtemplateService.searchDefault(context) ;
        List<MsgTemplateDTO> list = msgtemplateMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgTemplate-searchDefault-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"消息模板" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/msgtemplates/searchdefault")
	public ResponseEntity<Page<MsgTemplateDTO>> searchDefault(@RequestBody MsgTemplateSearchContext context) {
        Page<MsgTemplate> domains = msgtemplateService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(msgtemplateMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

