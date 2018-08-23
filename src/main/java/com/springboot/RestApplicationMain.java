package com.springboot;
//Main method

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Calls IOC Container
/*It is made up of 3 annotations 
1. @ComponentScan
2. @Configuration
3. @EnableAutoConfiguration*/
public class RestApplicationMain {

		public static void main(String[] args )
		{
			SpringApplication.run(RestApplicationMain.class, args);
			/* This method do the following things
		 	1. Sets up the default spring configuration
			2. Starts the tomcat server
			3. Performs the class path scan
			4. Creates spring application context (like ApplicationContext in spring .xml file)
			5. Contains all the annotations and beans
			*/
			
		}
}