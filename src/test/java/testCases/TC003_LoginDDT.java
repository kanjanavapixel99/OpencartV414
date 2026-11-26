package testCases;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test (dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= "DataDriven")
	public void verify_loginDDT(String email, String pwd, String exp)
	{
		logger.info("**** Starting TC003_LoginDDT ****");
		try
		{
		//HomePage
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		/* Data is valid - login success - test pass - logout
		 * 				-	login failed- test fail
		 * 
		 * Data is invalid - login success - test fail- logout
		 					login failed - test pass
		 */
		
		System.out.println("DEBUG -> Email: " + email + " | Exp: " + exp + " | targetPage: " + targetPage + " | URL: " + driver.getCurrentUrl());

		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
				
			}
		}
		/*if(exp.equalsIgnoreCase("Invalid"))
		{
		    boolean warningShown = lp.isWarningMessageDisplayed();

		    if(warningShown)
		    {
		        Assert.assertTrue(true);
		    }
		    else
		    {
		        macc.clickLogout();
		        Assert.assertTrue(false);
		    }
		}
		*/
		} 
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC003_LoginDDT ****");
	}

}
