import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by dyakushev on 3/24/2016.
 */
public class LoginPage extends BasePage {

    // Page Constructor
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    // WebElements of the page
    @FindBy(how = How.NAME, using = "login")
    private WebElement userNameField;

    @FindBy(how = How.NAME, using = "passwd")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement logInButton;


    // Methods
    public LoginPage enterUsername(String username){
        userNameField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLogInButton(){
        logInButton.click();
        return this;
    }

    public InboxMailPage initInboxMailPage(){
        return PageFactory.initElements(webDriver, InboxMailPage.class);
    }

    public PassportPage initPassportPage(){
        return PageFactory.initElements(webDriver, PassportPage.class);
    }

}
