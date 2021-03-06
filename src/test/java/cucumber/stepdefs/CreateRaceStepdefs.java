package cucumber.stepdefs;

import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static cucumber.stepdefs.support.Url.url;
import static cucumber.stepdefs.support.WebDrivers.getDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CreateRaceStepdefs implements En {
    public CreateRaceStepdefs() {
        When("^I try to create a new race$", () -> {
            getDriver().get(url("/races/new"));

            getDriver().findElement(By.id("name")).sendKeys("New Race");

            getDriver().findElement(By.id("submit")).click();
        });

        Then("^I must see the new race$", () -> {
            getDriver().get(url("/races"));

            List<WebElement> rows = getDriver().findElements(By.cssSelector("#races tbody tr"));

            assertThat(rows.size(), is(1));;
        });
    }
}
