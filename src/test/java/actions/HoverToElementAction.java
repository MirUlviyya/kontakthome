package actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static managers.ChromeDriverManager.getDriver;

public class HoverToElementAction {

    public static void hoverToElement(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

}
