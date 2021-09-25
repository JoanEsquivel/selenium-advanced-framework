package testBase;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentFactory {
    private ExtentFactory(){

    }

    public static ExtentFactory driverInstance = new ExtentFactory();
    public static ExtentFactory getInstance(){
        return driverInstance;
    }

    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    public ExtentTest getExtent(){
        return extent.get();
    }

    public void setExtent(ExtentTest extentToSet){
        extent.set(extentToSet);
    }

    public void removeExtentObject(){
        extent.remove();
    }

}
