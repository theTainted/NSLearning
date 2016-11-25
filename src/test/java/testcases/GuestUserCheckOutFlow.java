package testcases;

import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 11/3/2016.
 */
public class GuestUserCheckOutFlow extends General{

    @Test
   // public static void main(String[] args) throws InterruptedException {
    /*016fd76(Need to add the driver in the general class)*/
     public void testGuestUserCheckOutFlow() {

      /*  System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/
        General.getBrowser("Chrome");
        driver.get(General.URL);
        driver.manage().window().maximize();
    //Accept cookies message
        HomePage homePage =new HomePage(driver);
        homePage.clickAcceptCookiesButton();
    //Click on ContinueShopping in the countrySelector PopuP
     //   homePage.clickShoppingButtonInCountrySelector();

    //Search for Jackets
        homePage.clickOnSearchIcon();
        ProductListPage plp= homePage.searchText("jacket dickey");
        ProductDisplayPage pdp = plp.clickOnFirstResult();
         pdp.clickOnFirstSize();
        //Thread.sleep(2000);
        pdp.clickOnAddToCart();
        ShoppingBasket sb= pdp.clickOnMiniBasketIcon();
        Login login = sb.clickOnCheckoutButton();
        ShippingAddress shippingAddress = login.clickOnCheckoutAsGuest();
        shippingAddress.selectMan();
        shippingAddress.enterFirstName("test");
        shippingAddress.enterLastName("tester");
        shippingAddress.enterAddressOne("Line 1");
        shippingAddress.enterZip("1114AB");
        shippingAddress.enterCity("Amsterdam");
         shippingAddress.selectCountry("Greece");
        shippingAddress.enterEmail("bjornjaco.geerding@digitaslbi.com");
        shippingAddress.enterPhone("3333333333");
       // shippingAddress.selectBillingAddressOption();

        BillingPage billingPage= shippingAddress.clickBtnToBilling();


      //  Thread.sleep(5000);
        billingPage.enterNumber("4111111111111111");
        billingPage.enterCVV("737");
        billingPage.enterName("test");
        billingPage.selectTermsAndConditions();
        billingPage.selectExpiryMonth("August");
        billingPage.selectExpiryYear("2018");
        billingPage.clickBtnToPay();

       driver.quit();
/*
                Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//div[@id='wrapper']/header//i[@class='icon-bag']"));
        action.moveToElement(we).build().perform();
        driver.findElement(By.xpath("//div[@id='wrapper']/header//a[@class='btn btn--large btn--fullwidth mini-cart-link-checkout']")).click();*/


    }
}