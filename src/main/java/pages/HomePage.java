package pages;

public class HomePage {
    private String ListNameItems = "//a[contains(@id, 'item')]/div[contains(@class, 'name')]";
    private String listAddToCartBtn = "//a[contains(@id, 'item')]/div[contains(@class, 'name')]/ancestor::div//button[text()='Add to cart']";

    private String addToCartByItemName = "//a[contains(@id, 'item')]/div[contains(@class, 'name') and text()='%s']/../../..//button[text()='Add to cart']";
    private String numberItemInCart = "//span[@class='shopping_cart_badge']";
}
