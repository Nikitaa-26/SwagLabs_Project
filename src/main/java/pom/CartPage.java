package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	@FindBy (xpath=  "//div[@class='inventory_item_name']" ) private List<WebElement> checkoutPName;
//	@FindBy (xpath = "//div[@class='cart_item_label']") private List<WebElement> productName;
	@FindBy (xpath = "//div[@class='inventory_item_name']") private List<WebElement> productName;
	@FindBy (xpath = "//div[@class='inventory_item_price']") private List<WebElement> productPrice;
	@FindBy (xpath = "//button[@id='checkout']" )private WebElement checkout;
	@FindBy (xpath = "//input[@name='continue']")private WebElement continueBtn;		
	@FindBy (xpath = "//button[text()='Remove']") private List<WebElement> removeBtn;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}	
	public String getProductName(int index) {
		return  productName.get(index).getText();
	}
	public String getCheckoutPName(int index) {
		return checkoutPName.get(index).getText();
	}
	public double getProductPrice(int index) {
		return Double.parseDouble(productPrice.get(index).getText().substring(1));
	}
	public void clickOnCheckout() {
		checkout.click();
	}
	public void clickOnContnue() {
		continueBtn.click();
	}
	public void clickOnremoveBtn(int index) {
		removeBtn.get(index).click();
	}
	
}
