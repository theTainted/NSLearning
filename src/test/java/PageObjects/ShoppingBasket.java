package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.NoSuchElementException;

/**
 * Created by syam.suryanarayanan on 11/17/2016.
 */
public class ShoppingBasket extends General {

  //  WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath="//form[@id='checkout-form']//button[@name='dwfrm_cart_checkoutCart']")
    public WebElement btnTopCheckout;
    @FindBy(xpath="//div[@id='wrapper-sc']/div[1]/a[@class='close-sc']")
    public WebElement btnCloseNewsLetterPopUp;
    public ShoppingBasket(WebDriver driver) {
       General.driver = driver;
        PageFactory.initElements(General.driver, this);
    }

    public Login clickOnCheckoutButton(){
        if(btnTopCheckout.isEnabled()){
            btnTopCheckout.click();

        }
        return new Login(driver);
    }
    public void clickOnCloseNewsLetterPopUp(){

      if (btnCloseNewsLetterPopUp.isDisplayed()){
          btnCloseNewsLetterPopUp.click();
        }
    }

}
