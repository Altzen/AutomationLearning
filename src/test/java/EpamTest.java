import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.About;
import pages.GlobalNavigation;
import testRunner.Runner;

import java.io.File;
import java.time.Duration;

public class EpamTest {

    private WebDriver driver;
    Runner runner = new Runner();
    private final String downloadPath = "C:\\Users\\mserg\\Downloads";

//    @BeforeMethod
//    @Parameters("browser")
//    public void setup(String browser) {
//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = runner.runChrome();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            driver = runner.runFireFox();
//
//        }
//    }

    @BeforeMethod
    public void setup() {
        driver = runner.runFireFox();
    }

    @Test
    public void searchTest(){
        driver.get("https://www.epam.com/");
        GlobalNavigation nav = new GlobalNavigation(driver);

        nav.clickOnSearchButton();
        nav.getSearchInput().sendKeys("AI");

    }
    @Test
    public void goToUASite(){
        driver.get("https://www.epam.com/");
        GlobalNavigation nav = new GlobalNavigation(driver);

        nav.clickOnLanguageDropdownButton();
        nav.waitForSelectedElement(driver, nav.getEpamUALanguageButtonSelector(),10);
        nav.clickOnEpamUALanguageButton();

        String expectedUrl = "https://careers.epam.ua/";
        nav.waitForUrlChange(driver,expectedUrl,10);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "URL does not match the expected URL");
    }
    @Test
    public void downloadAndVerifyFile() {

        driver.get("https://www.epam.com/about");
        About about = new About(driver);

        about.moveToElement(driver, about.getDownloadOverview());
        about.clickOnCookieAcceptAll();

        about.waitForSelectedElement(driver,about.getDownloadOverviewSelector(),10);
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