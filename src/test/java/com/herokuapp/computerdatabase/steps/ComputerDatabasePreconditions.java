package com.herokuapp.computerdatabase.steps;

import com.herokuapp.computerdatabase.pages.Pages;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class ComputerDatabasePreconditions {

    @Autowired
    private Pages pages;

    @Given("^I want to add a new computer to the database$")
    public void iWantToAddANewComputerToTheDatabase() throws Throwable {
        pages.homePage().clickPlayApplicationLink();
        System.out.println(pages.homePage().getComputersFoundText() + " and I want to add a computer\n");
    }

    @Given("^I want to delete a computer from the database$")
    public void iWantToDeleteAComputerFromTheDatabase() throws Throwable {
        pages.homePage().clickPlayApplicationLink();
        System.out.println(pages.homePage().getComputersFoundText() + " and I want to delete a computer\n");
    }

    @Given("^I want to search for a computer in the database$")
    public void iWantToSearchForAComputerInTheDatabase() throws Throwable {
        pages.homePage().clickPlayApplicationLink();
        System.out.println(pages.homePage().getComputersFoundText() + " and I want to search for a computer\n");
    }

    @Given("^I want to update a new computer in the database$")
    public void iWantToUpdateANewComputerInTheDatabase() throws Throwable {
        pages.homePage().clickPlayApplicationLink();
        System.out.println(pages.homePage().getComputersFoundText() + " and I want to update a computer\n");
    }
}
