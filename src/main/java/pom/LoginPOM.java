package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {

private WebDriver driver;	

public LoginPOM(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(className="sign-in")
	private WebElement signin;

	@FindBy(id="user_login")
	private WebElement userName; 
	

	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	
	@FindBy(linkText="Log Out")
	private WebElement logoutBtn;
	
	@FindBy(className="user-name")
	private WebElement usernameBtn;
	
	
	public void gosignin() {
		this.signin.click();
		
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	
	public void clicklogoutbtn() {
		this.logoutBtn.click();
	}
	
	public void usernamebtn() {
		this.usernameBtn.click();
	}

}
