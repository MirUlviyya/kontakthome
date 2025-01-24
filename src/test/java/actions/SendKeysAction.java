package actions;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;


import static managers.ChromeDriverManager.getDriver;
import static managers.WebDriverWaitManager.waitForElementClickable;
import static managers.WebDriverWaitManager.waitForElementVisibility;

public class SendKeysAction {

    public static void sendKeys(WebElement element, String text) {
        try {
            waitForElementVisibility(element);
            waitForElementClickable(element);
            element.sendKeys(text);
        } catch (ElementNotInteractableException | StaleElementReferenceException e) {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].value = arguments[1];", element, text);
        }
    }

}