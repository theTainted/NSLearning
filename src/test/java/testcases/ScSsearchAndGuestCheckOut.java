package testcases;

import PageObjects.General;
import PageObjects.HomePage;
import PageObjects.ProductListPage;
import PageObjects.scsOrderPreview;
import PageObjects.ShippingAddress;
import PageObjects.BillingPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import org.openqa.selenium.By;

 public class ScSsearchAndGuestCheckOut  {
     WebDriver driver =General.getBrowser("chrome"); //added to see if it helps in the race condition

@Test
    public  void testScSearchAndGuestCheckOut() throws InterruptedException {



  //  General.getBrowser("Chrome");
 //   driver.manage().deleteAllCookies();
  String sProductName = "L036281";

      driver.get(General.URL) ;
       driver.manage().window().maximize();
       Thread.sleep(10000);
        HomePage homePage = new HomePage(driver);
    homePage.clickOnCookieNotification();
       ProductListPage plp = homePage.searchText(sProductName);


        boolean elementExists = driver.findElements(By.xpath("//input[@class='add-to-cart btn btn--buy btn--large btn--full']")).size() != 0;
        if (elementExists == true) {
            driver.findElement(By.xpath("//input[@class='add-to-cart btn btn--buy btn--large btn--full']")).click();
        }
        Thread.sleep(3000);
        // driver.switchTo().frame(1);
        boolean windowContinueToCheckOutButtonExists = driver.findElements(By.xpath("//div[@id='dialog--extra-products']//div[@class='dialog--button--bar']/a[1]")).size() != 0;
        if (windowContinueToCheckOutButtonExists == true) {
            driver.findElement(By.xpath("//div[@id='dialog--extra-products']//div[@class='dialog--button--bar']/a[1]")).click();
        }
        boolean cookieButtonExists = driver.findElements(By.xpath("//div[@class='cookie-policy__container shown']/span[@class='icon-close']")).size() != 0;
        if (cookieButtonExists) {
            driver.findElement(By.xpath("//div[@class='cookie-policy__container shown']/span[@class='icon-close']")).click();
        }
        driver.findElement(By.name("dwfrm_cart_unregistered")).click();
        boolean upsellContinueToCheckOutButtonExists = driver.findElements(By.xpath("//form[@id='upsell-checkout-form']/button[@class='btn btn--pay btn--dialog--black']")).size() != 0;

        if (upsellContinueToCheckOutButtonExists == true) {
            driver.findElement(By.xpath("//form[@id='upsell-checkout-form']/button[@class='btn btn--pay btn--dialog--black']")).click();
        }

        ShippingAddress shippingAddress = new ShippingAddress(driver);
        shippingAddress.scsSelectTitle("Miss");
        shippingAddress.enterFirstName("test");
        shippingAddress.enterLastName("tester");
        shippingAddress.scsEnterEmail("syam.suryanarayanan@digitaslbi.com");
        shippingAddress.enterPhone("3333333333");
        shippingAddress.selectBestTimeToContact("Call me now");
        //   shippingAddress.enterAddressOne("Line 1");
        shippingAddress.scsEnterZip("AB11 5BA");
        shippingAddress.clickOnLookUp();
        Thread.sleep(7000);
        shippingAddress.scsSelectAnAddressFromAddressDropDown(3);
        Thread.sleep(3000);
        shippingAddress.scsBtnContinueInShippingPage();
        scsOrderPreview orderPreview = new scsOrderPreview(driver);
        orderPreview.clickOnChkBoxTerm();
        orderPreview.clickOnPayByCard();

        BillingPage billingPage = new BillingPage(driver);
        billingPage.enterNumber("5100290029002909");
        billingPage.enterCVV("737");
        billingPage.enterName("test");
        billingPage.selectExpiryMonth("10");
        billingPage.selectExpiryYear("2020");
  billingPage.clickBtnToPay();

    }
  @AfterClass
    public void tearDown()  {

        driver.quit();

    }
}