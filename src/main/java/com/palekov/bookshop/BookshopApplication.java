package com.palekov.bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//		(exclude = { SecurityAutoConfiguration.class })
public class BookshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
	}

}
