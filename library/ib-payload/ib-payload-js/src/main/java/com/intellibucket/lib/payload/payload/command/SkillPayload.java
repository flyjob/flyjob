package com.intellibucket.lib.payload.payload.command;


import com.intellibucket.lib.payload.payload.Payload;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillPayload extends Payload {
    private UUID skillId;
}
