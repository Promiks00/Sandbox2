package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    // Sauce Labs Backpack
    private static final String ADD_TO_CART =
            "//*[text()='%s']//ancestor:: div[@class='inventory_item']//child::button[text()='Add to cart']";
    private final By title = By.xpath("//*[@data-test='title']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean getTitle() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public void addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
    }


}
