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
public class ProductListPage extends General {
    General general = new General();
    //WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
  /*  @FindAll({
        @FindBy(xpath="//ul[@id='search-result-items']/li")
    })*/
    @FindAll(@FindBy(xpath = "//div[@class='product-image product__thumbnail']//img"))
    public List <WebElement> allResults ;



    public ProductListPage(WebDriver driver) {
        general.driver = driver;
        PageFactory.initElements(general.driver, this);
    }

    /*clicks on the first available product*/
    public ProductDisplayPage clickOnFirstResult(){
     //   System.out.println(allResults.size());
        this.allResults.get(0).click();
        return new ProductDisplayPage(general.driver);
    }

}
