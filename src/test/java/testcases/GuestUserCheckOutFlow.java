package testcases;

import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 11/3/2016.
 */
public class GuestUserCheckOutFlow extends General{

    @Test
   // public static void main(String[] args) throws InterruptedException {
    /*016fd76(Need to add the driver in the general class)*/
     public void testGuestUserCheckOutFlow() throws InterruptedException {
       String[] countries = {"Angola","Germany","France","Spain","United Kingdom","Netherlands","Switzerland","Sweden","Belgium","Greece"};

  for(int i=0;i<countries.length;i++) {
      /*  System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/
      General.getBrowser("Firefox");

        General.driver.get(General.URL);
        General.driver.manage().window().maximize();

          //Accept cookies message
        HomePage homePage = new HomePage(General.driver);
        Thread.sleep(10000);
        homePage.clickOnCountrySelectorFirstLink("ALL~en");
        homePage.clickAcceptCookiesButton();
          //Search for Jackets
          homePage.clickOnSearchIcon();
          ProductListPage plp = homePage.searchText("jacket dickey");
          ProductDisplayPage pdp = plp.clickOnFirstResult();
      //    pdp.clickOnFirstColor();
          Thread.sleep(2000);
          pdp.clickOnFirstSize();
          //Thread.sleep(2000);
          pdp.clickOnAddToCart();
        Thread.sleep(2000);
          ShoppingBasket sb = pdp.clickOnMiniBasketIcon();
          Login login = sb.clickOnCheckoutButton();
          ShippingAddress shippingAddress = login.clickOnCheckoutAsGuest();
          shippingAddress.selectMan();
          shippingAddress.enterFirstName("test");
          shippingAddress.enterLastName("tester");
          shippingAddress.enterAddressOne("Line 1");
          shippingAddress.enterZip("1114AB");
          shippingAddress.enterCity("Amsterdam");

        shippingAddress.selectCountry(countries[i]);
        //  shippingAddress.selectCountry("Angolagfsgfsg");
          shippingAddress.enterEmail("syam.suryanarayanan@digitaslbi.com");
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

        General.driver.quit();


       }
    }
}