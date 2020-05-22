package screens;

import general.AppiumElement;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;

public class CategoriesScreen extends BaseScreen {
  // Constructor
  public CategoriesScreen(AppiumDriver driver) {
    super(driver);
    addElement("categoriesTitle", "id", "title");
    addElement("antiques", "xpath", "//*[@text='Antiques']");
    addElement("art", "xpath", "//*[@text='Art']");
    addElement("baby", "xpath", "//*[@text='Baby']");
    addElement("books", "xpath", "//*[@text='Books']");
    addElement("antiquities", "xpath", "//*[@text='Antiquities']");
    addElement("architecturalGarden", "xpath", "//*[@text='Architectural & Garden']");
    addElement("asianAntiques", "xpath", "//*[@text='Asian Antiques']");
    addElement("decorativeArts", "xpath", "//*[@text='Decorative Arts']");
    addElement("ethnographic", "xpath", "//*[@text='Ethnographic']");
    addElement("african", "xpath", "//*[@text='African']");
    addElement("latinAmerican", "xpath", "//*[@text='Latin American']");
    addElement("nativeAmerican", "xpath", "//*[@text='Native American']");
    addElement("pacificIslandsOceania", "xpath", "//*[@text='Pacific Islands & Oceania']");
  }
  // Base Methods
  @Override
  public AppiumElement getMainElement(){
    return getElement("categoriesTitle");
  }
}
