import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver webDriver;

    // Page Constructor
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    // Methods
    public boolean elementIsPresent(WebElement webElement){
        try {
            webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }


    // Getters
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
