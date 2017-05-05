package testcases;

import PageObjects.General;
import PageObjects.TheHub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 5/5/2017.
 */
public class clickOnFormatTabInAllResults extends General {
  @Test
  public void testClickOnFormatTabInAllResults(){


        TheHub theHub = new TheHub(driver);
        driver.get(TheHub.theHubUrl);
        driver.manage().window().maximize();
        theHub.setLoginEmail(TheHub.userName);
        theHub.setLoginPassword(TheHub.password);
        theHub.clickOnLoginButton();
        theHub.enterSearchText("Hunted");

    }
 /*   @AfterClass
    public void tearDown() {
        driver.quit();
    }*/
}
