package com.wakacop.wakacop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "/")
@EnableScheduling
public class WakacopApplication {

	@GetMapping
	public String testeHome(){
		return "teste regio wakacop";
	}

	public static void main(String[] args) {
		SpringApplication.run(WakacopApplication.class, args);
	}

}
