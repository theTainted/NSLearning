package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

/**
 * Created by syam.suryanarayanan on 11/17/2016.
 */
public class ShippingAddress {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//input[@value='Man']")
    public WebElement rdoGenderMan;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_firstName")
    public WebElement txtBoxShippingAddressFirstName;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_lastName")
    public WebElement txtBoxShippingAddressLastName;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_address1")
    public WebElement txtBoxShippingAddressAddress1;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_postal")
    public WebElement txtBoxZip;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_city")
    public WebElement txtBoxCity;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_email_emailAddress")
    public WebElement txtBoxEmailAddress;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_phone")
    public WebElement txtBoxPhone;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_useAsBillingAddress")
    public WebElement rdoChooseBillingAddress;
    @FindBy(xpath = "//form[@id='dwfrm_singleshipping_shippingAddress']/fieldset[@class='to-billing']//button[@class='btn btn--blue']")
    public WebElement btnToBilling;

    public ShippingAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void selectMan() {
        rdoGenderMan.click();
    }

    public void enterFirstName(String firstName) {
        txtBoxShippingAddressFirstName.sendKeys(firstName);
    }

    public void enterLastName(String LastName) {
        txtBoxShippingAddressLastName.sendKeys(LastName);

    }

    public void enterAddressOne(String addressOne) {
        txtBoxShippingAddressAddress1.sendKeys(addressOne);

    }

    public void enterZip(String zip) {
        txtBoxZip.sendKeys(zip);

    }

    public void enterCity(String city) {
        txtBoxCity.sendKeys(city);

    }

    public void enterEmail(String email) {
        txtBoxEmailAddress.sendKeys(email);

    }

    public void enterPhone(String phone) {
        txtBoxPhone.sendKeys(phone);

    }

    public void selectBillingAddressOption() {
        rdoChooseBillingAddress.click();

    }

    public void clickBtnToBilling() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(btnToBilling));



     /*   Actions actions = new Actions(driver);

        actions.moveToElement(btnToBilling).click().perform();*/
        btnToBilling.sendKeys(Keys.RETURN);


      /*  if (btnToBilling.isEnabled()){
            btnToBilling.click();


        }*/
    }
}