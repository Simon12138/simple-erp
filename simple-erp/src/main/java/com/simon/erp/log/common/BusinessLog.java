package com.simon.erp.log.common;

import java.util.Date;
import java.util.Locale;

import org.springframework.format.datetime.DateFormatter;

public class BusinessLog {
	
	public static void logInfo(Class<?> clazz, String message, Object...args) {
		Date date = new Date();
		DateFormatter formatter = new DateFormatter("yyyy-MM-dd hh:mm:ss.SSS");
		System.out.println(formatter.print(date, Locale.CHINESE) + " INFO --- []" + clazz.getName() + " : " + String.format(message, args));
	}
	
	public static void logDebug(Class<?> clazz, String message, Object...args) {
		Date date = new Date();
		DateFormatter formatter = new DateFormatter("yyyy-MM-dd hh:mm:ss.SSS");
		System.out.println(formatter.print(date, Locale.CHINESE) + " DEBUG --- []" + clazz.getName() + " : " + String.format(message, args));
	}
	
	public static void logWarn(Class<?> clazz, String message, Object...args) {
		Date date = new Date();
		DateFormatter formatter = new DateFormatter("yyyy-MM-dd hh:mm:ss.SSS");
		System.out.println(formatter.print(date, Locale.CHINESE) + " WARN --- []" + clazz.getName() + " : " + String.format(message, args));
	}

}
