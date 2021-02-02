package com.example.redditclonepractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RedditclonepracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedditclonepracticeApplication.class, args);
	}

}
