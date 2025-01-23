package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static managers.ChromeDriverManager.getDriver;
import static managers.WebDriverWaitManager.waitForElementClickable;
import static managers.WebDriverWaitManager.waitForElementVisibility;

public class ClickToElementAction {

    public static void click(WebElement element) {
        try {
            waitForElementVisibility(element);
            waitForElementClickable(element);
            element.click();
        } catch (IllegalAccessError error) {
            waitForElementVisibility(element);
            waitForElementClickable(element);
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", element);
        }
    }

}