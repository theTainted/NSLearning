package testcases;

import PageObjects.General;
import PageObjects.TheHub;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 5/5/2017.
 */
public class clickOnFormatTabInAllResults extends General {
    @Test
    public void testClickBrandToolkitFromHamburgerMenu(){

        TheHub theHub = new TheHub(General.driver);
        General.driver.get(TheHub.theHubUrl);
        General.driver.manage().window().maximize();
        theHub.setLoginEmail(TheHub.userName);
        theHub.setLoginPassword(TheHub.password);
        theHub.clickOnLoginButton();

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
