package testcases;

import PageObjects.General;
import PageObjects.TheHub;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 4/12/2017.
 */
public class clickOnCommercialFromHamburgerMenu extends General {
    @Test
    public void testClickCommercialFromHamburgerMenu(){

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
        driver.quit();
    }
}

