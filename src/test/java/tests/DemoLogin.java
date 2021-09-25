package tests;

import org.testng.annotations.Test;
import testBase.TestBase;
import utils.PropertiesManager;

public class DemoLogin extends TestBase {
    @Test
    public void successLogin(){
        System.out.println("Sucess Login Test");
        System.out.println( PropertiesManager.getPropertyValueByKey("browser"));
    }
    @Test
    public void lockedUser(){
        System.out.println("Locked User Test");
    }
    @Test
    public void wrongUser(){
        System.out.println("Wrong User Name Test");
    }
    @Test
    public void wrongPassword(){
        System.out.println("Wrong Password Test");
    }
}
