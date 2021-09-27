package testBase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertiesManager;
import utils.Wrapper;

import java.util.concurrent.TimeUnit;

public class TestBase extends Wrapper {

    BrowserFactory bFactory = new BrowserFactory();

    @BeforeMethod
    public void setUp(){

        String browser = PropertiesManager.getPropertyValueByKey("browser");
        String url = PropertiesManager.getPropertyValueByKey("url");

        DriverFactory.getInstance().setDriver(bFactory.createBrowserInstance(browser));
        WebDriver driver = DriverFactory.driverInstance.getDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getInstance().closeBrowser();
    }


}
