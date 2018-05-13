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
        pages.addComputerPage().addComputer("", "test", "test");
    }

    @When("^I search for a computer in the database$")
    public void iSearchForAComputerInTheDatabase() throws Throwable {
        pages.homePage().searchForComputer("ASCI White");
    }

    @When("^I add a \"([^\"]*)\" computer with introduced date \"([^\"]*)\" and discontinued date \"([^\"]*)\" to the database$")
    public void
    iAddAComputerWithIntroducedDateAndDiscontinuedDateToTheDatabase(String computer, String introducedDate, String discontinuedDate) throws Throwable {
        pages.homePage().clickAddNewComputer();
        pages.addComputerPage().addComputer(computer, introducedDate, discontinuedDate);
    }

    @When("^I delete the \"([^\"]*)\" computer$")
    public void iDeleteTheComputer(String computer) throws Throwable {
        iAddAComputerWithIntroducedDateAndDiscontinuedDateToTheDatabase("TestPC", "2001-01-01", "2018-02-02");
        pages.homePage().searchForComputer(computer);
        pages.editComputerPage().clickDeleteButton();
    }

    @When("^I update the \"([^\"]*)\" computer with name \"([^\"]*)\" introduced date \"([^\"]*)\" discontinued date \"([^\"]*)\" and company \"([^\"]*)\"$")
    public void iUpdateTheComputerWithNameIntroducedDateDiscontinuedDateAndCompany(String oldComputer, String newComputer, String introducedDate, String discontinuedDate, String company) throws Throwable {
        iAddAComputerWithIntroducedDateAndDiscontinuedDateToTheDatabase("TestPC", "2010-10-30", "2017-02-20");
        pages.homePage().searchForComputer(oldComputer);
        pages.editComputerPage().updateComputer(newComputer,introducedDate,discontinuedDate,company);
    }

    @When("^I search for computer \"([^\"]*)\" in the database$")
    public void iSearchForComputerInTheDatabase(String computer) throws Throwable {
        pages.homePage().searchForComputer(computer);
    }
}
