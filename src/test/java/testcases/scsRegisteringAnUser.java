package testcases;

import PageObjects.General;
import PageObjects.HomePage;
import PageObjects.Login;
import PageObjects.RegistrationPage;
import org.testng.annotations.Test;

public class scsRegisteringAnUser extends General {

    @Test

    public void testScSRegisteringAnUser(){

        driver.get(General.URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
       Login login =  homePage.clickOnSCSLogin();
       login.clickCreateAccountButton();
        RegistrationPage registration=new RegistrationPage(driver);
        registration.generateFirstName();
        registration.enterLastName("Tester");
        registration.enterEmail();
        registration.enterConfirmationEmailAddress();
        registration.enterPassword();
        registration.enterConfrimsPassword();


    }
}
