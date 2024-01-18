package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateYourAccountPage extends BasePage {
	
	WebDriver driver;
	
	public CreateYourAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	@FindBy(id="firstname") WebElement txtbox_firstname_id;
	@FindBy(id="lastname") WebElement txtbox_lastname_id;
	@FindBy(id="email_address") WebElement txtbox_email_id;
	@FindBy(id="password") WebElement txtbox_password_id;
	@FindBy(id="password-confirmation") WebElement txtbox_confirmpassword_id;
	@FindBy(xpath="(//span[contains(text(),'Create an Account')])[1]") WebElement btn_createAccount_xpath;
	@FindBy(xpath="//div[@class='message-success success message']/div") WebElement txt_successfullregistraion_xpath;
	
	
	//Action
	public void set_FirstName(String firstname) {
		txtbox_firstname_id.sendKeys(firstname);
	}
	
	public void set_LastName(String lastname) {
		txtbox_lastname_id.sendKeys(lastname);
	}
	
	public void set_Email(String email) {
		txtbox_email_id.sendKeys(email);
	}
	
	public void set_Password(String password) {
		txtbox_password_id.sendKeys(password);
	}
	
	public void set_ConfirmPassword(String confirmpassword) {
		txtbox_confirmpassword_id.sendKeys(confirmpassword);
	}
	
	public void click_CreateAccount() {
		btn_createAccount_xpath.click();
	}
	
	public String capture_confirmationmsg() {
		String successtxt = txt_successfullregistraion_xpath.getText();
		return successtxt;
	}


}
