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
import cn.ibizlab.core.pay.domain.PayOpenAccess;
import cn.ibizlab.core.pay.service.IPayOpenAccessService;
import cn.ibizlab.core.pay.filter.PayOpenAccessSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"支付平台" })
@RestController("api-payopenaccess")
@RequestMapping("")
public class PayOpenAccessResource {

    @Autowired
    public IPayOpenAccessService payopenaccessService;

    @Autowired
    @Lazy
    public PayOpenAccessMapping payopenaccessMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-Create-all')")
    @ApiOperation(value = "新建支付平台", tags = {"支付平台" },  notes = "新建支付平台")
	@RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses")
    public ResponseEntity<PayOpenAccessDTO> create(@Validated @RequestBody PayOpenAccessDTO payopenaccessdto) {
        PayOpenAccess domain = payopenaccessMapping.toDomain(payopenaccessdto);
		payopenaccessService.create(domain);
        PayOpenAccessDTO dto = payopenaccessMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-Create-all')")
    @ApiOperation(value = "批量新建支付平台", tags = {"支付平台" },  notes = "批量新建支付平台")
	@RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PayOpenAccessDTO> payopenaccessdtos) {
        payopenaccessService.createBatch(payopenaccessMapping.toDomain(payopenaccessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-Update-all')")
    @ApiOperation(value = "更新支付平台", tags = {"支付平台" },  notes = "更新支付平台")
	@RequestMapping(method = RequestMethod.PUT, value = "/payopenaccesses/{payopenaccess_id}")
    public ResponseEntity<PayOpenAccessDTO> update(@PathVariable("payopenaccess_id") String payopenaccess_id, @RequestBody PayOpenAccessDTO payopenaccessdto) {
		PayOpenAccess domain  = payopenaccessMapping.toDomain(payopenaccessdto);
        domain .setId(payopenaccess_id);
		payopenaccessService.update(domain );
		PayOpenAccessDTO dto = payopenaccessMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-Update-all')")
    @ApiOperation(value = "批量更新支付平台", tags = {"支付平台" },  notes = "批量更新支付平台")
	@RequestMapping(method = RequestMethod.PUT, value = "/payopenaccesses/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PayOpenAccessDTO> payopenaccessdtos) {
        payopenaccessService.updateBatch(payopenaccessMapping.toDomain(payopenaccessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-Remove-all')")
    @ApiOperation(value = "删除支付平台", tags = {"支付平台" },  notes = "删除支付平台")
	@RequestMapping(method = RequestMethod.DELETE, value = "/payopenaccesses/{payopenaccess_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("payopenaccess_id") String payopenaccess_id) {
         return ResponseEntity.status(HttpStatus.OK).body(payopenaccessService.remove(payopenaccess_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-Remove-all')")
    @ApiOperation(value = "批量删除支付平台", tags = {"支付平台" },  notes = "批量删除支付平台")
	@RequestMapping(method = RequestMethod.DELETE, value = "/payopenaccesses/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        payopenaccessService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-Get-all')")
    @ApiOperation(value = "获取支付平台", tags = {"支付平台" },  notes = "获取支付平台")
	@RequestMapping(method = RequestMethod.GET, value = "/payopenaccesses/{payopenaccess_id}")
    public ResponseEntity<PayOpenAccessDTO> get(@PathVariable("payopenaccess_id") String payopenaccess_id) {
        PayOpenAccess domain = payopenaccessService.get(payopenaccess_id);
        PayOpenAccessDTO dto = payopenaccessMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取支付平台草稿", tags = {"支付平台" },  notes = "获取支付平台草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/payopenaccesses/getdraft")
    public ResponseEntity<PayOpenAccessDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(payopenaccessMapping.toDto(payopenaccessService.getDraft(new PayOpenAccess())));
    }

    @ApiOperation(value = "检查支付平台", tags = {"支付平台" },  notes = "检查支付平台")
	@RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PayOpenAccessDTO payopenaccessdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(payopenaccessService.checkKey(payopenaccessMapping.toDomain(payopenaccessdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-Save-all')")
    @ApiOperation(value = "保存支付平台", tags = {"支付平台" },  notes = "保存支付平台")
	@RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses/save")
    public ResponseEntity<Boolean> save(@RequestBody PayOpenAccessDTO payopenaccessdto) {
        return ResponseEntity.status(HttpStatus.OK).body(payopenaccessService.save(payopenaccessMapping.toDomain(payopenaccessdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-Save-all')")
    @ApiOperation(value = "批量保存支付平台", tags = {"支付平台" },  notes = "批量保存支付平台")
	@RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PayOpenAccessDTO> payopenaccessdtos) {
        payopenaccessService.saveBatch(payopenaccessMapping.toDomain(payopenaccessdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-searchDefault-all')")
	@ApiOperation(value = "获取数据集", tags = {"支付平台" } ,notes = "获取数据集")
    @RequestMapping(method= RequestMethod.GET , value="/payopenaccesses/fetchdefault")
	public ResponseEntity<List<PayOpenAccessDTO>> fetchDefault(PayOpenAccessSearchContext context) {
        Page<PayOpenAccess> domains = payopenaccessService.searchDefault(context) ;
        List<PayOpenAccessDTO> list = payopenaccessMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayOpenAccess-searchDefault-all')")
	@ApiOperation(value = "查询数据集", tags = {"支付平台" } ,notes = "查询数据集")
    @RequestMapping(method= RequestMethod.POST , value="/payopenaccesses/searchdefault")
	public ResponseEntity<Page<PayOpenAccessDTO>> searchDefault(@RequestBody PayOpenAccessSearchContext context) {
        Page<PayOpenAccess> domains = payopenaccessService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(payopenaccessMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

