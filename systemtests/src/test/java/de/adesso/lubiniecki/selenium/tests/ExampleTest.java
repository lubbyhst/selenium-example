package de.adesso.lubiniecki.selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.adesso.lubiniecki.selenium.base.TestBase;
import de.adesso.lubiniecki.selenium.pages.DemoTestPage;
import de.adesso.lubiniecki.selenium.pages.SuccessPage;

public class ExampleTest extends TestBase {

    @Test
    public void testInputClearAfterSubmit() {
        DemoTestPage demoTestPage = DemoTestPage.openDemoTestPage(driver);
        demoTestPage.writeIntoTestInput("test");
        SuccessPage successPage = demoTestPage.clickButton();
        Assertions.assertEquals("Ok!", successPage.getResult());
    }
}
