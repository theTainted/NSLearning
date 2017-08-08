package testcases;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.util.List;

public class FMLogin {
    public static void main(String[] args) throws InterruptedException {
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

            System.out.println("true");
        }
*/
        List<WebElement> deliveryDateHasOrder = driver.findElements(By.xpath("//div[@id='start-new-order-calendar']/div/form//td[@class='delivery-order has-order']/a"));
        System.out.println(deliveryDateHasOrder.size());
        Thread.sleep(2000);
        List<WebElement> deliveryDateTodayHasOrder = driver.findElements(By.xpath("//div[@id='start-new-order-calendar']//form//table//td[@class='delivery-order active has-order today']"));
        System.out.println(deliveryDateTodayHasOrder.size());
        List<WebElement> possibleDeliveryDatesWithNoOrders = driver.findElements(By.xpath("//div[@id='start-new-order-calendar']//form//table//td[@class='delivery']"));
        System.out.println(possibleDeliveryDatesWithNoOrders.size());
    }



}


