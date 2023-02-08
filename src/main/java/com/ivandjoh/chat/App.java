package com.ivandjoh.chat;

import com.ivandjoh.chat.service.ServiceGPT;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class App {

	public static void main(
			String[] args
	) throws IOException, InterruptedException {
		ServiceGPT.serviceExec(args);
	}
}
