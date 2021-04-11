package com.darkskynet.base;

import com.darkskynet.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;

    public static WebDriver initializeDriver(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILE);
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equals("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }else{
            System.out.println("Invalid driver");
            throw new RuntimeException("invalid browser name entered");
        }
        PageManager.initialize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(url);
        return driver;
    }

    public static void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
