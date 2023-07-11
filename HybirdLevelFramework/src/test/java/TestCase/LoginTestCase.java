package TestCase;

import Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;
import util.TestUtil;

public class LoginTestCase extends TestBase {
    LoginPage loginPage;
    TestUtil testUtil;
    public LoginTestCase(){
        super();
    }
    @BeforeMethod
    public void setup(){
          initializeBrowser();
         loginPage = new LoginPage();
    }
    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title =loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Demo App");
    }
    @Test(priority = 2)
    public void validateTheLogoTest(){
        boolean flag=loginPage.validateTheLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void verifyTheErrorUserNameTest() {
        boolean Passerror= loginPage.Verifywithoutpassword();
        Assert.assertTrue(Passerror,"Username must be present");
    }
    @Test(priority = 4)
    public void verifyTheErrorPasswordTest() {
        boolean Usererror = loginPage.VerifyWithoutUserName();
        Assert.assertTrue(Usererror, "Password must be present");
    }
    @Test(priority = 5)
    public void verifyTheErrorUserNameAndPasswordTest() {
        boolean Userandpasserror = loginPage.VerifywithoutUsernameAndPassword();
        Assert.assertTrue(Userandpasserror, "Both Username and Password must be present");
    }

    @Test(priority = 6)
    public void loginTest(){
        loginPage.setBtnLogin(prop.getProperty("username"),prop.getProperty("password"));
    }
    @Test(priority = 7)
    public void verifyAmountSorted(){
        loginPage.setBtnLogin(prop.getProperty("username"),prop.getProperty("password"));
        loginPage.clickOnamount();
        testUtil.SoreList();
    }

    @AfterMethod
    public void teardown() {
    driver.quit();
    }
}
