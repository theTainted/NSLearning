package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

/**
 * Created by syam.suryanarayanan on 11/17/2016.
 */
public class OrderConfirmationPage extends General {
    //WebDriver driver;
 //   General general = new General();
    SoftAssert softAssert = new SoftAssert();

  @FindBy(xpath="//div[@id='main']//div[@class='confirmation__message']")
    public WebElement confirmationMessage;


    public OrderConfirmationPage(WebDriver driver){
        General.driver=driver;
        PageFactory.initElements(General.driver,this);

    }

    public void confirmOrderConfirmationPage(){
        if(confirmationMessage.isDisplayed()){
            softAssert.notify();
            softAssert.assertAll();
        }
        else {
            softAssert.fail("order confirmation page is not shown");
            softAssert.assertAll();
        }
    }

}
