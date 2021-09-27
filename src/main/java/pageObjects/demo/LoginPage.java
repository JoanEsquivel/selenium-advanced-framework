package pageObjects.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.DriverFactory;
import utils.Wrapper;

public class LoginPage extends Wrapper {

//    @FindBy(id="user-name")
//    WebElement userInput;
//
//    @FindBy(id="password")
//    WebElement passInput;
//
//    @FindBy(id="login-button")
//    WebElement loginBtn;
//
//    @FindBy(css="h3")
//    WebElement errorMessageElement;

    By userInput = By.id("user-name");
    By passInput = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMessageElement = By.cssSelector("h3");

    public void login(String email, String password){
        type(DriverFactory.getInstance().getDriver().findElement(userInput), email);
        type(DriverFactory.getInstance().getDriver().findElement(passInput), password);
        clickOn(DriverFactory.getInstance().getDriver().findElement(loginBtn));
    }

    public String getErrorMessage(){
        return getText(DriverFactory.getInstance().getDriver().findElement(errorMessageElement));
    }

}
