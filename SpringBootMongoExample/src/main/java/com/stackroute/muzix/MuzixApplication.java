package com.stackroute.muzix;

import com.stackroute.muzix.component.FeedDataAppStartRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@SpringBootConfiguration
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class MuzixApplication {
	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);
	}
}

