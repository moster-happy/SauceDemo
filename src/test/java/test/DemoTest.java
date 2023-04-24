package test;

import listener.TestNGListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import steps.LoginPageSteps;
import utils.configs.ExcelConfig;

public class DemoTest extends TestNGListener {
    private HomePage homePage;
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
        homePage = new HomePage(action);
        homePage.loginAccount(userName, password);
    }
}
