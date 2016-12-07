package testcases;

import PageObjects.General;
import PageObjects.HomePage;
import org.testng.annotations.Test;

import static PageObjects.General.driver;


/**
 * Created by syam.suryanarayanan on 12/7/2016.
 */
public class DropDownValuesInReturnForm {
@Test
    public void testDropDownValuesInReturnForm(){
        General.getBrowser("Chrome");
        driver.get(General.URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.clickAcceptCookiesButton();
        homePage.clickLoginRegisterButton();
    //clicking on returns link in the footer
        homePage.footerReturnLink.click();
    }
}
