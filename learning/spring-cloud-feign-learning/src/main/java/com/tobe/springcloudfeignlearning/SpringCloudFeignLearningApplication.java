package com.tobe.springcloudfeignlearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudFeignLearningApplication {

	@Autowired
	private MailClient mailClient;

	public static void main(String[] args) {

		SpringApplication.run(SpringCloudFeignLearningApplication.class, args);
	}

}

