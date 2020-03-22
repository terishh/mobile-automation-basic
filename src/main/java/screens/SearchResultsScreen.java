package screens;

import general.AppiumElement;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;

public class SearchResultsScreen extends BaseScreen {
  // Constructor
  public SearchResultsScreen(AppiumDriver driver) {
    super(driver);
    addElement("infoPopUp", "id", "text_slot_1");
    addElement("saveButton", "id", "button_follow");
    addElement("sortButton", "id", "button_sort");
    addElement("homeButton", "id", "home");
    addElement("buyOneButton", "id", "//*[@text='Buy 1']");
    addElement("filterButton", "id", "button_filter");
    addElement("firstSearchResult", "id", "cell_collection_item");

  }
  // Base methods
  @Override
  public AppiumElement getMainElement(){
    if(getElement("infoPopUp").isDisplayed(5)){
      getElement("infoPopUp").click();
    }
    return getElement("homeButton");
  }
  @Override
  public void navigate(String element) {
    switch (element){
      case "firstSearchResult": ScreenManager.setCurrentPage(ScreenManager.getProductScreen());
      default                 : super.navigate(element);
    }
  }
}
