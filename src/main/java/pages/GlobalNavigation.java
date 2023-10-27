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
    private final String LOGO = ".desktop-logo";
    private final String THEME_SWITCHER = "TODO ";
    private final String LANGUAGE_DROPDOWN_BUTTON = ".location-selector__button";
    private final String EPAM_UA_LANGUAGE_BUTTON = ".location-selector__item a[lang='uk']";
    private final String SEARCH_BUTTON = ".header-search__button";
    private final String SEARCH_INPUT = "#new_form_search";


    private WebElement logo;
    private WebElement themeSwitcher;
    private WebElement languageDropdownButton;
    private WebElement epamUALanguageButton;
    private WebElement searchButton;
    private WebElement searchInput;
    private WebElement cookieAcceptAll;

    public GlobalNavigation(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {

        this.waitForSelectedElement(driver, COOKIE_ACCEPT_ALL_SELECTOR, 10);
        cookieAcceptAll = driver.findElement(By.cssSelector(COOKIE_ACCEPT_ALL_SELECTOR));
        logo = driver.findElement(By.cssSelector(LOGO));
        languageDropdownButton = driver.findElement(By.cssSelector(LANGUAGE_DROPDOWN_BUTTON));
        epamUALanguageButton = driver.findElement(By.cssSelector(EPAM_UA_LANGUAGE_BUTTON));
        searchButton = driver.findElement(By.cssSelector(SEARCH_BUTTON));
        searchInput = driver.findElement(By.cssSelector(SEARCH_INPUT));
    }

    public WebElement getCookieAcceptAll() {
        return cookieAcceptAll;
    }

    public String getCookieAcceptAllSelector() {
        return COOKIE_ACCEPT_ALL_SELECTOR;
    }

    public WebElement getLanguageDropdownButton() {
        return languageDropdownButton;
    }

    public String getLanguageDropdownButtonSelector() {
        return LANGUAGE_DROPDOWN_BUTTON;
    }

    public WebElement getEpamUALanguageButton() {
        return epamUALanguageButton;
    }

    public String getEpamUALanguageButtonSelector() {
        return EPAM_UA_LANGUAGE_BUTTON;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public String getSearchButtonSelector() {
        return SEARCH_BUTTON;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public String getSearchInputSelector() {
        return SEARCH_INPUT;
    }

    public WebElement getLogo() {
        return logo;
    }

    public String getLogoSelector() {
        return LOGO;
    }


    public void clickOnCookieAcceptAll() {
        getCookieAcceptAll().click();
    }
    public void clickOnSearchButton(){
        getSearchButton().click();
    }
    public void clickOnLanguageDropdownButton(){
        getLanguageDropdownButton().click();
    }
    public void clickOnEpamUALanguageButton(){
        getEpamUALanguageButton().click();
    }

    public void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        if (driver instanceof FirefoxDriver) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        }
        actions.moveToElement(element);
        actions.perform();
    }

    public void waitForSelectedElement(WebDriver driver, String selector, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));

    }

    public void waitForUrlChange(WebDriver driver, String url, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.urlToBe(url));

    }

}
