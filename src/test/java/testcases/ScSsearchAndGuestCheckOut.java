package testcases;

import PageObjects.ShippingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by syam.suryanarayanan on 7/20/2017.
 */
 public class ScSsearchAndGuestCheckOut {
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String sURL = "https://staging.scs.co.uk";
        //  String sURL ="https://" + "storefront" + ":" + "sancerre" + "@" + "development.scs.co.uk";
        String sProductName = "L036211";
        driver.get(sURL);
        driver.manage().window().maximize();
        driver.findElement(By.id("q")).sendKeys(sProductName);
        driver.findElement(By.id("q")).sendKeys(Keys.RETURN);
       /* System.out.println(driver.findElements(By.xpath("//form[contains(@id,'dwfrm_product_addtocart')]//input[@id='add-to-cart']")).size());
        boolean elementExists = driver.findElements(By.id("add-to-cart")).size()!=0;
        if (elementExists==true){
            driver.findElement(By.id("add-to-cart")).click();
        }*/

        boolean elementExists = driver.findElements(By.xpath("//input[@class='add-to-cart btn btn--buy btn--large btn--full']")).size() != 0;
        if (elementExists == true) {
            driver.findElement(By.xpath("//input[@class='add-to-cart btn btn--buy btn--large btn--full']")).click();
        }
        Thread.sleep(3000);
        // driver.switchTo().frame(1);
        boolean windowContinueToCheckOutButtonExists = driver.findElements(By.xpath("//div[@id='dialog--extra-products']//div[@class='dialog--button--bar']/a[1]")).size() != 0;
        if (windowContinueToCheckOutButtonExists == true) {
            driver.findElement(By.xpath("//div[@id='dialog--extra-products']//div[@class='dialog--button--bar']/a[1]")).click();
        }
        boolean cookieButtonExists = driver.findElements(By.xpath("//div[@class='cookie-policy__container shown']/span[@class='icon-close']")).size() != 0;
        if (cookieButtonExists) {
            driver.findElement(By.xpath("//div[@class='cookie-policy__container shown']/span[@class='icon-close']")).click();
        }
        driver.findElement(By.name("dwfrm_cart_unregistered")).click();
        boolean upsellContinueToCheckOutButtonExists = driver.findElements(By.xpath("//form[@id='upsell-checkout-form']/button[@class='btn btn--pay btn--dialog--black']")).size() != 0;

        if (upsellContinueToCheckOutButtonExists == true) {
            driver.findElement(By.xpath("//form[@id='upsell-checkout-form']/button[@class='btn btn--pay btn--dialog--black']")).click();
        }

        ShippingAddress shippingAddress = new ShippingAddress(driver);
        // shippingAddress.selectMan();
        shippingAddress.enterFirstName("test");
        shippingAddress.enterLastName("tester");
        shippingAddress.scsEnterEmail("syam.suryanaryanan@digitaslbi.com");
        shippingAddress.enterPhone("3333333333");
        shippingAddress.selectBestTimeToContact("Call me now");
        //   shippingAddress.enterAddressOne("Line 1");
        shippingAddress.scsEnterZip("AB11 5BA");
        shippingAddress.clickOnLookUp();
        Thread.sleep(5000);
        shippingAddress.scsSelectAnAddressFromAddressDropDown(4);
    }
}
