package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    public WebDriver createBrowserInstance(String browser){
      WebDriver driver = null;

      if(browser.equalsIgnoreCase("chrome")){
          ChromeOptions cOptions = new ChromeOptions();
          cOptions.addArguments("--incognito");
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver(cOptions);
      }else if(browser.equalsIgnoreCase("firefox")) {
          FirefoxOptions fOptions = new FirefoxOptions();
          fOptions.addArguments("-private");
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
      }
//      }else if(browser.equalsIgnoreCase("edge")){
//          WebDriverManager.edgedriver().setup();
//          driver = new EdgeDriver();
//      }


      return driver;
    };
}
