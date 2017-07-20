package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by syam.suryanarayanan on 7/20/2017.
 */
public class ScSsearchAndGuestCheckOut {
    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String sURL = "https://staging.scs.co.uk";
        String sProductName ="L036211";
        driver.get(sURL);
        driver.manage().window().maximize();
        driver.findElement(By.id("q")).sendKeys(sProductName);
        driver.findElement(By.id("q")).sendKeys(Keys.RETURN);


    }
}
