package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 스케줄링 활성화
public class JavaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaTestApplication.class, args);
	}

}
