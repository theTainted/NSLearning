package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.NoSuchElementException;

/**
 * Created by syam.suryanarayanan on 11/17/2016.
 */
public class ShoppingBasket extends General {

  //  WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
   /* @FindBy(xpath="//form[@id='checkout-form']//button[@name='dwfrm_cart_checkoutCart']") -> changing to below to support scs
   public WebElement btnTopCheckout;*/
    @FindBy(xpath="//form[@id='checkout-form']//button[@class='btn btn--pay btn--full shopping-cart-payment__btn dialogify']")
    public WebElement btnScSCheckOut;
    @FindBy(xpath="//div[@id='wrapper-sc']//a[@class='close-sc']")
    public WebElement btnCloseNewsLetterPopUp;



    WebDriverWait wait = new WebDriverWait(General.driver, 20);
    public ShoppingBasket(WebDriver driver) {
       General.driver = driver;
        PageFactory.initElements(General.driver, this);
    }
/*
    public Login clickOnCheckoutButton(){
        if(btnTopCheckout.isEnabled()){
            btnTopCheckout.click();

        }
        return new Login(driver);
    }*/
    public void clickOnCloseNewsLetterPopUp(){
        wait.until(ExpectedConditions.elementToBeClickable(btnCloseNewsLetterPopUp));
        System.out.println("newsletterpopup : "+btnCloseNewsLetterPopUp.isEnabled());
        btnCloseNewsLetterPopUp.click();


    }

    public void scsClickOnCheckOutButton(){
        btnScSCheckOut.click();

    }

}
