package com.logicgate.sheepadoption.pages;

import com.logicgate.sheepadoption.utils.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * This class will find the WebElements of adoption page and also contains Page methods which perform operations on those WebElements.
 *
 *
 * */

public class SheepAdoptionFormPage extends TestBase {


    @FindBy(id = "firstName")
    WebElement firstName;


    @FindBy(xpath = "//div[@class='container']/div[2]/div[1]/form[@class='needs-validation']/div[1]/div[1]/label")
    WebElement fName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "email")
    WebElement emailID;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(id = "address2")
    WebElement secondAddress;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "zip")
    WebElement zip;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-lg btn-block']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class='container']/div[2]/div[1]/form[@class='needs-validation was-validated']/div[1]/div[1]/div")
    WebElement missingFname;


    @FindBy(xpath = "//div[@class='container']/div[2]/div[1]/form[@class='needs-validation was-validated']/div[1]/div[2]/div")
    WebElement missingLastName;

    @FindBy(xpath = "//div[@class='container']/div[1]/h2")
    WebElement acceptedPage;


    public SheepAdoptionFormPage() {

        {

            PageFactory.initElements(driver, this);

        }
    }

    public String acceptedPage() {

        return acceptedPage.getText();
    }

    public void setFirstName(String fn) {

        firstName.sendKeys(fn);


    }

    public boolean fname(){
        return fName.isDisplayed();

    }

    public void setLastName(String ln) {

        lastName.sendKeys(ln);
    }


    public void setEmailID(String emal) {

        emailID.sendKeys(emal);
    }


    public void setAddress(String addr) {

        address.sendKeys(addr);
    }

    public void selectCountry(String coutryname) {

        Select countrydropDown = new Select(country);
        countrydropDown.selectByVisibleText(coutryname);

    }


    public void selectState(String stte) {

        Select stateDropDown = new Select(state);
        stateDropDown.selectByValue(stte);
    }

    public void setZip(String zipnum) {

        zip.sendKeys(zipnum);
    }


    public void clickSubmitButton() {
         submitButton.click();

    }

    public String missingFname() {
        return missingFname.getText();
    }


    public String missingLname() {
        return missingLastName.getText();
    }
}

