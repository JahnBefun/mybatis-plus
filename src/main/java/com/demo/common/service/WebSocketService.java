package com.demo.common.service;

import com.alibaba.fastjson.JSON;
import com.demo.common.model.WebSocketResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zbf
 * @create 2019-01-16 11:26
 **/
@ServerEndpoint("/websocket")
@Component
@Slf4j
public class WebSocketService {

    private static int onlineCount = 0;
    public static Map<String, WebSocketService> webSocketMap = new HashMap<>();
    private Session session;
    private String id;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        String queryString = session.getQueryString();
        if (StringUtils.isNoneBlank(queryString)) {
            String[] querys = queryString.split("&");
            for (String q : querys) {
                String[] qs = q.split("=");
                if ("id".equals(qs[0])) {
                    this.id=qs[1];
                    webSocketMap.put(qs[1], this);
                    break;
                }
            }
        }
        log.info("id :"+id+" isOpen");
       /* addOnlineCount();
        log.info("有新链接加入!当前在线人数为" + getOnlineCount());*/
    }

    @OnClose
    public void onClose() {
        log.info("id :"+id+" isClose");
        webSocketMap.remove(id);
      /*  subOnlineCount();
        log.info("有一链接关闭!当前在线人数为" + getOnlineCount());*/
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        log.info("来自客户端的消息:" + message);
        // 群发消息
        /*for (WebSocketService item : webSocketSet) {
            item.sendMessage(message);
        }*/
    }

    public void sendMessage(String message) throws IOException {
        log.info("send message to id: "+id );
        this.session.getBasicRemote().sendText(message);
    }

    public static void sendMessage(WebSocketResult message, String id) {
        try {
            WebSocketService webSocketService = webSocketMap.get(id);
            if(webSocketService!=null){
                webSocketService.sendMessage(JSON.toJSONString(message));
            }else{
                log.error("id "+id+" is removed" );
            }
        } catch (Exception e) {
            // e.printStackTrace();
            log.error("id is error: " + e.getMessage());
        }
    }

    public static Boolean isClose(String id){
        WebSocketService webSocketService = webSocketMap.get(id);
        if(webSocketService!=null){
            return  false;
        }else{
            return  true;
        }
    }
}
