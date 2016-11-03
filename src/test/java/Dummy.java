import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
/**
 * Created by syam.suryanarayanan on 11/3/2016.
 */
public class Dummy {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String URL = "https://" + "storefront" + ":" + "storefront" + "@" + "development.northsails.com";
        driver.get(URL);
     //   driver.get("https://development.northsails.com");
      //  driver.switchTo().alert();
//Selenium-WebDriver Java Code for entering Username & Password as below:
    /*    driver.findElement(By.id("userID")).sendKeys("userName");

        driver.findElement(By.id("password")).sendKeys("myPassword");
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();*/
    }
}