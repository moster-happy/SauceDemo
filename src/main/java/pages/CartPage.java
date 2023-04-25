package pages;

import WebKeywords.WebKeywords;
import io.qameta.allure.Step;

public class CartPage {
    public String cartTitle = "//span[text()='Your Cart']";
    public String checkoutBtn = "//button[@id='checkout']";

    public WebKeywords action;

    public CartPage(WebKeywords action){
        this.action = action;
    }

    @Step("Verify cart page is displayed")
    public CartPage verifyCartPageIsDisplayed() {
        action.isDisplayed(cartTitle);
        return this;
    }

    @Step("Click checkout button")
    public void clickCheckoutBtn() {
        action.click(checkoutBtn);
    }
}
