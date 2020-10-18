import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataprovider.filling_data;

import generics.ScreenShot;
import pom.LoginPOM;
import utility.DriverFactory;
import utility.DriverNames;
import generics.GenericMethods;

public class RETC_043 {

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
	
	@Test(dataProvider = "excel-inputs", dataProviderClass = filling_data.class)
	public void test(String key1, String key2 ) throws InterruptedException {
		 Thread.sleep(3000);
		 
	//1. Click on Properties tab
		WebElement properties=genericMethods.getElement("//*[@id=\"menu-posts-property\"]/a/div[3]", "xpath");
		properties.click();
		System.out.println("Got the properties tab");
		
	//2. Click on Add New link	
		WebElement add_new=genericMethods.getElement("//*[@id=\"menu-posts-property\"]/ul/li[3]/a", "xpath");
		Thread.sleep(3000);
		add_new.click();
		System.out.println("clicking on the addnew tab");
		
	//3. Enter valid credentials in Enter Title Here textbox	
		WebElement title=genericMethods.getElement("post_title", "name");
		title.click();
		title.sendKeys(key1);
		
	//4. Enter valid credentials in textbox	
		WebElement textbox=genericMethods.getElement("content", "id");
		textbox.click();
		textbox.sendKeys(key2);
		Thread.sleep(2000);
		
	//5. Click on Publish button	
		WebElement publish=genericMethods.getElement("//*[@id=\"publish\"]", "xpath");
		Thread.sleep(2000);
		publish.click();
		Thread.sleep(5000);
		
	//6. Click on View Post link	
		WebElement post=genericMethods.getElement("//*[@id=\"message\"]/p/a", "xpath");
		post.click();
		Thread.sleep(2000);
		screenShot.captureScreenShot("Firsttt");
		
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
