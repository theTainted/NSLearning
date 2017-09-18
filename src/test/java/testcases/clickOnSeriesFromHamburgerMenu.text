package testcases;

import PageObjects.General;
import PageObjects.TheHub;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 4/12/2017.
 */
public class clickOnSeriesFromHamburgerMenu extends General {
    @Test
    public void testClickSeriesFromHamburgerMenu(){

        TheHub theHub = new TheHub(driver);
        driver.get(TheHub.theHubUrl);
        driver.manage().window().maximize();
        theHub.setLoginEmail(TheHub.userName);
        theHub.setLoginPassword(TheHub.password);
        theHub.clickOnLoginButton();
        theHub.clickOnHamburgerIcon();
        theHub.clickonSeriesFromHamburgerMenu();

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
