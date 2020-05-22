package screens;

import general.AppiumElement;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;

public class CreateAnAccountScreen extends BaseScreen {

  public CreateAnAccountScreen(AppiumDriver driver) {
    super(driver);
    addElement("title", "id", "title");
    addElement("createABusinessAccount", "id", "button_business");
  }

  // Base Methods
  @Override
  public AppiumElement getMainElement(){
    return getElement("title");
  }

  @Override
  public void navigate(String element){
    switch (element){
      case "createABusinessAccount": ScreenManager.setCurrentPage(ScreenManager.getRegisterScreen());break;
      default                      : super.navigate(element);
    }
  }
}
