package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver; 
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	@FindBy(xpath="(//a[normalize-space()='Create an Account'])[1]") WebElement lnk_createaccount_xpath;
	@FindBy(xpath="(//a[text()[normalize-space() = 'Sign In']])[1]") WebElement lnk_signin_xpath;
	@FindBy(xpath="(//span[contains(text(),'Welcome')])[1]") WebElement txt_welcome_xpath;
	@FindBy(xpath="(//button[@type='button'])[1]") WebElement drpdownbtn_welocme_xpath;
	@FindBy(xpath="(//a[normalize-space()='Sign Out'])[1]") WebElement lnk_signout_xpath;
	
	
	//Action
	public void click_CreateAccount() {
		lnk_createaccount_xpath.click();
	}

	public void click_SignIn() {
		lnk_signin_xpath.click();
	}
	
	
	public boolean isWelComeExists() { //Successful signin verification
		try 
		{
			return(txt_welcome_xpath.isDisplayed());
		}
		catch (Exception e)
		{
			return(false);
		}
	}
	
	public void click_WelComedrp() {
		drpdownbtn_welocme_xpath.click();
	}
	
	public void click_SignOut() {
		lnk_signout_xpath.click();
	}
	
}
