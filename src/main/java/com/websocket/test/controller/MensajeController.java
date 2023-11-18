package com.websocket.test.controller;

import com.websocket.test.model.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MensajeController {

    @MessageMapping("/envio")
    @SendTo("/tema/mensajes")
    public Mensaje envio(Mensaje mensaje) {
        return new Mensaje(mensaje.getNombre(), mensaje.getContenido());
    }

    @MessageMapping("/respuesta")
    public void recibido(String mensaje) {
        System.out.println(mensaje);
    }
}
