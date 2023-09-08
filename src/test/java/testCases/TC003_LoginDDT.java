package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void text_loginDDT(String username, String password, String exp)
	{
		logger.info("***** Starting TC003 Login data driven test *****");
		
				try 
				{
					HomePage hp = new HomePage(driver);
					hp.clickMyAccount(); 
					hp.clickLogin();
					
					LoginPage lp = new LoginPage(driver);
					lp.setEmail(username);
					lp.setPassword(password);
					lp.clickOnLogin();
					
					MyAccountPage macpage = new MyAccountPage(driver);
					boolean targetPage = macpage.isMyAccountPageExists();				
		
					if(exp.equals("Valid")) 
					{
						if(targetPage==true) 
						{
							macpage.ClickLogoutBtn();
							Assert.assertTrue(true);
						}
						else
						{
							Assert.assertTrue(false);
						}
					}
					
					if(exp.equals("Invalid"))
					{
						if(targetPage==true)
						{
							macpage.ClickLogoutBtn();
							Assert.assertTrue(false);
						}
						else
						{
							Assert.assertTrue(true);
						}
					}
				}catch (Exception e){
					Assert.fail();
				}
				
				
		logger.info("***** Finished TC003 Login data driven test *****");
	}
}
