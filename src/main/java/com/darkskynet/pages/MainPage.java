package com.darkskynet.pages;

import com.darkskynet.base.BasePage;
import com.darkskynet.utils.HelperMethods;
import org.openqa.selenium.By;
import static com.darkskynet.base.BasePage.driver;

public class MainPage {

    public static By locationx = By.xpath("//*[@id='searchForm']/input");
    public static By searchx = By.xpath("//*[@id='searchForm']/a[2]");
    public static By lowestx = By.xpath("//*[@id='title']/span[1]/span[2]/span[2]/span[2]/span[2]");
    public static By highestx = By.xpath("//*[@id='title']/span[1]/span[2]/span[2]/span[3]/span[2]");

    public static void enterLocation(String location){
        HelperMethods.sendText(locationx, location);
    }
    public static void enterSearch(){
        HelperMethods.doClick(driver.findElement(searchx));
    }
    public static void getLowestTemp(){
        HelperMethods.doGetText(driver.findElement(lowestx));
    }
    public static void getHighestTemp(){
        HelperMethods.doGetText(driver.findElement(highestx));
    }
    public static Boolean verifyTemps(){
        Boolean isVisibleLowestTemp=driver.findElement(lowestx).isDisplayed();
        Boolean isVisibleHighestTemp=driver.findElement(highestx).isDisplayed();
        return isVisibleHighestTemp && isVisibleLowestTemp;
    }
    public static void quit(){
        BasePage.tearDown();
    }


}
