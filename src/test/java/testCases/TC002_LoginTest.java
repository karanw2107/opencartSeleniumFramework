package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = {"Sanity", "Master"})// this groups are used when we have to run the test cases in group
	public void login_test()
	{
		try {
				HomePage hp = new HomePage(driver);
				hp.clickMyAccount(); 
				hp.clickLogin();
				
				LoginPage lp = new LoginPage(driver);
				lp.setEmail(rb.getString("username"));
				lp.setPassword(rb.getString("password"));
				lp.clickOnLogin();
				
				MyAccountPage macpage = new MyAccountPage(driver);
				boolean targetPage = macpage.isMyAccountPageExists();
				Assert.assertEquals(targetPage, true, "Invalid Login Data");
			}catch(Exception e) {
				Assert.fail();
			}
		
		logger.info("****************** Finished TC002 ******************");
	}
	
}
