package lippia.web;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.*;
import lippia.web.services.SauceDemoService;

import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static org.testng.Assert.*;

public class SauceDemoSteps extends PageSteps {

    @Given("the user is on the SauceDemo login page")
    public void openSauceDemo() {
        SauceDemoService.navigateToSauceDemo();
    }

    @And("the user enters username {string}")
    public void theUserEntersUsername(String username) {
        SauceDemoService.enterUsername(username);
    }

    @And("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        SauceDemoService.enterPassword(password);
    }

    @And("the user clicks Login")
    public void theUserClicksLogin() {
        SauceDemoService.clickLogin();
    }

    @Then("the Products page should be displayed")
    public void theProductsPageShouldBeDisplayed() {
        assertEquals(SauceDemoService.getProductsTitle(), "Products");
    }

    @Then("an error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String message) {
        assertEquals(SauceDemoService.getErrorMessage(), message);
    }

    @When("the user adds the backpack product to the cart")
    public void theUserAddsBackpackToCart() {
        SauceDemoService.addBackpackToCart();
    }

    @Then("the cart counter should show {string}")
    public void theCartCounterShouldShow(String expected) {
        assertEquals(SauceDemoService.getCartBadgeText(), expected);
    }

    @When("the user removes the backpack from the cart")
    public void theUserRemovesBackpackFromCart() {
        SauceDemoService.removeBackpackFromCart();
    }

    @Then("the cart counter should be empty")
    public void theCartCounterShouldBeEmpty() {
        assertFalse(SauceDemoService.isCartBadgePresent());
    }
}