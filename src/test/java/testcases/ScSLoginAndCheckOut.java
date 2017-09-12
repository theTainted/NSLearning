package testcases;

        import PageObjects.*;
        import org.openqa.selenium.By;
        import org.testng.annotations.Test;

        import static PageObjects.General.driver;

public class ScSLoginAndCheckOut extends General  {
  //  @Test
 public  void testScSLoginAndCheckOut() throws InterruptedException {

       String sProductName = "L036281";
        General.getBrowser("Chrome");

        driver.get(General.URL);

     General.getBrowser("Chrome");

     driver.get(General.URL);
     driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        Login login =  homePage.clickOnSCSLogin();
        login.enterUserName("tester@yopmail.com");
        login.enterPassword("test1234");
        login.clickOnRegisteredLogin();

        ProductListPage plp = homePage.searchText(sProductName);

        boolean elementExists = driver.findElements(By.xpath("//input[@class='add-to-cart btn btn--buy btn--large btn--full']")).size() != 0;
        if (elementExists == true) {
            driver.findElement(By.xpath("//input[@class='add-to-cart btn btn--buy btn--large btn--full']")).click();
        }

        Thread.sleep(3000);
        ShoppingBasket sb = new ShoppingBasket(driver);


        // driver.switchTo().frame(1);
        boolean windowContinueToCheckOutButtonExists = driver.findElements(By.xpath("//div[@id='dialog--extra-products']//div[@class='dialog--button--bar']/a[1]")).size() != 0;
        if (windowContinueToCheckOutButtonExists == true) {
            driver.findElement(By.xpath("//div[@id='dialog--extra-products']//div[@class='dialog--button--bar']/a[1]")).click();
        }

        boolean cookieButtonExists = driver.findElements(By.xpath("//div[@class='cookie-policy__container shown']/span[@class='icon-close']")).size() != 0;
        if (cookieButtonExists) {
            driver.findElement(By.xpath("//div[@class='cookie-policy__container shown']/span[@class='icon-close']")).click();
            Thread.sleep(15000);
            sb.clickOnCloseNewsLetterPopUp();
        }
        ShippingAddress shippingAddress = new ShippingAddress(driver);
     boolean upsellContinueToCheckOutButtonExists = driver.findElements(By.xpath("//form[@id='upsell-checkout-form']/button[@class='btn btn--pay btn--dialog--black']")).size() != 0;
     if (upsellContinueToCheckOutButtonExists == true) {
         driver.findElement(By.xpath("//form[@id='upsell-checkout-form']/button[@class='btn btn--pay btn--dialog--black']")).click();
     }
   shippingAddress.scsSelectTitle("Miss");
        shippingAddress.enterFirstName("test");
        shippingAddress.enterLastName("tester");
        shippingAddress.scsEnterEmail("syam.suryanarayanan@digitaslbi.com");
        shippingAddress.enterPhone("3333333333");
        shippingAddress.selectBestTimeToContact("Call me now");

        shippingAddress.scsEnterZip("AB11 5BA");
        shippingAddress.clickOnLookUp();
        Thread.sleep(7000);
        shippingAddress.scsSelectAnAddressFromAddressDropDown(3);
        Thread.sleep(3000);
        shippingAddress.clickscsBtnContinueInShippingPage();
        scsOrderPreview orderPreview = new scsOrderPreview(driver);
        orderPreview.clickOnChkBoxTerm();
        orderPreview.clickOnPayByCard();
        /*
        BillingPage billingPage = new BillingPage(driver);
        billingPage.enterNumber("5100290029002909");
        billingPage.enterCVV("737");
        billingPage.enterName("test");
        billingPage.selectExpiryMonth("10");
        billingPage.selectExpiryYear("2020");
        billingPage.clickBtnToPay();*/
    }

}
