package testcases;

import PageObjects.General;
import PageObjects.TheHub;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 4/6/2017.
 */
public class theHubLogout extends General {

    @Test
    public void testTheHubLogout(){
      /*  General.getBrowser("Chrome");
      System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/
        TheHub theHub = new TheHub(General.driver);
        General.driver.get(TheHub.theHubUrl);
        General.driver.manage().window().maximize();
        theHub.setLoginEmail(TheHub.userName);
        theHub.setLoginPassword(TheHub.password);
        theHub.clickOnLoginButton();
        theHub.clickOnLogout();
    }
    @AfterClass
    public void tearDown() {
        General.driver.quit();
    }
}

