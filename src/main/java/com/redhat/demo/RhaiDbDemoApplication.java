package com.redhat.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.redhat.demo"})
public class RhaiDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RhaiDbDemoApplication.class, args);
	}

}
