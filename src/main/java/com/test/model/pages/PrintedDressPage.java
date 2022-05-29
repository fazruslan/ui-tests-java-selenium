package com.test.model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintedDressPage extends PageFactory {

    WebDriver driver;

    public PrintedDressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String expectedDressCompositions = "Viscose";
    public String expectedDressStyles = "Dressy";
    public String expectedDressProperties = "Short Dress";
    @FindBy(xpath = "//table[@class='table-data-sheet']//tr[1]/td[2]")
    private WebElement actualDressCompositions;

    @FindBy(xpath = "//table[@class='table-data-sheet']//tr[2]/td[2]")
    private WebElement actualDressStyles;

    @FindBy(xpath = "//table[@class='table-data-sheet']//tr[3]/td[2]")
    private WebElement actualDressProperties;

    public String getActualDressCompositions(){ return actualDressCompositions.getText(); }

    public String getActualDressStyles() { return actualDressStyles.getText(); }

    public String getActualDressProperties() { return actualDressProperties.getText(); }

}
