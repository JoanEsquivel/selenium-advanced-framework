package tests;

import org.testng.annotations.Test;
import pageObjects.demo.LoginPage;
import testBase.DriverFactory;
import testBase.TestBase;
import utils.PropertiesManager;

public class DemoLogin extends TestBase {

    LoginPage loginPage = new LoginPage();

    @Test
    public void successLogin(){
        loginPage.login("standard_user", "secret_sauce");

    }
    @Test
    public void lockedUser(){
//        System.out.println( PropertiesManager.getPropertyValueByKey("browser"));
        loginPage.login("locked_out_user", "secret_sauces");
        isTextCorrect("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessage());
    }
    @Test
    public void wrongUser(){
        loginPage.login("wrong_user", "secret_sauce");
    }
    @Test
    public void wrongPassword(){
        loginPage.login("standard_user", "wrong_password");
    }
}
