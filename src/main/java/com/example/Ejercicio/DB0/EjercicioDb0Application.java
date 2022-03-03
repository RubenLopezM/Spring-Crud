package com.example.Ejercicio.DB0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class EjercicioDb0Application {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioDb0Application.class, args);
	}

}
