package com.darkskynet.base;

import com.darkskynet.pages.MainPage;
import org.openqa.selenium.By;

public class PageManager {

    public static MainPage mainPage;

    public static void initialize(){
        mainPage=new MainPage();
    }
}
