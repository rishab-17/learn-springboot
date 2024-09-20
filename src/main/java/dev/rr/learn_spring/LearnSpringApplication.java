package dev.rr.learn_spring;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import dev.rr.learn_spring.run.*;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

//import org.springframework.context.ConfigurableApplicationContext;
import org.slf4j.Logger;
//import org.springframework.*;
//import org.springframework.context.annotation.Bean;;
//import org.slf4j.LoggerFactory;


@SpringBootApplication
public class LearnSpringApplication {

	private static final Logger log = LoggerFactory.getLogger(LearnSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringApplication.class, args);
		log.info("Application started"); //there are different types of logging

	}

	@Bean
	CommandLineRunner runner(){
		return args ->{
			Run run = new Run(1, "testrun", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
			log.info("Run" + run);
		};
	}

}
