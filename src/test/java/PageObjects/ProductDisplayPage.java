package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

/**
 * Created by syam.suryanarayanan on 11/14/2016.
 */
public class ProductDisplayPage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public ProductDisplayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
