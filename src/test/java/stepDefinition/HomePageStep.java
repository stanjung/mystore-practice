package stepDefinition;

import base.BaseReport;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stepMethod.HomePageMethod;
import testRunner.CucumberTestRunner;


import static base.BaseDriver.driver;


public class HomePageStep extends CucumberTestRunner {
    HomePageMethod HomePageMethod = new HomePageMethod(driver);
    BaseReport report = new BaseReport();

    //    =======================================stepDefinition====================================================
    @Given("^user open browser$")
    public void userOpenBrowser(){
        HomePageMethod.open_homepage();
    }

    @When("^user enter a keyword in the search field \"([^\"]*)\"$")
    public void userEnterAKeywordInTheSearchField(String keyword)  {
        HomePageMethod.enterSearchKey(keyword);
        report.getScreenShoot();
    }

    @And("user clicks search button")
    public void userClicksSearchButton() {
        HomePageMethod.clickSearchButton();
        report.getScreenShoot();
    }

    @Then("search result will be displayed \"([^\"]*)\"$")
    public void searchResultWillBeDisplayed(String keyword){
        HomePageMethod.searchResult(keyword);
        report.getScreenShoot();
    }

}
