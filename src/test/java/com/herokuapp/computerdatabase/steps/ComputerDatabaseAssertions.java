package com.herokuapp.computerdatabase.steps;

import com.herokuapp.computerdatabase.pages.Pages;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ComputerDatabaseAssertions {

    @Autowired
    private Pages pages;

    @Then("^the computer is added to the database$")
    public void theComputerIsAddedToTheDatabase() throws Throwable {
        assertThat("error message", pages.homePage().getComputersFoundText(), containsString("576"));

    }

    @Then("^then I am alerted that a computer name is required$")
    public void thenIAmAlertedThatAComputerNameIsRequired() throws Throwable {
        assertThat("err", pages.addComputerPage().getComputerNameError(), is("clearfix error"));
        assertThat("err", pages.addComputerPage().getIntroducedDateError(), is("clearfix error"));
        assertThat("err", pages.addComputerPage().getDiscontinuedDateError(), is("clearfix error"));
    }

    @Then("^then the computer details are displayed$")
    public void thenTheComputerDetailsAreDisplayed() throws Throwable {
        assertThat("err", pages.editComputerPage().getComputer(), is("ASCI White"));
    }
}
