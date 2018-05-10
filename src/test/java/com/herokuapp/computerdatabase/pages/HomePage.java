package com.herokuapp.computerdatabase.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver webDriver, String baseURL) {
        super(webDriver);
        webDriver.get(baseURL);
    }
}
