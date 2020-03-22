package screens;

import general.AppiumElement;
import io.appium.java_client.AppiumDriver;

public class SignInScreen extends BaseScreen {
  // Constructor
  public SignInScreen(AppiumDriver driver) {
    super(driver);
    addElement("signIn", "xpath", "//*[@text='Sign in']");
    addElement("useEmailOrUsername", "id", "button_classic");
    addElement("signInWithGoogle", "id", "button_google");
    addElement("signInWithFacebook", "id", "button_facebook");
    addElement("createAnAccount", "id", "button_create_account");
  }
  // Base methods
  @Override
  public AppiumElement getMainElement() {
    return getElement("signIn");
  }
}
