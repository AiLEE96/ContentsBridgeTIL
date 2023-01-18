package org.socket.chat.controller;

import org.socket.chat.dto.EnterRequest;
import org.socket.chat.dto.EnterResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class JoinMessageController {

    @MessageMapping("/join")
    @SendTo("/subscribe/join")
    public EnterResponse joinMessage(final EnterRequest enterRequest) {
        return EnterResponse.of(enterRequest);
    }
} 
    
