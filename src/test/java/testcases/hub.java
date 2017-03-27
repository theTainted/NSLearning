package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.TheHub;



/**
 * Created by syam.suryanarayanan on 2/22/2017.
 */
public class hub {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
      TheHub theHub = new TheHub(driver);
      driver.get(TheHub.theHubUrl);
      theHub.setLoginEmail(TheHub.userName);




    }
}
