package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


   @FindBy(xpath="//div[@id='language-overlay']//div[@class='buttons-holder']//a[contains(@class,'btn btn--blue flag-icon')]")
   public WebElement btnCountrySelector;

    @FindBy(xpath="//li[@id='simple-search']//button[@type='submit']")
    public WebElement btnSearchIcon;

    @FindBy (xpath="//*[@id='simple-search']//input[@name='q']")
    public WebElement txtBoxSearch;

    @FindBy(id="shopping-button")
    public WebElement btnShoppingButtonInCountrySelector;

    @FindBy(xpath="//div[@id='wrapper']//a[@class='user-account']")
    public WebElement btnLoginRegister;

    @FindBy(xpath="//div[@id='wrapper']//div[@class='user-links']/a[2]") //have used the [2] because as language changes the text changes
    public WebElement btnRegister;

    @FindBy(xpath="//div[@id='wrapper']/footer//a[contains(@href,'returns')]")
    public WebElement footerReturnLink;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
   public void clickOnCountrySelectorFirstLink(String countryName) {

       WebDriverWait wait = new WebDriverWait(driver, 30);
       wait.until(ExpectedConditions.elementToBeClickable(btnCountrySelector));


       boolean countrySelector = btnCountrySelector.isDisplayed();
       System.out.println(countrySelector);
       if (countrySelector= true) {
        System.out.println("in clickOnCountrySelectorFirstLinkcls");
           btnCountrySelector.click();
       } else if (countrySelector=false) {
           driver.findElement(By.xpath("//div[@id='language-overlay']//a[@data-countrycode=' "+countryName+"'"+"]"));

       }
       else {
           System.out.println("help me !!!!");
       }
   }
   public void  clickAcceptCookiesButton(){
       System.out.println("in");


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
    public void clickShoppingButtonInCountrySelector() {
        if (btnShoppingButtonInCountrySelector.isDisplayed()) {
            btnShoppingButtonInCountrySelector.click();
        }
    }
    public void clickLoginRegisterButton(){
        btnLoginRegister.click();
    }

    public RegistrationPage clickOnRegisterButton(){
        btnRegister.click();
        return new RegistrationPage(driver);
    }
    public ProductListPage searchText(String searchString){
        txtBoxSearch.sendKeys(searchString);
        clickOnSearchIcon();
        return new ProductListPage(driver);
    }
}
