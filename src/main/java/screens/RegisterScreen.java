package screens;

import general.AppiumElement;
import io.appium.java_client.AppiumDriver;

public class RegisterScreen extends CreateAnAccountScreen {

  public RegisterScreen(AppiumDriver driver) {
    super(driver);
    //*[@text='Legal business name']

    addElement("legalBusinessName", "xpath", "//*[@text='Legal business name']");
    addElement("legalBusinessEmail", "xpath", "//*[@text='Legal business email']");
    addElement("reenterEmail", "xpath", "//*[@text='Reenter email']");
    addElement("password", "xpath", "//*[@text='Password']");
    addElement("legalBusinessPhone", "xpath", "//*[@text='Legal business phone']");
  }



}

