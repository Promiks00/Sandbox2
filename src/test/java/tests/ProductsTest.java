package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductsTest extends BaseTest {

    @Test
    public void checkTwoGoodsAddedToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.addToCart("Sauce Labs Bolt T-Shirt");
        assertTrue(productsPage.getCartBadgeCounter());
        assertEquals(productsPage.getCartCounterText(), "2");
    }

    @Test
    public void validLogin() {
        final String goodsName = "Test.allTheThings() T-Shirt (Red)";
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpen();
        productsPage.addToCart(0);
        productsPage.addToCart(goodsName);
        productsPage.switchToCart();
        assertTrue(cartPage.getProductNames().contains(goodsName));
        assertEquals(cartPage.getProductNames().size(),2);
        assertFalse(cartPage.getProductNames().isEmpty());

    }
}
