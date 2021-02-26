package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.api.dto.MsgBodyDTO;
import cn.ibizlab.api.mapping.MsgBodyMapping;
import cn.ibizlab.core.extensions.domain.Template;
import cn.ibizlab.core.extensions.service.NotifyCoreService;
import cn.ibizlab.core.notify.domain.MsgBody;
import cn.ibizlab.core.notify.filter.MsgBodySearchContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class NotifyCoreResource {

    @Autowired
    NotifyCoreService notifyCoreService;

    @Autowired
    MsgBodyMapping mapping;

    /**
     * 发送工作流消息
     * @param dto
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/notify/sendmsg")
    public ResponseEntity<Boolean> sendMsg(@Validated @RequestBody MsgBodyDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(notifyCoreService.sendMsg(mapping.toDomain(dto)));
    }
    /**
     * 建立消息模板
     * @param template
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/notify/createmsgtempl")
    public ResponseEntity<Boolean> createMsgTemplate(@Validated @RequestBody Template template){
        return ResponseEntity.status(HttpStatus.OK).body(notifyCoreService.createMsgTemplate(template));
    }
    /**
     * 发送钉钉链接消息
     * @param dto
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/notify/dingtalk/sendlinkmsg")
    public ResponseEntity<Boolean> sendDingTalkLinkMsg(@RequestBody MsgBodyDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(notifyCoreService.sendDingTalkLinkMsg(mapping.toDomain(dto)));
    }
    /**
     * 创建钉钉待办
     * @param dto
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/notify/dingtalk/createworkrecord")
    public ResponseEntity<String> createDingTalkWorkRecord(@RequestBody MsgBodyDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(notifyCoreService.createDingTalkWorkRecord(mapping.toDomain(dto)));
    }
    /**
     * 完成钉钉待办
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/notify/dingtalk/finishworkrecord/{msgid}")
    public ResponseEntity<Boolean> finishDingTalkWorkRecord(@Validated @NotNull @PathVariable("msgid") String msgId){
        return ResponseEntity.status(HttpStatus.OK).body(notifyCoreService.finishDingTalkWorkRecord(msgId));
    }

    /**
     * 全量获取催办消息
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/notify/msgbody/getallbacklogall")
    public ResponseEntity<List<MsgBodyDTO>> getAllBacklogAll(MsgBodySearchContext context){
        Page domains = notifyCoreService.getBacklogAllContent(context);
        List<MsgBodyDTO> list = mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
    }

    /**
     * 分页获取催办消息
     * @param
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/notify/msgbody/getbacklogbypage")
    public ResponseEntity<List<MsgBodyDTO>> getBacklogByPage(MsgBodySearchContext context) {
        Page domains = notifyCoreService.getBacklogByPage(context);
        List<MsgBodyDTO> list = mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
    }
}
