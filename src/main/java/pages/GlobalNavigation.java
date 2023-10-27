package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GlobalNavigation {
    protected WebDriver driver;

    private final String COOKIE_ACCEPT_ALL_SELECTOR = ".ot-sdk-row #onetrust-accept-btn-handler";

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

        this.waitForSelectedElement(driver,COOKIE_ACCEPT_ALL_SELECTOR,10);
        cookieAcceptAll = driver.findElement(By.cssSelector(COOKIE_ACCEPT_ALL_SELECTOR));
    }

    public WebElement getCookieAcceptAll(){
        return cookieAcceptAll;
    }
    public String getCookieAcceptAllSelector() {
        return COOKIE_ACCEPT_ALL_SELECTOR;
    }

    public void clickOnCookieAcceptAll(){
        getCookieAcceptAll().click();
    }
    public void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        if (driver instanceof FirefoxDriver){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        }
        actions.moveToElement(element);
        actions.perform();
    }
    public void waitForSelectedElement(WebDriver driver, String selector, int duration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

}
