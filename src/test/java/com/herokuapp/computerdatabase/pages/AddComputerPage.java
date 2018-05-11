package com.herokuapp.computerdatabase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddComputerPage extends BasePage {

    private static final String SECTION_HEADING = "Add a computer";
    private static final By COMPUTER_NAME_INPUT = By.id("name");
    private static final By INTRODUCED_DATE_INPUT = By.id("introduced");
    private static final By DISCONTINUED_DATE_INPUT = By.id("discontinued");
    private static final By COMPANY_SELECT = By.id("company");
    private static final By CREATE_COMPUTER_BUTTON = By.cssSelector(".btn.primary");
    private static final By COMPUTER_NAME_ERROR = By.cssSelector("#main > form > fieldset > div:nth-child(1)");
    private static final By INTRODUCED_DATE_ERROR = By.cssSelector("#main > form > fieldset > div:nth-child(2)");
    private static final By DISCONTINUED_DATE_ERROR = By.cssSelector("#main > form > fieldset > div:nth-child(3)");

    public AddComputerPage(WebDriver webDriver) {
        super(webDriver);
        waitForSectionHeading(SECTION_HEADING);
    }

    public void addComputer(String computer, String introducedDate, String discontinuedDate) {
        getDriver().findElement(COMPUTER_NAME_INPUT).clear();
        getDriver().findElement(COMPUTER_NAME_INPUT).sendKeys(computer);
        getDriver().findElement(INTRODUCED_DATE_INPUT).clear();
        getDriver().findElement(INTRODUCED_DATE_INPUT).sendKeys(introducedDate);
        getDriver().findElement(DISCONTINUED_DATE_INPUT).clear();
        getDriver().findElement(DISCONTINUED_DATE_INPUT).sendKeys(discontinuedDate);
        Select select = new Select(getDriver().findElement(COMPANY_SELECT));
        select.selectByValue("6");
        clickCreateComputer();
    }

    public String getComputerNameError() {
        return getDriver().findElement(COMPUTER_NAME_ERROR).getAttribute("class");
    }

    public String getIntroducedDateError() {
        return getDriver().findElement(INTRODUCED_DATE_ERROR).getAttribute("class");
    }

    public String getDiscontinuedDateError() {
        return getDriver().findElement(DISCONTINUED_DATE_ERROR).getAttribute("class");
    }

    public void clickCreateComputer() {
        getDriver().findElement(CREATE_COMPUTER_BUTTON).click();
    }
}
