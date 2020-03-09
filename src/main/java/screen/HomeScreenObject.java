package screen;

import general.AppiumElement;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class HomeScreenObject extends BaseScreenObject {
  AppiumElement ebayLogo = new AppiumElement("id", "logo");
  AppiumElement searchBox = new AppiumElement("id", "search_box");

  // Constructor
  public HomeScreenObject(AppiumDriver driver) {
    super(driver);
  }

  // Methods
  public WebElement getMainElement(){
    return findElement(ebayLogo);
  }
  public WebElement elementCollector(String element) {
    switch(element) {
      case "ebayLogo" : return findElement(ebayLogo);
      case "searchBox": return findElement(searchBox);
      default        : return super.elementCollector(element);
    }
  }
  public void navigate(String element){
    switch (element){
      case "searchBox":
        ScreenManager.setCurrentPage(ScreenManager.getSearchScreen());
      default: super.navigate(element);
    }
  }
}
