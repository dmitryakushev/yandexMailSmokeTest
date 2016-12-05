import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MainMailPage extends BasePage {

    // Page Constructor
    public MainMailPage(WebDriver webDriver) {
        super(webDriver);
    }

    // WebElements, that are common for all mail pages
    @FindBy(how = How.XPATH, using = "(//a[contains(@title, 'Inbox')])[1]")
    private WebElement inboxMenuItem;
    public WebElement getInboxMenuItem() {
        return inboxMenuItem;
    }

    @FindBy(how = How.XPATH, using = "//a[@title='Sent']")
    private WebElement sentMenuItem;
    public WebElement getSentMenuItem() {
        return sentMenuItem;
    }

    @FindBy(how = How.XPATH, using = "//*[contains(@class, 'b-ico_compose')]")
    private WebElement composeButton;
    public WebElement getComposeButton() {
        return composeButton;
    }


    // Methods
    public ComposeMailPage clickComposeButton(){
        composeButton.click();
        return PageFactory.initElements(webDriver, ComposeMailPage.class);
    }

    public InboxMailPage clickInboxMenuItem(){
        getInboxMenuItem().click();
        return PageFactory.initElements(webDriver, InboxMailPage.class);
    }

    public void verifyInboxMenuItemPresent(){
        Assert.assertTrue(elementIsPresent(inboxMenuItem),
                "Inbox menu item is not present on the page!");
    }

    public SentMailPage clickSentMenuItem() throws InterruptedException {
        Thread.sleep(20000);
        sentMenuItem.click();
        return PageFactory.initElements(webDriver, SentMailPage.class);
    }






}
