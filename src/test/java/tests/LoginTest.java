package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpen());
        assertEquals(productsPage.getTitleText(), "Products");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }


    @Test(dataProvider = "loginData")
    public void incorrectLogin(String user, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.checkErrorMsg(), errorMessage);
    }

    @Test
    public void EmptyLoginAndPassword() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username is required");
    }

    @Test
    public void IncorrectLoginValidPassword() {
        loginPage.open();
        loginPage.login("123", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void ValidLoginIncorrectPassword() {
        loginPage.open();
        loginPage.login("standard_user", "12345678");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username and password do not match any user in this service");
    }
}
