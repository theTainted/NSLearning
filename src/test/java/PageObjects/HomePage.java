package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by syam.suryanarayanan on 11/14/2016.
 */
public class HomePage {
    WebDriver driver;

    @FindBy(xpath="//div[@id='js-cookie-message']//button[@class='btn']")
    public WebElement btnAcceptCookies;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }




}
