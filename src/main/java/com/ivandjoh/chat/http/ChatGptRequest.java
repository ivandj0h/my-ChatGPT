package com.ivandjoh.chat.http;

public record ChatGptRequest(
        String model,
        String prompt,
        int temperature,
        int max_tokens
) { }
