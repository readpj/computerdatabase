package com.herokuapp.computerdatabase.pages;

import org.openqa.selenium.WebDriver;

public class AddComputerPage extends BasePage{

    private static final String SECTION_HEADING = "Dropdown List";


    public AddComputerPage(WebDriver webDriver) {
        super(webDriver);
        waitForSectionHeading(SECTION_HEADING);
    }
}
