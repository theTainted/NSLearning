package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.TheHub;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by syam.suryanarayanan on 2/22/2017.
 */
public class hub {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
      TheHub theHub = new TheHub(driver);
      driver.get(TheHub.theHubUrl);
      driver.manage().window().maximize();
      theHub.setLoginEmail(TheHub.userName);
      theHub.setLoginPassword(TheHub.password);
      theHub.clickOnLoginButton();
   /*  driver.findElement(By.id("q")).sendKeys("alma santo");
      driver.findElement(By.xpath("//div[@id='search']//button[@class='form-search__btn']")).click();*/
   /*    List <WebElement> hamburgerMenu = new ArrayList<>();
       if( driver.findElement(By.xpath("//i[@class='burger-icon']")).isEnabled()){
            driver.findElement(By.xpath("//i[@class='burger-icon']")).click();
           List<WebElement> links = driver.findElements(By.xpath("//ul[@class='nav-2016__list']//a"));
             for (WebElement link : links){

        hamburgerMenu.add(link);
          }
           System.out.println(hamburgerMenu.size());
           for (int j=0; j<hamburgerMenu.size();j++){
               System.out.println(hamburgerMenu.get(j).getText());
           }
       }*/
       theHub.enterSearchText("big Brother");
       theHub.clickSeachIcon();



    }
}
