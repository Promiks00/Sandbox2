package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART =
            "//*[text()='%s']//ancestor:: div[@class='inventory_item']//child::button[text()='Add to cart']";
    private final By title = By.xpath("//*[@data-test='title']");
    private final By cartBadgeCounter = By.xpath("//*[@data-test='shopping-cart-badge']");
    private final By addToCart = By.xpath("//*[text()='Add to cart']");
    private final By cartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ожидаем прогрузки страницы с товаром")
    public boolean isPageOpen() {
        return driver.findElement(title).isDisplayed();
    }

    @Step("Проверяем название страницы")
    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    @Step("Добавляем товар в корзину по названию")
    public void addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    @Step("Добавляем товар в корзину по индексу")
    public void addToCart(final int index) {
        driver.findElements(addToCart).get(index).click();
    }

    @Step("Проверяем отображение каунтера корзины")
    public boolean getCartBadgeCounter() {
        return driver.findElement(cartBadgeCounter).isDisplayed();
    }

    @Step("Получаем значение каунтера корзины")
    public String getCartCounterText() {
        return driver.findElement(cartBadgeCounter).getText();
    }

    @Step("Переходим в корзину")
    public void switchToCart() {
        driver.findElement(cartLink).click();
    }
}
