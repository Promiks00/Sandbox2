package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import user.User;

public class LoginPage extends BasePage {

    private static final By USERNAME_FIELD = By.id("user-name");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BTN = By.id("login-button");
    private static final By ERROR_AUTH_MSG = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие url страницы")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Логинимся под кредами: логин = {user.email}, пароль = *****")
    public void login(User user) {
        fillInLogin(user.getEmail());
        fillPassword(user.getPassword());
        pressLoginBtn();
    }

    @Step("Вводим логин = {user.email}")
    public void fillInLogin(String username) {
        driver.findElement(USERNAME_FIELD).sendKeys(username);
    }

    @Step("Вводим пароль = *****")
    public void fillPassword(String password) {
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Нажимаем кнопку 'Login'")
    public void pressLoginBtn() {
        driver.findElement(LOGIN_BTN).click();
    }

    @Step("Проверяем текст сообщения об ошибке")
    public String checkErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_AUTH_MSG));
        return driver.findElement(ERROR_AUTH_MSG).getText();
    }
}
