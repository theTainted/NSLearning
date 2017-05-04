package testcases;

import PageObjects.General;
import PageObjects.TheHub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 4/12/2017.
 */
public class clickOnCommercialFromHamburgerMenu extends General {
    @Test
    public void testClickCommercialFromHamburgerMenu(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        TheHub theHub = new TheHub(driver);
        driver.get(TheHub.theHubUrl);
        driver.manage().window().maximize();
        theHub.setLoginEmail(TheHub.userName);
        theHub.setLoginPassword(TheHub.password);
        theHub.clickOnLoginButton();
        theHub.clickOnHamburgerIcon();
        theHub.clickonCommercialFromHamburgerMenu();
       // driver.quit();

    }
    @AfterClass
    public void tearDown() {
        General.driver.quit();
    }
}

