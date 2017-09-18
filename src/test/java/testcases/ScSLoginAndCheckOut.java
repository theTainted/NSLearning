package testcases;

        import PageObjects.*;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.testng.annotations.*;

        import static PageObjects.General.driver;

public class ScSLoginAndCheckOut extends General {

 @Test
  public void testScSLoginAndCheckOut() throws InterruptedException {
  // public static void main (String [] args) throws InterruptedException{
    General.getBrowser("Chrome");
     String sProductName = "L036281";


        driver.get(General.URL);

        General.getBrowser("Chrome");

        driver.get(General.URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
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
        homePage.clickOnCookieNotification();
        shippingAddress.scsBtnContinueInShippingPage();

        scsOrderPreview orderPreview = new scsOrderPreview(driver);
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
   // driver.quit();
    }
 @AfterMethod
    public void tearDown() {
        General.driver.quit();
    }
}
