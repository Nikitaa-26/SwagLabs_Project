package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class CheckoutPage {
	 @FindBy (xpath = "//input[@name='firstName']")private WebElement name;
	 @FindBy (xpath = "//input[@id='last-name']")private WebElement lastName;
	 @FindBy (xpath = "//input[@placeholder='Zip/Postal Code']") private WebElement postalCode;
     @FindBy (xpath = "//input[@name='continue']")private WebElement continueBtn;
     @FindBy (xpath = "//button[@id='cancel']") private WebElement cancelBtn;
     
     public CheckoutPage(WebDriver driver) {
     	PageFactory.initElements(driver,this);
     }
     public void enterName(String Name) {
     	name.sendKeys(Name);
     }
     public void enterLastName(String LastName) throws InterruptedException {
     	Thread.sleep(1000);
     	name.sendKeys(LastName);
     }
     public void enterPostalCode(String PostalCode) {
     	name.sendKeys(PostalCode);
     }
     public void clickOnContinueButton() {
     	continueBtn.click();
     }
     public void clickOnCancelButton() {
     	cancelBtn.click();
     }

}
