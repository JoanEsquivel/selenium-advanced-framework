package pageObjects.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(className="title")
    WebElement header;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
