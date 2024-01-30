package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayPage {
	  @FindBy (xpath = "//div[@class='inventory_item_name']") private List<WebElement> productName;
      @FindBy (xpath = "//button[text()='Add to cart']") private List<WebElement> addToCart;
      @FindBy (xpath = "//button[text()='Remove']") private List<WebElement> removeBtn;
      @FindBy (xpath= "//div[@class='inventory_item_price']") private List<WebElement> productPrice;
      @FindBy (xpath = "//img[@class='inventory_item_img']") private List<WebElement> products;
      @FindBy (xpath = "//div[@id='shopping_cart_container']") private WebElement cartIcon;
      
      public ProductDisplayPage(WebDriver driver) {
    	  PageFactory.initElements(driver, this);
      }
      public void clickOnProductTitle(int index) {
  		productName.get(index).click();		
  	  }
      public String getOnProductName(int index) {
    		return productName.get(index).getText();		
    	  }
      public void clickOnAddToCartButton(int index) {
    	  addToCart.get(index).click();
      }
      public void clickOnRemoveButton(int index) {
    	  removeBtn.get(index).click();  
      }
      public void clickOnProduct(int index) {
    	  products.get(index).click();
      }
      public double getProductPrice(int index) {
    	  return Double.parseDouble(productPrice.get(index).getText().substring(1));
      }
      public void clickOnCartIcon() {
  		cartIcon.click();
  	}
}
