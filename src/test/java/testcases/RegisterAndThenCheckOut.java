package testcases;

import PageObjects.*;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 11/30/2016.
 */
public class RegisterAndThenCheckOut extends General{
@Test
    public void testRegisterAndThenCheckOut() {
        General.getBrowser("Chrome");
        driver.get(General.URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.clickAcceptCookiesButton();
        homePage.clickOnSearchIcon();
        ProductListPage plp = homePage.searchText("jacket dickey");
        ProductDisplayPage pdp = plp.clickOnFirstResult();
        pdp.clickOnFirstSize();

        pdp.clickOnAddToCart();
        ShoppingBasket sb = pdp.clickOnMiniBasketIcon();
        Login login = sb.clickOnCheckoutButton();
        RegistrationPage register =login.clickCreateAccountButton();

        register.generateFirstName();
        register.enterLastName("tester");
        register.enterEmail();
        register.enterConfirmationEmailAddress();
        register.enterPassword();
        register.enterConfrimsPassword();
        register.clickCreateAccount();

        ShippingAddress shippingAddress = new ShippingAddress(driver);

        shippingAddress.selectMan();
        shippingAddress.enterFirstName("test");
        shippingAddress.enterLastName("tester");
        shippingAddress.enterAddressOne("Line 1");
        shippingAddress.enterZip("1114AB");
        shippingAddress.enterCity("Amsterdam");
      //  shippingAddress.selectCountry();  -> by default will place for the selected country
       // shippingAddress.enterEmail("bjornjaco.geerding@digitaslbi.com"); -> Address section is prefilled with the email used to register
        shippingAddress.enterPhone("3333333333");
        // shippingAddress.selectBillingAddressOption();

        BillingPage billingPage = shippingAddress.clickBtnToBilling();


        //  Thread.sleep(5000);
        billingPage.enterNumber("5100290029002909");
        billingPage.enterCVV("737");
        billingPage.enterName("test");
        billingPage.selectTermsAndConditions();
        billingPage.selectExpiryMonth("October");
        billingPage.selectExpiryYear("2020");
        billingPage.clickBtnToPay();

        driver.quit();

    }
}
