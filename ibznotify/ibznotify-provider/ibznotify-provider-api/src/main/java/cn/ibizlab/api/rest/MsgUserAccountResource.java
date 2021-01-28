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
import cn.ibizlab.core.notify.domain.MsgUserAccount;
import cn.ibizlab.core.notify.service.IMsgUserAccountService;
import cn.ibizlab.core.notify.filter.MsgUserAccountSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"绑定消息账号" })
@RestController("api-msguseraccount")
@RequestMapping("")
public class MsgUserAccountResource {

    @Autowired
    public IMsgUserAccountService msguseraccountService;

    @Autowired
    @Lazy
    public MsgUserAccountMapping msguseraccountMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgUserAccount-Create-all')")
    @ApiOperation(value = "新建绑定消息账号", tags = {"绑定消息账号" },  notes = "新建绑定消息账号")
	@RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts")
    public ResponseEntity<MsgUserAccountDTO> create(@Validated @RequestBody MsgUserAccountDTO msguseraccountdto) {
        MsgUserAccount domain = msguseraccountMapping.toDomain(msguseraccountdto);
		msguseraccountService.create(domain);
        MsgUserAccountDTO dto = msguseraccountMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgUserAccount-Create-all')")
    @ApiOperation(value = "批量新建绑定消息账号", tags = {"绑定消息账号" },  notes = "批量新建绑定消息账号")
	@RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<MsgUserAccountDTO> msguseraccountdtos) {
        msguseraccountService.createBatch(msguseraccountMapping.toDomain(msguseraccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgUserAccount-Update-all')")
    @ApiOperation(value = "更新绑定消息账号", tags = {"绑定消息账号" },  notes = "更新绑定消息账号")
	@RequestMapping(method = RequestMethod.PUT, value = "/msguseraccounts/{msguseraccount_id}")
    public ResponseEntity<MsgUserAccountDTO> update(@PathVariable("msguseraccount_id") String msguseraccount_id, @RequestBody MsgUserAccountDTO msguseraccountdto) {
		MsgUserAccount domain  = msguseraccountMapping.toDomain(msguseraccountdto);
        domain .setId(msguseraccount_id);
		msguseraccountService.update(domain );
		MsgUserAccountDTO dto = msguseraccountMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgUserAccount-Update-all')")
    @ApiOperation(value = "批量更新绑定消息账号", tags = {"绑定消息账号" },  notes = "批量更新绑定消息账号")
	@RequestMapping(method = RequestMethod.PUT, value = "/msguseraccounts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<MsgUserAccountDTO> msguseraccountdtos) {
        msguseraccountService.updateBatch(msguseraccountMapping.toDomain(msguseraccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgUserAccount-Remove-all')")
    @ApiOperation(value = "删除绑定消息账号", tags = {"绑定消息账号" },  notes = "删除绑定消息账号")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msguseraccounts/{msguseraccount_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("msguseraccount_id") String msguseraccount_id) {
         return ResponseEntity.status(HttpStatus.OK).body(msguseraccountService.remove(msguseraccount_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgUserAccount-Remove-all')")
    @ApiOperation(value = "批量删除绑定消息账号", tags = {"绑定消息账号" },  notes = "批量删除绑定消息账号")
	@RequestMapping(method = RequestMethod.DELETE, value = "/msguseraccounts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        msguseraccountService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibznotify-MsgUserAccount-Get-all')")
    @ApiOperation(value = "获取绑定消息账号", tags = {"绑定消息账号" },  notes = "获取绑定消息账号")
	@RequestMapping(method = RequestMethod.GET, value = "/msguseraccounts/{msguseraccount_id}")
    public ResponseEntity<MsgUserAccountDTO> get(@PathVariable("msguseraccount_id") String msguseraccount_id) {
        MsgUserAccount domain = msguseraccountService.get(msguseraccount_id);
        MsgUserAccountDTO dto = msguseraccountMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取绑定消息账号草稿", tags = {"绑定消息账号" },  notes = "获取绑定消息账号草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/msguseraccounts/getdraft")
    public ResponseEntity<MsgUserAccountDTO> getDraft(MsgUserAccountDTO dto) {
        MsgUserAccount domain = msguseraccountMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(msguseraccountMapping.toDto(msguseraccountService.getDraft(domain)));
    }

    @ApiOperation(value = "检查绑定消息账号", tags = {"绑定消息账号" },  notes = "检查绑定消息账号")
	@RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody MsgUserAccountDTO msguseraccountdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(msguseraccountService.checkKey(msguseraccountMapping.toDomain(msguseraccountdto)));
    }

    @ApiOperation(value = "保存绑定消息账号", tags = {"绑定消息账号" },  notes = "保存绑定消息账号")
	@RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts/save")
    public ResponseEntity<Boolean> save(@RequestBody MsgUserAccountDTO msguseraccountdto) {
        return ResponseEntity.status(HttpStatus.OK).body(msguseraccountService.save(msguseraccountMapping.toDomain(msguseraccountdto)));
    }

    @ApiOperation(value = "批量保存绑定消息账号", tags = {"绑定消息账号" },  notes = "批量保存绑定消息账号")
	@RequestMapping(method = RequestMethod.POST, value = "/msguseraccounts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<MsgUserAccountDTO> msguseraccountdtos) {
        msguseraccountService.saveBatch(msguseraccountMapping.toDomain(msguseraccountdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"绑定消息账号" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/msguseraccounts/fetchdefault")
	public ResponseEntity<List<MsgUserAccountDTO>> fetchDefault(MsgUserAccountSearchContext context) {
        Page<MsgUserAccount> domains = msguseraccountService.searchDefault(context) ;
        List<MsgUserAccountDTO> list = msguseraccountMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"绑定消息账号" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/msguseraccounts/searchdefault")
	public ResponseEntity<Page<MsgUserAccountDTO>> searchDefault(@RequestBody MsgUserAccountSearchContext context) {
        Page<MsgUserAccount> domains = msguseraccountService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(msguseraccountMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

