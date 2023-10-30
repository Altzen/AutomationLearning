import epamPages.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import uiTesting.epamPages.*;
import testRunner.Runner;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class EpamTest {

    private WebDriver driver;
    Runner runner = new Runner();
    private final String downloadPath = "C:\\Users\\mserg\\Downloads";

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = runner.runChrome();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = runner.runFireFox();

        }
    }

//    @BeforeMethod           // solo browser run
//    public void setup() {
//        driver = runner.runFireFox();
//    }

    @Test
    public void searchTest() {
        driver.get("https://www.epam.com/");
        GlobalNavigation nav = new GlobalNavigation(driver);

        nav.clickOnSearchButton();
        nav.waitForSelectedElementToBeClickable(driver, nav.getGLobalNavSearchInputSelector(), 10);

        nav.getGLobalNavSearchInput().sendKeys("AI");
        nav.getGLobalNavSearchInput().sendKeys(Keys.ENTER);

        EpamSearch search = new EpamSearch(driver);
        search.waitForSelectedElementToBeClickable(driver, search.getSearchTitleSelector(), 10);
        Assert.assertEquals(search.getSearchTitle().getText(), "Search", "There is no Search title");
        search.getSearchInput().clear();
        Assert.assertEquals(search.getSearchInput().getAttribute("placeholder"), "What are you looking for?", "There is wrong placeholder");
    }

    @Test
    public void goToUASite() {
        driver.get("https://www.epam.com/");
        GlobalNavigation nav = new GlobalNavigation(driver);

        nav.clickOnLanguageDropdownButton();
        nav.waitForSelectedElementToBeClickable(driver, nav.getEpamUALanguageButtonSelector(), 10);
        nav.clickOnEpamUALanguageButton();

        String expectedUrl = "https://careers.epam.ua/";
        nav.waitForUrlChange(driver, expectedUrl, 10);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "URL does not match the expected URL");
    }

    @Test
    public void policiesTest() {
        driver.get("https://www.epam.com/");
        EpamHome home = new EpamHome(driver);

        home.moveToElement(driver, home.getWebAccessibility());

        List<WebElement> elements = List.of(home.getInvestors(), home.getCookiePolicy(), home.getOpenSource(), home.getApplicantPrivacyNotice(), home.getPrivacyPolicy(), home.getWebAccessibility());
        List<String> expectedTexts = List.of("INVESTORS", "COOKIE POLICY", "OPEN SOURCE", "APPLICANT PRIVACY NOTICE", "PRIVACY POLICY", "WEB ACCESSIBILITY");

        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            String actualText = element.getText();
            String expectedText = expectedTexts.get(i);
            Assert.assertTrue(element.isDisplayed(), "Element is not displayed");
            Assert.assertEquals(actualText, expectedText, "Text on element " + i + " not match.");
        }
    }

    @Test
    public void ourLocationChangeRegionTest() {
        driver.get("https://www.epam.com/");
        EpamHome home = new EpamHome(driver);
        home.clickOnCookieAcceptAll();
        home.moveToElement(driver, home.getAmericas());
        home.waitForSelectedElementToBeVisible(driver,home.getAmericasSelector(),5);
        Assert.assertTrue(home.getAmericas().isDisplayed(), "AMERICAS element is not displayed");
        Assert.assertEquals(home.getAmericas().getText(), "AMERICAS", "Text on " + home.getAmericas().getText() + " not match.");
        home.moveToElement(driver, home.getEmea());
        home.getEmea().click();
        Assert.assertTrue(home.getEmea().isDisplayed(), "EMEA element is not displayed");
        Assert.assertEquals(home.getEmea().getText(), "EMEA", "Text on " + home.getEmea().getText() + " not match.");
        home.moveToElement(driver, home.getApac());
        home.getApac().click();
        home.waitForSelectedElementToBeVisible(driver, home.getAustraliaSelector(), 5);
        Assert.assertTrue(home.getApac().isDisplayed(), "APAC element is not displayed");
        Assert.assertEquals(home.getApac().getText(), "APAC", "Text on " + home.getApac().getText() + " not match.");

        home.getAmericas().click();
        home.initLocationsComponents();
        Assert.assertTrue(home.getCanada().isDisplayed(), "CANADA Element is not displayed");
        Assert.assertEquals(home.getCanada().getText(), "CANADA", "Text on " + home.getCanada().getText() + " not match.");
        home.getEmea().click();
        Assert.assertTrue(home.getArmenia().isDisplayed(), "ARMENIA Element is not displayed");
        Assert.assertEquals(home.getArmenia().getText(), "ARMENIA", "Text on " + home.getArmenia().getText() + " not match.");
        home.getApac().click();
        Assert.assertTrue(home.getAustralia().isDisplayed(), "AUSTRALIA Element is not displayed");
        Assert.assertEquals(home.getAustralia().getText(), "AUSTRALIA", "Text on " + home.getAustralia().getText() + " not match.");

    }


    @Test
    public void checkRequiredFields() {
        driver.get("https://www.epam.com/about/who-we-are/contact");
        ContactUs contactUs = new ContactUs(driver);

        List<WebElement> elements = List.of(contactUs.getReason(), contactUs.getFirstName(), contactUs.getLastName(), contactUs.getEMail(), contactUs.getPhone(), contactUs.getLocation(), contactUs.getHowDidHear(), contactUs.getPolicyCheckbox());

        for (WebElement checkbox : elements) {
            Assert.assertEquals(checkbox.getAttribute("aria-required"), "true", "Aria-required must be true");
        }

    }

    @Test
    public void modeSwitchTest() {
        driver.get("https://www.epam.com/");
        GlobalNavigation nav = new GlobalNavigation(driver);
        String currentMode = nav.getCurrentMode();

        if ("dark-mode".equals(currentMode)) {
            nav.clickOnModeSwitch();
            nav.waitForAttribute(driver, nav.getBody(), "class", "light-mode", 5);
            Assert.assertEquals(nav.getCurrentMode(), "light-mode", "Wrong mode, should be: light-mode");
            nav.clickOnModeSwitch();
            nav.waitForAttribute(driver, nav.getBody(), "class", "dark-mode", 5);
            Assert.assertEquals(nav.getCurrentMode(), "dark-mode", "Wrong mode, should be: dark-mode");
        } else if ("light-mode".equals(currentMode)) {
            nav.clickOnModeSwitch();
            nav.waitForAttribute(driver, nav.getBody(), "class", "dark-mode", 5);
            Assert.assertEquals(nav.getCurrentMode(), "dark-mode", "Wrong mode, should be: dark-mode");
            nav.clickOnModeSwitch();
            nav.waitForAttribute(driver, nav.getBody(), "class", "light-mode", 5);
            Assert.assertEquals(nav.getCurrentMode(), "light-mode", "Wrong mode, should be: light-mode");
        }
    }

    @Test
    public void logoClickTest() {
        driver.get("https://www.epam.com/about");
        About about = new About(driver);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.epam.com/about", "Should be https://www.epam.com/about");
        about.getLogo().click();
        about.waitForUrlChange(driver,"https://www.epam.com/",5);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.epam.com/", "Should be https://www.epam.com");

    }

    @Test
    public void downloadAndVerifyFile() {

        driver.get("https://www.epam.com/about");
        About about = new About(driver);

        about.moveToElement(driver, about.getDownloadOverview());
        about.clickOnCookieAcceptAll();

        about.waitForSelectedElementToBeClickable(driver, about.getDownloadOverviewSelector(), 10);
        about.clickDownload();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        File downloadedFile = wait.until((WebDriver d) -> {
            File file = new File(downloadPath + File.separator + "EPAM_Corporate_Overview_Q3_october.pdf");
            if (file.exists() && file.isFile()) {
                return file;
            }
            return null;
        });
        try {
            Assert.assertNotNull(downloadedFile, "File wasn't downloaded");

            Assert.assertEquals(downloadedFile.getName(), "EPAM_Corporate_Overview_Q3_october.pdf", "Wrong file name");
            Assert.assertEquals(downloadedFile.getPath().substring(downloadedFile.getPath().lastIndexOf(".") + 1), "pdf", "Wrong file extension");
        } finally {
            if (downloadedFile != null && downloadedFile.exists()) {
                downloadedFile.delete();
            }
        }

    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        driver.quit();
    }
}
