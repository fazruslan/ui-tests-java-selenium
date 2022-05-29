package com.test.model.pages;

import com.test.utils.Webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MainPage extends PageFactory {

    WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a")
    private WebElement dressesTab;

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/ul/li[2]/a")
    private WebElement eveningDressesTab;

    public void moveCursorToDressesTab(){
        Actions actions = new Actions(driver);
        actions.moveToElement(dressesTab).perform();
    }

    public void clickOnEveningDressesTab() { eveningDressesTab.click(); }
}
