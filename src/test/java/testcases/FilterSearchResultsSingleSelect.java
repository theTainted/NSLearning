package testcases;

import PageObjects.TheHub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


/**
 * Created by syam.suryanarayanan on 2/22/2017.
 * This test case handles the scenario
 */
public class FilterSearchResultsSingleSelect {

    @Test
      public void testFilterSingleSelect() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
      TheHub theHub = new TheHub(driver);
      driver.get(TheHub.theHubUrl);
      driver.manage().window().maximize();
      theHub.setLoginEmail(TheHub.userName);
      theHub.setLoginPassword(TheHub.password);
      theHub.clickOnLoginButton();
      theHub.enterSearchText("Hunted");

     //  theHub.clickOnAFacet();

 /*       theHub.clickOnFilter("Commercial");
        Thread.sleep(5000);
        theHub.clickOnFilter("Videos");

      //  theHub.selectedFacet();
      driver.quit();*/

    }
}
