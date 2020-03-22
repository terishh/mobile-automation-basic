package screens;

import general.AppiumElement;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;

public class HomeScreen extends BaseScreen {
  // Constructor
  public HomeScreen(AppiumDriver driver) {
    super(driver);
    addElement("ebayLogo", "id", "logo");
    addElement("searchBox", "id", "search_box");
    addElement("progressBar", "id", "translucent_progress_bar");
  }
  // Base Methods
  @Override
  public AppiumElement getMainElement(){
    return getElement("ebayLogo");
  }
  @Override
  public void navigate(String element){
    switch (element){
      case "searchBox": ScreenManager.setCurrentPage(ScreenManager.getSearchScreen());break;
      default         : super.navigate(element);
    }
  }
}
