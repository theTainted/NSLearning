package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by syam.suryanarayanan on 7/18/2017.
 */
public class testClass {
    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

    String [] aProducts = {"L022953","L022955", "L018620", "L030585", "L018455","L018623","L018621","L018619","L030586","L028650","L030589","L021870","L018615","L025086","L016576"};
        WebDriver driver = new ChromeDriver();
        driver.get("https://staging.scs.co.uk");
        driver.manage().window().maximize();
        for (int i=0;i<=2;i++) {
            driver.findElement(By.id("q")).sendKeys(aProducts[i]);
            driver.findElement(By.id("q")).sendKeys(Keys.RETURN);

            boolean present;
            try {
                driver.findElement(By.xpath("//div[@id='primary']//label[contains(text(),'Try a new search')]"));
                present = true;
            } catch (NoSuchElementException e) {
                present = false;
                break;
            }


        }

    }
}
