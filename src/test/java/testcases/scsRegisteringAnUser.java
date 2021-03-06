package testcases;

import PageObjects.General;
import PageObjects.HomePage;
import PageObjects.Login;
import PageObjects.RegistrationPage;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class scsRegisteringAnUser  {

    WebDriver  driver= General.getBrowser("Chrome");

    @Test

    public void testScSRegisteringAnUser() throws InterruptedException {

        ////added to see if it helps in the race condition

        // driver.manage().deleteAllCookies();
     driver.get(General.URL);
      driver.manage().window().maximize();
      Thread.sleep(10000);

        HomePage homePage = new HomePage(driver);
        homePage.clickOnCookieNotification();
       Login login =  homePage.clickOnSCSLogin();
       login.clickCreateAccountButton();
        RegistrationPage registration=new RegistrationPage(driver);
        registration.generateFirstName();
        registration.enterLastName("Tester");
        registration.enterEmail();
        registration.enterConfirmationEmailAddress();
        registration.enterPassword();
        registration.enterConfrimsPassword();
        registration.clickCreateAccount();
       System.out.println(driver.getCurrentUrl());
       registration.assertHeadingMyAccount("My account");
     //  driver.findElement(By.xpath("//div[@id='main']//a[@title='Logout'])")).click();


    }
  @AfterClass
    public void tearDown()  {

        driver.quit();

    }


}