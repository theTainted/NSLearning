package testcases;

import PageObjects.General;
import PageObjects.TheHub;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


/**
 * Created by syam.suryanarayanan on 2/22/2017.
 * This test case handles the scenario
 */
public class FilterSearchResultsSingleSelect extends General {

    @Test
      public void testFilterSingleSelect() throws InterruptedException{
       /* System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/
      TheHub theHub = new TheHub(driver);
      driver.get(TheHub.theHubUrl);
      driver.manage().window().maximize();
      theHub.setLoginEmail(TheHub.userName);
      theHub.setLoginPassword(TheHub.password);
      theHub.clickOnLoginButton();
      theHub.enterSearchText("Hunted");
      theHub.expandUsingSingleSelectFacet("Company");
      theHub.expanddropDownSelectAnOwner();
      Thread.sleep(3000);
      theHub.filterUsingSingleSelectFilter("Canal");
      Thread.sleep(3000);
      theHub.expanddropDownSelectAnOwner();
      Thread.sleep(2000);
      theHub.filterUsingSingleSelectFilter("Shine TV");
      Thread.sleep(2000);
      theHub.expanddropDownSelectAProducer();
      theHub.filterUsingSingleSelectFilter("NL Film");
      //driver.quit();


    }
}
