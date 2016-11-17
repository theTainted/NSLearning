import PageObjects.HomePage;
import PageObjects.ProductDisplayPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import PageObjects.ProductListPage;


import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 11/3/2016.
 */
public class Dummy {

    public static void main(String[] args) throws InterruptedException {

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
        ProductListPage plp= homePage.searchText("JACKET DICKEY");
        ProductDisplayPage pdp = plp.clickOnFirstResult();
         pdp.clickOnFirstSize();
        //Thread.sleep(2000);
        pdp.clickOnAddToCart();
        pdp.clickOnMiniBasketIcon();


/*
                Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//div[@id='wrapper']/header//i[@class='icon-bag']"));
        action.moveToElement(we).build().perform();
        driver.findElement(By.xpath("//div[@id='wrapper']/header//a[@class='btn btn--large btn--fullwidth mini-cart-link-checkout']")).click();*/


    }
}