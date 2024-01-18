package testCases;

import testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.SignInPage;

public class TC002_SignInTest extends BaseClass{
	
	@Test
	public void verify_SignIn() {
		
		logger.info("**********Staring TC002_SignInTest************");
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
		sp.set_email(p.getProperty("email"));
		sp.set_Password(p.getProperty("pwd"));
		sp.click_SignIn();
		logger.info("Clicked on SignIn button");
		
		
		boolean confirmationpage = hp.isWelComeExists();
		
		if (confirmationpage==true) {
			logger.info("SignIn test passed..");
			Assert.assertTrue(true);
		}
		else {
			logger.error("SignIn test failed");
			Assert.fail();
		}
		
		hp.click_SignOut();
		}
		catch (Exception e) {
			
			Assert.fail();
		}
		
		logger.info("**********Finished TC002_SignInTest************");
	
		
		
		
		
		
		
	}

}
