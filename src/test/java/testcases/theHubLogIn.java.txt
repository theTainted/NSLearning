package testcases;

        import PageObjects.General;
        import PageObjects.TheHub;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.Test;



/**
 * Created by syam.suryanarayanan on 4/6/2017.
 */
public class theHubLogIn  extends General {


    @Test
    public void testTheHubLogin() {
      /*System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
      WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.ie.driver","C:/IEDriverServer.exe");
        General.driver = new InternetExplorerDriver();*/
        TheHub theHub = new TheHub(General.driver);
        General.driver.get(TheHub.theHubUrl);
        General.driver.manage().window().maximize();
        theHub.setLoginEmail(TheHub.userName);
        theHub.setLoginPassword(TheHub.password);
        theHub.clickOnLoginButton();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}