package screens;

import general.AppiumElement;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProductScreen extends HomeScreen {
  // Constructor
  public ProductScreen(AppiumDriver driver) {
    super(driver);
    addElement("buyItNow", "id", "button_bin");
    addElement("addToCart", "id", "button_add_to_cart");
    addElement("storageCapacitySelector", "xpath", "//*[@text='Storage Capacity']/../android.widget.Spinner");
    addElement("colorSelector", "xpath", "//*[@text='Color']/../android.widget.Spinner");
    addElement("optionsList", "xpath", "//android.widget.ListView");
  }
  // Base methods
  @Override
  public AppiumElement getMainElement(){
    return getElement("ebayLogo");
  }
  @Override
  public void callMethod(String method, List<Map<String, String>> data) {
    switch (method){
      case "selectOptions": selectOptions(data); return;
      default             : super.callMethod(method, data);
    }
  }
  @Override
  public void navigate(String element) {
    switch (element){
      case "buyItNow" : ScreenManager.setCurrentPage(ScreenManager.getSignInScreen()); break;
      case "addToCart": ScreenManager.setCurrentPage(ScreenManager.getProductOptionsScreen());break;
      default         : super.navigate(element);
    }
  }
  // Methods
  public void selectOptions(List<Map<String, String>> data){
    Map<String, String> map = data.get(0);
    Iterator<String> itr = map.keySet().iterator();
    while (itr.hasNext())
    {
      String key = itr.next();
      String value = map.get(key);
      String el = capitalizeSecond(key);
      getElement(el).isDisplayed(getTimeout());
      getElement(el).click();
      getElement("optionsList").find(5).findElement("xpath", "//*[@text='" + value + "']").click();
    }
  }
}
