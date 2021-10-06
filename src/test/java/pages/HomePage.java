package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage{


     private By myLabIcon = By.className("b-header-b-personal-e-icon-m-profile");
     private By loginCaption = By.xpath("//a[@data-sendto-params='auth-registration']");
     private By loginForm = By.id("auth-by-code");
     private By search = By.id("search-field");
     public HomePage(WebDriver driver) {
        super(driver);
     }

    public RegisterForm clickToLogin() {
        WebElement icon = driver.findElement(myLabIcon);
        WebElement form = driver.findElement(loginForm);
        Actions actions = new Actions(driver);
        actions.moveToElement(icon).perform();
        getWait().until(ExpectedConditions.visibilityOf(icon.findElement(loginCaption))).click();
        getWait().until(ExpectedConditions.visibilityOf(form));
        return new RegisterForm(form);
    }
    public void findBook(String nameOfBook) {
        WebElement searchField = driver.findElement(search);
        searchField.sendKeys(nameOfBook);

    }
    public class RegisterForm {
        private WebElement form;
        private By loginField = By.xpath("//input[@name='code']");//("//input[starts-with(@id,'_inputnamecode')]");
        private By loginButton = By.id("g-recap-0-btn");
        public RegisterForm(WebElement form) {
            this.form = form;
        }
        public boolean isFormDisplayed() {
            return form.isDisplayed();
        }
        public void setEmail(String email) {
            driver.findElement(loginField).sendKeys(email);

        }
        public void clearInput() {
            driver.findElement(loginField).clear();
        }
        public void setDiscountCode(String code) {
            driver.findElement(loginField).sendKeys(code);
        }
        public void clickLoginButton() {
            getWait().until(ExpectedConditions.elementToBeClickable(loginButton));
            driver.findElement(loginButton).click();
        }
    }
/*
    public void loadPage() {
        getDriver().get("https://www.labirint.ru/");
    }
    */
}
