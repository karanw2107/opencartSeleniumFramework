package testCases;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	@Test(groups = {"Regression", "Master"})// this groups are used when we have to run the test cases in group
	public void test_account_registration()
	{
	
		logger.debug("application logs.....");
		logger.info("Staring TC001_AccountRegistrationTest...");
		try 
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			regpage.setFName("Karan");
			logger.info("Entered First Name...");
			regpage.setLName("Wani");
			logger.info("Entered Last Name...");
			regpage.setEmail(randomString() + "@gmail.com");
			logger.info("Entered Email with random name...");
			regpage.setTelephoneNo(randomNumbers());
			logger.info("Entered Email with random phone number...");
			regpage.setPassword("test@123");
			logger.info("Entered Password...");
			regpage.setConfirmPassword("test@123");
			logger.info("Entered Password again for confirmation...");
			regpage.setCheckbox();
			regpage.setSubmitBtn();
			logger.info("Clicked on Continue button");
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
}
