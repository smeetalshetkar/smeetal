package com.psl.selenium.smeet;

import static junit.framework.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;

import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestingGoogle {
	// private String baseUrl;
	//  private WebDriver driver;
	
	  private ScreenshotHelper screenshotHelper;
	  private static  WebDriver driver;
		private static  String baseUrl;
	  
		
		@Before
	  public void openBrowser() {
			driver=new FirefoxDriver();
			baseUrl = "http://www.bing.com/";
			driver.get(baseUrl);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    screenshotHelper = new ScreenshotHelper();
	  }
	  
	   
	  @Test
	  public void pageTitleAfterSearchShouldBeginWithDrupal() throws IOException {
	 // assertEquals("The page title should equal Google at the start of the test.", "Google", driver.getTitle());
	    WebElement searchField = driver.findElement(By.id("sb_form_q"));
	    searchField.sendKeys("Drupal");
	    searchField.submit();
	    String verify=driver.findElement(By.xpath("//*[@id='wg0']/li[1]/div/div/div[1]/h3/a/strong[1]")).getText();
	    assertEquals("Drupal",verify);
	  
	  }
	  @Test
	  public void pageTitleAfterSearchShouldBeginWithDrupal1() throws IOException {
	 // assertEquals("The page title should equal Google at the start of the test.", "Google", driver.getTitle());
	    WebElement searchField = driver.findElement(By.id("sb_form_q"));
	    searchField.sendKeys("Selenium");
	    searchField.submit();
	    String verify=driver.findElement(By.xpath("//*[@id='wg0']/li[1]/div/div/div[1]/h3/a/strong[1]")).getText();
	    assertEquals("Selenium",verify);
	  
	  }
	 

		@After
		  public void saveScreenshotAndCloseBrowser() throws IOException {
		    screenshotHelper.saveScreenshot("screenshot.png");
		    driver.quit();
		  }
		 
	  
	  private class ScreenshotHelper {
	      public void saveScreenshot(String screenshotFileName) throws IOException {
	      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot, new File(screenshotFileName));
	    }
	  }
		
		
	
}
