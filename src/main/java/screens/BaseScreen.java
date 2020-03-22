package screens;

import general.AppiumElement;
import general.ElementCollection;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static general.Logger.info;

public class BaseScreen {
  // Variables
  private final Integer TIMEOUT = 10;
  private final AppiumDriver driver;
  private ElementCollection elementCollection;
  // Constructor
  public BaseScreen(AppiumDriver driver){
    this.driver = driver;
    elementCollection = new ElementCollection(driver);
  }
  // General Methods
  public void click(String element){
    elementCollection.getElement(capitalizeSecond(element)).click();
    navigate(capitalizeSecond(element));
  }
  public void scrollTo(String element){
    getElement(capitalizeSecond(element)).scrollIntoView();
  }
  public void doAction(String scope, DataTable dataTable) {
    List<Map<String,String>> data = dataTable.asMaps();
    scope = capitalizeSecond(scope);
    info("Calling method: '" + scope + "' with data: " + data);
    callMethod(scope, data);
  }
  public void addElement(String key, String by, String using){
    elementCollection.addElement(key, by, using);
  }
  public void validatePage() {
    info("Validating page: " + this.getClass());
    assertThat(getMainElement().isDisplayed(getTimeout())).isTrue();
  }
  public void validateData(String scope, DataTable dataTable) {
    List<Map<String,String>> data = dataTable.asMaps();
    info("Validating '" + scope + "' with data: " + data);
    assertThat(validator("validate" + capitalize(scope), data)).isTrue();
  }
  public void validateFields(DataTable dataTable) {
    info("Validating fields: " + dataTable.asList());
    for(String element : dataTable.asList()){
      assertThat(getElement(capitalizeSecond(element)).isDisplayed(getTimeout())).isTrue();
    }
  }
  public Boolean validator(String scope, List<Map<String,String>> data) {
    switch (scope){
      default: throw new Error("The given method 'validate" + capitalize(scope) + "' is undefined");
    }
  }
  public Integer getTimeout(){
    return TIMEOUT;
  }
  public AppiumElement getElement(String el){
    return elementCollection.getElement(el);
  }
  // Overridable methods
  public void navigate(String element){}
  public void searchFor(String string) {
    throw new Error("'searchFor' is undefined for " + this.getClass());
  }
  public void callMethod(String method, List<Map<String,String>> data){
    switch (method){
      default: throw new Error("Given method '" + method + "' is undefined");
    }
  }
  public AppiumElement getMainElement(){
    throw new Error("getMainElement is undefined for " + this.getClass());
  }
  // Helper methods
  public String capitalize(String words){
    words = words.toLowerCase().
            replaceAll("[^a-zA-Z0-9]", " ").
            replaceAll("\\s+"," ");
    StringBuilder capitalized = new StringBuilder();
    for(String word: words.split(" ")){
      capitalized.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
    }
    return capitalized.toString().replaceAll("\\s+","");
  }
  public String capitalizeSecond(String words){
    String str = capitalize(words);
    return Character.toLowerCase(str.charAt(0)) + str.substring(1);
  }
}
