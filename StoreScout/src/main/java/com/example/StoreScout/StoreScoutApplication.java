package com.example.StoreScout;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreScoutApplication {

	public static void main(String[] args) {

        // environment configuration using dotenv
        Dotenv dotenv = Dotenv.configure()
                        .ignoreIfMissing().load();

        dotenv.entries().forEach((entry) -> System.setProperty(entry.getKey(), entry.getValue()));


        SpringApplication.run(StoreScoutApplication.class, args);
	}

}
