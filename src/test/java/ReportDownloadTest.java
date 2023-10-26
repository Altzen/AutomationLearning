import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.About;
import testRunner.Runner;

public class ReportDownloadTest {

    private WebDriver driver;
    Runner runner = new Runner();
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
    public void setup(){
        driver = runner.runChrome();
    }

    @Test
    public void downloadFile() {

        driver.get("https://www.epam.com/about");
        About about = new About(driver);

        about.moveToElement(driver,about.getDownloadOverview());

        about.clickOnCookieAcceptAll();

        about.clickDownload();


    }

    @AfterMethod(alwaysRun = true)
    public void cleanup(){
        driver.quit();
    }
}
