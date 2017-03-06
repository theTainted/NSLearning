package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by syam.suryanarayanan on 11/14/2016.
 */
public class ProductDisplayPage extends General {
   // WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @FindAll({
          //  @FindBy(xpath="//div[@id='product-content']//ul[@class='swatches size']/li") -> updated to the below
            @FindBy(xpath="//div[@id='product-content']//div[@class='product-detail__variants']//ul[@class='swatch-container']//a[@data-type='size']")
    })
    public List<WebElement> allSizes ;

    @FindAll({
            @FindBy(xpath="//div[@id='product-content']//div[@class='product-detail__variants']//ul[@class='swatch-container']//a[@data-type='color']")
    })
       public List <WebElement> allColors;

    @FindBy(id="add-to-cart")
    public WebElement btnAddToCart;
    @FindBy(xpath="//div[@id='pdpMain']/span//a/img[@class='primary-image']")
    public WebElement productImage;
   // @FindBy(xpath="//div[@id='wrapper']//ul[@class='navigation-tools']/li[@class='navigation-tools__item navigation-tools__minicart js-minicart']") ->updated to the below
    @FindBy(id="mini-cart")
    public WebElement miniBasket;

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
    /*clicks on the first available color*/
    public void clickOnFirstColor(){
        System.out.println(allColors.size());
        System.out.println(allColors.get(0).getText()); //gets the text of the size
        allColors.get(0).click();

    }
//div[@id='wrapper']//ul[@class='navigation-tools']/li[@class='navigation-tools__item navigation-tools__minicart js-minicart']

    public void clickOnAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
      //  wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        System.out.println(btnAddToCart.isEnabled());
        if(driver.findElement(By.id("add-to-cart")).isEnabled()){
            driver.findElement(By.id("add-to-cart")).click();
     //   System.out.println("in if");
        }
         else {

         softAssert.fail("add to cart button is disabled");
         softAssert.assertAll();
        }
    }

    public ShoppingBasket clickOnMiniBasketIcon(){
        if(miniBasket.isEnabled()){
            miniBasket.click();

        }
        return new ShoppingBasket(driver);
    }

}
