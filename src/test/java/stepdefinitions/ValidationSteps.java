package stepdefinitions;

import cucumber.api.java.en.Then;
import general.ScreenManager;
import io.cucumber.datatable.DataTable;

public class ValidationSteps {
  @Then("I see {string} with the following data:")
  public void i_see_the_with_the_following_data(String scope, DataTable dataTable) {
    // PageManager.getCurrentPage().validateData(scope, dataTable);
  }

  @Then("I see the following fields:")
  public void i_see_the_following_fields(DataTable dataTable) {
    ScreenManager.getCurrentPage().validateFields(dataTable);
  }
}
