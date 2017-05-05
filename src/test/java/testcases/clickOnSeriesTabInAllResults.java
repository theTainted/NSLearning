package testcases;

import PageObjects.General;
import PageObjects.TheHub;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 5/5/2017.
 */
public class clickOnSeriesTabInAllResults extends General {
  @Test
  public void testClickOnSeriesTabInAllResults() throws InterruptedException {


        TheHub theHub = new TheHub(driver);
        driver.get(TheHub.theHubUrl);
        driver.manage().window().maximize();
        theHub.setLoginEmail(TheHub.userName);
        theHub.setLoginPassword(TheHub.password);
        theHub.clickOnLoginButton();
        theHub.enterSearchText("Hunted");
        Thread.sleep(2000);
        theHub.clickOnTabInAllResults("Series");

    }
   @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
