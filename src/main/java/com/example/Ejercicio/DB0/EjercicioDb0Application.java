package com.example.Ejercicio.DB0;

import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.input.PersonainputDTO;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;


@SpringBootApplication
@EnableFeignClients
public class EjercicioDb0Application {

	public static void main(String[] args) {

		SpringApplication.run(EjercicioDb0Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(PersonaService personaService){
		return args -> {
			personaService.addPerson(new PersonainputDTO("Cristian","cris0503","cristian","cristian","crist@bosonit.com","crist@hotmail.com","Barcelona",true,new Date(),"",new Date(),true));
		};
	}

}
