package de.adesso.lubiniecki.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement title;

    @FindBy(xpath = "//span")
    private WebElement testText;

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getResult() {
        return testText.getText();
    }
}
