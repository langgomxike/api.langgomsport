package com.langgomsport.langgomsport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableCaching
public class LanggomsportApplication {

	@CrossOrigin("http://127.0.0.1:3000")
	public static void main(String[] args) {
		SpringApplication.run(LanggomsportApplication.class, args);
	}

}
