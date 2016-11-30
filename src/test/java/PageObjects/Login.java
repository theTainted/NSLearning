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
    @FindBy(xpath="//input[contains(@id,'dwfrm_login_username')]")
    public WebElement username;
    @FindBy(xpath="//input[contains(@id,'dwfrm_login_password')]")
    public WebElement txtPassword;
    @FindBy(xpath="//form[@id='dwfrm_login']//button[@name='dwfrm_login_login']")
    public WebElement btnLogin;
    @FindBy(xpath="//div[@id='checkoutloginpage']//button[@name='dwfrm_login_register']")
    public WebElement btnCreateAccount;

    public Login(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(this.driver,this);
    }


    public ShippingAddress clickOnCheckoutAsGuest(){
        btnCheckoutAsGuest.click();
        return new ShippingAddress(driver);

    }
   public RegistrationPage clickCreateAccountButton(){
       btnCreateAccount.click();
       return new RegistrationPage(driver);
   }

    public void enterUserName(String emailID){
        username.sendKeys(emailID);
    }

    public void enterPassword(String password){
        txtPassword.sendKeys(password);
    }
    public ShippingAddress clickOnRegisteredLogin(){
        btnLogin.click();
        return new ShippingAddress(driver);
    }
}


