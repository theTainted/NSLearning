package PageObjects;



//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


/**
 * Created by syam.suryanarayanan on 11/21/2016.
 */
 public  class General {
  // public  static WebDriver driver;
  protected static  WebDriver driver ; //added to see if it helps in the race condition and also remove the static declarations in the page


//public  static String URL="https://staging.scs.co.uk";
public static String URL = "https://"+"storefront"+":"+"sancerre"+"@"+"development.scs.co.uk";
// public static String URL = "https://"+"storefront"+":"+"storefront"+"@"+"staging.cortefiel.com/es/es";
   // public  static String  searchString="Jacket";


@BeforeClass
@Parameters("browser")
    public static WebDriver getBrowser(String browser){

    WebDriver driver;

//if(General.driver==null)
     //if (this.driver == null)

         if (browser.equals("Firefox"))

         {


             DesiredCapabilities dc = DesiredCapabilities.firefox();
             FirefoxProfile profile = new FirefoxProfile();
             profile.setAcceptUntrustedCertificates(false);
             profile.setAssumeUntrustedCertificateIssuer(true);
             System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
             dc = DesiredCapabilities.firefox();
             dc.setCapability(FirefoxDriver.PROFILE, profile);
         //   driver = new FirefoxDriver(dc);
            return new FirefoxDriver(dc); //added to see if it helps in the race condition

         } else if (browser.equals("Chrome"))

         {
             System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
           //driver = new ChromeDriver();
             System.out.println("inside the general");
            return new ChromeDriver();//added to see if it helps in the race condition
         }
         else if (browser.equals("IE"))

         {
          /*  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability("ignoreZoomSetting", true);*/

             System.setProperty("webdriver.ie.driver", "C:/IEDriverServer.exe");
      // driver = new InternetExplorerDriver();
            return new InternetExplorerDriver(); //added to see if it helps in the race condition

         }
//return driver
        return null; ///added to see if it helps in the race condition

     }
/*    @AfterClass
    public void tearDown() {

        driver.quit();
    }
*/
}






