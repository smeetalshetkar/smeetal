package com.psl.selenium.smeet;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestingGoogle {
	// private String baseUrl;
	//  private WebDriver driver;
	
	  private ScreenshotHelper screenshotHelper;
	  private static  WebDriver driver=new FirefoxDriver();
		private static  String baseUrl;
	  
		
		@Before
	  public void openBrowser() {
			baseUrl = "http://www.bing.com/";
			driver.get(baseUrl);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    screenshotHelper = new ScreenshotHelper();
	  }
	  
	  @After
	  public void saveScreenshotAndCloseBrowser() throws IOException {
	    screenshotHelper.saveScreenshot("screenshot.png");
	    driver.quit();
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
		public void Verify_Test() throws Exception  {
			driver.get("http://www.google.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			String ExpectedLabel="Google Search";
			String buttonLabel=driver.findElement(By.id("gbqfsa")).getText();
			assertEquals(ExpectedLabel,buttonLabel);
			}

		@Test
		public void Verify_SignIn() throws Exception  {
			driver.get("http://www.google.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("gb_70")).click();
			String ExpectedLabel="Stay signed in";
			String signIn=driver.findElement(By.xpath("//*[@id='gaia_loginform']/label[3]/span")).getText();
			
			// String signIn=driver.findElement(By.id("signIn")).getText();
			
			assertEquals(ExpectedLabel,signIn);
			}
	  
	  
	  
	  private class ScreenshotHelper {
	      public void saveScreenshot(String screenshotFileName) throws IOException {
	      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot, new File(screenshotFileName));
	    }
	  }
		
		
	
}
