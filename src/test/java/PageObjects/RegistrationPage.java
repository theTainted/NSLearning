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
   // @FindBy(xpath="//input[contains(@id,'dwfrm_profile_login_password_')]")
    @FindBy(id="dwfrm_profile_login_password") //->Updated for ScS
    public WebElement txtBoxPassword;
   // @FindBy(xpath="//input[contains(@id,'dwfrm_profile_login_passwordconfirm_')]")
    @FindBy(id="dwfrm_profile_login_passwordconfirm") //->Updated for scs
    public WebElement txtBoxConfirmPassword;
  //  @FindBy(xpath="//form[@id='RegistrationForm']//button[@name='dwfrm_profile_confirm']")
    @FindBy(xpath="//form[@id='RegistrationForm']//button[@value='Apply']")//->updated for Scs
    public WebElement btnCreateAccount;
    @FindBy(xpath="//div[@id='main']/div/h1[contains(text(),'My account')]")
    public WebElement headingMyAccount;


    public RegistrationPage(WebDriver driver) {
        General.driver = driver;
        PageFactory.initElements(General.driver, this);
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
    public void assertHeadingMyAccount(String headingText){

        softAssert.assertTrue(headingMyAccount.getText().contains(headingText),"User is registered");
        softAssert.assertAll();



    }
}
