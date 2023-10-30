package epamPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EpamHome extends GlobalNavigation {


    private final String INVESTORS = "//a[@class='fat-links' and text()='INVESTORS']";
    private final String OPEN_SOURCE = "//a[@class='fat-links' and text()='OPEN SOURCE']";
    private final String PRIVACY_POLICY = "//a[@class='fat-links' and text()='PRIVACY POLICY']";
    private final String COOKIE_POLICY = "//a[@class='fat-links' and text()='COOKIE POLICY']";
    private final String APPLICANT_PRIVACY_NOTICE = "//a[@class='fat-links' and text()='APPLICANT PRIVACY NOTICE']";
    private final String WEB_ACCESSIBILITY = "//a[@class='fat-links' and text()='WEB ACCESSIBILITY']";
    private final String AMERICAS = "//div/a[contains(@class, 'tabs-23__link') and contains(., 'AMERICAS')]";
    private final String EMEA = "//div/a[contains(@class, 'tabs-23__link') and contains(., 'EMEA')]";
    private final String APAC = "//div/a[contains(@class, 'tabs-23__link') and contains(., 'APAC')]";
    private final String CANADA = ".owl-item:not(.cloned) .locations-viewer-23__country-btn[data-country-title=\"Canada\"]";
    private final String ARMENIA = ".owl-item:not(.cloned) .locations-viewer-23__country-btn[data-country-title=\"Armenia\"]";
    private final String AUSTRALIA = ".owl-item:not(.cloned) .locations-viewer-23__country-btn[data-country-title=\"Australia\"]";


    private WebElement investors;
    private WebElement openSource;
    private WebElement privacyPolicy;
    private WebElement cookiePolicy;
    private WebElement applicantPrivacyNotice;
    private WebElement webAccessibility;
    private WebElement americas;
    private WebElement emea;
    private WebElement apac;
    private WebElement canada;
    private WebElement armenia;
    private WebElement australia;

    public EpamHome(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {

        investors = driver.findElement(By.xpath(INVESTORS));
        openSource = driver.findElement(By.xpath(OPEN_SOURCE));
        privacyPolicy = driver.findElement(By.xpath(PRIVACY_POLICY));
        cookiePolicy = driver.findElement(By.xpath(COOKIE_POLICY));
        applicantPrivacyNotice = driver.findElement(By.xpath(APPLICANT_PRIVACY_NOTICE));
        webAccessibility = driver.findElement(By.xpath(WEB_ACCESSIBILITY));
        americas = driver.findElement(By.xpath(AMERICAS));
        emea = driver.findElement(By.xpath(EMEA));
        apac = driver.findElement(By.xpath(APAC));
    }

    public void initLocationsComponents(){
        canada = driver.findElement(By.cssSelector(CANADA));
        australia = driver.findElement(By.cssSelector(AUSTRALIA));
        armenia = driver.findElement(By.cssSelector(ARMENIA));
    }

    public WebElement getInvestors() {
        return investors;
    }

    public WebElement getOpenSource() {
        return openSource;
    }

    public WebElement getPrivacyPolicy() {
        return privacyPolicy;
    }

    public WebElement getCookiePolicy() {
        return cookiePolicy;
    }

    public WebElement getApplicantPrivacyNotice() {
        return applicantPrivacyNotice;
    }

    public WebElement getWebAccessibility() {
        return webAccessibility;
    }

    public WebElement getAmericas() {
        return americas;
    }

    public WebElement getEmea() {
        return emea;
    }

    public WebElement getApac() {
        return apac;
    }

    public WebElement getCanada() {
        return canada;
    }

    public WebElement getArmenia() {
        return armenia;
    }

    public WebElement getAustralia() {
        return australia;
    }

    // Get Selectors

    public String getInvestorsSelector() {
        return INVESTORS;
    }

    public String getOpenSourceSelector() {
        return OPEN_SOURCE;
    }

    public String getPrivacyPolicySelector() {
        return PRIVACY_POLICY;
    }

    public String getCookiePolicySelector() {
        return COOKIE_POLICY;
    }

    public String getApplicantPrivacyNoticeSelector() {
        return APPLICANT_PRIVACY_NOTICE;
    }

    public String getWebAccessibilitySelector() {
        return WEB_ACCESSIBILITY;
    }

    public String getAmericasSelector() {
        return AMERICAS;
    }

    public String getEmeaSelector() {
        return EMEA;
    }

    public String getApacSelector() {
        return APAC;
    }

    public String getCanadaSelector() {
        return CANADA;
    }

    public String getArmeniaSelector() {
        return ARMENIA;
    }

    public String getAustraliaSelector() {
        return AUSTRALIA;
    }

}
