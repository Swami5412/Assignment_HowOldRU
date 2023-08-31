package driverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;

public class DriverFactory {

    public WebDriver driver;

    static ThreadLocal<WebDriver> tsLocal = new ThreadLocal<>();

    public WebDriver init_browser(String browser) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origin=*");
            options.addArguments("--disable-notifications");
            tsLocal.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--remote-allow-origin=*");
            tsLocal.set(new FirefoxDriver());
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.setCapability("ignoreZoomSetting", true);
            options.setCapability("nativeEvents", false);
            options.setCapability("unexpectedAlertBehaviours", "ignore");
            options.setCapability("disable-popup-blocking", true);
            options.setCapability("requireWindowFocus", true);
            options.setCapability("enablePersistentHover", true);
            options.setCapability("ignoreProtectedModeSettings", true);
            tsLocal.set(new EdgeDriver());
        } else if (browser.equals("ie")) {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability("ignoreZoomSetting", true);
            options.setCapability("nativeEvents", false);
            options.setCapability("unexpectedAlertBehaviours", "ignore");
            options.setCapability("disable-popup-blocking", true);
            options.setCapability("requireWindowFocus", true);
            options.setCapability("enablePersistentHover", true);
            options.setCapability("ignoreProtectedModeSettings", true);
            tsLocal.set(new InternetExplorerDriver());
        } else {
            System.out.println("Please Provide the Correct Browser value " + browser);

        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tsLocal.get();
    }
}
