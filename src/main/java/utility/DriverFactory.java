package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class DriverFactory {

	
		// it only a reference 
		private static WebDriver driver; 
		
		public static WebDriver getDriver(String driverName){

			if(driverName.equals(DriverNames.CHROME)){
				System.setProperty(Driver.CHROME, Driver.CHROME_PATH);
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				
			}
			return driver;
		}
	
}
