package testcases;

import PageObjects.General;
import PageObjects.TheHub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 4/6/2017.
 */
public class theHubLogout extends General {

    @Test
    public void testTheHubLogout(){
        /*System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/
        TheHub theHub = new TheHub(General.driver);
        General.driver.get(TheHub.theHubUrl);
        General.driver.manage().window().maximize();
        theHub.setLoginEmail(TheHub.userName);
        theHub.setLoginPassword(TheHub.password);
        theHub.clickOnLoginButton();

        General.driver.quit();
    }
}

