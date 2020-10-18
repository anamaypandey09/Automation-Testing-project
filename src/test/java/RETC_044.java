import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataprovider.filling_data;
import generics.GenericMethods;
import generics.ScreenShot;
import pom.LoginPOM;
import utility.DriverFactory;
import utility.DriverNames;

public class RETC_044 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods;
	
	@BeforeTest
	public void setupBeforeClass() throws IOException, InterruptedException {
		
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./src/main/resources/url.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver);
		// open the browser 
		driver.get(baseUrl);
		loginPOM.gosignin();
		Thread.sleep(3000);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		Thread.sleep(3000);
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		
	}
	
	@Test
	public void test() throws InterruptedException {
		 Thread.sleep(3000);
	
	//1. Click on Properties link	 
		 WebElement properties=genericMethods.getElement("//*[@id=\"menu-posts-property\"]/a/div[3]", "xpath");
		 properties.click();
		 Thread.sleep(2000);
		 
	//2. Click on Features link	 
		 WebElement features=genericMethods.getElement("//*[@id=\"menu-posts-property\"]/ul/li[4]/a", "xpath");
		 Thread.sleep(2000);
		 features.click();
	
	//3. Enter Valid Credentials in Name textbox	 
		 WebElement name=genericMethods.getElement("tag-name", "id");
		 Thread.sleep(2000);
		 name.click();
		 name.sendKeys("New Launches");
		 Thread.sleep(2000);
	
	//4. Enter Valid Credentials in Slug textbox	 
		 genericMethods.getElement("tag-slug", "id").sendKeys("launch");
		 Thread.sleep(2000);
		 
	//5. Enter Valid Credentials in Description textbox	 
		 genericMethods.getElement("tag-description", "id").sendKeys("New Launches of villas, apartments, flats");
		 Thread.sleep(2000);
		 
	//6. Click on Add New Feature button	 
		 WebElement addfeature=genericMethods.getElement("submit", "id");
		 Thread.sleep(2000);
		 addfeature.click();
		 Thread.sleep(2000);
		 
	//7. Click on Add new link of Properties section	 
		 WebElement add_new=genericMethods.getElement("//*[@id=\"menu-posts-property\"]/ul/li[3]/a", "xpath");
		 Thread.sleep(2000);
		 add_new.click();
	
	//8. Enter valid credentials in Enter Title Here textbox	 
		 WebElement title=genericMethods.getElement("post_title", "name");
		 title.click();
		 title.sendKeys("prestige");
		 
	//9. Enter valid credentials in textbox	 
		 WebElement textbox=genericMethods.getElement("content", "id");
		 textbox.click();
		 textbox.sendKeys("hometown");
	
    //10. Click on checkbox beside added Feature of Features section
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement checkbox = genericMethods.getElement("//*[@id=\"in-property_feature-1618\"]", "xpath");
		 Thread.sleep(2000);
		 checkbox.click();
		 Thread.sleep(2000);
		 js.executeScript("window.scrollBy(0,-250)", "");
		 
	//11. Click on Publish button	 
		 WebElement publish=genericMethods.getElement("//*[@id=\"publish\"]", "xpath");
		 Thread.sleep(2000);
		 publish.click();
		 Thread.sleep(5000);
		 WebElement post=genericMethods.getElement("//*[@id=\"message\"]/p/a", "xpath");
		 post.click();
		 Thread.sleep(2000);
}
	
	@AfterTest
	public void aftertest() throws Exception {
		Thread.sleep(3000);
		loginPOM.usernamebtn();
		Thread.sleep(2000);
		loginPOM.clicklogoutbtn();		
		Thread.sleep(2000);
		driver.quit();
	}
}