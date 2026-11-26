package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	 @FindBy (xpath="//input[@id='input-email']")
	 WebElement  txtEmailAddress;
	 
	 @FindBy (xpath="//input[@id='input-password']")
	 WebElement  txtPassword;
	 
	 @FindBy (xpath= "//button[normalize-space()='Login']")
	 WebElement btnLogin;
	 
	 public void setEmail(String email)
	 {
		 txtEmailAddress.sendKeys(email);
	 }
	 
	 public void setPassword(String pwd)
	 {
		 txtPassword.sendKeys(pwd); 
	 }
	 
	 public void clickLogin()
	 {
		 btnLogin.click();
	}
	 
	 public boolean isWarningMessageDisplayed() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        WebElement warningMsg = wait.until(
		            ExpectedConditions.visibilityOfElementLocated(
		                By.xpath("//div[@class='alert alert-danger alert-dismissible']")
		            )
		        );
		        return warningMsg.isDisplayed();
		    } catch (Exception e) {
		        return false;
		    }
		}

		 
}
