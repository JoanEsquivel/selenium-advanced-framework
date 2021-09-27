package utils;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testBase.ExtentFactory;

public class Wrapper {

    //-- Actions
    public void type(WebElement locator, String value){
        try{
            locator.sendKeys(value);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Typed '" +value+"' at the element '" +locator+"'.");
        }catch (Exception e){
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Type error trying to send '" +value+"' at the element '" +locator+"'. The error is: " + e);
        }
    }

    public void clickOn(WebElement locator){
        try{
            locator.click();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Click on the element '" +locator+"'.");
        }catch (Exception e){
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Click on the element '" +locator+ "'. The error is: " + e);
        }
    }

    //-- Validations
    public void isTextCorrect(String expectedValue, String actualValue){
        try {
            Assert.assertEquals(expectedValue, actualValue);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Expected value ' "+expectedValue+ "' is equal to '"+actualValue+"', which is the current value.");
        }catch (Exception e){
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Expected value ' "+expectedValue+ "' is not equal to '"+actualValue+"', which is the current value. The error is: " + e);
        }
    }

    public boolean elementExists(WebElement locator){
        boolean doesExist = false;
        try{
            doesExist = locator.isDisplayed();
            Assert.assertTrue(doesExist);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Element '" +locator+"' exists.");
        }catch (Exception e){
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Element '" +locator+"' does not exist. The error is: " + e);
        }
        return doesExist;
    }

    //-- Helpers
    public String getText(WebElement locator){
        String value = "";
        try{
            value = locator.getText();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Getting the text from the element '" + locator+ "'. The text is: " + value);
        }catch (Exception e){
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Error getting the text from the element '" + locator+ "'. The error is: " + e);
        }
        return value;
    }

}
