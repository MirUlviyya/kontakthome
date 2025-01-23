package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver initializeDriverFromChrome() {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = createDriverFromChrome();
            driverManageConfig(driver);
            driverThreadLocal.set(driver);
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    private static WebDriver createDriverFromChrome() {
        ChromeOptions options = createChromeOptions();
        return new ChromeDriver(options);
    }

    private static ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless",
                "--disable-dev-shm-usage",
                "--disable-notifications",
                "--remote-allow-origins=*",
                "--window-size=1920,1080");
        return options;
    }

    private static void driverManageConfig(WebDriver driver) {
        int IMPLICIT_WAIT_SECONDS = 10;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_SECONDS));
        driver.manage().window().maximize();
    }

}
