package com.dvm.qa.selenium.util;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="dataProvidertest")
	public Object[][] getData() {

		return new Object[][] {
			{"Jorgn","admin@123"},
			{"Jorgn","Jorgn@123"},
			{"Admin","12345"},
			};
		}

	}
