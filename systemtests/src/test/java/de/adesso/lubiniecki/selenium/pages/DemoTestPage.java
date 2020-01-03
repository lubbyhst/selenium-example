package de.adesso.lubiniecki.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoTestPage extends BasePage {

    @FindBy(id = "testLabel")
    private WebElement testLabel;

    @FindBy(id = "testButton")
    private WebElement testButton;

    @FindBy(tagName = "input")
    private WebElement testInput;

    @FindBy(xpath = "//h1")
    private WebElement title;

    public DemoTestPage(WebDriver driver) {
        super(driver);
    }

    public static DemoTestPage openDemoTestPage(WebDriver driver) {
        driver.get(webAppBaseUrl);
        return new DemoTestPage(driver);
    }

    public void writeIntoTestInput(String value) {
        input(testInput, value);
    }

    public SuccessPage clickButton() {
        testButton.click();
        return new SuccessPage(this.driver);
    }

    public String getTextFromLabel() {
        return testLabel.getText();
    }

    public String getTitle() {
        return title.getText();
    }

    public String getValueFromInput() {
        return testInput.getAttribute("value");
    }
}
