package com.ivandjoh.chat.service;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.Scanner;

@Service
public class ServiceGPT {

    static String getGPT(String str) {
        return str;
    }

    public static void serviceExec() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a String to search for: ");

        String searchStr = scanner.nextLine();

        String userInput = """
                {
                    "model": "text-davinci-001",
                    "prompt": "%s",
                    "max_tokens": 100,
                    "temperature": 1,
                }
                """.formatted(searchStr);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization", "Beaere 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")
                .POST(HttpRequest.BodyPublishers.ofString(userInput))
                .build();
    }
}
