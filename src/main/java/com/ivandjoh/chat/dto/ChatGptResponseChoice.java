package com.ivandjoh.chat.dto;

public record ChatGptResponseChoice(
        String text,
        int index,
        Object logprobs,
        String finish_reason
) { }
