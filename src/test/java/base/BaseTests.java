package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import pages.HomePage;

public class BaseTests {
    protected HomePage homePage;
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        goHomeAndLogin();
    }
    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return  options;
    }

    public void goHomeAndLogin() {
        driver.get("https://www.labirint.ru/");
        homePage = new HomePage(driver);
        login();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    public void login(){
        HomePage.RegisterForm form =homePage.clickToLogin();
        form.clearInput();
        form.setDiscountCode("910D-4623-8EB7");
        form.clickLoginButton();
        homePage.getWait().until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("auth-by-code"))));

    }
    @Test
    public void testSomething() throws InterruptedException {
        homePage.findBook("Колобок");
        //homePage.getWait().until(ExpectedConditions.)
        //caption.setDiscountCode("CEA5-4332-A918");
        //homePage.clickLoginButton();
    }
}
