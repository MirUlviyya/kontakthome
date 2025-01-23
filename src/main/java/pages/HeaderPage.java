package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    @FindBy(css = "div[data-block='minicart']")
    public WebElement miniCartButton;

    public HeaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}