package com.sridhar.springbootjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseAPIapp {

	/*
	 * 1) Sets up default configurations. Spring boot prefers convention over
	 * configuration,where it addresses over 80% of the use case already
	 * 
	 * 2) Every Spring Application has an application context that runs when the
	 * application runs *****Spring container is the application context*****
	 * So,this spring-boot-starter creates that application context
	 * 
	 * 3) Performs the class path scan. Like , it treats the @controller as a
	 * controller,@service as a ...... so on...For this to happen, it has to perform
	 * a class-path scan logically
	 * 
	 * 4) Finally,it starts a tomcat server.This came with spring boot.This is
	 * why,it gives a stand-alone application
	 */
	public static void main(String[] args) {
		SpringApplication.run(CourseAPIapp.class, args);
	}

}
