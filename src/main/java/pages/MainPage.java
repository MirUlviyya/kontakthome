package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(css = "div[aria-label='1 / 15']")
    public WebElement firstDefaultProduct;

    @FindBy(css = "form[action='https://kontakt.az/checkout/cart/add/uenc/aHR0cHM6Ly9rb250YWt0LmF6L2Ntc2xvYWQvc2xpZGVycy9pbmZvcHJvZHVjdHM%2C/product/67028/'] button[class$='tocart']")
    public WebElement addToCartButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}