package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class ProductsPage extends BasePage {

    private By title = By.xpath("//*[@data-test='title']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean getTitle() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }
//    assertTrue(productsTitlePresent, "Ожидалось наличие названия страницы 'Products'");




}
