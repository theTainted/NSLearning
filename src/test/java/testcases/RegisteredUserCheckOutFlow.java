package testcases;

import PageObjects.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 11/21/2016.
 */
public class RegisteredUserCheckOutFlow extends General {
    @BeforeTest
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            //create chrome instance
        //    driver = new ChromeDriver();
        }
    }
@Test
/*016fd76(Need to add the driver in the general class)*/
    public void testRegisteredUserCheckOutFlow() throws InterruptedException {

  /* System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
    WebDriver driver = new ChromeDriver();*/
    String[] countries = {"Italy","Germany","France","Spain","United Kingdom","Netherlands","Switzerland","Sweden","Belgium","Greece"};
//for(int i=0;i<countries.length;i++) {

   // General.getBrowser("Chrome");
    driver.get(General.URL);
    driver.manage().window().maximize();

    //Accept cookies message
    HomePage homePage = new HomePage(driver);
    Thread.sleep(10000);
    homePage.clickOnCountrySelectorFirstLink("ALL~en");
    homePage.clickAcceptCookiesButton();

    //Click on ContinueShopping in the countrySelector PopuP
    // homePage.clickShoppingButtonInCountrySelector();

    //Search for Jackets
    homePage.clickOnSearchIcon();
    ProductListPage plp = homePage.searchText("jacket dickey");
    ProductDisplayPage pdp = plp.clickOnFirstResult();
    pdp.clickOnFirstColor();
    Thread.sleep(2000);
    pdp.clickOnFirstSize();
    Thread.sleep(2000);
    pdp.clickOnAddToCart();
    Thread.sleep(5000);
    ShoppingBasket sb = pdp.clickOnMiniBasketIcon();
    Login login = sb.clickOnCheckoutButton();
    login.enterUserName("bjornjg@yopmail.com");
    login.enterPassword("test1234");
    ShippingAddress shippingAddress = login.clickOnRegisteredLogin();
    shippingAddress.selectMan();
    //commenting this section out as the first name and last name is being filled from the

    //shippingAddress.enterEmail("bjornjaco.geerding@digitaslbi.com"); -> commented out as for a registered user the email id is prefilled with the login id
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


    driver.quit();
//test comment
    //test comment2
//}
}
}
