package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by syam.suryanarayanan on 3/27/2017.
 */
public class TheHub {

    public static WebDriver driver;
    public static String theHubUrl = "http://test-thehub.endemolshine.com/";
    public static String userName = "syam.suryanarayanan@digitaslbi.com";
    public static String password = "P@ssword1";

    @FindBy(id="login-email")
    public WebElement txtBoxLoginEmail;
    @FindBy(id="login-password")
    public WebElement txtBoxPassword;
    @FindBy(xpath="//form[@id='login']/fieldset/div[4]/button")
    public WebElement btnLogin;
    @FindBy(id="q")
    public WebElement txtBoxSearch;
    @FindBy(xpath="//div[@id='search']//button[@class='form-search__btn']")
    public WebElement btnSearchIcon;
    @FindAll({
        @FindBy(xpath="//form[@id='searchForm']//a[@class='search-header__label-link']")
    })
    public List<WebElement> allResultTabs ;
    @FindBy(xpath="//div[@id='result_update']//div[@class='facet__body']//label//input[contains(@value,'Commercial')]")
    public WebElement facetCommercial;

    public TheHub(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void setLoginEmail(String userName){
     txtBoxLoginEmail.sendKeys(userName);
    }
    public void setLoginPassword(String password){
        txtBoxPassword.sendKeys(password);
    }
    public void clickOnLoginButton(){
        btnLogin.click();
    }
    public void enterSearchText(String searchText){
        txtBoxSearch.sendKeys(searchText);
    }
    public void clickSeachIcon(){
        btnSearchIcon.click();
        for (WebElement tab : allResultTabs){
            System.out.println(tab.getText());

        }
    }
    public void clickOnAFacet(){
        if (facetCommercial.isDisplayed()){
        facetCommercial.click();

        }
        else{
            System.out.println("False");
        }
    }

}
