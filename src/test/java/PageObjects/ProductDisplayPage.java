package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by syam.suryanarayanan on 11/14/2016.
 */
public class ProductDisplayPage extends General {
    General general = new General();
   // WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @FindAll(@FindBy(xpath = "//div[@id='product-content']//div[@class='product-detail__variants']//ul[@class='swatch-container']//a[@data-type='size']"))
    public List<WebElement> allSizes ;

    @FindAll(@FindBy(xpath = "//div[@id='product-content']//div[@class='product-detail__variants']//ul[@class='swatch-container']//a[@data-type='color']"))
       public List <WebElement> allColors;

    @FindBy(id="add-to-cart")
    public WebElement btnAddToCart;
    @FindBy(xpath="//div[@id='pdpMain']/span//a/img[@class='primary-image']")
    public WebElement productImage;
   // @FindBy(xpath="//div[@id='wrapper']//ul[@class='navigation-tools']/li[@class='navigation-tools__item navigation-tools__minicart js-minicart']") ->updated to the below
    @FindBy(id="mini-cart")
    public WebElement miniBasket;
    @FindBy(xpath="//input[@class='add-to-cart btn btn--buy btn--large btn--full']") //-> updated for scs
    public WebElement scsAddToBasketButton;

    @FindBy(xpath="//div[@id='dialog--extra-products']//div[@class='dialog--button--bar']/a[1]")
    public WebElement scsOverlayContinueButton;


    WebDriverWait wait = new WebDriverWait(General.driver, 15);

    public ProductDisplayPage(WebDriver driver) {
     //   General.driver = driver;
        PageFactory.initElements(General.driver, this);
    }
    /*clicks on the first available size*/
    public void clickOnFirstSize(){
       // System.out.println(allSizes.size());
       // System.out.println(allSizes.get(0).getText()); //gets the text of the size
        this.allSizes.get(0).click();

    }
    /*clicks on the first available color*/
    public void clickOnFirstColor(){
        System.out.println(this.allColors.size());
        System.out.println(this.allColors.get(0).getText()); //gets the text of the size
        this.allColors.get(0).click();

    }
//div[@id='wrapper']//ul[@class='navigation-tools']/li[@class='navigation-tools__item navigation-tools__minicart js-minicart']

    public void clickOnAddToCart(){
        WebDriverWait wait = new WebDriverWait(General.driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(this.btnAddToCart));
      //  wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        System.out.println(this.btnAddToCart.isEnabled());
        if(General.driver.findElement(By.id("add-to-cart")).isEnabled()){
            General.driver.findElement(By.id("add-to-cart")).click();
     //   System.out.println("in if");
        }
         else {

            this.softAssert.fail("add to cart button is disabled");
            this.softAssert.assertAll();
        }
    }

    public ShoppingBasket clickOnMiniBasketIcon(){
        if(this.miniBasket.isEnabled()){
            this.miniBasket.click();

        }
        return new ShoppingBasket(General.driver);
    }
    public void scsAddToBasket(){

        wait.until(ExpectedConditions.elementToBeClickable(scsAddToBasketButton));
        //  wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        System.out.println("AddToBasketButton : "+scsAddToBasketButton.isEnabled());
        scsAddToBasketButton.click();

    }
    public void scsClickOnContinueInTheShoppingBasketOverlay(){
        wait.until(ExpectedConditions.elementToBeClickable(scsOverlayContinueButton));
        scsOverlayContinueButton.click();

    }

}
