package com.test.model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EveningDressesPage extends PageFactory{

    WebDriver driver;

    public EveningDressesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='product-image-container']/a")
    private WebElement printedDress;

    @FindBy(xpath = "//div[@class='right-block']/div[2]/a[2]")
    private WebElement moreAboutProductButton;

    public void moveCursorToPrintedDressProduct(){
        Actions actions = new Actions(driver);
        actions.moveToElement(printedDress).perform();
    }

    public void clickMoreButton() { moreAboutProductButton.click(); }

}
