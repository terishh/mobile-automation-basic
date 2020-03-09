package screen;

import general.AppiumElement;
import general.Logger;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseScreenObject {
  // Elements
  private final Integer defaultTimeout = 5;
  private final Logger logger = new Logger();
  private final AppiumDriver driver;

  // Constructor
  public BaseScreenObject(AppiumDriver driver){
    this.driver = driver;
  }

  // General Methods
  public WebElement findElement(AppiumElement element){
    info("Finding element");
    return driver.findElement(element.getBy(), element.getUsing());
  }
  public void click(String element) {
    element = capitalizeSecond(element);
    info("Clicking '" + element +"'");
    getElement(element).click();
    navigate(element);
  }
  public void validatePage() {
    info("Validating page: " + this.getClass());
    assertThat(getMainElement().isDisplayed()).isTrue();
  }
  public void validateData(String scope, DataTable dataTable) {
    List<Map<String,String>> data = dataTable.asMaps();
    info("Validating '" + scope + "' with data: " + data);
    assertThat(validator("validate" + capitalize(scope), data)).isTrue();
  }
  public void validateFields(DataTable dataTable) {
    info("Validating fields: " + dataTable.asList());
    for(String element : dataTable.asList()){
      assertThat(getElement(capitalizeSecond(element)).isDisplayed()).isTrue();
    }
  }
  public Boolean validator(String scope, List<Map<String,String>> data) {
    switch (scope){
      default: throw new Error("The given method 'validate" + capitalize(scope) + "' is undefined");
    }
  }
  public Integer getTimeout(){
    return defaultTimeout;
  }
  public WebElement getElement(String element) {
    info("Getting '" + element + "'");
    return elementCollector(element);
  }
  public WebElement elementCollector(String element) {
    switch (element){
      default: throw new Error("Given element '" + element + "' is undefined");
    }
  }
  public void doAction(String scope, DataTable dataTable) {
    List<Map<String,String>> data = dataTable.asMaps();
    scope = capitalizeSecond(scope);
    info("Calling method: '" + scope + "' with data: " + data);
    callMethod(scope, data);
  }
  public void callMethod(String method, List<Map<String,String>> data) {
    switch (method){
      default: throw new Error("Given method '" + method + "' is undefined");
    }
  }

  // Methods - overridable
  public void navigate(String element){}
  public WebElement getMainElement(){
    throw new Error("'getMainElement' is undefined for " + this.getClass());
  }
  public void searchFor(String string) {
    throw new Error("'searchFor' is undefined for " + this.getClass());
  }

  // Helper methods
  public void info(String str){
    logger.info(str);
  }
  public void compare(List<String> expected, List<String> actual) {
    logger.compare(expected, actual);
  }
  public void waitUntilDisplayed(AppiumElement elem, Integer time) {
    info("Waiting for element to be displayed");
    //elem.wait(time);
    //Loading.waitUntilDisplayed(elem, time);
  }
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
