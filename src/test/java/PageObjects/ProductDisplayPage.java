package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by syam.suryanarayanan on 11/14/2016.
 */
public class ProductDisplayPage {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    @FindAll({
            @FindBy(xpath="//div[@id='product-content']//ul[@class='swatches size']")
    })
    public List<WebElement> allSizes ;


    public ProductDisplayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    /*clicks on the first available size*/
    public void clickOnFirstSize(){
        allSizes.get(1).click();
    }

}
