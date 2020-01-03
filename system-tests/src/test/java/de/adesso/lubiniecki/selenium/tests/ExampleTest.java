package de.adesso.lubiniecki.selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.adesso.lubiniecki.selenium.base.TestBase;
import de.adesso.lubiniecki.selenium.pages.DemoTestPage;

public class ExampleTest extends TestBase {

    @Test
    public void testInputClearAfterSubmit() {
        DemoTestPage demoTestPage = DemoTestPage.openDemoTestPage(driver);
        demoTestPage.writeIntoTestInput("test");
        demoTestPage.clickButton();
        Assertions.assertTrue(demoTestPage.getValueFromInput().isEmpty());
    }
}
