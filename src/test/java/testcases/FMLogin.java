package testcases;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.util.Calendar;
        import java.util.Date;
        import java.util.List;
        import java.util.logging.Logger;

public class FMLogin {

    public static void main(String[] args) throws InterruptedException {
        Logger LOG = Logger.getLogger("InfoLogging");

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String sURL = "http://t2.fleurametz.com";
        String sEmail = "mobilexl@fleurametz.com";
        String sPassword = "lelie";
        driver.get(sURL);
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys(sEmail);
        driver.findElement(By.id("password")).sendKeys(sPassword);
        driver.findElement(By.xpath("//input[@class='btn btn--login btn-login']")).click();
  /*      if((driver.findElement(By.xpath("//li[3]//a[@class='dropdown-text']")).getText()).equals(sEmail)) {

            LOG.info("true");
        }
*/
        List<WebElement> deliveryDateHasOrder = driver.findElements(By.xpath("//div[@id='start-new-order-calendar']/div/form//td[@class='delivery-order has-order']/a"));

        Thread.sleep(2000);
        List<WebElement> deliveryDateTodayHasOrder = driver.findElements(By.xpath("//div[@id='start-new-order-calendar']//form//table//td[@class='delivery-order active has-order today']"));

        List<WebElement> possibleDeliveryDatesWithNoOrders = driver.findElements(By.xpath("//div[@id='start-new-order-calendar']//form//table//td[@class='delivery']//a[@class='order-day-link']"));        for (WebElement test :possibleDeliveryDatesWithNoOrders) {
          //  LOG.info(test.getText());

            Date date = new Date();
            System.out.println(date);

            if (test.getText().equalsIgnoreCase("16")) {
                test.click();
                break;
            }

        }
        driver.findElement(By.xpath("//div[@id='start-new-order-calendar']//span[contains(text(),'Start nieuwe order')]")).click();

    }
}