



import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;




import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;





public class GoogleSearch {
	
	//System.setProperty("webdriver.ie.driver","D:/selenium-java-2.28.01/selenium-2.28.0/IEDriverServer.exe");
		private static  WebDriver driver=new FirefoxDriver();
		private static  String baseUrl;
			
	@BeforeClass
	public  static void setUp() throws Exception {
		baseUrl = "http://www.google.com/";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	@Test
	public void Verify_Google_Page_Tittle() throws Exception  {
		Boolean Element=driver.findElement(By.id("gbqfq")).isDisplayed();
		assertTrue("Google Info Box Present ",Element);
		}

	@Test
	public void Verify_Test() throws Exception  {
		String ExpectedLabel="Google Search";
		String buttonLabel=driver.findElement(By.id("gbqfsa")).getText();
		assertEquals(ExpectedLabel,buttonLabel);
		}

	@Test
	public void Verify_SignIn() throws Exception  {
		
		driver.findElement(By.id("gb_70")).click();
		String ExpectedLabel="Stay signed in";
		String signIn=driver.findElement(By.xpath("//*[@id='gaia_loginform']/label[3]/span")).getText();
		
		// String signIn=driver.findElement(By.id("signIn")).getText();
		
		assertEquals(ExpectedLabel,signIn);
		}

	@AfterClass
	public  static void tearDown() throws Exception {
		driver.quit();
			
		}
		
		
	
}


