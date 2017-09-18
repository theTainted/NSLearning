package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by syam.suryanarayanan on 11/17/2016.
 */
public class BillingPage extends General {
  //  WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @FindBy(id="dwfrm_billing_paymentMethods_creditCard_owner")
    public WebElement txtBoxCreditCardUserName;
    @FindBy(xpath="//input[contains(@id,'dwfrm_billing_paymentMethods_creditCard_number')]")
    public WebElement txtBoxCreditCardNumber;
    @FindBy(xpath="//input[contains(@id,'dwfrm_billing_paymentMethods_creditCard_cvn')]")
    public WebElement txtBoxCVVNumber;
    @FindBy(id="dwfrm_billing_terms")
    public WebElement chkBoxTermsAndConditions;
   // @FindBy (id="dwfrm_billing_paymentMethods_creditCard_expiration_month")
    @FindBy(id="dwfrm_billing_paymentMethods_creditCard_month") //->updated for scs
    public WebElement expiryMonth;
   // @FindBy(id="dwfrm_billing_paymentMethods_creditCard_expiration_year")
    @FindBy(id="dwfrm_billing_paymentMethods_creditCard_year")//-> updated for scs
    public WebElement expiryYear;
    @FindBy(xpath="//form[@id='dwfrm_billing']//button[@name='dwfrm_billing_save']")
    public WebElement btnPay;
    List<WebElement> options;
    List<WebElement> optionYear;
    General general = new General();

    public BillingPage(WebDriver driver) {
      general.driver = driver;
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
    public void selectTermsAndConditions(){
        chkBoxTermsAndConditions.click();
    }

    /**
     * for select dropdowns i am passing values and treating them as WebElements instead of dropdowns, need to check this again.
     * @param month
     */
    public void selectExpiryMonth(String month){
        expiryMonth.sendKeys(month);
      //  expiryMonth.selectByIndex(6);
      /*  options=expiryMonth.getOptions();
        for (WebElement option : options) {
            if(month.equals(option.getText()))
                System.out.println(option);
                option.click();*/
        }

    /**
     * for select dropdowns i am passing values and treating them as WebElements instead of dropdowns, need to check this again.
     * @param year
     */
    public void selectExpiryYear(String year){

        expiryYear.sendKeys(year);
      /*  optionYear=expiryYear.getOptions();
        for (WebElement option : optionYear) {
            if(year.equals(option.getText()))
                option.click();*/
        }

    public void clickBtnToPay() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(btnPay));
        btnPay.sendKeys(Keys.RETURN);


     /*   Actions actions = new Actions(driver);

        actions.moveToElement(btnToBilling).click().perform();*/



      /*  if (btnToBilling.isEnabled()){
            btnToBilling.click();s


        }*/
    }
}
