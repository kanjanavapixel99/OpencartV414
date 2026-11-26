package testCases;

//import java.time.Duration;

//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test (groups= {"Sanity", "Master"})
	
	public void verify_login() throws InterruptedException
	{
		logger.info (" **** Starting T002_LoginTest **** ");
		
		try {
		HomePage hp=new HomePage(driver);
		 hp.clickMyAccount();
		 hp.clickLogin();
		 
		 LoginPage lp=new LoginPage(driver);
		 lp.setEmail(p.getProperty("email"));
		 lp.setPassword(p.getProperty("password"));
		 lp.clickLogin();
		 
		 //MyAccount
		 
		 MyAccountPage macc=new MyAccountPage(driver);
		 boolean targetPage =macc.isMyAccountPageExists();
		 
		 Assert.assertTrue(targetPage);
		 
//		 macc.clickLogout();
//		 Thread.sleep(5000);
		} 
		catch (Exception e)
		{
			Assert.fail();
		}
		 logger.info(" **** Finished TC_002 LoginTest **** ");
		 
		 
	}
}
	
	


