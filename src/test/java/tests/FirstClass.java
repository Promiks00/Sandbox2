package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstClass extends BaseTest {
    @Test
    public void zipCode() {
        loginPage.open();
        loginPage.login("123456");
        browser.findElement(By.xpath("//input[@value='Continue']")).click();
        boolean registerBtnPresent = browser.findElement(By.xpath("//input[@value='Register']")).isDisplayed();
        assertTrue(registerBtnPresent, "Ожидалось наличие кнопки 'Register'");
    }

    @Test
    public void zipDigitCode() {
        loginPage.open();
        loginPage.login("12");
        assertEquals(loginPage.checkErrorMsg(), "Oops, error on page. ZIP code should have 5 digits");
    }
}
