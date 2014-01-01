package com.psl.selenium.smeet;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

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
	  
	  private class ScreenshotHelper {
	      public void saveScreenshot(String screenshotFileName) throws IOException {
	      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(screenshot, new File(screenshotFileName));
	    }
	  }
		
		
	
}
