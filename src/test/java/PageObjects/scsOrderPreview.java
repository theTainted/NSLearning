package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class scsOrderPreview extends General{

        //  WebDriver driver;
        SoftAssert softAssert = new SoftAssert();
    public scsOrderPreview (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    }
