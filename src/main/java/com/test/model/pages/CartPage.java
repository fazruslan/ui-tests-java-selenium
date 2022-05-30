package com.test.model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends PageFactory{

    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String expectedTextInMessage = "Your shopping cart is empty.";
    public String expectedCartText = "(empty)";


    @FindBy(id = "4_44_0_0")
    private WebElement deleteDressBtn;

    @FindBy(xpath = "//*[@class='alert alert-warning']")
    private WebElement infoMessageInCart;

    @FindBy(xpath = "//div[@class='shopping_cart']//span[5]")
    private WebElement cartText;

    public void clickDeleteDress() { deleteDressBtn.click(); }
    public boolean checkInfoMessageDisplayed() { return infoMessageInCart.isDisplayed(); }
    public String getInfoMessageText() { return infoMessageInCart.getText(); }
    public WebElement getElementOfMessage() { return infoMessageInCart; }
    public String getCartText() { return cartText.getText(); }
}
