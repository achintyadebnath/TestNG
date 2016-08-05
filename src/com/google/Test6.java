package com.google;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test6 {
	public String baseURL = "http://newtours.demoaut.com/";
	public WebDriver driver = new FirefoxDriver();
	public String expected = null;
	public String actual = null;

	
	@BeforeTest
	public void launchBrowser() {
		driver.get(baseURL);
	}

	@BeforeMethod
	public void verifyHomePageTitle() {
		expected = "Welcome: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority = 1)
	public void Login() throws Exception {
		XSSFWorkbook myWorkbook = new XSSFWorkbook("C:/Selenium/AMercury.xlsx");
		XSSFSheet s1 = myWorkbook.getSheet("Input");
		
		driver.findElement(By.name("userName")).sendKeys(s1.getRow(6).getCell(0).getStringCellValue());
		driver.findElement(By.name("password")).sendKeys(s1.getRow(6).getCell(1).getStringCellValue());
		driver.findElement(By.name("login")).click();
		
		expected = "Find a Flight: Mercury Tours: ";
		actual = driver.getTitle();
		
		Assert.assertEquals(actual, expected);
		myWorkbook.close();
	}
  

	@AfterMethod
	public void afterMethod() {
		driver.findElement(By.name("SIGN-OFF")).click();
		
		expected = "Sign-on: Mercury Tours";
		actual = driver.getTitle();
		
		Assert.assertEquals(actual, expected);
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Test Passed");
		driver.close();
	}
}