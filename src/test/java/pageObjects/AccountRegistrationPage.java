package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@name='firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkCheckbox;
	
	public void setFName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setSubmitBtn()
	{
		btnContinue.click();;
	}
	
	public void setTelephoneNo(String PNumber)
	{
		txtTelephone.sendKeys(PNumber);
	}
	public void setConfirmPassword(String confirmPwd)
	{
		txtConfirmPassword.sendKeys(confirmPwd);
	}
	public void setCheckbox()
	{
		checkCheckbox.click();
	}
}
