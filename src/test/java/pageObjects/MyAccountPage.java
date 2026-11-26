package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class MyAccountPage extends BasePage {

	//import java.time.Duration;

	
		public MyAccountPage (WebDriver driver) {
			super(driver);
		}

		@FindBy(xpath="//h1[text()='My Account']") 
		WebElement msgHeading;
		
		@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") 
		WebElement lnkLogout;
		
		public boolean isMyAccountPageExists()
		{
			try
			{
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//				return wait.until(ExpectedConditions.visibilityOf(msgHeading)).isDisplayed();
				return msgHeading.isDisplayed();
			}
			catch (Exception e)
			{
				return false;
			}
		}
		
		public void clickLogout()
		{
			lnkLogout.click();
		}
			
	}



