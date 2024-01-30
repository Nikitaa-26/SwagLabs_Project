package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

	@FindBy (xpath = "//div[@class='cart_item_label']") private List<WebElement> productName;
	@FindBy (xpath= "//div[@class='inventory_item_price']") private List<WebElement> Productprice;
    @FindBy (xpath= "//div[@class='summary_subtotal_label']") private WebElement itemTotal;
    @FindBy (xpath= "//div[@class='summary_tax_label']") private WebElement taxAmt;
    @FindBy (xpath= "//div[@class='summary_info_label summary_total_label']") private WebElement totalAmt;
    @FindBy (xpath= "//button[@id='cancel']") private WebElement cancelBtn;
    @FindBy (xpath= "//button[@id='finish']") private WebElement finishBtn;
    @FindBy (xpath= "//h2[text()='Thank you for your order!']") private WebElement orderComplete;
    @FindBy (xpath = "//h2[text()='Thank you for your order!']")private WebElement orderSuccess;
    public PaymentPage(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    }
    public String getProductName(int index) {
    	return productName.get(index).getText();
    }
    public String getProductPrice(int index) {
    	return Productprice.get(index).getText();
    }
    public double getItemTotal() {
    	return Double.parseDouble(itemTotal.getText().substring(13));
    }
    public double getTaxAmt() {
    	return Double.parseDouble(taxAmt.getText().substring(6));
    }
    public double getTotalAmt() {
    	return Double.parseDouble(totalAmt.getText().substring(8));
    }
    public String orderSuccess() {
   	    return orderSuccess.getText();
    }
}
