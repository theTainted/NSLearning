package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Created by syam.suryanarayanan on 11/21/2016.
 */
public class General {
   public static WebDriver driver;


   // public static String URL = "https://" + "storefront" + ":" + "storefront" + "@" + "development.northsails.com/se/en/homepage/";
    public static String URL="https://" + "storefront" + ":" + "storefront" + "@" + "development.northsails.com";
    public static String searchString="Jacket";


   @BeforeTest
   @Parameters("browser")
    public static WebDriver getBrowser(String browser)

    {
       // if(driver == null)

        if(browser.equals("Firefox"))

        {


            DesiredCapabilities dc=DesiredCapabilities.firefox();
            FirefoxProfile profile = new FirefoxProfile();
            profile.setAcceptUntrustedCertificates(false);
            profile.setAssumeUntrustedCertificateIssuer(true);
            System.setProperty("webdriver.gecko.driver","C:/geckodriver.exe");
            dc = DesiredCapabilities.firefox();
            dc.setCapability(FirefoxDriver.PROFILE, profile);
            General.driver =  new FirefoxDriver(dc);



        }

        else if(browser.equals("Chrome"))

        {
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            driver = new ChromeDriver();

        }

        else if(browser.equals("IE"))

        {
          /*  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability("ignoreZoomSetting", true);*/

            System.setProperty("webdriver.ie.driver","C:/IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        }

        return driver;

    }

}






