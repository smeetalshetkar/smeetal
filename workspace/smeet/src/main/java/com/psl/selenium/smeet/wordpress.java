package com.psl.selenium.smeet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class wordpress {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		WebElement username;
		WebElement password;
		WebElement submit;
		
		driver.get("http://www.wordpress.com/");
		/*driver.findElement(By.name("log")).sendKeys("smeetalshetkar");
		driver.findElement(By.name("pwd")).sendKeys("smeetal123");
		driver.findElement(By.xpath(".//form[@id='signin-form']/input[4]")).click();
		Thread.sleep(10);*/

		username=driver.findElement(By.name("log"));
		password=driver.findElement(By.name("pwd"));
		submit=driver.findElement(By.xpath(".//form[@id='signin-form']/input[4]"));
		
		username.sendKeys("smeetalshetkar");
		password.sendKeys("smeetal123");
		submit.click();
		
		Thread.sleep(10);
		
		
		
		driver.quit();
	}
}
