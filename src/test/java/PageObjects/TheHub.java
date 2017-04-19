package PageObjects;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by syam.suryanarayanan on 3/27/2017.
 */
public class TheHub {

    public static WebDriver driver;
    public static String theHubUrl = "http://test-thehub.endemolshine.com/";
    public static String userName = "syam.suryanarayanan@digitaslbi.com";
    public static String password = "P@ssword1";
    SoftAssert softAssert;

    @FindBy(id="login-email")
    public WebElement txtBoxLoginEmail;
    @FindBy(id="login-password")
    public WebElement txtBoxPassword;
    @FindBy(xpath="//form[@id='login']/fieldset/div[4]/button")
    public WebElement btnLogin;
    @FindBy(id="q")
    public WebElement txtBoxSearch;
    @FindBy(xpath="//div[@class='account-2016']//img")
    public WebElement loginUserImage;
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
    @FindBy(xpath="//a[@href='/ErrorPage/Login/Logout']")
    public WebElement btnLogout;
    @FindBy(xpath="//i[@class='burger-icon']")
    public WebElement hamburgerIcon;
    @FindBy(xpath="//a[@href='/Formats']")
    public WebElement hamburgerFormatLink;
    @FindBy(xpath="//a[@href='/Series']")
    public WebElement hamburgerSeriesLink;
    @FindBy(xpath="//a[@href='/Media']")
    public WebElement hamburgerMediaLink;
    @FindBy(xpath="//a[@href='/News']")
    public WebElement hamburgerNewsLink;
    @FindBy(xpath="//a[@href='/Calendar']")
    public WebElement hamburgerCalendarLink;
    @FindBy(xpath="//a[@href='/Brand toolkit']")
    public WebElement hamburgerBrandTookitLink;
    @FindBy(xpath="//a[@href='/Commercial']")
    public WebElement hamburgerCommercialLink;
    @FindBy(xpath="//a[@href='/Policies']")
    public WebElement hamburgerPoliciesLink;
    @FindBy(xpath="//form[@id='searchForm']//h2[@class='main__title']")
    public WebElement pageHeading;
    @FindBy(xpath="//div[@class='calendar']/h1[@class='calendar__h']")
    public WebElement calendarHeading;
    @FindBy(xpath="//form[@id='searchForm']//h2[@class='format-summary__desc-header']")
    public WebElement newPageHeading;
    @FindAll(@FindBy(xpath="//div[@id='result_update']//div[@class='facet collapsed']//h3[@class='facet__header-title']"))
    public WebElement collapsableFacets;

    public TheHub(WebDriver driver) {
        TheHub.driver = driver;
        PageFactory.initElements(TheHub.driver, this);
    }
    public void setLoginEmail(String userName){
        txtBoxLoginEmail.sendKeys(userName);
    }
    public void setLoginPassword(String password){
        txtBoxPassword.sendKeys(password);
    }
    public void clickOnLoginButton(){
        btnLogin.click();
      Assert.assertTrue(this.loginUserImage.isDisplayed());
    }
    public void enterSearchText(String searchText){
        txtBoxSearch.sendKeys(searchText);
        this.clickSearchIcon();


        if (txtBoxSearch.getText().length()!=0){
            System.out.println(txtBoxSearch.getText());
        }
          else {
            System.out.println("damn u");
        }
    }
    public void clickSearchIcon(){
        btnSearchIcon.click();

        for (WebElement tab : allResultTabs){
          //  System.out.println(tab.getText());

        }
    }
   /* public void clickOnAFacet(){

        facetCommercial.click();

        }*/
    public void clickOnFilter(String sFacet ) throws InterruptedException {
       // System.out.println(facet.size());
        for (int i = 0; i< facet.size(); i++){
         //   System.out.println(i);
         //   System.out.println(facet.get(i).getText());
            if(facet.get(i).getText().contains(sFacet)){
         //       System.out.println(facet.get(i).getText());
                facet.get(i).click();

                Thread.sleep(5000);
               String chosenFacet= selectedFacet();
                System.out.println("chosen : " +chosenFacet.trim());
                System.out.println("chosen : " +chosenFacet.trim().length());
                String aFacet[] = facet.get(i).getText().split("\\(");
                if (chosenFacet.trim().equals(aFacet[0].trim())){
                    System.out.println("Awesome");

                }
                else {
                    System.out.println("facet : "+aFacet[0].trim());
                    System.out.println("facet: "+aFacet[0].trim().length());


                }
                i = facet.size();
            }
        }


    }
    public String selectedFacet() {
        System.out.println(selectedFacet.size());
        String chosen = null;
        for (int j = 0; j < selectedFacet.size(); j++) {
            //  System.out.println(this.selectedFacet.get(j).getText());
           return chosen = selectedFacet.get(j).getText();
        }

        return chosen;
    }

    public void clickOnLogout(){
        loginUserImage.click();
        btnLogout.click();
        Assert.assertTrue(txtBoxLoginEmail.isDisplayed());

    }
    public void clickOnHamburgerIcon(){
        this.hamburgerIcon.click();
    }
    public void clickonFormatFromHamburgerMenu(){
        if (hamburgerFormatLink.isDisplayed()){
            hamburgerFormatLink.click();
            String pageTitle = this.pageHeading.getText();
            System.out.println(pageTitle);
           Assert.assertTrue(pageTitle.equalsIgnoreCase("Formats"));
        }
        else{
            Assert.assertFalse(hamburgerFormatLink.isDisplayed(),"format link is not ready to be clicked");
        }
    }
    public void clickonSeriesFromHamburgerMenu(){
        if (hamburgerSeriesLink.isDisplayed()){
            hamburgerSeriesLink.click();
            String pageTitle = this.pageHeading.getText();
            System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Series"));
        }
        else{
            Assert.assertFalse(hamburgerFormatLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonMediaFromHamburgerMenu(){

        if (hamburgerMediaLink.isDisplayed()){
            hamburgerMediaLink.click();
            String pageTitle = this.pageHeading.getText();
            System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Media"));
        }
        else{
            Assert.assertFalse(hamburgerFormatLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonNewsFromHamburgerMenu(){

        if (hamburgerNewsLink.isDisplayed()){
            hamburgerNewsLink.click();
            String pageTitle = this.pageHeading.getText();
            System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("News"));
        }
        else{
            Assert.assertFalse(hamburgerFormatLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonCalendarFromHamburgerMenu(){

        if (hamburgerCalendarLink.isDisplayed()){
            hamburgerCalendarLink.click();
            String pageTitle = this.calendarHeading.getText();
            System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Calendar"));
        }
        else{
            Assert.assertFalse(hamburgerFormatLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonBrandToolkitFromHamburgerMenu(){

        if (hamburgerBrandTookitLink.isDisplayed()){
            hamburgerBrandTookitLink.click();
            String pageTitle = this.newPageHeading.getText();
            System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Brand toolkits"));
        }
        else{
            Assert.assertFalse(hamburgerBrandTookitLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonCommercialFromHamburgerMenu(){

        if (hamburgerCommercialLink.isDisplayed()){
            hamburgerCommercialLink.click();
            String pageTitle = this.newPageHeading.getText();
            System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Commercial"));
        }
        else{
            Assert.assertFalse(hamburgerCommercialLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonPoliciesFromHamburgerMenu(){

        if (hamburgerPoliciesLink.isDisplayed()){
            hamburgerPoliciesLink.click();
            String pageTitle = this.newPageHeading.getText();
            System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Policies"));
        }
        else{
            Assert.assertFalse(hamburgerPoliciesLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
}
