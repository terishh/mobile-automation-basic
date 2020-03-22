package general;

import io.appium.java_client.AppiumDriver;
import java.util.HashMap;

import static general.Logger.info;

public class ElementCollection {
  // Variables
  private AppiumDriver driver;
  private HashMap<String, AppiumElement> elementCollection = new HashMap<String, AppiumElement>();;
  // Constructor
  public ElementCollection(AppiumDriver driver){
    this.driver = driver;
  }
  // Methods
  public void addElement(String key, String by, String using){
    elementCollection.put(key, new AppiumElement(key, by, using, driver));
  }
  public AppiumElement getElement(String key){
    // info("Getting " + key);
    AppiumElement element = elementCollection.get(key);
    if(element == null) {
      info("!!! " + key + " is undefined !!!");
    }
    return element;
  }
}
