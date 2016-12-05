import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CreateMessageTest {

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

    @Test(priority = 2)
    @Parameters({"validEmailAddress", "validPassword", "validEmailAddressTo", "emailSubject", "emailBody"})
    public void testCreateMessage_successfullyCreatedAndSend(
            String validEmailAddress, String validPassword,
            String validEmailAddressTo, String emailSubject, String emailBody) throws InterruptedException{

        loginPage.enterUsername(validEmailAddress)
                .enterPassword(validPassword)
                .clickLogInButton()
                .initInboxMailPage()
                .clickComposeButton()
                .enterMailRecipients(validEmailAddress)
                .enterMailSubject(emailSubject)
                .enterMailBody(emailBody)
                .clickSendEmailButton()
                .clickSentMenuItem()
                .verifySentEmailIsPresent();
    }
}
