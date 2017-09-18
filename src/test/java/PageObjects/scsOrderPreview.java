package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class scsOrderPreview extends General {
 General general = new General();
    @FindBy(xpath="//label[@for='dwfrm_summary_summaryCheckboxes_readTermsConditions']")
    public WebElement chkBoxTerms;
    @FindBy(xpath="//div[@class='form-actions--buttons-creditcards']//button[@name='dwfrm_summary_summaryCheckboxes_submitSummary']")
    public WebElement btnPayByCard;
        //  WebDriver driver;
        SoftAssert softAssert = new SoftAssert();
    public scsOrderPreview (WebDriver driver) {
        //  General.driver = driver;
        this.general.driver=driver;
        PageFactory.initElements(driver, this);
    }
     public void clickOnChkBoxTerm(){
        System.out.println(chkBoxTerms.getAttribute("label"));
        chkBoxTerms.click();

     }
     public void clickOnPayByCard(){

         btnPayByCard.click();
     }
    }
