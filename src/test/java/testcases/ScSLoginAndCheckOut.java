package testcases;

        import PageObjects.*;
        import org.openqa.selenium.By;
        import org.testng.annotations.Test;

        import static PageObjects.General.driver;

public class ScSLoginAndCheckOut {
    @Test
    public  void testScSLoginAndCheckOut() throws InterruptedException {
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

        boolean elementExists = driver.findElements(By.xpath("//input[@class='add-to-cart btn btn--buy btn--large btn--full']")).size() != 0;
        if (elementExists == true) {
            driver.findElement(By.xpath("//input[@class='add-to-cart btn btn--buy btn--large btn--full']")).click();
        }
        Thread.sleep(3000);
        // driver.switchTo().frame(1);
        boolean windowContinueToCheckOutButtonExists = driver.findElements(By.xpath("//div[@id='dialog--extra-products']//div[@class='dialog--button--bar']/a[1]")).size() != 0;
        if (windowContinueToCheckOutButtonExists == true) {
            driver.findElement(By.xpath("//div[@id='dialog--extra-products']//div[@class='dialog--button--bar']/a[1]")).click();
        }
        boolean cookieButtonExists = driver.findElements(By.xpath("//div[@class='cookie-policy__container shown']/span[@class='icon-close']")).size() != 0;
        if (cookieButtonExists) {
            driver.findElement(By.xpath("//div[@class='cookie-policy__container shown']/span[@class='icon-close']")).click();
        }

    }
}
