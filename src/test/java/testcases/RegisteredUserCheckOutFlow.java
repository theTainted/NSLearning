package testcases;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 11/21/2016.
 */
public class RegisteredUserCheckOutFlow extends General {

@Test
/*016fd76(Need to add the driver in the general class)*/
    public void testRegisteredUserCheckOutFlow() {
    General.getBrowser("Chrome");
    driver.get(General.URL);
    driver.manage().window().maximize();
    //Accept cookies message
    HomePage homePage =new HomePage(driver);
    homePage.clickAcceptCookiesButton();
    //Click on ContinueShopping in the countrySelector PopuP
    homePage.clickShoppingButtonInCountrySelector();

    //Search for Jackets
    homePage.clickOnSearchIcon();
    ProductListPage plp= homePage.searchText("JACKET DICKEY");
    ProductDisplayPage pdp = plp.clickOnFirstResult();
    pdp.clickOnFirstSize();
    //Thread.sleep(2000);
    pdp.clickOnAddToCart();
    ShoppingBasket sb= pdp.clickOnMiniBasketIcon();
    Login login = sb.clickOnCheckoutButton();
}
}
