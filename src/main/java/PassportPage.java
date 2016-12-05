import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

/**
 * Created by dyakushev on 3/25/2016.
 */
public class PassportPage extends BasePage {

    // Page Constructor
    public PassportPage(WebDriver webDriver) {
        super(webDriver);
    }

    // WebElements of the page
    @FindBy(how = How.CLASS_NAME, using = "error-msg")
    private WebElement wrongCredentialsErrorMessage;

    // Methods
    public void verifyWrongCredentialsErrorMessagePresent(){
        Assert.assertTrue(elementIsPresent(wrongCredentialsErrorMessage),
                "Error message is not present on the page!");
    }
}
