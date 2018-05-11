package com.herokuapp.computerdatabase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By ADD_COMPUTER_BUTTON = By.id("add");
    private static final By FILTER_BY_NAME_BUTTON = By.id("searchsubmit");
    private static final By SEARCH_BOX_INPUT = By.id("searchbox");
    private static final By COMPUTERS_FOUND_HEADER = By.cssSelector("#main > h1");
    private static final By ALERT_MESSAGE = By.cssSelector("#.alert-message.warning");

//    public HomePage(WebDriver webDriver, String baseURL) {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
//        webDriver.get(baseURL);
    }

    public String getComputersFoundText() {
        return getDriver().findElement(COMPUTERS_FOUND_HEADER).getText();
    }

    public String getComputerCreatedText() {
        return getDriver().findElement(ALERT_MESSAGE).getText();
    }

    public void clickFilterByName() {
        getDriver().findElement(FILTER_BY_NAME_BUTTON).click();
    }

    public void clickAddNewComputer() {
        getDriver().findElement(ADD_COMPUTER_BUTTON).click();
    }

    public void clickComputerName(String computer) {
        getDriver().findElement(By.linkText(computer));
    }

    public void searchForComputer(String computer) {
        getDriver().findElement(SEARCH_BOX_INPUT).clear();
        getDriver().findElement(SEARCH_BOX_INPUT).sendKeys(computer);
        clickFilterByName();
        clickComputerName(computer);
    }
}
