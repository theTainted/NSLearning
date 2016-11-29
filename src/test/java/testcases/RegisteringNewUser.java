package testcases;



import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;;

/**
 * Created by syam.suryanarayanan on 11/29/2016.
 */
public class RegisteringNewUser extends General{
@Test
    public void testRegisteringNewUser(){
        General.getBrowser("Chrome");
        driver.get(General.URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.clickAcceptCookiesButton();
        homePage.clickLoginRegisterButton();
        RegistrationPage register = homePage.clickOnRegisterButton();
        register.generateFirstName();
        register.enterLastName("tester");
        register.enterEmail();
        register.enterConfirmationEmailAddress();
        register.enterPassword();
        register.enterConfrimsPassword();
        register.clickCreateAccount();
    }
}
