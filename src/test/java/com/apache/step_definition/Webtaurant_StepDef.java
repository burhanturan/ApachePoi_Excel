package com.apache.step_definition;

import com.apache.pages.WebstaurantPage;
import com.apache.utilities.BrowserUtils;
import com.apache.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Webtaurant_StepDef {

    WebstaurantPage page = new WebstaurantPage();

    @Given("users are on  the homepage")
    public void users_are_on_the_homepage() {
        Driver.getDriver().get("https://www.webstaurantstore.com/");
    }

    @When("user search {string}")
    public void user_search(String string) {
        page.searchBox.sendKeys(string + Keys.ENTER);
    }

    @Then("user should see {string} in every title")
    public void user_should_see_int_every_title(String string) throws RuntimeException {


        List<String> product = new ArrayList<>();

        for (WebElement each : page.allProduct) {
            product.add(each.getText());
        }
        page.rightButton.click();

        while (Integer.parseInt(Driver.getDriver().getCurrentUrl().substring(Driver.getDriver().getCurrentUrl().length() - 1)) < 9) {
            for (WebElement each : page.allProduct) {
                product.add(each.getText());
            }
            page.rightButton1.click();
            BrowserUtils.sleep(1);
        }


        for (String each : product) {
            Assert.assertTrue(each.contains("Table"));
        }

        if (Integer.parseInt(Driver.getDriver().getCurrentUrl().substring(Driver.getDriver().getCurrentUrl().length() - 1)) == 9) {

            for (WebElement each : page.allProduct) {
                product.add(each.getText());
            }
            for (String each : product) {
                Assert.assertTrue(each.contains("Table"));
            }
        }

        System.out.println(product.size());
        Driver.closeDriver();


//        for (WebElement each : page.allProduct) {
//            Assert.assertTrue(each.getText().contains("Table"));
//        }
//        page.rightButton.click();
//
//        do {
//            for (WebElement each : page.allProduct) {
//                Assert.assertTrue(each.getText().contains("Table"));
//            }
//            page.rightButton1.click();
//            BrowserUtils.sleep(1);
//        } while (Integer.parseInt(Driver.getDriver().getCurrentUrl().substring(Driver.getDriver().getCurrentUrl().length() - 1)) <= 8);
//
//        Driver.closeDriver();
    }

}
