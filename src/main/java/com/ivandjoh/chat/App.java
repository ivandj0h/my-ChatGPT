package com.ivandjoh.chat;

import com.ivandjoh.chat.service.ServiceGPT;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ServiceGPT.serviceExec();
	}

}
