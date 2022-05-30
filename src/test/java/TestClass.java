import com.test.model.pages.CartPage;
import com.test.model.pages.EveningDressesPage;
import com.test.model.pages.MainPage;
import com.test.model.pages.PrintedDressPage;
import com.test.utils.Webdriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestClass {

    WebDriver driver = Webdriver.getChromeDriver();
    MainPage mainPage = new MainPage(driver);
    EveningDressesPage eveningDressesPage = new EveningDressesPage(driver);
    PrintedDressPage printedDressPage = new PrintedDressPage(driver);
    CartPage cartPage = new CartPage(driver);


    @Before
    public void setUp(){
    driver.get("http://automationpractice.com");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    }

    @Test
    public void checkDressDescription()
    {
        mainPage.moveCursorToDressesTab();
        mainPage.clickOnEveningDressesTab();
        eveningDressesPage.moveCursorToPrintedDressProduct();
        eveningDressesPage.clickMoreButton();

        Assert.assertEquals(printedDressPage.expectedDressCompositions, printedDressPage.getActualDressCompositions());
        Assert.assertEquals(printedDressPage.expectedDressStyles, printedDressPage.getActualDressStyles());
        Assert.assertEquals(printedDressPage.expectedDressProperties, printedDressPage.getActualDressProperties());
    }

    @Test
    public void addDressToCart()
    {
        mainPage.moveCursorToDressesTab();
        mainPage.clickOnEveningDressesTab();
        eveningDressesPage.moveCursorToPrintedDressProduct();
        eveningDressesPage.clickMoreButton();
        printedDressPage.chooseSize();
        printedDressPage.choosePinkColor();
        printedDressPage.clickAddToCart();
        printedDressPage.clickContinueShopping();

        Assert.assertEquals(printedDressPage.expectedCartText, printedDressPage.getCartTextAfterNumber());
    }

    @Test
    public void clearCart()
    {
        mainPage.moveCursorToDressesTab();
        mainPage.clickOnEveningDressesTab();
        eveningDressesPage.moveCursorToPrintedDressProduct();
        eveningDressesPage.clickMoreButton();
        printedDressPage.chooseSize();
        printedDressPage.choosePinkColor();
        printedDressPage.clickAddToCart();
        printedDressPage.clickContinueShopping();
        printedDressPage.moveCursorToShoppingCart();
        printedDressPage.clickCheckOutBtn();
        cartPage.clickDeleteDress();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(cartPage.getElementOfMessage()));

        Assert.assertTrue(cartPage.checkInfoMessageDisplayed());
        Assert.assertEquals(cartPage.expectedTextInMessage, cartPage.getInfoMessageText());
        Assert.assertEquals(cartPage.expectedCartText, cartPage.getCartText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
