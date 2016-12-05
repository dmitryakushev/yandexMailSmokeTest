import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Parameters;

/**
 * Created by user on 25.03.2016.
 */
public class SentMailPage extends MainMailPage {

    protected String sentEmailSubject;

    // Page Constructor
    public SentMailPage(WebDriver webDriver) {
        super(webDriver);
    }

    //Web Elements on page

//    @Parameters({"emailSubject"})
//    private String getEmailSubjectFromParameters (String emailSubject){
//        sentEmailSubject = emailSubject;
//        return sentEmailSubject;
//    }

    @FindBy(how = How.XPATH, using = "//span[@title='TestSubject']")
    private WebElement sentEmail;

    // Methods
    public void verifySentEmailIsPresent(){
        Assert.assertTrue(elementIsPresent(sentEmail),
                "Email is not present in 'Sent' folder!");
    }

}
