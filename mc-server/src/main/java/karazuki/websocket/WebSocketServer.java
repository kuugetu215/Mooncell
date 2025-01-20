package karazuki.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import context.BaseContext;
import dto.EmailSendDTO;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import karazuki.config.GetHttpSessionConfig;
import karazuki.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * WebSocket服务
 */
@Slf4j
@Component
@ServerEndpoint(value = "/email", configurator = GetHttpSessionConfig.class)  //根据路径进行匹配
public class WebSocketServer {

    //存放会话对象
    private static Map<Integer, Session> sessionMap = new HashMap();
    private HttpSession httpSession;

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context){
        applicationContext = context;
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        Integer uid = BaseContext.getCurrentId();
        System.out.println("客户端：" + uid + "建立连接");
        sessionMap.put(uid, session);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message) {
        Integer uid = (Integer) this.httpSession.getAttribute("uid");
        System.out.println("收到来自客户端：" + uid + "的信息:" + message);
    }

    /**
     * 连接关闭调用的方法
     *
     */
    @OnClose
    public void onClose() {
        System.out.println("连接断开:");
    }

    /**
     * 群发
     *
     * @param message
     */
    public void sendToAllClient(String message) {
        Collection<Session> sessions = sessionMap.values();
        for (Session session : sessions) {
            try {
                //服务器向客户端发送消息
                session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendToUser(String msg, Integer uid, Integer receiveId){
        Session session = sessionMap.get(uid);
        Map<String, Object> map = new HashMap<>();
        map.put("message", msg);
        map.put("uid", uid);
        map.put("toId", receiveId);
        JSONObject jsonObject = new JSONObject(map);
        if (session != null){
            try {
                session.getBasicRemote().sendText(jsonObject.toJSONString());
            } catch (IOException e) {
                throw new RuntimeException("网络错误");
            }
        }
        session = sessionMap.get(receiveId);
        if (session != null){
            try {
                session.getBasicRemote().sendText(jsonObject.toJSONString());
            } catch (IOException e){
                throw new RuntimeException("网络错误");
            }
        }
    }

}