package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.LoginPage;


public class LoginTest extends BaseTest{
	@BeforeMethod
	public void browser() {
		 driver= LaunchBrowser.openChrome();
	}
	  @Test
      public void verifyIfUserIsAbleToLogin() {
    	  LoginPage loginPage = new LoginPage(driver);
    	  loginPage.enterTheUsername(driver,"standard_user");
    	  loginPage.enterThePassword(driver,"secret_sauce");
    	  loginPage.clickOnLogin();
      }
      
}
