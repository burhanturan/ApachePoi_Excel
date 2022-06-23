package com.apache.step_definition;

import com.apache.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Google_StepDef {

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        Driver.getDriver().get("https:/www.google.com");
    }
    @Then("user should see {string} in the title")
    public void user_should_see_in_the_title(String title) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
        Driver.closeDriver();
    }

}
