package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

/**
 * Created by syam.suryanarayanan on 11/17/2016.
 */
public class Login extends General {
  //  WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath="//div[@id='checkoutloginpage']//button[@name='dwfrm_login_unregistered']")
    public WebElement btnCheckoutAsGuest;

    public Login(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(this.driver,this);
    }


    public ShippingAddress clickOnCheckoutAsGuest(){
        btnCheckoutAsGuest.click();
        return new ShippingAddress(driver);

    }



}


