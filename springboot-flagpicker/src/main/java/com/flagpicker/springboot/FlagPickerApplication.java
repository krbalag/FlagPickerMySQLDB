package com.flagpicker.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FlagPickerApplication {
	public static void main(String[] args) {
		SpringApplication.run(FlagPickerApplication.class, args);
	}
}
