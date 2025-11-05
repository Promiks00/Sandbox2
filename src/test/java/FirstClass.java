import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirstClass {

    //открыть браузер
    //зайти на сайт

    @Test
    public void zipCode() {
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("123456");
        browser.findElement(By.xpath("//input[@name='zip_code']")).sendKeys(Keys.CONTROL + "A");
        browser.findElement(By.cssSelector(".error_message")).getText();
//        browser.findElement(By.name("zip_code"));
//        browser.quit();

    }

}
