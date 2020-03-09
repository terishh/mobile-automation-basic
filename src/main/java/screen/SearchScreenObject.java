package screen;

import general.AppiumElement;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class SearchScreenObject extends BaseScreenObject {
  // Elements
  private AppiumElement searchField = new AppiumElement("id", "search_src_text");
  private AppiumElement firstSearchResult =
          new AppiumElement("xpath", "//android.widget.ListView/android.widget.RelativeLayout[1]");

  // Methods
  public SearchScreenObject(AppiumDriver driver) {
    super(driver);
  }
  public WebElement getMainElement(){
    return findElement(searchField);
  }

  public void searchFor(String string){
    info("Searching for '" + string + "'");
    findElement(searchField).sendKeys(string);
    findElement(firstSearchResult).click();
    ScreenManager.setCurrentPage(ScreenManager.getSearchResultsScreenObject());
  }
}
