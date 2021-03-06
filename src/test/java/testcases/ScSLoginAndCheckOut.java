package testcases;

        import PageObjects.*;
        import org.openqa.selenium.WebDriver;
        import org.testng.annotations.*;
        import org.testng.annotations.Test;

public class ScSLoginAndCheckOut  {
    WebDriver driver = General.getBrowser("Chrome");//added to see if it helps in the race condition

//    General general = new General();
 @Test
  public void testScSLoginAndCheckOut() throws InterruptedException {
  // public static void main (String [] args) throws InterruptedException{

    // driver.manage().deleteAllCookies();
     String sProductName = "L036281";


      driver.get(General.URL);

   driver.manage().window().maximize();
   Thread.sleep(10000);

        HomePage homePage = new HomePage(driver);
     homePage.clickOnCookieNotification();
        Login login = homePage.clickOnSCSLogin();
        login.enterUserName("tester@yopmail.com");
        login.enterPassword("test1234");
        login.clickOnRegisteredLogin();

        ProductListPage plp = homePage.searchText(sProductName);
        ProductDisplayPage pdp = new ProductDisplayPage(driver);
        pdp.scsAddToBasket();
        pdp.scsClickOnContinueInTheShoppingBasketOverlay();
        ShoppingBasket sb = new ShoppingBasket(driver);
       // sb.clickOnCloseNewsLetterPopUp();
        sb.scsClickOnCheckOutButton();
        sb.scsClickOnOverlayContinue();

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
        Thread.sleep(7000);

        shippingAddress.scsBtnContinueInShippingPage();

        scsOrderPreview orderPreview = new scsOrderPreview(driver);
         homePage.clickOnCookieNotification();
        orderPreview.clickOnChkBoxTerm();
        Thread.sleep(2000);
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
    public void tearDown() {

        driver.quit();
    }
}
