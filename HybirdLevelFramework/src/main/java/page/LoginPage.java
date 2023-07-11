package page;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends TestBase {

    // Page Factory or
    @FindBy(xpath = "//input[@id='username']")
    WebElement txtUserName;

    @FindBy(xpath = "//input[@id='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@id='log-in']")
    WebElement btnLogin;

    @FindBy(css = ".auth-header")
    WebElement logo;

    @FindBy(xpath = "//div[text()='Username must be present']")
    WebElement verifyErrorMessageUserName;

    @FindBy(xpath = "//div[text()='Password must be present']")//
    WebElement verifyErrorMessagePassword;

    @FindBy(xpath = "//div[text()='Both Username and Password must be present ']")
    WebElement verifyErrorMessageUserNamePassword;

    @FindBy(xpath = "//th[@id='amount']")
    WebElement amount;

    @FindBy(xpath = "//tr/td[5]")
    WebElement getelementList;

    //td[@class='text-right bolder nowrap']//span

    // Initializing the Page object
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //Actions on the page
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }
    public boolean validateTheLogo(){
       return logo.isDisplayed();
    }
    public void setBtnLogin(String un,String pwd){
        txtUserName.sendKeys(un);
        txtPassword.sendKeys(pwd);
        btnLogin.click();
    }
    public boolean VerifyWithoutUserName(){
        txtPassword.sendKeys("ka");
        btnLogin.click();
        return  verifyErrorMessageUserName.isDisplayed();
    }
    public boolean Verifywithoutpassword() {
        txtUserName.sendKeys("ka");
        btnLogin.click();
        return verifyErrorMessagePassword.isDisplayed();
    }
    public boolean VerifywithoutUsernameAndPassword() {
        txtUserName.sendKeys("");
        txtPassword.sendKeys("");
        btnLogin.click();
        return verifyErrorMessageUserNamePassword.isDisplayed();
    }
    public void clickOnamount(){
        amount.click();
    }
}



