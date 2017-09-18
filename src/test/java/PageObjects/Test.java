package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Test {
    public  String URL="https://staging.scs.co.uk";
    @BeforeTest
    @Parameters("browser")
    public WebDriver setup(String browser) throws Exception {
        WebDriver driver = null;
        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            //create firefox instance
            return new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            //create chrome instance
            return new ChromeDriver();
        }

        return driver;
    }

}
