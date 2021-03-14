package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

//    search
    @FindBy(id = "search_query_top")
    public WebElement fieldSearch;

    @FindBy(name = "submit_search")
    public WebElement buttonSearch;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
    public WebElement searchResult;


}
