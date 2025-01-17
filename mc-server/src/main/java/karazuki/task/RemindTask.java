package karazuki.task;

import karazuki.mapper.EmailMapper;
import karazuki.service.EmailService;
import karazuki.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RemindTask {

    @Autowired
    private WebSocketServer webSocketServer;

    @Autowired
    private EmailService emailService;

    //每日定时处理已撤回的消息
    @Scheduled(cron = "0 0 0 * * ?")
    public void deleteRecall(){
        emailService.delete();
    }


    //提醒每周任务更新
    @Scheduled(cron = "0 0 0 ? * * ")
    public void everyweekRemind(){
        webSocketServer.sendToAllUser("每周任务已更新");
        emailService.sendToAll("每周任务已更新");
    }
}
