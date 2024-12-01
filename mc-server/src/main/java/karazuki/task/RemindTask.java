package karazuki.task;

import karazuki.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RemindTask {

    @Autowired
    private WebSocketServer webSocketServer;

    //提醒每日任务更新
    //TODO 增加消息提醒功能 发送消息增加每日任务种类 增加国服日服时间区分
    @Scheduled(cron = "0 0 0 * * ?")
    public void everydayRemind(){
        webSocketServer.sendToAllClient("每日任务已更新");
    }

    //TODO 增加消息提醒功能 发送消息增加每周任务种类 增加国服日服时间区分
    //提醒每周任务更新

    @Scheduled(cron = "0 0 0 ? * * ")
    public void everyweekRemind(){
        webSocketServer.sendToAllClient("每周任务已更新");
    }
}
