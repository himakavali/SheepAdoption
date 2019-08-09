package com.logicgate.sheepadoption.stepdefinations;


import com.logicgate.sheepadoption.pages.AdoptionRequestAccepted;
import com.logicgate.sheepadoption.pages.SheepAdoptionFormPage;
import com.logicgate.sheepadoption.utils.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * This class has methods which check for the Elements visibility
 * Enter data in the form
 *checks for Error validations for mandatory fields
 *
 * */

public class SheepAdoptionStepdefinition extends TestBase {


    private static SheepAdoptionFormPage sheepAdoptionFormPage = new SheepAdoptionFormPage();


    @Given("^Logicgate sheep adoption page$")
    public void logicgate_sheep_adoption_page() {

        TestBase.initialization();

    }


    @Then("^Validate Elements on the page$")
    public void isDisplayedElementsOnPage() {

        sheepAdoptionFormPage = new SheepAdoptionFormPage();

        try {
            sheepAdoptionFormPage.fname();

        } catch (Exception e) {
            Assert.fail("Element not Displayed on Page ");
        }

    }


    @When("^user enter mandatory fields for adoption details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void userEnterMandatoryAdoptionDetails(String fName, String lName, String email, String adress, String country, String state, String zip) {

        sheepAdoptionFormPage = new SheepAdoptionFormPage();
        sheepAdoptionFormPage.setFirstName(fName);
        sheepAdoptionFormPage.setLastName(lName);
        sheepAdoptionFormPage.setAddress(adress);
        sheepAdoptionFormPage.setEmailID(email);
        sheepAdoptionFormPage.selectCountry(country);
        sheepAdoptionFormPage.selectState(state);
        sheepAdoptionFormPage.setZip(zip);

    }


    @Then("^submit the form for sheep adoption$")
    public void isClickbleSubmitButtonforsheepadoptionForm() {

        try {

            sheepAdoptionFormPage.clickSubmitButton();

        } catch (Exception e) {
            Assert.fail("Adop now Button  not clickable ");
        }
    }


    @Then("^Validate Adoption Request Accepted page$")
    public void isAdoptionRequestAcceptedDisplayed() {

        AdoptionRequestAccepted adoptionRequestAccepted = new AdoptionRequestAccepted();
        String expectedPage = adoptionRequestAccepted.acceptedPage();
        Assert.assertEquals("Navigated to Adoption request accepted page", expectedPage, "Adoption Request Accepted!");

    }


    @Then("^validate the error message \"([^\"]*)\"$")
    public void validate_the_error_message(String expectedErrorResponse) {

        sheepAdoptionFormPage = new SheepAdoptionFormPage();

        String actualResponse = sheepAdoptionFormPage.missingFname();

        Assert.assertEquals("Mandatory FirstName is missing  ", expectedErrorResponse, actualResponse);

    }


    @Then("^validate the error message when \"([^\"]*)\",\"([^\"]*)\"$")
    public void isErrorMessageDisplayedCorrectForMissingFields(String expectedErrorResponse, int i) {


        sheepAdoptionFormPage = new SheepAdoptionFormPage();


        switch (i) {
            case 1:
                String actualResponseFname = sheepAdoptionFormPage.missingFname();
                Assert.assertEquals("Expected Error msg not matching with Actual Error msg for Firstname: ", expectedErrorResponse, actualResponseFname);
                break;

            case 2:
                String actualResponseLname = sheepAdoptionFormPage.missingLname();
                Assert.assertEquals("xpected Error msg not matching with Actual Error msg for Lastname: ", expectedErrorResponse, actualResponseLname);
                break;
            default:
                System.out.println("Not Matching:");
                break;

        }


    }

}
