package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Epic("Интернет-магазин")
    @Feature("Авторизация")
    @Story("Успешное прохождение авторизации")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Prokudin Dmitry")
    @TmsLink("Sandbox2")
    @Issue("ToyStore")
    @Test (description = "Проверка авторизации под валидными логином и паролем", enabled = false)
    public void validLogin() {
        System.out.println("CorrectLogin tests are running in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertTrue(productsPage.isPageOpen());
        assertEquals(productsPage.getTitleText(), "Productss");
    }


    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {UserFactory.withLockedUserPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {UserFactory.withEmptyLogin(), "Epic sadface: Username is required"},
                {UserFactory.withEmptyPassword(), "Epic sadface: Password is required"},
                {UserFactory.withEmptyLoginAndPassword(), "Epic sadface: Username is required"},
                {UserFactory.withInCorrectLogin(), "Epic sadface: Username and password do not match any user in this service"},
                {UserFactory.withInCorrectPassword(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Epic("Интернет-магазин")
    @Feature("Авторизация")
    @Story("Непрохождение авторизации по причине невалидных кредов")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Prokudin Dmitry")
    @TmsLink("Sandbox2")
    @Test(dataProvider = "loginData")
    public void incorrectLogin(User user, String errorMessage) {
        System.out.println("InCorrectLogin tests are running in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user);
        assertEquals(loginPage.checkErrorMsg(), errorMessage);
    }
}
