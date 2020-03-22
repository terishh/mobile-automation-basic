package screens;

import general.AppiumElement;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;

public class ProductOptionsScreen extends ProductScreen {
  // Constructor
  public ProductOptionsScreen(AppiumDriver driver) {
    super(driver);
    addElement("options", "xpath", "//*[@text='Options']");
    addElement("addToCart", "id", "button_add_to_cart_buybar");
  }
  // Base methods
  @Override
  public AppiumElement getMainElement(){
    return getElement("options");
  }
  @Override
  public void navigate(String element) {
    switch (element){
      case "addToCart": ScreenManager.setCurrentPage(ScreenManager.getSignInScreen()); break;
      default         : super.navigate(element);
    }
  }
}
