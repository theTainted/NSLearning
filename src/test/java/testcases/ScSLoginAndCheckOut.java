package testcases;

        import PageObjects.*;
        import org.openqa.selenium.By;
        import org.testng.annotations.Test;

        import static PageObjects.General.driver;

public class ScSLoginAndCheckOut extends General {
   @Test
  public void testScSLoginAndCheckOut() throws InterruptedException {
   // public static void main (String [] args){

        String sProductName = "L036281";
        General.getBrowser("Chrome");

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
        Thread.sleep(3000);
        shippingAddress.clickscsBtnContinueInShippingPage();
        scsOrderPreview orderPreview = new scsOrderPreview(driver);
        orderPreview.clickOnChkBoxTerm();
        orderPreview.clickOnPayByCard();

    }
}