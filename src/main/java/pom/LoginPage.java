package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
      @FindBy(xpath = "//input[@id='user-name']") private WebElement username;
      @FindBy(xpath = "//input[@id='password']") private WebElement password;
      @FindBy(xpath = "//input[@name='login-button']") private WebElement logIn;
      
      public LoginPage(WebDriver driver) {
    	  PageFactory.initElements(driver,this);
      }      
      public void enterTheUsername(WebDriver driver,String name) {
//    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//    	  wait.until(ExpectedConditions.visibilityOf(username));
    	  username.sendKeys(name);
      }
      public void enterThePassword(WebDriver driver,String pass) {
//    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//    	  wait.until(ExpectedConditions.visibilityOf(password));
    	  password.sendKeys(pass);
      }
      public void clickOnLogin() {
    	  logIn.click();
      }
      
}
