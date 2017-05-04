package testcases;

import PageObjects.General;
import PageObjects.TheHub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by syam.suryanarayanan on 4/6/2017.
 */
public class theHubLogIn {
  @BeforeTest
  @Parameters("browser")
  General.getBrowser()

  @Test
    public void testTheHubLogin(){
   /*   System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
      WebDriver driver = new ChromeDriver();*/
      TheHub theHub = new TheHub(driver);
      driver.get(TheHub.theHubUrl);
      driver.manage().window().maximize();
      theHub.setLoginEmail(TheHub.userName);
      theHub.setLoginPassword(TheHub.password);
      theHub.clickOnLoginButton();
    driver.quit();
  }
}
