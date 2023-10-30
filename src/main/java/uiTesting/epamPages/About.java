package uiTesting.epamPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class About extends GlobalNavigation {

    private final String DOWNLOAD_OVERVIEW = ".button .button-ui-23[download]";
    private WebElement downloadOverview;

    public About(WebDriver driver){
        super(driver);
        initElements();
    }


    private void initElements(){

        downloadOverview = driver.findElement(By.cssSelector(DOWNLOAD_OVERVIEW));
    }

    public WebElement getDownloadOverview(){
        return downloadOverview;
    }
    public String getDownloadOverviewSelector() {
        return DOWNLOAD_OVERVIEW;
    }

    public void clickDownload(){
        getDownloadOverview().click();
    }
}
