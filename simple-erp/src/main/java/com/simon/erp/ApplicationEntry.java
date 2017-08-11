package com.simon.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan
public class ApplicationEntry {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationEntry.class, args);
    }
}
