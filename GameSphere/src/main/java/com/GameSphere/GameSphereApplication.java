package com.GameSphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.GameSphere.dao")

public class GameSphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameSphereApplication.class, args);
	}

}
