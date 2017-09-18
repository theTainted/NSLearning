package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by syam.suryanarayanan on 12/8/2016.
 */
public class ReturnPage extends General {
    General general = new General();
    // WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
     @FindBy(xpath="//div[@id='primary']//a[contains(@href,'return')]")
    public WebElement lnkReturn;

    @FindAll({
            @FindBy(xpath="//select[@id='dwfrm_return_request_items_item1_reason']/option")
    })
    public List<WebElement> reasonCodes; ;
   /* @FindBy(id = "dwfrm_return_request_items_item1_reason")
    WebElement reasonDropDown ;
    Select dropDownReason = new Select(reasonDropDown);*/

   @FindBy(id = "dwfrm_return_request_items_item1_reason")
    public WebElement elDropdownReason;

    public ReturnPage(WebDriver driver) {
      general.driver = driver;
        PageFactory.initElements(general.driver, this);
    }

    public void clickLinkReturn(){
        lnkReturn.click();
    }
    public void listAllOptionsFromDropDownReason(){
        elDropdownReason.click();
        System.out.println(reasonCodes.size());
        for(int i=0; i<reasonCodes.size();i++) {
            System.out.println(reasonCodes.get(i).getText());
        }
    }

}
