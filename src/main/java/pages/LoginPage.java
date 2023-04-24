package pages;

import WebKeywords.WebKeywords;
import io.qameta.allure.Step;
import items.Item;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import utils.log.LogHelper;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    private static Logger logger = LogHelper.getLogger();
    public WebKeywords action;
    private Item item;
    List<WebElement> els = new ArrayList<WebElement>();
    List<Item> listItems = new ArrayList<>();
    private String INPUT_USERNAME = "//input[@id='user-name']";
    private String INPUT_PASSWORD = "//input[@id='password']";
    private String LOGIN_BTN = "//input[@id='login-button']";

    public LoginPage(WebKeywords action){
        this.action = action;
    }

    @Step("Login account")
    public LoginPage loginAccount(String userName, String passWord) {
        System.out.println("userName: " + userName);
        System.out.println("password: " + passWord);
        action.setText(INPUT_USERNAME, userName);
        action.setText(INPUT_PASSWORD, passWord);
        action.click(LOGIN_BTN);
        System.out.println("Done test");
        return new LoginPage(action);
    }

    @Step("Get items")
    public void getItems(){

    }
}
