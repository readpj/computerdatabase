package com.herokuapp.computerdatabase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

public class BasePage {

    private final WebDriver webDriver;
    private static final int DEFAULT_TIME_OUT = 10;

    protected static final String PAGE_HEADING_IDENTIFIER = ".example>h3";
    private static final String SECTION_HEADING_XPATH = "//h3[contains(text(), '%s')]";
    private static final String SECTION_HEADING_TWO_XPATH = "//h2[contains(text(), '%s')]";


    public BasePage(WebDriver driver) {
        this.webDriver = driver;
    }

    protected WebDriver getDriver() {
        return webDriver;
    }

    protected void waitForSectionHeading(String sectionHeading) {
        waitForVisibilityOf(By.xpath(format(SECTION_HEADING_XPATH, sectionHeading)));
    }

    protected void waitForVisibilityOf(By elementIdentifier, int timeoutInSeconds) {
        new WebDriverWait(getDriver(), timeoutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(elementIdentifier));
    }

    protected void waitForVisibilityOf(By elementIdentifier) {
        waitForVisibilityOf(elementIdentifier, DEFAULT_TIME_OUT);
    }

}
