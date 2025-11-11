package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final By USERNAME_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BTN = By.id("login-button");
    private static final By ERROR_AUTH_MSG = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String username, String password) {
        fillInLogin(username);
        fillPassword(password);
        pressLoginBtn();
    }

    public void fillInLogin(String username) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void pressLoginBtn() {
        driver.findElement(LOGIN_BTN).click();
    }

    public String checkErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_AUTH_MSG));
        return driver.findElement(ERROR_AUTH_MSG).getText();
    }
}
