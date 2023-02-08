package com.ivandjoh.chat.http;

import com.ivandjoh.chat.dto.ChatGptResponseChoice;
import com.ivandjoh.chat.dto.ChatGptResponseUsage;

public record ChatGptResponse(
        String id,
        String object,
        int created,
        String model,
        ChatGptResponseChoice[] choices,
        ChatGptResponseUsage usage
) { }
