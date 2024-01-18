package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
	
	public WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		super(driver);
		
	}
	//Locators
	@FindBy(id="email") WebElement txtbox_email_id;
	@FindBy(id="pass") WebElement txtbox_password_id;
	@FindBy(id="send2") WebElement btn_signin_id;
	
	//Actions
	public void set_email(String email) {
		txtbox_email_id.sendKeys(email);
	}
	
	public void set_Password(String pwd) {
		txtbox_password_id.sendKeys(pwd);
	}
	
	public void click_SignIn() {
		btn_signin_id.click();
	}
}
