package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by syam.suryanarayanan on 4/5/2017.
 */
public class companies_test {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://test-thehub.endemolshine.com/");
        driver.findElement(By.id("login-email")).sendKeys("syam.suryanarayanan@digitaslbi.com");
        driver.findElement(By.id("login-password")).sendKeys("P@ssword1");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//form[@id='login']/fieldset/div[4]/button")).click();
        // driver.findElement(By.xpath("//div[@id='search']//button[@class='form-search__btn']")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("q")).sendKeys("");
        driver.findElement(By.xpath("//div[@id='search']//button[@class='form-search__btn']")).click();
                Thread.sleep(2000);

        driver.findElement(By.xpath("//form[@id='searchForm']//a[@data-category='People']")).click();
        Thread.sleep(5000);
        Select testCompanyDropDown = new Select(driver.findElement(By.xpath("//select[@name='Select a Company...']")));
        List<WebElement> companiesTest = testCompanyDropDown.getOptions();
        System.out.println(companiesTest.size());

        File file = new File("C:/companies_test.txt");
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            file = new File("C:/companies.txt");
            for (int j = 0; j < companiesTest.size(); j++) {
                System.out.println("here");
                String content = companiesTest.get(j).getText();


                // if file doesnt exists, then create it

                if (!file.exists()) {
                    file.createNewFile();
                }


                //System.out.println(content);
                bw.write(content);
                bw.write("\r\n");
                System.out.println(j);


            }

            bw.close();
        } catch (IOException ioe) {
            System.out.println("Trouble reading from the file: ");
        }

    }
}

