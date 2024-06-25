package com.learn.quizMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients("com.learn.feign")

@EntityScan("com.learn.model") //This is telling Spring to look for DB entities here
@ComponentScan("com.learn") //Spring will look for Beans within com.learn (and its subpackages)
@EnableJpaRepositories("com.learn.dao") //This allows us to use JpaRepository in our daos

public class QuizMicroserviceApplication {

	public static void main(String[] args) {
		
		System.out.print("++++++START QUIZ SERVICE APPLICATION HERE----------------");
		SpringApplication.run(QuizMicroserviceApplication.class, args);
		
		System.out.print(" QUIZ SERVICE APPLICATION STARTED HERE----------------");
	}

}
