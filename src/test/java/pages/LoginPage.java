package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver browser;

    private static final By ZIP_CODE_FIELD = By.xpath("//input[@name='zip_code']");
    private static final By CONTINUE = By.xpath("//input[@value='Continue']");

    public LoginPage(WebDriver browser) {
        this.browser = browser;

    }

    public void open(){
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
    }

    public void login(String zipCode){
        browser.findElement(ZIP_CODE_FIELD).sendKeys("12");
        browser.findElement(CONTINUE).click();

    }

    public String checkErrorMsg(){
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error_message")));
        return browser.findElement(By.cssSelector(".error_message")).getText();
    }

}
