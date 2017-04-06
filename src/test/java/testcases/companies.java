package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by syam.suryanarayanan on 4/5/2017.
 */
public class companies {
   // public static void main(String[] args) throws InterruptedException {
   @Test
   public void numberOfCompaniesInProduction()throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://thehub.endemolshine.com/");
        driver.findElement(By.id("login-email")).sendKeys("Alma.santo@endemolshine.com");
        driver.findElement(By.id("login-password")).sendKeys("Jeroen1979!");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//form[@id='login']/fieldset/div[4]/button")).click();
        // driver.findElement(By.xpath("//div[@id='search']//button[@class='form-search__btn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//i[@class='burger-icon']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/People']")).click();

        Select companyDropDown = new Select(driver.findElement(By.xpath("//select[@name='Select a Company...']")));
        List<WebElement> companies = companyDropDown.getOptions();
        System.out.println(companies.size());

        File file = new File("C:/companies_prod.txt");
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            file = new File("C:/copmanies_prod.txt");
            for (int j = 0; j < companies.size(); j++) {

                String content = companies.get(j).getText();


                // if file doesnt exists, then create it

                if (!file.exists()) {
                    file.createNewFile();
                }


                System.out.println(content);
                bw.write(content);
                bw.write("\r\n");
                System.out.println(j);


            }

            bw.close();
        } catch (IOException ioe) {
            System.out.println("Trouble reading from the file: ");
        }
        driver.quit();
    }

}