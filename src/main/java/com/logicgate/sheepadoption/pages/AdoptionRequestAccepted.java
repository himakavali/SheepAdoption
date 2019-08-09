package com.logicgate.sheepadoption.pages;

import com.logicgate.sheepadoption.utils.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class is for other page, all the web elements in the page and methods
 *
 * */

public class AdoptionRequestAccepted extends TestBase {


    public AdoptionRequestAccepted() {
        {

            PageFactory.initElements(driver, this);

        }
    }

    @FindBy(xpath = "//div[@class='container']/div[1]/h2")
    WebElement acceptedPage;


    public String acceptedPage()
    {

        return acceptedPage.getText();
    }

}
