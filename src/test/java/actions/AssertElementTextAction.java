package actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static managers.WebDriverWaitManager.waitForElementVisibility;

public class AssertElementTextAction {

    public static void assertElementText(WebElement element, String expectedText) {
        try {
            waitForElementVisibility(element);
            Assert.assertEquals(element.getText(), expectedText);
        } catch (AssertionError error) {
            throw new RuntimeException(error);
        }
    }

    public static void assertElementNotDisplayed(WebElement element) {
        try {
            Assert.assertFalse(element.isDisplayed(), "Element is displayed, but it should not be.");
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            // exception lazım deyil
        }
    }


}