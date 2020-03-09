package screen;

import general.AppiumElement;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsScreenObject extends BaseScreenObject {
  // Elements
  private AppiumElement infoPopUp = new AppiumElement("id", "text_slot_1");
  private AppiumElement homeButton = new AppiumElement("id", "home");
  private AppiumElement saveButton = new AppiumElement("id", "button_follow");
  private AppiumElement sortButton = new AppiumElement("id", "button_sort");
  private AppiumElement filterButton = new AppiumElement("id", "button_filter");

  // Methods
  public SearchResultsScreenObject(AppiumDriver driver) {
    super(driver);
  }

  public WebElement getMainElement(){
    if(findElement(infoPopUp).isDisplayed()){
      findElement(infoPopUp).click();
    }
    return findElement(homeButton);
  }

  public WebElement elementCollector(String element){
    switch (element){
      case "saveButton"  : return findElement(saveButton);
      case "sortButton"  : return findElement(sortButton);
      case "filterButton": return findElement(filterButton);
      default            : return super.elementCollector(element);
    }
  }
}
