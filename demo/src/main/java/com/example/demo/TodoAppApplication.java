package com.example.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoAppApplication {

	public static void main(String[] args) {
		// configure dotenv to load the env variables from my .env file
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        dotenv.entries().forEach((entry) -> System.setProperty(entry.getKey(), entry.getValue())); // so of the environment variable that are added in env file will be configure to jvm



        SpringApplication.run(TodoAppApplication.class, args);
	}

}
