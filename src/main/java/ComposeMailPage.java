import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by dyakushev on 3/25/2016.
 */
public class ComposeMailPage extends MainMailPage{

    // Page Constructor
    public ComposeMailPage(WebDriver webDriver) {
        super(webDriver);
    }
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor)webDriver;

    private WebDriverWait wait = new WebDriverWait(webDriver, 10);

    // Webelements of the page
    @FindBy(how = How.XPATH, using = "//*[@class='b-mail-input_yabbles__focus']")
    private WebElement mailRecipientsInputField;

    @FindBy(how = How.XPATH, using = "//*[@class='b-mail-input__yabbles']/child::div/child::input")
    private WebElement mailRecipientsInputFieldActivated;

    @FindBy(how = How.ID, using = "compose-subj")
    private WebElement mailSubjectInputField;

    @FindBy(how = How.XPATH, using = ".//*[@id='tinymce']/div[1]")
    private WebElement mailBody;

    @FindBy(how = How.ID, using = "compose-submit")
    private WebElement sendEmailButton;

    @FindBy(how = How.ID, using = "compose-send_ifr")
    private WebElement emailBodyIframe;


    //Methods
    public ComposeMailPage enterMailRecipients(String recipient){
        mailRecipientsInputField.click();
        wait.until(ExpectedConditions.elementToBeClickable(mailRecipientsInputFieldActivated));
        mailRecipientsInputFieldActivated.sendKeys(recipient);
        return this;
    }

    public ComposeMailPage enterMailSubject(String subject){
        mailSubjectInputField.sendKeys(subject);
        return this;
    }

    public ComposeMailPage enterMailBody(String body){
        webDriver.switchTo().frame(emailBodyIframe);
        mailBody.sendKeys(body);
        webDriver.switchTo().defaultContent();
        return this;
    }

    public ComposeMailPage clickSendEmailButton(){
        sendEmailButton.click();
        return this;
    }

}
