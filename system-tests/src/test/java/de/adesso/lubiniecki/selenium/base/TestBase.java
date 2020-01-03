package de.adesso.lubiniecki.selenium.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class TestBase {

    private static final String SELENIUM_HUB_URL = "http://localhost:4444/wd/hub";

    protected WebDriver driver;

    @BeforeEach
    public void before() throws MalformedURLException {
        driver = initializeDriver();
    }

    @AfterEach
    public void after() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    private WebDriver initializeDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, getLoggingPreferences());
        return new RemoteWebDriver(new URL(SELENIUM_HUB_URL), desiredCapabilities);
    }

    private LoggingPreferences getLoggingPreferences() {
        final LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.INFO);
        logPrefs.enable(LogType.SERVER, Level.INFO);
        logPrefs.enable(LogType.DRIVER, Level.INFO);
        logPrefs.enable(LogType.PROFILER, Level.INFO);
        logPrefs.enable(LogType.CLIENT, Level.INFO);
        return logPrefs;
    }

}
