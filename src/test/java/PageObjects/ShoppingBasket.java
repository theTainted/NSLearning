package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

/**
 * Created by syam.suryanarayanan on 11/17/2016.
 */
public class ShoppingBasket {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath="//form[@id='checkout-form']//button[@name='dwfrm_cart_checkoutCart']")
    public WebElement btnTopCheckout;
    public ShoppingBasket(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnCheckoutButton(){
        if(btnTopCheckout.isEnabled()){
            btnTopCheckout.click();
        }
    }

}
