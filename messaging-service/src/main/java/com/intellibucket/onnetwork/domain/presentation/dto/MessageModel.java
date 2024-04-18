package com.intellibucket.onnetwork.domain.presentation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageModel {
    private MessageType type;
    private String content;
    private String sender;
}
