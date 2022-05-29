import com.test.model.pages.EveningDressesPage;
import com.test.model.pages.MainPage;
import com.test.model.pages.PrintedDressPage;
import com.test.utils.Webdriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestClass {

    WebDriver driver = Webdriver.getChromeDriver();
    MainPage mainPage = new MainPage(driver);
    EveningDressesPage eveningDressesPage = new EveningDressesPage(driver);
    PrintedDressPage printedDressPage = new PrintedDressPage(driver);


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

        Assert.assertEquals(printedDressPage.expectedCartText, printedDressPage.getActualCartText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
