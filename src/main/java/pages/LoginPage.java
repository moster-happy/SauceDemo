package pages;

import WebKeywords.WebKeywords;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.testng.Assert;
import utils.log.LogHelper;

public class LoginPage {
    private static Logger logger = LogHelper.getLogger();
    public WebKeywords action;
    private String INPUT_USERNAME = "//input[@id='user-name']";
    private String INPUT_PASSWORD = "//input[@id='password']";
    private String LOGIN_BTN = "//input[@id='login-button']";
    public String LoginFailMsg = "//h3[@data-test='error' and contains(text(), 'Username and password do not match any user in this service')]";
    public String LoginRequireMsg = "//h3[@data-test='error' and contains(text(), 'Username is required')]";
    public String LoginLockedFailMsg = "//h3[@data-test='error' and contains(text(), 'Sorry, this user has been locked out.')]";

    public LoginPage(WebKeywords action){
        this.action = action;
    }

    @Step("Login account")
    public void loginAccount(String userName, String passWord, String result) {
        action.setText(INPUT_USERNAME, userName);
        action.setText(INPUT_PASSWORD, passWord);
        action.click(LOGIN_BTN);
        switch (result) {
            case "success":
                verifyLoginSuccess();
                break;
            case "require":
                verifyLoginFailRequire();
                break;
            case "locked":
                verifyLoginFailLocked();
                break;
            case "incorrect":
                verifyLoginFailIncorrect();
                break;
        }
    }

    @Step("Verify login successfully")
    public HomePage verifyLoginSuccess() {
        return new HomePage(action);
    }

    @Step("Verify login fail, incorrect userName or password")
    public LoginPage verifyLoginFailIncorrect() {
        Assert.assertTrue(action.isDisplayed(LoginFailMsg));
        return this;
    }

    @Step("Verify login fail, require userName or password")
    public LoginPage verifyLoginFailRequire() {
        Assert.assertTrue(action.isDisplayed(LoginRequireMsg));
        return this;
    }

    @Step("Verify login locked")
    public LoginPage verifyLoginFailLocked() {
        Assert.assertTrue(action.isDisplayed(LoginLockedFailMsg));
        return this;
    }
}
