package com.ivandjoh.chat.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

@Service
public class ServiceGPT {

    public static void serviceExec() throws IOException, InterruptedException {

        Dotenv dotenv = Dotenv.load();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a String to search for: ");

        String searchStr = scanner.nextLine();

        String userInput = """
                {
                    "model": "text-davinci-001",
                    "prompt": "%s",
                    "temperature": 0.9,
                    "max_tokens": 100
                }
                """.formatted(searchStr);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openai.com/v1/completions"))
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer " + dotenv.get("OPEN_AI_API_KEY"))
                .POST(HttpRequest.BodyPublishers.ofString(userInput))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        try {
            System.out.println(response.get().body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
