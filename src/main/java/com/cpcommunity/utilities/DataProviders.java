package com.cpcommunity.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {

	

	@Test(dataProvider = "dataMethod")
	public void testMethod(String param) {
		System.out.println("The parameter value is: " + param);
	}

	@DataProvider
	public Object[][] dataMethod() {
		return new Object[][] { { "one" }, { "two" } };
	}

	
	
	
	
	
	
	@DataProvider(name = "masterDP", parallel = false)
	public static Object[][] getDataSuite1(Method m) {

//		System.out.println(m.getName());

		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		String testcase = m.getName();
		return DataUtil.getData(testcase, excel);
	}

}
