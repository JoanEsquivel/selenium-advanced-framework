package pageObjects.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="user-name")
    WebElement userInput;

    @FindBy(id="password")
    WebElement passInput;

    @FindBy(id="login-button")
    WebElement loginBtn;

    @FindBy(css="h3")
    WebElement errorMessageElement;

    //Initialize all page objects for given driver instance
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password){
        userInput.sendKeys(email);
        passInput.sendKeys(password);
        loginBtn.click();
    }

}
