package helper;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserFabric {
    public static WebDriver getDriver(BrowserType type) {
        switch (type) {
            case FIREFOX:
                return getFirefoxDriver();
            default:
                return getChromeDriver();
        }
    }
    private static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        options.addArguments("--headless");
        return new ChromeDriver(options);
    }
    private static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("--headless");
        return new FirefoxDriver(options);
    }
}
