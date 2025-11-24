package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.*;

public class ProductsTest extends BaseTest {

    @Test
    public void checkTwoGoodsAddedToCart() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");

        assertTrue(productsPage.getCartBadgeCounter());
        assertEquals(productsPage.getCartCounterText(), "2");
    }

    @Test
    public void checkGoodsAddedToCart() {
        final String goodsName = "Test.allTheThings() T-Shirt (Red)";
        System.out.println("Products tests are running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        productsPage.isPageOpen();
        productsPage.addToCart(0);
        productsPage.addToCart(goodsName);
        productsPage.switchToCart();

        assertTrue(cartPage.getProductNames().contains(goodsName));
        assertEquals(cartPage.getProductNames().size(),2);
        assertFalse(cartPage.getProductNames().isEmpty());
    }
}
