package com.phoneScamCatcher.scatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@SpringBootApplication
public class ScatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScatcherApplication.class, args);
		Web3j web3j = Web3j.build(new HttpService());
	}

}
