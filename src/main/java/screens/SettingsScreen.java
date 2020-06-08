package screens;

import general.AppiumElement;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;
import static general.Logger.info;

public class SettingsScreen extends BaseScreen {
  // Constructor
  public SettingsScreen(AppiumDriver driver) {
    super(driver);
    addElement("settingsTitle", "xpath", "//*[@text='Settings']");
    addElement("countryOrRegion", "xpath", "//*[@text='Country or region']");
    addElement("switchWidget", "id", "switchWidget");
    addElement("unitedStates", "xpath", "//*[@text='United States']");
    addElement("searchField", "id", "filter");
    addElement("swaziland", "xpath", "//*[@text='Swaziland']");
    addElement("sweden", "xpath", "//*[@text='Sweden']");
    addElement("switzerland", "xpath", "//*[@text='Switzerland']");
    
  }
  // Base Methods
  @Override
  public AppiumElement getMainElement(){
    return getElement("settingsTitle");
  }
   public void searchFor(String string){
    info("Searching for '" + string + "'");
    getElement("searchField").find(getTimeout()).sendKeys(string);
   }
}
