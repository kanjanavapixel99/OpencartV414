package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstName;
@FindBy(xpath="//input[@id='input-lastname']")	
WebElement txtLastName;
@FindBy(xpath="//input[@id='input-email']")	
WebElement txtEmail;

//@FindBy(xpath="")	
//WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")	
WebElement txtPassword;

//@FindBy(xpath="")	
//WebElement txtConfirmPassword;

@FindBy(xpath="//input[@name='agree']")	
WebElement chkdPolicy;
@FindBy(xpath="//button[normalize-space()='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")	
WebElement msgConfirmation;



public void setFirstName(String fname) {
	txtFirstName.sendKeys(fname);
}
public void setLastName(String lname) {
	txtLastName.sendKeys(lname);
}
public void setEmail (String email) {
	txtEmail.sendKeys(email);
}
	

public void setPassword (String pwd) {
	txtPassword.sendKeys(pwd);
}
public void setPrivacyPolicy () {
	chkdPolicy.click();
}
public void clickContinue () {
	btnContinue.click();
}

public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
}
}