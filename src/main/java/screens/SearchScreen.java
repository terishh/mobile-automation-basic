package screens;

import general.AppiumElement;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;

import static general.Logger.info;

public class SearchScreen extends BaseScreen {
  // Constructor
  public SearchScreen(AppiumDriver driver) {
    super(driver);
    addElement("searchField", "id", "search_src_text");
    addElement("firstSearchResult", "xpath", "//android.widget.ListView/android.widget.RelativeLayout[1]");
  }
  // Base methods
  @Override
  public AppiumElement getMainElement(){
    return getElement("searchField");
  }
  // Methods
  public void searchFor(String string){
    info("Searching for '" + string + "'");
    getElement("searchField").find(getTimeout()).sendKeys(string);
    getElement("firstSearchResult").click();
    ScreenManager.setCurrentPage(ScreenManager.getSearchResultsScreen());
  }
}
