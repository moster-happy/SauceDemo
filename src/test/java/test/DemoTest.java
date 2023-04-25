package test;

import listener.TestNGListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.configs.ExcelConfig;

public class DemoTest extends TestNGListener {
    public LoginPage loginPage;
    public HomePage homePage;
    ExcelConfig excelConfig = new ExcelConfig("src/main/resources/account.xlsx");


    public DemoTest(){
        super();
    }

    @DataProvider(name = "excelUser")
    public Object[][] getCredential() {
        return excelConfig.data();
    }

    @Test(priority = 1, dataProvider = "excelUser", description = "Test login account", groups = "loginTest")
    public void loginTest(String userName, String password, String result){
        loginPage = new LoginPage(action);
        loginPage.loginAccount(userName, password, result);
    }

    @Test(priority = 2, description = "Add random 2 items and add to cart", groups = "buyItems")
    public void buyRandom2Items() {
        loginPage = new LoginPage(action);
        loginPage.loginAccount("standard_user", "secret_sauce", "success");
        homePage = new HomePage(action);
        homePage.getRandom2Items()
                .verifyNumberItemsInCart(2)
                .clickCartIcon()
                .verifyCartPageIsDisplayed()
                .clickCheckoutBtn();
    }
}
