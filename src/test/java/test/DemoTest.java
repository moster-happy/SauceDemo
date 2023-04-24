package test;

import listener.TestNGListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginPageSteps;
import utils.configs.ExcelConfig;

public class DemoTest extends TestNGListener {
    private LoginPage homePage;
    ExcelConfig excelConfig = new ExcelConfig("src/main/resources/account.xlsx");
    LoginPageSteps loginPageStepsPage;


    public DemoTest(){
        super();
    }

    @DataProvider(name = "excelUser")
    public Object[][] getCredential() {
        return excelConfig.data();
    }

    @Test(dataProvider = "excelUser", description = "Get 2 items and add to cart")
    public void demoTest(String userName, String password){
        homePage = new LoginPage(action);
        homePage.loginAccount(userName, password);
    }
}
