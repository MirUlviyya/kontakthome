package test;

import com.aventstack.extentreports.ExtentTest;
import managers.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HeaderPage;
import pages.MainPage;
import pages.OfficialOrderPage;

import static actions.AssertElementTextAction.assertElementNotDisplayed;
import static actions.AssertElementTextAction.assertElementText;
import static actions.ClickToElementAction.click;
import static actions.HoverToElementAction.hoverToElement;
import static actions.SendKeysAction.sendKeys;
import static managers.ChromeDriverManager.initializeDriverFromChrome;
import static managers.ChromeDriverManager.quitDriver;
import static managers.ExtentManager.flushReports;
import static managers.ExtentManager.initExtentReports;
import static managers.WebDriverWaitManager.setDriverForSynchronization;
import static managers.WebDriverWaitManager.sleepForSeconds;

public class TestCases {

    public WebDriver driver;
    public CartPage cartPage;
    public HeaderPage headerPage;
    public MainPage mainPage;
    public OfficialOrderPage officialOrderPage;
    public ExtentTest test;


    @BeforeTest
    public void setUp() {
        initExtentReports();
        driver = initializeDriverFromChrome();
        setDriverForSynchronization();
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        mainPage = new MainPage(driver);
        officialOrderPage = new OfficialOrderPage(driver);
    }

    @AfterTest
    public void shutdown() {
        quitDriver();
        flushReports();
    }

    @Test
    public void userAddsProductToTheShoppingCartTest() {
        test = ExtentManager.createTest("userAddsProductToTheShoppingCartTest");
        driver.get("https://kontakt.az/");
        hoverToElement(mainPage.firstDefaultProduct);
        sleepForSeconds(1000);
        click(mainPage.addToCartButton);
        sleepForSeconds(2000); // wait for selected product drops to cart
        click(headerPage.miniCartButton);
        sleepForSeconds(1000);
        assertElementText(cartPage.productTitle, "iPhone 13 128GB Starlight");
    }

    @Test
    public void userRemovesProductFromTheShoppingCartTest() {
        test = ExtentManager.createTest("userRemovesProductFromTheShoppingCartTest");
        driver.get("https://kontakt.az/");
        hoverToElement(mainPage.firstDefaultProduct);
        sleepForSeconds(1000);
        click(mainPage.addToCartButton);
        sleepForSeconds(2000); // wait for selected product drops to cart
        click(headerPage.miniCartButton);
        sleepForSeconds(1000);
        click(cartPage.removeProduct);
        sleepForSeconds(500);
        assertElementNotDisplayed(cartPage.productTitle);
    }

    @Test
    public void userUpdatesTheQuantityOfProductInTheShoppingCart() {
        test = ExtentManager.createTest("userUpdatesTheQuantityOfProductInTheShoppingCart");
        driver.get("https://kontakt.az/");
        hoverToElement(mainPage.firstDefaultProduct);
        sleepForSeconds(1000);
        click(mainPage.addToCartButton);
        sleepForSeconds(2000); // wait for selected product drops to cart
        click(headerPage.miniCartButton);
        sleepForSeconds(1000);
        click(cartPage.addCount);
        sleepForSeconds(2000); // wait for count change
        assertElementText(cartPage.quantityOfProduct, "2");
    }

    @Test
    public void userProceedsToCheckout() {
        test = ExtentManager.createTest("userProceedsToCheckout");
        driver.get("https://kontakt.az/");
        hoverToElement(mainPage.firstDefaultProduct);
        sleepForSeconds(1000);
        click(mainPage.addToCartButton);
        sleepForSeconds(2000); // wait for selected product drops to cart
        click(headerPage.miniCartButton);
        click(cartPage.completeOrder);
    }

    @Test
    public void userEntersPaymentInformationAndFailsThePurchase() {
        test = ExtentManager.createTest("userEntersPaymentInformationAndFailsThePurchase");
        driver.get("https://kontakt.az/");
        hoverToElement(mainPage.firstDefaultProduct);
        sleepForSeconds(1000);
        click(mainPage.addToCartButton);
        sleepForSeconds(2000); // wait for selected product drops to cart
        click(headerPage.miniCartButton);
        sleepForSeconds(3000); // wait for page fully loaded
        click(cartPage.completeOrder);
        sleepForSeconds(10000); // wait for form loaded
        sendKeys(officialOrderPage.firstName, "exampleName");
        sendKeys(officialOrderPage.lastName, "exampleSurname");
        sendKeys(officialOrderPage.telephone, "51 552 54 55");
        click(officialOrderPage.country);
        sleepForSeconds(1000);
        click(officialOrderPage.bakuCity);
        sendKeys(officialOrderPage.street, "exampleStreet");
        click(officialOrderPage.cashOnDelivery);
        click(cartPage.completeOrder);
    }

}