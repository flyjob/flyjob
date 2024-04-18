package com.intellibucket.onnetwork.application.presentation.api;

import com.intellibucket.onnetwork.application.spec.MessagingSpec;
import com.intellibucket.onnetwork.domain.presentation.dto.MessageModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class MessagingController implements MessagingSpec {

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public MessageModel register(@Payload MessageModel chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    /**
     * Sends a chat message to all connected users.
     * <p>
     * param chatMessage The chat message to be sent.
     * return The sent chat message.
     */
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public MessageModel sendMessage(@Payload MessageModel chatMessage) {
        return chatMessage;
    }

}
