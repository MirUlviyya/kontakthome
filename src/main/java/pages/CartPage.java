package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(css = "div[class='cartContentItem__title']")
    public WebElement productTitle;

    @FindBy(css = "div[class='cartContentItem__INFO'] a[class$='close']")
    public WebElement removeProduct;

    @FindBy(xpath = "/html/body/div[1]/main/section/div/div/div[1]/div[2]/form/div/div[6]/div[1]/button[2]")
    public WebElement addCount;

    @FindBy(xpath = "//input[@class='count']")
    public WebElement quantityOfProduct;

    @FindBy(xpath = "//button[@class='oform checkout']")
    public WebElement completeOrder;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}