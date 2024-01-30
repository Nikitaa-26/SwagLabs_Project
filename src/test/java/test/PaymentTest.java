package test;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.LoginPage;
import pom.PaymentPage;
import pom.PersonalDetailsPage;
import pom.ProductDisplayPage;
@Listeners(test.Listeners.class)
public class PaymentTest extends BaseTest {
	  LoginPage loginPage;
	  ProductDisplayPage productDislayPage;
	  CartPage cartPage;
	  PersonalDetailsPage personalDetailsPage;
	  PaymentPage paymentPage;
	  
	@BeforeMethod
     public void browser() {
	    driver = LaunchBrowser.openChrome();
	 
	    loginPage = new LoginPage(driver); 
	    loginPage.enterTheUsername(driver, "standard_user");
	    loginPage.enterThePassword(driver,"secret_sauce");
	    loginPage.clickOnLogin();
    }
	@Test(priority = 1)
	public void verifyIfUserIsAbleToEnterThePersonalInformation() throws InterruptedException {
		
		productDislayPage = new ProductDisplayPage(driver);
		productDislayPage.clickOnAddToCartButton(0);  
		productDislayPage.clickOnCartIcon();
		
		cartPage = new CartPage(driver);
		cartPage.clickOnCheckout();
				
		personalDetailsPage = new PersonalDetailsPage(driver);
		personalDetailsPage.enterName("Nikita");
		personalDetailsPage.enterLastName("Patil");
		personalDetailsPage.enterPostalCode("425001");
		personalDetailsPage.clickOnContinueButton();					
	}
	
	@Test(priority = 2)
	public void verifyIfUserIsAbleTOrderTheProductSucessfully() throws InterruptedException {
		productDislayPage = new ProductDisplayPage(driver);
		productDislayPage.clickOnAddToCartButton(0);  
		productDislayPage.clickOnCartIcon();
		
		cartPage = new CartPage(driver);		
		cartPage.clickOnCheckout();
		
		personalDetailsPage = new PersonalDetailsPage(driver);
		personalDetailsPage.enterName("Nikita");
		personalDetailsPage.enterLastName("Patil");
		personalDetailsPage.enterPostalCode("425001");
		personalDetailsPage.clickOnContinueButton();	
		personalDetailsPage.clickOnFinishButton();
		
		paymentPage= new PaymentPage(driver);
		String expectedText = paymentPage.orderSuccess();
	//	System.out.println(expectedText);
		Assert.assertEquals(expectedText,"Thank you for your order!");
	}

	@Test(priority = 3)
	public void verifyIfUserIsAbleToCancelTheOrder() throws InterruptedException {
		productDislayPage = new ProductDisplayPage(driver);
		productDislayPage.clickOnAddToCartButton(0);  
		productDislayPage.clickOnCartIcon();
		
		cartPage = new CartPage(driver);
		cartPage.clickOnCheckout();
		
		personalDetailsPage = new PersonalDetailsPage(driver);
		personalDetailsPage.enterName("Nikita");
		personalDetailsPage.enterLastName("Patil");
		personalDetailsPage.enterPostalCode("425001");
		personalDetailsPage.clickOnContinueButton();	
		personalDetailsPage.clickOnCancelButton();		
	}
	
	@Test(priority = 4)
	public void verifyIfAdditonOfMultipleProductPriceIsEqualToTotalPrice() throws InterruptedException {
		productDislayPage = new ProductDisplayPage(driver);
		productDislayPage.clickOnAddToCartButton(0);  
		productDislayPage.clickOnAddToCartButton(1);
		productDislayPage.clickOnCartIcon();
		
		cartPage = new CartPage(driver);
		cartPage.clickOnCheckout();
		
		personalDetailsPage = new PersonalDetailsPage(driver);
		personalDetailsPage.enterName("Nikita");
		personalDetailsPage.enterLastName("Patil");
		personalDetailsPage.enterPostalCode("425001");
		personalDetailsPage.clickOnContinueButton();
		
		paymentPage = new PaymentPage(driver);
//		double itemTotal = paymentPage.getItemTotal();
//		System.out.println(itemTotal);
//		double taxAmt = paymentPage.getTaxAmt();
//		System.out.println(taxAmt);
//		double totalAmt = paymentPage.getTotalAmt();
//		System.out.println(totalAmt);
		
//		Assert.assertTrue(itemTotal+taxAmt==totalAmt);
		Assert.assertTrue(paymentPage.getItemTotal()+paymentPage.getTaxAmt()==paymentPage.getTotalAmt());
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
