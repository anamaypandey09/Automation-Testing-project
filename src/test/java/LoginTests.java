import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import generics.ScreenShot;
import pom.LoginPOM;
import utility.DriverFactory;
import utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeTest
	public void setupBeforeClass() throws IOException {
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./src/main/resources/url.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		
	}
	
	
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a"));
		actions.moveToElement(target).perform();		
		Thread.sleep(3000);
		loginPOM.clicklogoutbtn();
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test
		public void validLoginTest() throws InterruptedException {
		loginPOM.gosignin();
		Thread.sleep(3000);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		Thread.sleep(3000);
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
	}
	
	
}
