package com.simon.mgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.simon.mgr.utils.DBScriptRunner;

@SpringBootApplication
@ComponentScan
public class ApplicationEntry {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationEntry.class, args);
        DBScriptRunner.initData();
    }
}
