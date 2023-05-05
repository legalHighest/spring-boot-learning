package top.hjh.websocket;

import jakarta.websocket.*;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author huang
 * @Description SpringBoot 服务端 WebSocket 服务类定义
 * @Date 2023 04 17 15 41
 **/
@Component
@Slf4j
@ServerEndpoint(value = "/socket/{id}")
public class WebSocketServer {
    /**
     * 静态变量，用来统计在线连接数
     */
    private static int onlineCount = 0;
    /**
     * 与某个客户端连接的会话，存放了和客户端连接对象的WebSocket对象（每个都会存放一个对应的对象）
     */
    private Session session;

    private Integer id;
    /**
     * concurrent 包：线程安全的集合，用来村法国和每个客户端对象的WebSocket对象
     */
    public static ConcurrentHashMap<Integer, WebSocketServer> map = new ConcurrentHashMap<>();


    /**
     * 建立连接成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam(value = "id") Integer id, Session session) {
        log.info("连接成功");

        //接收到编号
        this.id = id;
        this.session = session;

        //加入集合（对象全部内容全部进去）
        map.put(id, this);
//在线人数+1
        addOnlineCout();
        log.info("有新连接加入，当前在线人数加入为" + getOnlineCount());
        sendMessage("--连接已经成功建立--");
    }

    @OnClose
    public void onClose() {
        log.info("有连接关闭，当前在线人数为：" + getOnlineCount());
        //从map移除
        map.remove(this.id);
        //在线人数-1
        subOnlineCout();
    }

    /**
     * 收到客户端发送的消息后，调用的方法
     *
     * @param session
     * @param msg
     */
    @OnMessage
    public void onMessage(Session session, String msg) {
        log.info("收到客户端发送的消息后:" + msg);
        this.sendMessage(msg);
    }

    @OnError
    public void onError(Throwable error) {
        log.error(error.getMessage());
        error.printStackTrace();
    }

    /**
     * 群发消息
     *
     * @param message
     */
    private void sendMessage(String message) {
        try {
            getSession().getBasicRemote().sendText(message);
        } catch (
                IOException e) {
            log.error("发生错误");
        }
    }

    /**
     * 给指定的id发送消息
     *
     * @param id
     * @param msg
     */
    private void sendMessageById(Integer id, String msg) {
        WebSocketServer webSocketServer = map.get(id);
        if (webSocketServer != null) {
            webSocketServer.sendMessage(msg);

        } else {
            log.info("客户端已经下线，不能发送消息");
        }
    }

    /**
     * 群发自定义消息
     *
     * @param msg
     */
    private void broadcastMsg(String msg) {
        for (WebSocketServer item : map.values()) {
            item.sendMessage(msg);
        }
    }

    public Session getSession() {
        return session;
    }


    /**
     * 通过synchronized给方法枷锁，实现线程安全
     */
    public static synchronized void addOnlineCout() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCout() {
        WebSocketServer.onlineCount--;
    }

    public static synchronized int getOnlineCount() {
        return WebSocketServer.onlineCount;
    }
}
