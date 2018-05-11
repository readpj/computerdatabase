package com.herokuapp.computerdatabase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EditComputerPage extends BasePage {

    private static final String SECTION_HEADING = "Add a computer";
    private static final By COMPUTER_NAME_INPUT = By.id("name");
    private static final By INTRODUCED_DATE_INPUT = By.id("introduced");
    private static final By DISCONTINUED_DATE_INPUT = By.id("discontinued");
    private static final By COMPANY_SELECT = By.id("company");
    private static final By DELETE_COMPUTER_BUTTON = By.cssSelector(".btn.danger");

    public EditComputerPage(WebDriver webDriver) {
        super(webDriver);
        waitForSectionHeading(SECTION_HEADING);
    }

    public void clickDeleteButton() {
        getDriver().findElement(DELETE_COMPUTER_BUTTON).click();
    }

    public String getComputer() {
        return getDriver().findElement(COMPUTER_NAME_INPUT).getAttribute("value");
    }

    public String getIntroducedDate() {
        return getDriver().findElement(INTRODUCED_DATE_INPUT).getAttribute("value");
    }

    public String getDiscontinuedDate() {
        return getDriver().findElement(DISCONTINUED_DATE_INPUT).getAttribute("value");
    }

    public String getCompany() {
        Select select = new Select(getDriver().findElement(COMPANY_SELECT));
        return select.getFirstSelectedOption().getText();
    }

}
