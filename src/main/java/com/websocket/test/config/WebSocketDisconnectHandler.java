package com.websocket.test.config;

import org.springframework.context.ApplicationListener;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

public class WebSocketDisconnectHandler implements ApplicationListener<SessionDisconnectEvent> {

    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        String sessionId = event.getSessionId();
        // Realiza acciones en el servidor cuando un cliente se desconecta
        System.out.println("Cliente desconectado: " + sessionId);
    }

}
