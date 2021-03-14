package stepMethod;

import base.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import util.Constants;
import base.BaseReport;

import static base.BaseDriver.driver;

public class HomePageMethod {
    public HomePageMethod(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    BaseDriver base = new BaseDriver();
    HomePage homePage = new HomePage(driver);
    BaseReport report = new BaseReport();

    //===============================================stepMethod==============================================

    public void open_homepage() {
        base.deleteAllCookies();
        driver.get(Constants.BaseURL);
    }

    //search from the homepage
    public void enterSearchKey(String keyword) {
        homePage.fieldSearch.sendKeys(keyword);
    }

    public void clickSearchButton() {
        homePage.buttonSearch.click();
    }

    public void searchResult(String keyword) {
        String actualResult = homePage.searchResult.getText();
        System.out.println(actualResult);
        if (actualResult.toLowerCase().equals(keyword.toLowerCase())){
            assert true;
            System.out.println(actualResult + " same as " + keyword);
        }
        else{
            assert false;
            System.out.println(actualResult + " not same as " + keyword);
        }
    }



}
