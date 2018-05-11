package com.herokuapp.computerdatabase.steps;

import com.herokuapp.computerdatabase.pages.Pages;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class ComputerDatabasePreconditions {

    @Autowired
    private Pages pages;

    @Given("^I want to add a new computer to the database$")
    public void iWantToAddANewComputerToTheDatabase() throws Throwable {
        System.out.println(pages.homePage().getComputersFoundText());
    }
}
