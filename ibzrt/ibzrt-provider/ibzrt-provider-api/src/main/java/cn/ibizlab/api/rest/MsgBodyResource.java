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
import cn.ibizlab.core.notify.domain.MsgBody;
import cn.ibizlab.core.notify.service.IMsgBodyService;
import cn.ibizlab.core.notify.filter.MsgBodySearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"消息" })
@RestController("api-msgbody")
@RequestMapping("")
public class MsgBodyResource {

    @Autowired
    public IMsgBodyService msgbodyService;

    @Autowired
    @Lazy
    public MsgBodyMapping msgbodyMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-Create-all')")
    @ApiOperation(value = "新建消息", tags = {"消息" },  notes = "新建消息")
	@RequestMapping(method = RequestMethod.POST, value = "/msgbodies")
    public ResponseEntity<MsgBodyDTO> create(@Validated @RequestBody MsgBodyDTO msgbodydto) {
        MsgBody domain = msgbodyMapping.toDomain(msgbodydto);
		msgbodyService.create(domain);
        MsgBodyDTO dto = msgbodyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-Create-all')")
    @ApiOperation(value = "批量新建消息", tags = {"消息" },  notes = "批量新建消息")
	@RequestMapping(method = RequestMethod.POST, value = "/msgbodies/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MsgBodyDTO> msgbodydtos) {
        msgbodyService.createBatch(msgbodyMapping.toDomain(msgbodydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-Update-all')")
    @ApiOperation(value = "更新消息", tags = {"消息" },  notes = "更新消息")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgbodies/{msgbody_id}")
    public ResponseEntity<MsgBodyDTO> update(@PathVariable("msgbody_id") String msgbody_id, @RequestBody MsgBodyDTO msgbodydto) {
		MsgBody domain  = msgbodyMapping.toDomain(msgbodydto);
        domain .setMsgId(msgbody_id);
		msgbodyService.update(domain );
		MsgBodyDTO dto = msgbodyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-Update-all')")
    @ApiOperation(value = "批量更新消息", tags = {"消息" },  notes = "批量更新消息")
	@RequestMapping(method = RequestMethod.PUT, value = "/msgbodies/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MsgBodyDTO> msgbodydtos) {
        msgbodyService.updateBatch(msgbodyMapping.toDomain(msgbodydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-Remove-all')")
    @ApiOperation(value = "删除消息", tags = {"消息" },  notes = "删除消息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgbodies/{msgbody_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("msgbody_id") String msgbody_id) {
         return ResponseEntity.status(HttpStatus.OK).body(msgbodyService.remove(msgbody_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-Remove-all')")
    @ApiOperation(value = "批量删除消息", tags = {"消息" },  notes = "批量删除消息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msgbodies/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        msgbodyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-Get-all')")
    @ApiOperation(value = "获取消息", tags = {"消息" },  notes = "获取消息")
	@RequestMapping(method = RequestMethod.GET, value = "/msgbodies/{msgbody_id}")
    public ResponseEntity<MsgBodyDTO> get(@PathVariable("msgbody_id") String msgbody_id) {
        MsgBody domain = msgbodyService.get(msgbody_id);
        MsgBodyDTO dto = msgbodyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取消息草稿", tags = {"消息" },  notes = "获取消息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/msgbodies/getdraft")
    public ResponseEntity<MsgBodyDTO> getDraft(MsgBodyDTO dto) {
        MsgBody domain = msgbodyMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(msgbodyMapping.toDto(msgbodyService.getDraft(domain)));
    }

    @ApiOperation(value = "检查消息", tags = {"消息" },  notes = "检查消息")
	@RequestMapping(method = RequestMethod.POST, value = "/msgbodies/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody MsgBodyDTO msgbodydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(msgbodyService.checkKey(msgbodyMapping.toDomain(msgbodydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-Save-all')")
    @ApiOperation(value = "保存消息", tags = {"消息" },  notes = "保存消息")
	@RequestMapping(method = RequestMethod.POST, value = "/msgbodies/save")
    public ResponseEntity<Boolean> save(@RequestBody MsgBodyDTO msgbodydto) {
        return ResponseEntity.status(HttpStatus.OK).body(msgbodyService.save(msgbodyMapping.toDomain(msgbodydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-Save-all')")
    @ApiOperation(value = "批量保存消息", tags = {"消息" },  notes = "批量保存消息")
	@RequestMapping(method = RequestMethod.POST, value = "/msgbodies/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MsgBodyDTO> msgbodydtos) {
        msgbodyService.saveBatch(msgbodyMapping.toDomain(msgbodydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-searchDefault-all')")
	@ApiOperation(value = "获取数据集", tags = {"消息" } ,notes = "获取数据集")
    @RequestMapping(method= RequestMethod.GET , value="/msgbodies/fetchdefault")
	public ResponseEntity<List<MsgBodyDTO>> fetchDefault(MsgBodySearchContext context) {
        Page<MsgBody> domains = msgbodyService.searchDefault(context) ;
        List<MsgBodyDTO> list = msgbodyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzrt-MsgBody-searchDefault-all')")
	@ApiOperation(value = "查询数据集", tags = {"消息" } ,notes = "查询数据集")
    @RequestMapping(method= RequestMethod.POST , value="/msgbodies/searchdefault")
	public ResponseEntity<Page<MsgBodyDTO>> searchDefault(@RequestBody MsgBodySearchContext context) {
        Page<MsgBody> domains = msgbodyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(msgbodyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

