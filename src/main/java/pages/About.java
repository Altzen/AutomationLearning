package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class About extends GlobalNavigation {

    protected WebDriver driver;

    private WebElement downloadOverview;

    private void initElements(){
        downloadOverview = driver.findElement(By.xpath("//a[@href='https://www.epam.com/content/dam/epam/free_library/EPAM_Corporate_Overview_2023.pdf']"));
    }

    public WebElement getDownloadOverview(){
        return downloadOverview;
    }

    public void clickDownload(){
        getDownloadOverview().click();
    }
}
