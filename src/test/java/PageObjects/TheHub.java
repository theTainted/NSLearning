package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public TheHub(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public void setLoginEmail(String userName){
     txtBoxLoginEmail.sendKeys(userName);
    }
}
