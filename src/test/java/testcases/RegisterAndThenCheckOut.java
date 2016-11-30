package testcases;

import PageObjects.*;

/**
 * Created by syam.suryanarayanan on 11/30/2016.
 */
public class RegisterAndThenCheckOut extends General{

    public void testRegisterAndThenCheckOut() {
        General.getBrowser("Chrome");
        driver.get(General.URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
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

    }
}
