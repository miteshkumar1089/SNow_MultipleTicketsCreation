package StepDefinition;

import Pages.Others.InaciveCatalogItem;
import base.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class inactiveCatalogItem {

    InaciveCatalogItem inact;
    @When("User opens Maintain items table")
    public void user_opens_maintain_items_table() throws IOException {

        inact= new InaciveCatalogItem(Hooks.driver);
        inact.maintainItemTable();
    }

    @When("User enters \"([^\"]*)\" item in Action\\/Name field")
    public void user_enters_item_in_action_name_field(String catalogItem) throws IOException {
        inact= new InaciveCatalogItem(Hooks.driver);
        inact.searchCatalog(catalogItem);
    }

    @Then("User validates if Active checkbox is unchecked")
    public void user_validates_if_active_checkbox_is_unchecked() throws IOException {
        inact= new InaciveCatalogItem(Hooks.driver);
        inact.activeStatus();

    }
}
