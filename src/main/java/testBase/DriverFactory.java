package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private DriverFactory(){

    }

    public static DriverFactory driverInstance = new DriverFactory();
    public static DriverFactory getInstance(){
        return driverInstance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver driverToSet){
        driver.set(driverToSet);
    }

    public void closeBrowser(){
        driver.get().close();
        driver.remove();
    }
}
