package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SignInPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_SignInDDT extends BaseClass {
	
	
	@Test(dataProvider="SignInData", dataProviderClass=DataProviders.class)
	public void verify_SignInDDT(String email,String password,String exp) {
		
		logger.info("**********Staring TC003_SignInDDt************");
		logger.debug("Capturing application debug logs....");
		
		try 
		{
		//HomePage
		HomePage hp =new HomePage(driver);
		hp.click_SignIn();
		logger.info("Clicked on SignIn link on the home page..");
		
		//SignInPage
		logger.info("Entering vaild email and password..");
		SignInPage sp = new SignInPage(driver);
		sp.set_email(email);
		sp.set_Password(password);
		sp.click_SignIn();
		logger.info("Clicked on SignIn button");
		
		boolean confirmationpage = hp.isWelComeExists();
		
		if(exp.equalsIgnoreCase("valid")) {
			
			if(confirmationpage==true) {
				hp.click_WelComedrp();
				hp.click_SignOut();
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			
			if(confirmationpage==true) {
				hp.click_WelComedrp();
				hp.click_SignOut();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("**********Finshed TC003_SignInDDT************");
	}

}
