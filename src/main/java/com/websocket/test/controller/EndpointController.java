package com.websocket.test.controller;

import com.websocket.test.model.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EndpointController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/send/push")
    public void sendPush(@RequestBody List<Mensaje> mensajes){
        try {
            mensajes.forEach(data -> {
                simpMessagingTemplate.convertAndSend("/tema/mensajes", data);
            });
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
