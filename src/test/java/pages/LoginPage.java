package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver browser;

    private static final By USERNAME_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BTN = By.id("login-button");
    private static final By ERROR_AUTH_MSG = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void open(){
        browser.get("https://www.saucedemo.com/");
    }

    public void login(String username){
        browser.findElement(USERNAME_FIELD).sendKeys(username);
    }

    public void password(String password){
        browser.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickLoginButton(){
        browser.findElement(LOGIN_BTN).click();
    }

    public String checkErrorMsg(){
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_AUTH_MSG));
        return browser.findElement(ERROR_AUTH_MSG).getText();
    }
}
