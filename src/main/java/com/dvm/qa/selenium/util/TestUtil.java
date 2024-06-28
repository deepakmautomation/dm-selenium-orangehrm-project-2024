package com.dvm.qa.selenium.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestUtil {

	public static String getCurrentDateTime() {

		LocalDateTime datetime = LocalDateTime.now();

		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");

		String datenow =  datetime.format(formatter);

		return datenow;
	}

	
	

}
