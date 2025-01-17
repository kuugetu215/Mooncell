package karazuki.controller;

import dto.EmailSendDTO;
import entity.Email;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import karazuki.service.EmailService;
import karazuki.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.Result;
import vo.EmailVO;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/email")
@Tag(name = "聊天框接口")
public class EmailController {

    @Autowired
    private EmailService emailService;


    /**
     * 发送会话
     * @param emailSendDTO
     * @return
     */
    @Operation(description = "发送会话")
    @PostMapping()
    public Result send(@RequestBody EmailSendDTO emailSendDTO){
        log.info("发送会话:{}", emailSendDTO);
        emailService.insert(emailSendDTO);
        return Result.success();
    }

    /**
     * 列出消息列表
     * @param targetId
     * @return
     */
    @Operation(description = "列出消息列表")
    @GetMapping("/{targetId}")
    public Result<List<EmailVO>> list(@PathVariable Integer targetId){
        log.info("列出消息列表");
        List<EmailVO> emailVOList = emailService.list(targetId);
        return Result.success(emailVOList);
    }

    /**
     * 撤回消息
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public Result recall(@PathVariable Integer id){
        log.info("撤回消息");
        Boolean isSucceed = emailService.recall(id);
        if (!isSucceed){
            return Result.error("消息发送时间超过2分钟，不可撤回");
        } else {
            return Result.success("你撤回了一条消息");
        }

    }

}
