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

    String [] aProducts = {"L022953","L022955", "L018620", "L030585", "L018455","L018623","L018621","L018619","L030586","L028650","L030589","L021870","L018615","L025086","L016576","L030582","L030584","L018617","L016578","L020366","L021869","L018616","L019291","L028648","L023687","L023688","L030580","L030583","L020937","L018618","L020935","L018622","L016574","L022828","L030581","L030578","L025611","L023689","L023686","L030590","L030588","L020816","L025546_STAINFREE-AQUA-LUXURY-7-GRAPHITE_200","L030579","L022952"};
        WebDriver driver = new ChromeDriver();
        driver.get("https://staging.scs.co.uk");
        driver.manage().window().maximize();
        for (int i=0;i<aProducts.length;i++) {
            driver.findElement(By.id("q")).sendKeys(aProducts[i]);
            driver.findElement(By.id("q")).sendKeys(Keys.RETURN);
            System.out.println(i);
            boolean present;
            try {
                driver.findElement(By.xpath("//div[@id='primary']//label[contains(text(),'Try a new search')]"));
                present = true;
            } catch (NoSuchElementException e) {
                present = false;
                break;
            }


        }
        driver.quit();
    }
}
