package testCases;
import pageObject.HomePage;
import testBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.CreateYourAccountPage;

public class TC001_CreateYourAccountTest extends BaseClass {

	@Test
	public void verify_CreateAccount() throws InterruptedException {
		logger.debug("**application log");
		try
		{
		logger.info("******** Starting TC001_CreateYourAccountTest *********");
		HomePage hp = new HomePage(driver);
		hp.click_CreateAccount(); //link in homepage
		logger.info("Clicked on Create Account link");
		
		logger.info("Entering Customer Details..");
		CreateYourAccountPage cp = new CreateYourAccountPage(driver);
		cp.set_FirstName(randomAlphabet());
		cp.set_LastName(randomAlphabet());
		cp.set_Email(randomAlphabet()+"@gmail.com");
		
		String pwd = randomAlphaNum();
		cp.set_Password(pwd);
		cp.set_ConfirmPassword(pwd);
		cp.click_CreateAccount(); //button in CreateYourAccountPage
		logger.info("Clicked on Create Account Button");
		
		String conftxt = cp.capture_confirmationmsg();
		
		logger.info("validation expected msg..");
		if(conftxt.equals("Thank you for registering with Main Website Store.")) 
		{
			
			logger.info("test passed..");
			Assert.assertTrue(true);
			
		}
		else
		{
			
			logger.error("test failed..");
			Assert.fail();
			
		}
		
		}
		
		catch(Exception e)
		{
			
			logger.error("test failed..");
			Assert.fail();
			
		}
		logger.info("******** Starting TC001_CreateYourAccountTest *********");
	}

}