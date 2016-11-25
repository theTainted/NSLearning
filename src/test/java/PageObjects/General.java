package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by syam.suryanarayanan on 11/21/2016.
 */
public class General {
   public static WebDriver driver;


    public static String URL = "https://" + "storefront" + ":" + "storefront" + "@" + "development.northsails.com/global/en/homepage/";
    public static String searchString="Jacket";

    public static WebDriver getBrowser(String browserType)

    {
        //if(driver == null)

        {

            if(browserType.equals("Firefox"))

            {
                System.setProperty("webdriver.gecko.driver","C:/geckodriver.exe");
                ProfilesIni prof = new ProfilesIni();
                FirefoxProfile ffProfile= prof.getProfile ("myProfile");
                ffProfile.setAcceptUntrustedCertificates(true);
                ffProfile.setAssumeUntrustedCertificateIssuer(false);
                driver = new FirefoxDriver(ffProfile);

            }

            else if(browserType.equals("Chrome"))

            {
                System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
                driver = new ChromeDriver();

            }

            else if(browserType.equals("IE"))

            {

                driver = new InternetExplorerDriver();

            }

        }
        return driver;

    }
}






