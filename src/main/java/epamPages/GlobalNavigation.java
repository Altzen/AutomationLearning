package epamPages;

import org.openqa.selenium.*;
import tools.Wait;

public class GlobalNavigation extends Wait {

    private final String COOKIE_ACCEPT_ALL_SELECTOR = ".ot-sdk-row #onetrust-accept-btn-handler";
    private final String LOGO = ".desktop-logo";
    private final String THEME_SWITCHER = "//div[contains(@class, 'header__content')]/section[contains(@class, 'theme-switcher-ui')]/div";
    private final String LANGUAGE_DROPDOWN_BUTTON = ".location-selector__button";
    private final String EPAM_UA_LANGUAGE_BUTTON = ".location-selector__item a[lang='uk']";
    private final String SEARCH_BUTTON = ".header-search__button";
    private final String SEARCH_INPUT = "#new_form_search";
    private final String BODY = "body.fonts-loaded";




    private WebElement logo;
    private WebElement themeSwitcher;
    private WebElement languageDropdownButton;
    private WebElement epamUALanguageButton;
    private WebElement searchButton;
    private WebElement searchInput;
    private WebElement cookieAcceptAll;
    private WebElement body;
    public GlobalNavigation(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {

        this.waitForSelectedElementToBeClickable(driver, COOKIE_ACCEPT_ALL_SELECTOR, 10);
        cookieAcceptAll = driver.findElement(By.cssSelector(COOKIE_ACCEPT_ALL_SELECTOR));
        logo = driver.findElement(By.cssSelector(LOGO));
        languageDropdownButton = driver.findElement(By.cssSelector(LANGUAGE_DROPDOWN_BUTTON));
        epamUALanguageButton = driver.findElement(By.cssSelector(EPAM_UA_LANGUAGE_BUTTON));
        searchButton = driver.findElement(By.cssSelector(SEARCH_BUTTON));
        searchInput = driver.findElement(By.cssSelector(SEARCH_INPUT));
        body = driver.findElement(By.cssSelector(BODY));
        themeSwitcher = driver.findElement(By.xpath(THEME_SWITCHER));
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

    public WebElement getGLobalNavSearchInput() {
        return searchInput;
    }

    public String getGLobalNavSearchInputSelector() {
        return SEARCH_INPUT;
    }

    public WebElement getLogo() {
        return logo;
    }

    public String getLogoSelector() {
        return LOGO;
    }
    public WebElement getThemeSwitcher(){
        return themeSwitcher;
    }
    public String getThemeSwitcherSelector(){
        return THEME_SWITCHER;
    }

    public String getBodySelector() {
        return BODY;
    }
    public WebElement getBody (){
        return body;
    }

    public void clickOnCookieAcceptAll() {
        this.waitForSelectedElementToBeVisible(driver,getCookieAcceptAllSelector(),5);
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
    public void clickOnModeSwitch(){
        getThemeSwitcher().click();
    }

    public void moveToElement(WebDriver driver, WebElement element) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public String getCurrentMode(){
        String classes = this.getBody().getAttribute("class");

        if (classes.contains("dark-mode")) {
            return "dark-mode";
        } else if (classes.contains("light-mode")) {
            return "light-mode";
        } else {
            return "unknown";
        }
    }

}
