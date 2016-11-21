package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

/**
 * Created by syam.suryanarayanan on 11/14/2016.
 */
public class HomePage extends General {
   // WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath="//div[@id='js-cookie-message']//button[@class='btn']")
    public WebElement btnAcceptCookies;
    @FindBy(xpath="//li[@id='simple-search']//button[@type='submit']")
    public WebElement btnSearchIcon;
    @FindBy (xpath="//*[@id='simple-search']//input[@name='q']")
    public WebElement txtBoxSearch;
    @FindBy(id="shopping-button")
    public WebElement btnShoppingButtonInCountrySelector;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
   public void  clickAcceptCookiesButton(){
       if (btnAcceptCookies.isDisplayed()){
           btnAcceptCookies.click();
       }
       else{
           System.out.println("accept Cookies button not found");
       }
   }
    public void clickOnSearchIcon() {
        btnSearchIcon.click();

    }
    public void clickShoppingButtonInCountrySelector(){
        if(btnShoppingButtonInCountrySelector.isDisplayed()){
            btnShoppingButtonInCountrySelector.click();
        }
    }
    public ProductListPage searchText(String searchString){
        txtBoxSearch.sendKeys(searchString);
        clickOnSearchIcon();
        return new ProductListPage(driver);
    }
}
