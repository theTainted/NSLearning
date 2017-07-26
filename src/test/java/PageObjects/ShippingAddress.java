package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by syam.suryanarayanan on 11/17/2016.
 */
public class ShippingAddress extends General {

    // WebDriver driver;
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
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_country")
    public WebElement selectCountry;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_email")
    public WebElement scstxtBoxEmailAddress;
    @FindBy(id = "dwfrm_singleshipping_shippingAddress_addressFields_bestTimeToContact")
    public WebElement scsSelectBestTimeToContact;
    @FindBy(id="dwfrm_singleshipping_shippingAddress_addressFields_zip")
    public WebElement scstxtBoxZip;
    @FindBy(xpath="//fieldset[@id='checkout-details-delivery']//button[@value='Postcode lookup']")
    public WebElement scsPostCodeLookUp;
    @FindBy (id="addresses-found")
    public WebElement scsDropDownPostCodeLookUp;

    @FindBy(xpath="//form[@id='dwfrm_singleshipping_shippingAddress']//button[@value='Continue']")
    public WebElement scsBtnContinueInShippingPage;

    public ShippingAddress(WebDriver driver) {
        General.driver = driver;
        PageFactory.initElements(General.driver, this);
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

    /**
     *
     * @param postCode
     */
    public void scsEnterZip(String postCode){
        scstxtBoxZip.sendKeys(postCode);
    }
    public void enterCity(String city) {
        txtBoxCity.sendKeys(city);

    }

    public void enterEmail(String email) {
        txtBoxEmailAddress.sendKeys(email);

    }

    public void scsEnterEmail(String email) {
        scstxtBoxEmailAddress.sendKeys(email);

    }

    /***
     *
     * @param phone
     */
    public void enterPhone(String phone) {
        txtBoxPhone.sendKeys(phone);

    }

    public void selectBillingAddressOption() {
        rdoChooseBillingAddress.click();

    }

    public BillingPage clickBtnToBilling() {
        WebDriverWait wait = new WebDriverWait(General.driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(btnToBilling));



     /*   Actions actions = new Actions(driver);

        actions.moveToElement(btnToBilling).click().perform();*/
        btnToBilling.sendKeys(Keys.RETURN);
        return new BillingPage(General.driver);


      /*  if (btnToBilling.isEnabled()){
            btnToBilling.click();


        }*/
    }

    /**
     * for select dropdowns i am passing values and treating them as WebElements instead of dropdowns, need to check this again.
     * updated to have  a select box inside the method
     *
     * @param chosenCountry . Have to check if this works as expected.
     */
    public void selectCountry(String chosenCountry) {
        boolean matchFound = false;
        Select selectCountryDropDown = new Select(selectCountry);
        List<WebElement> countries = selectCountryDropDown.getOptions();
        selectCountry.click();
        for (WebElement country : countries) {
            if (chosenCountry.equals(country.getText())) {
                country.click();
                matchFound = true;
                break;
            }

        }
        if (!matchFound) {
            System.out.println("no match found,setting to default country");
        }

    }

     /*   selectCountry.sendKeys(country);
          expiryMonth.selectByIndex(6);
       options=expiryMonth.getOptions();
        for (WebElement option : options) {
            if(month.equals(option.getText()))
                System.out.println(option);
                option.click();
    }*/

    /**
     * @param scsChosenBestTimeToContact
     */
    public void selectBestTimeToContact(String scsChosenBestTimeToContact) {
        boolean matchFound = false;
        Select selectBestTimeToContact = new Select(scsSelectBestTimeToContact);
        List<WebElement> bestTimeToContact = selectBestTimeToContact.getOptions();
        scsSelectBestTimeToContact.click();
        for (WebElement toContact : bestTimeToContact) {
            if (scsChosenBestTimeToContact.equals(toContact.getText())) {
                toContact.click();
                matchFound = true;
                break;
            }

        }
    }
    /**
     *
     */
    public void clickOnLookUp(){
        scsPostCodeLookUp.click();
    }

    /**
     *
     * @param addressNumber
     */
    public void scsSelectAnAddressFromAddressDropDown(int addressNumber){
        Logger LOGGER = Logger.getLogger("InfoLogging");
        Select addressPicker= new Select(scsDropDownPostCodeLookUp);
        List <WebElement> addresses = addressPicker.getOptions();
       int numberOfAddresses= addresses.size();
       if (addressNumber > numberOfAddresses){

           addressPicker.selectByIndex(1);
           LOGGER.warning("the size is less than the entered integer");

       }
        else{
           addressPicker.selectByIndex(addressNumber);
       }
    }
    public void clickscsBtnContinueInShippingPage(){
        scsBtnContinueInShippingPage.click();
    }
}