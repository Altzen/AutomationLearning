package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class GlobalNavigation {
    protected WebDriver driver;

    private WebElement logo;
    private WebElement themeSwitcher;
    private WebElement languageDropdownButton;
    private WebElement epamUALink;
    private WebElement searchButton;
    private WebElement searchInput;
    private WebElement cookieAcceptAll;

    public GlobalNavigation (WebDriver driver){
        this.driver = driver;
        initElements();
    }

    private void initElements(){

        cookieAcceptAll = driver.findElement(By.cssSelector(".ot-sdk-row #onetrust-accept-btn-handler"));
    }

    public WebElement getCookieAcceptAll(){
        return cookieAcceptAll;
    }

    public void clickOnCookieAcceptAll(){
        getCookieAcceptAll().click();
    }
    public void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        if (driver instanceof FirefoxDriver){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        }
        actions.moveToElement(element);
        actions.perform();
    }

}
