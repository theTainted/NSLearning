package testcases;

import PageObjects.General;
import PageObjects.HomePage;

/**
 * Created by syam.suryanarayanan on 11/30/2016.
 */
public class RegisterAndThenCheckOut extends General{

    public void testRegisterAndThenCheckOut() {
        General.getBrowser("Chrome");
        driver.get(General.URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);

    }
}
