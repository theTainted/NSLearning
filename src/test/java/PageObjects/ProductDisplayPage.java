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
            @FindBy(xpath="//div[@id='product-content']//ul[@class='swatches size']/li")
    })
    public List<WebElement> allSizes ;
    @FindBy(id="add-to-cart")
    public WebElement btnAddToCart;


    public ProductDisplayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    /*clicks on the first available size*/
    public void clickOnFirstSize(){
        System.out.println(allSizes.size());
        System.out.println(allSizes.get(0).getText()); //gets the text of the size
        allSizes.get(0).click();

    }
    public void clickOnAddToCart(){
        if(btnAddToCart.isEnabled()){
            btnAddToCart.click();
        System.out.println("in if");
        }
         else {

         softAssert.fail("add to cart button is disabled");
         softAssert.assertAll();
        }
    }

}
