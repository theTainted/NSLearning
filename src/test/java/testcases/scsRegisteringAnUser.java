package testcases;

import PageObjects.General;
import PageObjects.HomePage;
import org.testng.annotations.Test;

public class scsRegisteringAnUser extends General {

    @Test

    public void testScSRegisteringAnUser(){

        driver.get(General.URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSCSLogin();

    }
}
