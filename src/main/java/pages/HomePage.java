package pages;

import WebKeywords.WebKeywords;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomePage {
    public String ListNameItems = "//a[contains(@id, 'item')]/div[contains(@class, 'name')]";
    public String addToCartByItemName = "//a[contains(@id, 'item')]/div[contains(@class, 'name') and text()='%s']/../../..//button[text()='Add to cart']";
    public String numberItemInCart = "//span[@class='shopping_cart_badge']";
    public String cartIcon = "//div[@id='shopping_cart_container']";

    public WebKeywords action;
    List<WebElement> elsNameItems = new ArrayList<WebElement>();
    List<String> listNameItems = new ArrayList<>();

    Random rand = new Random();

    public HomePage(WebKeywords action){
        this.action = action;
    }

    @Step("Get 2 random items add to cart")
    public HomePage getRandom2Items() {
        elsNameItems = action.findWebElements(ListNameItems);
        for (WebElement el : elsNameItems) {
            listNameItems.add(action.getText(el));
        }
        int value1 = rand.nextInt(5 - 3 + 1) + 3;
        String nameItem1 = listNameItems.get(value1);
        String locatorAddToCartItem1 = String.format(addToCartByItemName, nameItem1);

        int value2 = rand.nextInt(2 - 0 + 1) + 0;
        String nameItem2 = listNameItems.get(value2);
        String locatorAddToCartItem2 = String.format(addToCartByItemName, nameItem2);

        action.click(locatorAddToCartItem1);
        action.click(locatorAddToCartItem2);

        return this;
    }

    @Step("Verify {0} items in cart")
    public HomePage verifyNumberItemsInCart(int number) {
        Assert.assertEquals(action.getText(numberItemInCart), Integer.toString(number));
        return this;
    }

    @Step("Click cart icon")
    public CartPage clickCartIcon() {
        action.click(cartIcon);
        return new CartPage(action);
    }
}