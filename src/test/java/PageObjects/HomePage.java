package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

/**
 * Created by syam.suryanarayanan on 11/14/2016.
 */
public class HomePage extends General {
   // WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath="//div[@id='js-cookie-message']//button[@class='btn']")
    public WebElement btnAcceptCookies;


   //@FindBy(xpath="//div[@id='language-overlay']//div[@class='buttons-holder']//a[contains(@class,'btn btn--blue flag-icon')]")
    @FindBy (xpath="//div[@id='language-overlay']//a[@data-countrycode='ALL~en']")
   public WebElement btnCountrySelector;

   // @FindBy(xpath="//li[@id='simple-search']//button[@type='submit']")
    @FindBy(xpath="//div[@id='simple-search']/form/button[@class='simple-search__submit js-btn-search']")
    public WebElement btnSearchIcon;

    @FindBy (xpath="//*[@id='simple-search']//input[@name='q']")
    public WebElement txtBoxSearch;

    @FindBy(id="shopping-button")
    public WebElement btnShoppingButtonInCountrySelector;

    //@FindBy(xpath="//div[@id='wrapper']//a[@class='user-account']")
    @FindBy(xpath="//div[@id='wrapper']/header//a/span")
    public WebElement btnLoginRegister;

   // @FindBy(xpath="//div[@id='wrapper']//div[@class='user-links']/a[2]") //have used the [2] because as language changes the text changes
    @FindBy(xpath="//form[@id='dwfrm_login_register']//button[@name='dwfrm_login_register']") // -> this is the create accout now button which is displayed when we click on the login link in the home page
    public WebElement btnRegister;

    @FindBy(xpath="//div[@id='wrapper']/footer//a[contains(@href,'returns')]")
    public WebElement footerReturnLink;

    public HomePage(WebDriver driver) {
        General.driver = driver;
        PageFactory.initElements(General.driver, this);
    }
   public void clickOnCountrySelectorFirstLink(String countryName) {
      if ()
       General.driver.findElement(By.xpath("//div[@id='language-overlay']//a[@data-countrycode=\" "+countryName+"\""+"]")).click();


   }
   public void  clickAcceptCookiesButton(){
      // System.out.println("in");


       if (this.btnAcceptCookies.isDisplayed()){
           this.btnAcceptCookies.click();
       }
       else{
           System.out.println("accept Cookies button not found");
       }
   }
    public void clickOnSearchIcon() {
        this.btnSearchIcon.click();

    }
    public void clickShoppingButtonInCountrySelector() {
        if (this.btnShoppingButtonInCountrySelector.isDisplayed()) {
            this.btnShoppingButtonInCountrySelector.click();
        }
    }
    public void clickLoginRegisterButton(){
     //   Actions action = new Actions(driver);

     //   action.moveToElement(btnLoginRegister).build().perform();

        this.btnLoginRegister.click();
    }

    public RegistrationPage clickOnRegisterButton(){
        System.out.println(this.btnRegister.isDisplayed());
        this.btnRegister.click();
        return new RegistrationPage(General.driver);
    }
    public ProductListPage searchText(String searchString){
        this.txtBoxSearch.sendKeys(searchString);
        this.clickOnSearchIcon();
        return new ProductListPage(General.driver);
    }
}
