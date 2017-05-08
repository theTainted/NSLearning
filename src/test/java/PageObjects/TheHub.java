package PageObjects;

import org.openqa.selenium.By;
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
    public List <WebElement> collapsableFacets;

    @FindBy(xpath="//div[@id='result_update']//select[@name='Select an Owner...']")
    public WebElement dropDownSelectAnOwner;
    @FindBy(xpath="//div[@id='result_update']//select[@name='Select a Producer...']")
    public WebElement dropDownSelectAProducer;

    @FindAll(@FindBy(xpath="//div[@id='result_update']//select/option"))
    public List <WebElement> dropdownOptions;



    public TheHub(WebDriver driver) {
        TheHub.driver = driver;
        PageFactory.initElements(TheHub.driver, this);
    }
    public void setLoginEmail(String userName){

        this.txtBoxLoginEmail.click();
        this.txtBoxLoginEmail.sendKeys(userName);
    }
    public void setLoginPassword(String password){
        System.out.println(this.txtBoxPassword.isDisplayed());
        txtBoxPassword.clear();
        this.txtBoxPassword.sendKeys(password);
    }
    public void clickOnLoginButton(){
        this.btnLogin.click();
      Assert.assertTrue(loginUserImage.isDisplayed());
    }
    public void enterSearchText(String searchText){
        this.txtBoxSearch.sendKeys(searchText);
        clickSearchIcon();


        if (this.txtBoxSearch.getText().length()!=0){
           System.out.println(this.txtBoxSearch.getText());
        }
          else {
            System.out.println(this.txtBoxSearch.getText());
        }
    }
    public void clickSearchIcon(){
        this.btnSearchIcon.click();

        for (WebElement tab : this.allResultTabs){
          //  System.out.println(tab.getText());

        }
    }
   /* public void clickOnAFacet(){

        facetCommercial.click();

        }*/
    public void clickOnFilter(String sFacet ) throws InterruptedException {
        //System.out.println(this.facet.size());
        for (int i = 0; i< this.facet.size(); i++){
         //   System.out.println(i);
         //   System.out.println(facet.get(i).getText());
            if(this.facet.get(i).getText().contains(sFacet)){
         //       System.out.println(facet.get(i).getText());
                this.facet.get(i).click();

                Thread.sleep(5000);
               String chosenFacet= this.selectedFacet();
             //   System.out.println(chosenFacet);
                Assert.assertTrue(chosenFacet.equalsIgnoreCase(sFacet));

            }
        }


    }
    public String selectedFacet() {
        //System.out.println(this.selectedFacet.size());
        String chosen = null;
        for (int j = 0; j < this.selectedFacet.size(); j++) {
            //  System.out.println(this.selectedFacet.get(j).getText());
           return chosen = this.selectedFacet.get(j).getText();
        }

        return chosen;
    }

    public void clickOnLogout(){
        this.loginUserImage.click();
        this.btnLogout.click();
        Assert.assertTrue(this.txtBoxLoginEmail.isDisplayed());

    }
    public void clickOnHamburgerIcon(){
        hamburgerIcon.click();
    }
    public void clickonFormatFromHamburgerMenu(){
        if (this.hamburgerFormatLink.isDisplayed()){
            this.hamburgerFormatLink.click();
            String pageTitle = pageHeading.getText();
            //System.out.println(pageTitle);
           Assert.assertTrue(pageTitle.equalsIgnoreCase("Formats"));
        }
        else{
            Assert.assertFalse(this.hamburgerFormatLink.isDisplayed(),"format link is not ready to be clicked");
        }
    }
    public void clickonSeriesFromHamburgerMenu(){
        if (this.hamburgerSeriesLink.isDisplayed()){
            this.hamburgerSeriesLink.click();
            String pageTitle = pageHeading.getText();
            //System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Series"));
        }
        else{
            Assert.assertFalse(this.hamburgerFormatLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonMediaFromHamburgerMenu(){

        if (this.hamburgerMediaLink.isDisplayed()){
            this.hamburgerMediaLink.click();
            String pageTitle = pageHeading.getText();
            //System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Media"));
        }
        else{
            Assert.assertFalse(this.hamburgerFormatLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonNewsFromHamburgerMenu(){

        if (this.hamburgerNewsLink.isDisplayed()){
            this.hamburgerNewsLink.click();
            String pageTitle = pageHeading.getText();
            //System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("News"));
        }
        else{
            Assert.assertFalse(this.hamburgerFormatLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonCalendarFromHamburgerMenu(){

        if (this.hamburgerCalendarLink.isDisplayed()){
            this.hamburgerCalendarLink.click();
            String pageTitle = calendarHeading.getText();
            System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Calendar"));
        }
        else{
            Assert.assertFalse(this.hamburgerFormatLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonBrandToolkitFromHamburgerMenu(){

        if (this.hamburgerBrandTookitLink.isDisplayed()){
            this.hamburgerBrandTookitLink.click();
            String pageTitle = newPageHeading.getText();
            //System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Brand toolkits"));
        }
        else{
            Assert.assertFalse(this.hamburgerBrandTookitLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonCommercialFromHamburgerMenu(){

        if (this.hamburgerCommercialLink.isDisplayed()){
            this.hamburgerCommercialLink.click();
            String pageTitle = newPageHeading.getText();
         //   System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Commercial"));
        }
        else{
            Assert.assertFalse(this.hamburgerCommercialLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }
    public void clickonPoliciesFromHamburgerMenu(){

        if (this.hamburgerPoliciesLink.isDisplayed()){
            this.hamburgerPoliciesLink.click();
            String pageTitle = newPageHeading.getText();
            //System.out.println(pageTitle);
            Assert.assertTrue(pageTitle.equalsIgnoreCase("Policies"));
        }
        else{
            Assert.assertFalse(this.hamburgerPoliciesLink.isDisplayed(),"Series link is not ready to be clicked");
        }
    }

    public void expandUsingSingleSelectFacet(String singleSelectFilter){

        this.collapsableFacets.size();
        //System.out.println(this.collapsableFacets.size());
        for (int j = 0; j < this.collapsableFacets.size(); j++) {
            //  System.out.println(this.selectedFacet.get(j).getText());

            if (this.collapsableFacets.get(j).getText().contains(singleSelectFilter)){
              //  System.out.println(this.collapsableFacets.get(j).getText());
                this.collapsableFacets.get(j).click();
                break;
            }

        }

    }
    public void filterUsingSingleSelectFilter(String filterValue){
        /* Need to make this take a list of item from the dop down and then click on it
        Ideally this function when used to choose a filter from a facet like company, and when again using this method in the same function for the same facet
        but a different filter should replace the first chosen filter from the facet . An example :
        Check the for filters like company  which replace an selected filter inside the company facet (choose 'A' from company facet and then 'B' B should replace A)
                  */
        if(driver.findElement(By.xpath("//div[@id='result_update']//option[contains(text(),"+"'"+filterValue+"')]")).isDisplayed()) {
            driver.findElement(By.xpath("//div[@id='result_update']//option[contains(text()," + "'" + filterValue + "')]")).click();
        }
        else{

            Assert.assertTrue(driver.findElement(By.xpath("//div[@id='result_update']//option[contains(text(),"+"'"+filterValue+"')]")).isDisplayed(),"the option is not displayed");
        }
    }

    public void expanddropDownSelectAnOwner(){
        if(dropDownSelectAnOwner.isDisplayed()){
            dropDownSelectAnOwner.click();

        }
        }
    public void expanddropDownSelectAProducer(){
        if(dropDownSelectAProducer.isDisplayed()){
            dropDownSelectAProducer.click();

        }
    }
    public void clickOnTabInAllResults(String tabName){//ToDO: Add validations in this method or create a new method to validate if the correct tab is clicked

        for (WebElement tab : this.allResultTabs){

            if(tabName.equalsIgnoreCase(tab.getText())){

                driver.findElement(By.xpath("//form[@id='searchForm']//a[@data-category='"+tabName+"']")).click(); //TODO: this needs to be made into a page object

                break;
            }

        }

    }
}
