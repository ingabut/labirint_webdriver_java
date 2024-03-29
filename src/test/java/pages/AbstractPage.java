package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    private final static int TIMEOUT = 30;

    protected WebDriver driver;

    private WebDriverWait wait;

    public AbstractPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(driver, TIMEOUT);

    }

    public WebDriver getDriver() {

        return driver;

    }

    public WebDriverWait getWait() {

        return wait;

    }
}
