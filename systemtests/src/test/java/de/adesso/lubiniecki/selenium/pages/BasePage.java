package de.adesso.lubiniecki.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {

    protected final static String webAppBaseUrl = "http://demo:8080/";
    private final static int explicitTimeout = 30;

    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void input(final WebElement element, final String value) {
        waitForElementClickable(element);
        element.clear();
        element.sendKeys(value);
    }

    protected WebElement waitForElementClickable(final WebElement element) {
        return new WebDriverWait(this.driver, explicitTimeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement findElement(final By by) {
        final WebDriverWait wait = new WebDriverWait(this.driver, explicitTimeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> findElements(final By by) {
        final WebDriverWait wait = new WebDriverWait(this.driver, explicitTimeout);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
