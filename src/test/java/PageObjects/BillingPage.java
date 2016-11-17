package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

/**
 * Created by syam.suryanarayanan on 11/17/2016.
 */
public class BillingPage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @FindBy(id="dwfrm_billing_paymentMethods_creditCard_owner")
    public WebElement txtBoxCreditCardUserName;
    @FindBy(id="dwfrm_billing_paymentMethods_creditCard_number_d0vwtozoazfe")
    public WebElement txtBoxCreditCardNumber;
    @FindBy(id="dwfrm_billing_paymentMethods_creditCard_cvn_d0omarmoruon")
    public WebElement txtBoxCVVNumber;




    public BillingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void enterName(String name) {
        txtBoxCreditCardUserName.sendKeys(name);

    }
    public void enterNumber(String number) {
        txtBoxCreditCardNumber.sendKeys(number);

    }
    public void enterCVV(String cvv) {
        txtBoxCVVNumber.sendKeys(cvv);

    }
}
