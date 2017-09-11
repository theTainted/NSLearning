package testcases;

        import PageObjects.*;
        import org.testng.annotations.Test;

        import static PageObjects.General.driver;

public class ScSLoginAndCheckOut {
    @Test
    public  void testScSLoginAndCheckOut(){
        String sProductName = "L036281";
        General.getBrowser("Chrome");

        driver.get(General.URL);
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        Login login =  homePage.clickOnSCSLogin();
        login.enterUserName("tester@yopmail.com");
        login.enterPassword("test1234");
        login.clickOnRegisteredLogin();

        ProductListPage plp = homePage.searchText(sProductName);

    }
}
