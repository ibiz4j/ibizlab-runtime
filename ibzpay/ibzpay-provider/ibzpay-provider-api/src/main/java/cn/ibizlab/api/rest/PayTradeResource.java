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
import cn.ibizlab.core.pay.domain.PayTrade;
import cn.ibizlab.core.pay.service.IPayTradeService;
import cn.ibizlab.core.pay.filter.PayTradeSearchContext;
import cn.ibizlab.util.annotation.VersionCheck;

@Slf4j
@Api(tags = {"支付交易" })
@RestController("api-paytrade")
@RequestMapping("")
public class PayTradeResource {

    @Autowired
    public IPayTradeService paytradeService;

    @Autowired
    @Lazy
    public PayTradeMapping paytradeMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-Create-all')")
    @ApiOperation(value = "新建支付交易", tags = {"支付交易" },  notes = "新建支付交易")
	@RequestMapping(method = RequestMethod.POST, value = "/paytrades")
    public ResponseEntity<PayTradeDTO> create(@Validated @RequestBody PayTradeDTO paytradedto) {
        PayTrade domain = paytradeMapping.toDomain(paytradedto);
		paytradeService.create(domain);
        PayTradeDTO dto = paytradeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-Create-all')")
    @ApiOperation(value = "批量新建支付交易", tags = {"支付交易" },  notes = "批量新建支付交易")
	@RequestMapping(method = RequestMethod.POST, value = "/paytrades/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PayTradeDTO> paytradedtos) {
        paytradeService.createBatch(paytradeMapping.toDomain(paytradedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-Get-all')")
    @ApiOperation(value = "获取支付交易", tags = {"支付交易" },  notes = "获取支付交易")
	@RequestMapping(method = RequestMethod.GET, value = "/paytrades/{paytrade_id}")
    public ResponseEntity<PayTradeDTO> get(@PathVariable("paytrade_id") String paytrade_id) {
        PayTrade domain = paytradeService.get(paytrade_id);
        PayTradeDTO dto = paytradeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-Remove-all')")
    @ApiOperation(value = "删除支付交易", tags = {"支付交易" },  notes = "删除支付交易")
	@RequestMapping(method = RequestMethod.DELETE, value = "/paytrades/{paytrade_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("paytrade_id") String paytrade_id) {
         return ResponseEntity.status(HttpStatus.OK).body(paytradeService.remove(paytrade_id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-Remove-all')")
    @ApiOperation(value = "批量删除支付交易", tags = {"支付交易" },  notes = "批量删除支付交易")
	@RequestMapping(method = RequestMethod.DELETE, value = "/paytrades/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        paytradeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-Update-all')")
    @ApiOperation(value = "更新支付交易", tags = {"支付交易" },  notes = "更新支付交易")
	@RequestMapping(method = RequestMethod.PUT, value = "/paytrades/{paytrade_id}")
    public ResponseEntity<PayTradeDTO> update(@PathVariable("paytrade_id") String paytrade_id, @RequestBody PayTradeDTO paytradedto) {
		PayTrade domain  = paytradeMapping.toDomain(paytradedto);
        domain .setTradeId(paytrade_id);
		paytradeService.update(domain );
		PayTradeDTO dto = paytradeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-Update-all')")
    @ApiOperation(value = "批量更新支付交易", tags = {"支付交易" },  notes = "批量更新支付交易")
	@RequestMapping(method = RequestMethod.PUT, value = "/paytrades/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PayTradeDTO> paytradedtos) {
        paytradeService.updateBatch(paytradeMapping.toDomain(paytradedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查支付交易", tags = {"支付交易" },  notes = "检查支付交易")
	@RequestMapping(method = RequestMethod.POST, value = "/paytrades/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PayTradeDTO paytradedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(paytradeService.checkKey(paytradeMapping.toDomain(paytradedto)));
    }

    @ApiOperation(value = "获取支付交易草稿", tags = {"支付交易" },  notes = "获取支付交易草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/paytrades/getdraft")
    public ResponseEntity<PayTradeDTO> getDraft(PayTradeDTO dto) {
        PayTrade domain = paytradeMapping.toDomain(dto);
        return ResponseEntity.status(HttpStatus.OK).body(paytradeMapping.toDto(paytradeService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-Save-all')")
    @ApiOperation(value = "保存支付交易", tags = {"支付交易" },  notes = "保存支付交易")
	@RequestMapping(method = RequestMethod.POST, value = "/paytrades/save")
    public ResponseEntity<PayTradeDTO> save(@RequestBody PayTradeDTO paytradedto) {
        PayTrade domain = paytradeMapping.toDomain(paytradedto);
        paytradeService.save(domain);
        return ResponseEntity.status(HttpStatus.OK).body(paytradeMapping.toDto(domain));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-Save-all')")
    @ApiOperation(value = "批量保存支付交易", tags = {"支付交易" },  notes = "批量保存支付交易")
	@RequestMapping(method = RequestMethod.POST, value = "/paytrades/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PayTradeDTO> paytradedtos) {
        paytradeService.saveBatch(paytradeMapping.toDomain(paytradedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-searchDefault-all')")
	@ApiOperation(value = "获取数据集", tags = {"支付交易" } ,notes = "获取数据集")
    @RequestMapping(method= RequestMethod.GET , value="/paytrades/fetchdefault")
	public ResponseEntity<List<PayTradeDTO>> fetchDefault(PayTradeSearchContext context) {
        Page<PayTrade> domains = paytradeService.searchDefault(context) ;
        List<PayTradeDTO> list = paytradeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ibzpay-PayTrade-searchDefault-all')")
	@ApiOperation(value = "查询数据集", tags = {"支付交易" } ,notes = "查询数据集")
    @RequestMapping(method= RequestMethod.POST , value="/paytrades/searchdefault")
	public ResponseEntity<Page<PayTradeDTO>> searchDefault(@RequestBody PayTradeSearchContext context) {
        Page<PayTrade> domains = paytradeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(paytradeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}



}

