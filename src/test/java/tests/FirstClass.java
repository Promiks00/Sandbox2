package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstClass extends BaseTest {
    @Test
    public void validLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.getTitle());
        assertEquals(productsPage.getTitleText(), "Products");
    }

    @Test
    public void lockedOutLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
