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
    @FindAll(@FindBy(xpath = "//form[@id='searchForm']//a[@class='search-header__label-link']"))
    public List<WebElement> allResultTabs ;
    @FindBy(xpath="//div[@id='result_update']//div[@class='facet__body']//input[contains(@value,'Commercial')]")
    public WebElement facetCommercial;
    @FindAll(@FindBy(xpath = "//div[@id='result_update']//label[@class='facet__checkbox-label']"))
    public List<WebElement> facet;
    @FindAll(@FindBy(xpath = "//div[@id='result_update']//div[@class='facet__selection']/div[@class='facet__selection-label']"))
    public List<WebElement> selectedFacet;

    public TheHub(WebDriver driver) {
        TheHub.driver = driver;
        PageFactory.initElements(TheHub.driver, this);
    }
    public void setLoginEmail(String userName){
        this.txtBoxLoginEmail.sendKeys(userName);
    }
    public void setLoginPassword(String password){
        this.txtBoxPassword.sendKeys(password);
    }
    public void clickOnLoginButton(){
        this.btnLogin.click();
    }
    public void enterSearchText(String searchText){
        this.txtBoxSearch.sendKeys(searchText);
    }
    public void clickSeachIcon(){
        this.btnSearchIcon.click();
        for (WebElement tab : this.allResultTabs){
          //  System.out.println(tab.getText());

        }
    }
   /* public void clickOnAFacet(){

        facetCommercial.click();

        }*/
    public void clickOnFilter(String sFacet ) throws InterruptedException {
       // System.out.println(facet.size());
        for (int i = 0; i< this.facet.size(); i++){
         //   System.out.println(i);
         //   System.out.println(facet.get(i).getText());
            if(this.facet.get(i).getText().contains(sFacet)){
         //       System.out.println(facet.get(i).getText());
                this.facet.get(i).click();

                Thread.sleep(5000);
               String chosenFacet= this.selectedFacet();
                System.out.println("chosen : " +chosenFacet.trim());
                System.out.println("chosen : " +chosenFacet.trim().length());
                String aFacet[] = this.facet.get(i).getText().split("\\(");
                if (chosenFacet.trim().equals(aFacet[0].trim())){
                    System.out.println("Awesome");

                }
                else {
                    System.out.println("facet : "+aFacet[0].trim());
                    System.out.println("facet: "+aFacet[0].trim().length());


                }
                i = this.facet.size();
            }
        }


    }
    public String selectedFacet() {
        System.out.println(this.selectedFacet.size());
        String chosen = null;
        for (int j = 0; j < this.selectedFacet.size(); j++) {
            //  System.out.println(this.selectedFacet.get(j).getText());
           return chosen = this.selectedFacet.get(j).getText();
        }

        return chosen;
    }

}
