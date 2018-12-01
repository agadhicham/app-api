package org.m2i;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication

//@ImportResource("spring-bean.xml")
public class AngularCompteBApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularCompteBApplication.class, args);
	}
}
