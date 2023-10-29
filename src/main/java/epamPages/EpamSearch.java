package epamPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EpamSearch extends GlobalNavigation {

    private final String SEARCH_TITLE = ".rte-text-gradient.gradient-text";
    private final String SEARCH_INPUT = ".search-results__panel input[type='search']";

    private WebElement searchTitle;
    private WebElement searchInput;


    public EpamSearch(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){

        this.waitForSelectedElementToBeVisible(driver,SEARCH_TITLE,10);
        searchTitle = driver.findElement(By.cssSelector(SEARCH_TITLE));
        searchInput = driver.findElement(By.cssSelector(SEARCH_INPUT));
    }

    public WebElement getSearchTitle(){
        return searchTitle;
    }
    public String getSearchTitleSelector() {
        return SEARCH_TITLE;
    }

    public WebElement getSearchInput(){
        return searchInput;
    }
    public String getSearchInputSelector() {
        return SEARCH_INPUT;
    }

}
