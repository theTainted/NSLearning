package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by syam.suryanarayanan on 11/21/2016.
 */
public class General {
   public static WebDriver driver;


   // public static String URL = "https://" + "storefront" + ":" + "storefront" + "@" + "development.northsails.com/se/en/homepage/";
    public static String URL="https://" + "storefront" + ":" + "storefront" + "@" + "development.northsails.com";
    public static String searchString="Jacket";

    public static WebDriver getBrowser(String browser)

    {
        //if(driver == null)

        if(browser.equals("Firefox"))

        {

            FirefoxProfile profile = new FirefoxProfile();
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
           System.setProperty("webdriver.gecko.driver","C:/geckodriver.exe");
            General.driver = new FirefoxDriver(profile);


        }

        else if(browser.equals("Chrome"))

        {
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            General.driver = new ChromeDriver();

        }

        else if(browser.equals("IE"))

        {

            General.driver = new InternetExplorerDriver();

        }

        return General.driver;

    }

}






