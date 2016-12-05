import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by user on 24.03.2016.
 */
public class LoginTest {

    protected static WebDriver webDriver;
    protected static LoginPage loginPage;

    @BeforeMethod
    @Parameters({"page"})
    public static void initElements(String page){
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get(page);
        loginPage = PageFactory.initElements(webDriver, LoginPage.class);

    }

    @AfterMethod
    public static void closeFirefox(){
        webDriver.quit();
    }

    @Test(priority = 1)
    @Parameters({"validEmailAddress", "validPassword"})
    public void testLogin_validCredentials_successLogin(
            String validEmailAddress, String validPassword){

        loginPage.enterUsername(validEmailAddress)
                 .enterPassword(validPassword)
                 .clickLogInButton()
                 .initInboxMailPage()
                 .verifyInboxMenuItemPresent();
    }

    @Test(priority = 2)
    @Parameters ({"validEmailAddress", "invalidPassword"})
    public void testLogin_invalidCredentials_ErrorMessageIsShown(
            String validEmailAddress, String invalidPassword){

        loginPage.enterUsername(validEmailAddress)
                 .enterPassword(invalidPassword)
                 .clickLogInButton()
                 .initPassportPage()
                 .verifyWrongCredentialsErrorMessagePresent();
    }


}
