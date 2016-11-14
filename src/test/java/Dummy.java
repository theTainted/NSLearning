import PageObjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 11/3/2016.
 */
public class Dummy {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String URL = "https://" + "storefront" + ":" + "storefront" + "@" + "development.northsails.com";
        driver.get(URL);
        driver.manage().window().maximize();
    //Accept cookies message
        HomePage homePage =new HomePage(driver);
        homePage.clickAcceptCookiesButton();

    //Search for Jackets
        homePage.clickOnSearchIcon();



    }
}