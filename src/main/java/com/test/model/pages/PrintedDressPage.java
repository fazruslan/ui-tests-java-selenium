package com.test.model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PrintedDressPage extends PageFactory {

    WebDriver driver;

    public PrintedDressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String expectedDressCompositions = "Viscose";
    public String expectedDressStyles = "Dressy";
    public String expectedDressProperties = "Short Dress";
    public String dressSize = "M";
    public String expectedCartText = "1 Product";

    @FindBy(xpath = "//table[@class='table-data-sheet']//tr[1]/td[2]")
    private WebElement actualDressCompositions;

    @FindBy(xpath = "//table[@class='table-data-sheet']//tr[2]/td[2]")
    private WebElement actualDressStyles;

    @FindBy(xpath = "//table[@class='table-data-sheet']//tr[3]/td[2]")
    private WebElement actualDressProperties;

    @FindBy(id = "group_1")
    private WebElement sizeSelection;

    @FindBy(id = "color_24")
    private WebElement pinkColor;

    @FindBy(xpath = "//div[@class='box-cart-bottom']//button")
    private WebElement addToCart;

    @FindBy(xpath = "//div[@class='button-container']//span[1]")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//div[@class='shopping_cart']//span[1]")
    private WebElement numberOfProductsInCartText;

    @FindBy(xpath = "//div[@class='shopping_cart']//span[2]")
    private WebElement cartTextAfterNumber;

    @FindBy(xpath = "//div[@class='shopping_cart']/a")
    private WebElement shoppingCart;

    @FindBy(id = "button_order_cart")
    private WebElement checkOutBtn;

    public String getActualDressCompositions() { return actualDressCompositions.getText(); }
    public String getActualDressStyles() { return actualDressStyles.getText(); }
    public String getActualDressProperties() { return actualDressProperties.getText(); }
    public void chooseSize() {
        Select sizeSelect = new Select(sizeSelection);
        sizeSelect.selectByVisibleText(dressSize);
    }
    public void choosePinkColor() { pinkColor.click(); }
    public void clickAddToCart() { addToCart.click(); }
    public void clickContinueShopping() { continueShoppingBtn.click(); }
    public String getCartTextAfterNumber() { return numberOfProductsInCartText.getText() + " " + cartTextAfterNumber.getText(); }
    public void moveCursorToShoppingCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).perform();
    }
    public void clickCheckOutBtn() { checkOutBtn.click(); }
}
