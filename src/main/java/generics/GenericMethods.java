package generics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {

WebDriver driver ; 
	
	public GenericMethods(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getElement(String locator, String type){
		WebElement element  = null;
		//type = type.toLowerCase();
		
		if(type.equals("id")){
			element  =  driver.findElement(By.id(locator));
		} else if(type.equals("css")){
			element = driver.findElement(By.cssSelector(locator));
		}else if (type.equals("name")){
			element  = driver.findElement(By.name(locator));
		}else if(type.equals("xpath")){
			element = driver.findElement(By.xpath(locator));
		}else if(type.equals("classname")) {
			element = driver.findElement(By.className(locator));
		}else if(type.equals("linktext")) {
			element = driver.findElement(By.linkText(locator));
		}else if(type.equals("partiallinktext")) {
			element = driver.findElement(By.partialLinkText(locator));
		}else if(type.equals("tagname")) {
			element = driver.findElement(By.tagName(locator));
		}
		
		
		if(checkSingleEntry(locator, type)){
			System.out.println("Element Found and Returned");
			return element;
		}	
		System.out.println("Sorry Element not found, so not returned...");
		return null;


	}
	

	public List<WebElement> getElementsAsList(String locator, String type){
		type = type.toLowerCase();
		if(type.equals("id")){
			return driver.findElements(By.id(locator));
		}else if(type.equals("name")){
			return driver.findElements(By.name(locator));
		}else if(type.equals("xpath")){
			return driver.findElements(By.xpath(locator));
		}else if(type.equals("class")){
			return driver.findElements(By.className(locator));
		}else if(type.equals("css")){
			return driver.findElements(By.cssSelector(locator));
		}else if(type.equals("locator")){
			return driver.findElements(By.linkText(locator));
		}else if(type.equals("partiallinktext")){
			return driver.findElements(By.partialLinkText(locator));
		}else if(type.equals("tagname")){
			return driver.findElements(By.tagName(locator));
		}return null;
	}
	
	// return true if element exists 
	// this method works for us when we have more than 1 element 
	// to be found for 
	public boolean isElementFound(String locator, String type){
		return getElementsAsList(locator, type).size()>0;
	}
	
	// this method gives true only where there is an single entry 
	// in the DOM 
	public boolean checkSingleEntry(String locator, String type){
		return getElementsAsList(locator, type).size() ==1;
	}
	
	
	
}
