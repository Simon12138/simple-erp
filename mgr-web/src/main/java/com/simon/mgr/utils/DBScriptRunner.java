package com.simon.mgr.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBScriptRunner {
	
	private final static Logger logger = LoggerFactory.getLogger(DBScriptRunner.class);
	
	private final static String DB_INFO_FILE = "/application.properties";
	
	private final static String INIT_DB_SCRIPT = "/dbscripts/init/initdb.sql";
	
	@SuppressWarnings("resource")
	public static void initData() {
		// Start to load database information
		Properties properties = new Properties();
		InputStream dbInfoInputStream = DBScriptRunner.class.getResourceAsStream(DB_INFO_FILE);
		try {
			properties.load(dbInfoInputStream);
		} catch (IOException e) {
			logger.error("Cannot find the file: " + DB_INFO_FILE);
		}
		
		// Start to execute the sql script
		Scanner scanner = new Scanner(DBScriptRunner.class.getResourceAsStream(INIT_DB_SCRIPT));
		scanner.useDelimiter("/\\*[\\s\\S]*?\\*/|--[^\\r\\n]*|;");
		try(Connection connection = DriverManager.getConnection(properties.getProperty("spring.datasource.url").trim(), 
				properties.getProperty("spring.datasource.username").trim(), properties.getProperty("spring.datasource.password").trim());
				Statement statement = connection.createStatement();) {
			while (scanner.hasNext()) {
				String line = scanner.next().trim();
		        if (!line.isEmpty())
		        	statement.execute(line);
			}
		} catch(Exception e) {
			logger.error("Execute SQL failed: " + e.getMessage());
		}
	}

}
