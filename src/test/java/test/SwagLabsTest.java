package test;

import static org.testng.Assert.assertListContains;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.LoginPage;
import pom.ProductDisplayPage;

public class SwagLabsTest extends BaseTest{
  
	LoginPage loginPage;
	ProductDisplayPage productDisplayPage;
	CartPage cartPage;

	@BeforeMethod
	 public void chrome() {	
		 driver = LaunchBrowser.openChrome();
		 
		 loginPage = new LoginPage(driver);
	   	 loginPage.enterTheUsername(driver,"standard_user");
	   	 loginPage.enterThePassword(driver,"secret_sauce");
	   	 loginPage.clickOnLogin();
	}
	
	@Test(priority = 1)
	public void verifyIfUserIsAbleToAddTheProductIntoCartFromProdutDisplayPage() {
	   	  productDisplayPage = new ProductDisplayPage(driver);
	      productDisplayPage.clickOnAddToCartButton(1);  	  
	}
	
	@Test(priority = 2)
	public void verifyIfuserIsAbleToRemoveProductFromCartFromProdctDisplayPage() {
	     productDisplayPage = new ProductDisplayPage(driver);
	     productDisplayPage.clickOnAddToCartButton(0);
	     productDisplayPage.clickOnRemoveButton(0);	 	     
	}
	
   @Test(priority = 3)
	public void verifyIfUserIsAbleToAddTheMultipleProductIntoCartFromProdutDisplayPage() {
	   	  productDisplayPage = new ProductDisplayPage(driver);
	      productDisplayPage.clickOnAddToCartButton(0);
	      productDisplayPage.clickOnAddToCartButton(1); 	  
	}
   
   @Test(priority = 4)
   public void verifyIfuserIsAbleToRemoveMultipleProductFromCartFromProdctDisplayPage() { 
	     productDisplayPage = new ProductDisplayPage(driver);
	     productDisplayPage.clickOnAddToCartButton(0);
	     productDisplayPage.clickOnAddToCartButton(1);
	     productDisplayPage.clickOnRemoveButton(1);
	     productDisplayPage.clickOnRemoveButton(0);
	}
 
 	@Test(priority = 5)
 	public void verifyIfUserIsAbleToAddTheProductIntoCartFromProductDiscriptionPage() {
 		productDisplayPage = new ProductDisplayPage(driver);
 		productDisplayPage.clickOnProduct(0);	
 		productDisplayPage.clickOnAddToCartButton(0);
 	}
 	
 	@Test(priority = 6)
 	public void verifyIfUserIsAbleToRemoveTheProductIntoCartFromProductDiscriptionPage() {
 		productDisplayPage = new ProductDisplayPage(driver);
 		productDisplayPage.clickOnProduct(0);
 		productDisplayPage.clickOnAddToCartButton(0);
 		productDisplayPage.clickOnRemoveButton(0);
 	}
	
	@Test(priority = 7)
	public void verifyIfTheProductDetailsOfATCPageAndProductDisplayPageAareSimilar() {
		productDisplayPage = new ProductDisplayPage(driver);
		productDisplayPage.clickOnAddToCartButton(3);
        productDisplayPage.clickOnCartIcon();
		
        cartPage = new CartPage(driver);
        String expectedPName = cartPage.getProductName(0);
        System.out.println(expectedPName);
        
    	double expectedPrice = cartPage.getProductPrice(0);
		System.out.println(expectedPrice);
		
		Assert.assertEquals(productDisplayPage.getProductPrice(0),expectedPrice);
	    Assert.assertEquals(productDisplayPage.getOnProductName(0),expectedPName);
//        Assert.assertEquals(expectedPrice,"29.99");
//        Assert.assertEquals("Sauce Labs Fleece Jacket", expectedPName);
	}
 	
   @AfterMethod
    public void close() {
	   driver.close();
   }

}
