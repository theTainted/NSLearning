package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class scsOrderPreview extends General{
    @FindBy(xpath="//label[@for='dwfrm_summary_summaryCheckboxes_readTermsConditions']")
    public WebElement chkBoxTerms;

        //  WebDriver driver;
        SoftAssert softAssert = new SoftAssert();
    public scsOrderPreview (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
     public void clickOnChkBoxTerm(){
        System.out.println(chkBoxTerms.getAttribute("value"));
        chkBoxTerms.click();

     }
    }
