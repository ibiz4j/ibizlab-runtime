package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.api.dto.PayTradeDTO;
import cn.ibizlab.api.mapping.PayTradeMapping;
import cn.ibizlab.core.extensions.service.PayCoreService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

@RestController
public class PayCoreResource {

    @Autowired
    @Lazy
    PayCoreService payCoreService;

    @Autowired
    @Lazy
    PayTradeMapping payTradeMapping;

    @ApiOperation(value = "预下单获取二维码", tags = {"获取二维码" },  notes = "预下单获取二维码")
    @RequestMapping(method = RequestMethod.POST,value = "/pay/trade/precreate")
    public ResponseEntity<JSONObject> preCreate(@Validated @RequestBody PayTradeDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(payCoreService.preCreate(payTradeMapping.toDomain(dto)));
    }

    @ApiOperation(value = "查询订单", tags = {"查询订单" },  notes = "查询订单")
    @RequestMapping(method = RequestMethod.GET,value = "/pay/trade/query")
    public ResponseEntity<JSONObject> query(@Validated @NotBlank(message = "开放平台配置标识不允许为空")@RequestParam("accessid") String accessId,
                                            @NotBlank(message = "订单号不允许为空") @RequestParam("out_trade_no") String outTradeNo){
        return ResponseEntity.status(HttpStatus.OK).body(payCoreService.query(accessId,outTradeNo));
    }

    @ApiOperation(value = "取消订单", tags = {"取消订单" },  notes = "取消订单")
    @RequestMapping(method = RequestMethod.GET,value = "/pay/trade/cancel")
    public ResponseEntity<JSONObject> cancel(@Validated @NotBlank(message = "开放平台配置标识不允许为空")@RequestParam("accessid") String accessId,
                                             @NotBlank(message = "订单号不允许为空") @RequestParam("out_trade_no") String outTradeNo){
        return ResponseEntity.status(HttpStatus.OK).body(payCoreService.cancel(accessId,outTradeNo));
    }

    @ApiOperation(value = "支付回调", tags = {"支付回调" },  notes = "支付回调")
    @RequestMapping(value = "/pay/trade/callback")
    public ResponseEntity<String> callBack(HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.OK).body(payCoreService.callBack(req));
    }

    @ApiOperation(value = "网页支付", tags = {"网页支付" },  notes = "网页支付")
    @RequestMapping(method = RequestMethod.POST,value = "/pay/trade/pagepay")
    public ResponseEntity<String> pagePay(@Validated @RequestBody PayTradeDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(payCoreService.pagePay(payTradeMapping.toDomain(dto)));
    }

    @ApiOperation(value = "网页支付回调", tags = {"网页支付回调" },  notes = "网页支付回调")
    @RequestMapping(value = "/pay/trade/pagepay/callback")
    public ResponseEntity<String> pagePayCallBack(HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.OK).body(payCoreService.pagePayCallBack(req));
    }

}
