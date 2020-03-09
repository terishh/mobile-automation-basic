package stepdefinitions;

import cucumber.api.java.en.When;
import general.ScreenManager;
import io.cucumber.datatable.DataTable;


public class ActionSteps {
  @When("I click {string}")
  public void i_click(String string) {
    ScreenManager.getCurrentPage().click(string);
  }

  @When("I {string} with following data:")
  public void i_with_following_data(String scope, DataTable dataTable) {
    ScreenManager.getCurrentPage().doAction(scope, dataTable);
  }

  @When("I search for {string}")
  public void i_search_for(String string) {
    ScreenManager.getCurrentPage().searchFor(string);
  }
}
