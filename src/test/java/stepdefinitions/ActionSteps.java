package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import general.ScreenManager;
import io.cucumber.datatable.DataTable;

public class ActionSteps {
  @When("I click {string}")
  public void i_click(String string) {
    ScreenManager.getCurrentScreen().click(string);
  }

  @When("I {string} with following data:")
  public void i_with_following_data(String scope, DataTable dataTable) {
    ScreenManager.getCurrentScreen().doAction(scope, dataTable);
  }

  @When("I search for {string}")
  public void i_search_for(String string) {
    ScreenManager.getCurrentScreen().searchFor(string);
  }

  @And("I scroll to {string}")
  public void iScrollTo(String element) {
    ScreenManager.getCurrentScreen().scrollTo(element);
  }
}
