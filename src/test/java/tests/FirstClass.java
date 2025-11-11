package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstClass extends BaseTest {
    @Test
    public void validLogin() {
        loginPage.open();
        loginPage.login("standard_user");
        loginPage.password("secret_sauce");
        loginPage.clickLoginButton();
        boolean productsTitlePresent = browser.findElement(By.xpath("//span[@data-test='title']")).isDisplayed();
        assertTrue(productsTitlePresent, "Ожидалось наличие названия страницы 'Products'");
    }

    @Test
    public void lockedOutLogin() {
        loginPage.open();
        loginPage.login("locked_out_user");
        loginPage.password("secret_sauce");
        loginPage.clickLoginButton();
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
