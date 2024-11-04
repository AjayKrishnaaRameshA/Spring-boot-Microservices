package com.ajay.conifg_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConifgServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConifgServerApplication.class, args);
	}

}
