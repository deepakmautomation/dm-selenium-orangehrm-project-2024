package com.dvm.qa.selenium.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.random.RandomGenerator;

import net.bytebuddy.utility.RandomString;

public class TestUtil {

	public static String getCurrentDateTime() {

		LocalDateTime datetime = LocalDateTime.now();

		DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");

		String datenow =  datetime.format(formatter);

		return datenow;
	}


	public static String generateRandomeString(int length) {

		String characters = "ABCDEFGHITJLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		Random random = new Random();

		StringBuilder sb = new StringBuilder(length);

		for(int i=0;i<length;i++) {

			int index = random.nextInt(characters.length());

			sb.append(characters.charAt(index));
		}
		
		return sb.toString();

	}

}
