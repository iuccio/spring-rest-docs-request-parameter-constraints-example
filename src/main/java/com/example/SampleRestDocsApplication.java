package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SampleRestDocsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SampleRestDocsApplication.class, args);
	}
	
	@RestController
	static final class ExampleController {
		
		@RequestMapping("/")
		public String example(@RequestParam("example") String example) {
			return example.toUpperCase();
		}
		
	}

}
