package com.herokuapp.computerdatabase.steps;

import com.herokuapp.computerdatabase.pages.Pages;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
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
        assertThat("error message", pages.homePage().getComputerCreatedText(), is("Done! Computer TestPC has been created"));
        System.out.println("There are now " + pages.homePage().getComputersFoundText());

    }

    @Then("^then the computer details are displayed$")
    public void thenTheComputerDetailsAreDisplayed() throws Throwable {
        assertComputerFound("ASCI White", "2001-01-01", "2006-01-01", "IBM");
    }

    @Then("^the computer is deleted$")
    public void theComputerIsDeleted() throws Throwable {
        assertThat("Computer not deleted", pages.homePage().getComputerCreatedText(), is("Done! Computer has been deleted"));
        pages.homePage().clickPlayApplicationLink();
        System.out.println("There are now " + pages.homePage().getComputersFoundText());
    }

    @Then("^the computer is updated$")
    public void theComputerIsUpdated() throws Throwable {
        assertThat("Computer not updated", pages.homePage().getComputerCreatedText(), is("Done! Computer TestComputer has been updated"));
    }

    @And("^I can search for the new computer$")
    public void iCanSearchForTheNewComputer() throws Throwable {
        pages.homePage().searchForComputer("TestPC");
        assertComputerFound("TestPC", "2001-01-02", "2017-12-31", "Commodore International");
    }


    @And("^I can search for the updated computer$")
    public void iCanSearchForTheUpdatedComputer() throws Throwable {
        pages.homePage().searchForComputer("TestComputer");
        assertComputerFound("TestComputer", "1999-01-02", "2005-11-30", "Amiga Corporation");
    }

    private void assertComputerFound(String computer, String introducedDate, String discontinuedDate, String company) {
        assertThat("Computer name", pages.editComputerPage().getComputer(), is(computer));
        assertThat("Introduced date", pages.editComputerPage().getIntroducedDate(), is(introducedDate));
        assertThat("Discontinued date", pages.editComputerPage().getDiscontinuedDate(), is(discontinuedDate));
        assertThat("Company", pages.editComputerPage().getCompany(), is(company));
    }

    @Then("^I am alerted that a computer name is required and the dates are invalid$")
    public void iAmAlertedThatAComputerNameIsRequiredAndTheDatesAreInvalid() throws Throwable {
        assertThat("Computer name error", pages.addComputerPage().getComputerNameError(), is("clearfix error"));
        assertThat("Introduced date error", pages.addComputerPage().getIntroducedDateError(), is("clearfix error"));
        assertThat("Discontinued date error", pages.addComputerPage().getDiscontinuedDateError(), is("clearfix error"));
        pages.homePage().clickPlayApplicationLink();
        System.out.println("There are now " + pages.homePage().getComputersFoundText());

    }
}