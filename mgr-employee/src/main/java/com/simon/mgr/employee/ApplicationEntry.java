package com.simon.mgr.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.simon.mgr.common.utils.DBScriptRunner;


@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan
public class ApplicationEntry {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationEntry.class, args);
        DBScriptRunner.initData();
    }
}
