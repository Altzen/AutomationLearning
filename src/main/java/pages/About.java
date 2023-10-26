package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class About extends GlobalNavigation {


    private WebElement downloadOverview;

    public About(WebDriver driver){
        super(driver);
        initElements();
    }

    private void initElements(){

        downloadOverview = driver.findElement(By.cssSelector(".button .button-ui-23[download]"));
    }

    public WebElement getDownloadOverview(){
        return downloadOverview;
    }

    public void clickDownload(){
        getDownloadOverview().click();
    }
}
