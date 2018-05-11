package com.herokuapp.computerdatabase.steps;

import com.herokuapp.computerdatabase.pages.Pages;
import cucumber.api.PendingException;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class ComputerDatabaseActions {

    @Autowired
    private Pages pages;

    @When("^I add a new computer to the database$")
    public void iAddANewComputerToTheDatabase() throws Throwable {
        pages.homePage().clickAddNewComputer();
        pages.addComputerPage().addComputer("","test", "test");
    }

    @When("^I search for a computer in the database$")
    public void iSearchForAComputerInTheDatabase() throws Throwable {
        pages.homePage().searchForComputer("ASCI White");
    }
}
