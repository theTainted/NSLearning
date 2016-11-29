package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by syam.suryanarayanan on 11/29/2016.
 */
public class RegistrationPage extends General {
    public String sEmailAddress ;
    SoftAssert softAssert = new SoftAssert();
    @FindBy(id="dwfrm_profile_customer_firstname")
    public WebElement txtBoxFirstName;
    @FindBy(id="dwfrm_profile_customer_lastname")
    public WebElement txtBoxLastName;
    @FindBy(id="dwfrm_profile_customer_email")
    public WebElement txtBoxEmail;
    @FindBy(id="dwfrm_profile_customer_emailconfirm")
    public WebElement txtBoxConfirmEmail;
    @FindBy(xpath="//input[contains(@id,'dwfrm_profile_login_password_')]")
    public WebElement txtBoxPassword;
    @FindBy(xpath="//input[contains(@id,'dwfrm_profile_login_passwordconfirm_')]")
    public WebElement txtBoxConfirmPassword;
    @FindBy(xpath="//form[@id='RegistrationForm']//button[@name='dwfrm_profile_confirm']")
    public WebElement btnCreateAccount;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public void generateFirstName(){
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmm");
        Date date = new Date();
        txtBoxFirstName.sendKeys("tester"+dateFormat.format(date));
    }
    public void enterLastName(String sLastName){
        txtBoxLastName.sendKeys(sLastName);

    }
    public String  createEmail(){
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Date date = new Date();
       sEmailAddress = "tester"+dateFormat.format(date)+"@"+"yopmail.com";
        return sEmailAddress;

    }
    public String  enterEmail(){
      String sEmail = createEmail();
        //System.out.println(sEmailAddress);
        txtBoxEmail.sendKeys(sEmail);
        return sEmail;
    }
    public void enterConfirmationEmailAddress() {
     String sConfirmEmail = createEmail();
        txtBoxConfirmEmail.sendKeys(sConfirmEmail);

    }

    public void enterPassword(){
        txtBoxPassword.sendKeys("test1234");
    }
    public void enterConfrimsPassword(){
        txtBoxConfirmPassword.sendKeys("test1234");
    }
    public void clickCreateAccount(){
        btnCreateAccount.click();

    }

}
