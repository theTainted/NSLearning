package testcases;

import PageObjects.General;
import PageObjects.HomePage;
import PageObjects.Login;
import PageObjects.RegistrationPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class scsRegisteringAnUser extends General {
    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("Chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            //create chrome instance
            //    driver = new ChromeDriver();
        }
    }

    @Test

    public void testScSRegisteringAnUser(){
        General.getBrowser("Chrome");
        driver.get(General.URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
       Login login =  homePage.clickOnSCSLogin();
       login.clickCreateAccountButton();
        RegistrationPage registration=new RegistrationPage(driver);
        registration.generateFirstName();
        registration.enterLastName("Tester");
        registration.enterEmail();
        registration.enterConfirmationEmailAddress();
        registration.enterPassword();
        registration.enterConfrimsPassword();
        registration.clickCreateAccount();
       System.out.println(driver.getCurrentUrl());
       registration.assertHeadingMyAccount("My account");


    }
 @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
