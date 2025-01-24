package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfficialOrderPage {

    @FindBy(css = "div[name='shippingAddress.firstname'] div")
    public WebElement firstName;

    @FindBy(css = "div[name='shippingAddress.lastname'] div")
    public WebElement lastName;

    @FindBy(css = "div[name='shippingAddress.telephone'] div")
    public WebElement telephone;

    @FindBy(css = "select[id='QTLCR8G']")
    public WebElement country;

    @FindBy(css = "option[data-title^='Bakı']")
    public WebElement bakuCity;

    @FindBy(css = "div[name='shippingAddress.street.0'] div")
    public WebElement street;

    @FindBy(css = "label[for='cashondelivery']")
    public WebElement cashOnDelivery;

    public OfficialOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
