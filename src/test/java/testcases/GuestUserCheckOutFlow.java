package testcases;

import PageObjects.*;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 11/3/2016.
 */
public class GuestUserCheckOutFlow extends General {

    @Test
     public void testGuestUserCheckOutFlow() throws InterruptedException {
     //  String[] countries = {"Angola","Germany","France","Spain","United Kingdom","Netherlands","Switzerland","Sweden","Belgium","Greece"};


        driver.get(General.URL);
       driver.manage().window().maximize();

          //Accept cookies message
        HomePage homePage = new HomePage(driver);
        Thread.sleep(10000);
        homePage.clickOnCountrySelectorFirstLink("ALL~en");
        homePage.clickAcceptCookiesButton();
      String[] countries = {"Angola"};
      for(int i=0;i<countries.length;i++) {
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
          Thread.sleep(5000);
          Login login = sb.clickOnCheckoutButton();
          Thread.sleep(5000);
        //  System.out.println( driver.findElement(By.xpath("//div[@id='checkoutloginpage']//button[@name='dwfrm_login_unregistered']")).isDisplayed());
           login.popupUnregisteredCheckIn.click();

          ShippingAddress shippingAddress = login.clickOnCheckoutAsGuest();
          shippingAddress.selectMan();
          shippingAddress.enterFirstName("test");
          shippingAddress.enterLastName("tester");
          shippingAddress.enterAddressOne("Line 1");
          shippingAddress.enterZip("1114AB");
          shippingAddress.enterCity("Amsterdam");

        shippingAddress.selectCountry(countries[i]);

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




       }
    }
/*  @AfterClass
  public void tearDown() {
    driver.quit();
  }*/
}