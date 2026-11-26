package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
 @FindBy (xpath="//i[@class='fa-solid fa-user']")
 WebElement  lnkMyaccount;
 
 @FindBy (xpath="//a[normalize-space()='Register']")
 WebElement  lnkRegister;
 
 @FindBy (linkText= "Login")
 WebElement linkLogin;
 
 public void clickMyAccount()
 {
	 lnkMyaccount.click();
 }
 
 public void clickRegister()
 {
	 lnkRegister.click(); 
 }
 
 public void clickLogin()
 {
	 linkLogin.click();
	 
 }
 
}
