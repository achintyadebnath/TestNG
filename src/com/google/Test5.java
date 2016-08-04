package com.google;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test5 {
  public String baseurl = "http://newtours.demoaut.com/";
  public WebDriver driver = new FirefoxDriver();
  public String expected = null;
  public String actual = null;
  
  @BeforeTest
  public void launchBrowser() {
	  driver.get(baseurl);
  }
  
  @BeforeMethod
  public void verifyHomePageTitle() {
	  expected = "Welcome: Mercury Tours";
	  actual = driver.getTitle();
	  Assert.assertEquals(actual, expected);
  }
  
  @Test (priority = 1)
  public void register() {
	  driver.findElement(By.linkText("REGISTER")).click();
	  expected = "Register: Mercury Tours";
	  actual = driver.getTitle();
	  Assert.assertEquals(actual, expected);
  }
  
  @Test (priority = 2)
  public void support() {
	  driver.findElement(By.linkText("SUPPORT")).click();
	  expected = "Under Construction: Mercury Tours";
	  actual = driver.getTitle();
	  Assert.assertEquals(actual, expected);
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.navigate().back();
  }

  @AfterTest
  public void terminateBrowser() {
	  driver.close();
  }
  
}