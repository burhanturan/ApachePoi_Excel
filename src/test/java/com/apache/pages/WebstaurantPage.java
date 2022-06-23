package com.apache.pages;

import com.apache.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebstaurantPage {
    public WebstaurantPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "searchval")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@data-testid='itemDescription']")
    public List<WebElement> allProduct;

//    @FindBy(xpath = "(//li//a)[52]")
//    public WebElement rightButton;


    @FindBy(xpath = "(//li//a[contains(@aria-label,'Go to page')])[2]")
    public WebElement rightButton1;

    @FindBy(xpath = "(//li//a[contains(@aria-label,'Go to page')])")
    public WebElement rightButton;

}
