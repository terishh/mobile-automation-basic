package general;

import io.appium.java_client.AppiumDriver;
import screens.*;

public class ScreenManager {
  // Variables
  private static AppiumDriver driver;
  private static BaseScreen currentScreen;
  private static HomeScreen homeScreen;
  private static SearchScreen searchScreen;
  private static SignInScreen signInScreen;
  private static ProductScreen productScreen;
  private static SearchResultsScreen searchResultsScreen;
  private static ProductOptionsScreen productOptionsScreen;
  private static CategoriesScreen categoriesScreen;
  private static CreateAnAccountScreen createAnAccountScreen;
  private static RegisterScreen registerScreen;
  // Methods
  public static void initPages(){
    homeScreen = new HomeScreen(driver);
    searchScreen = new SearchScreen(driver);
    signInScreen = new SignInScreen(driver);
    productScreen = new ProductScreen(driver);
    searchResultsScreen = new SearchResultsScreen(driver);
    productOptionsScreen = new ProductOptionsScreen(driver);
    categoriesScreen = new CategoriesScreen(driver);
    createAnAccountScreen = new CreateAnAccountScreen(driver);
    registerScreen = new RegisterScreen(driver);
  }
  public static void setDriver(AppiumDriver driver){
    ScreenManager.driver = driver;
    initPages();
  }
  public static void setCurrentPage(BaseScreen page){
    currentScreen = page;
    ScreenManager.getCurrentScreen().validatePage();
  }
  public static BaseScreen getCurrentScreen(){
    return currentScreen;
  }
  // Screen getters
  public static HomeScreen getHomeScreen(){
    return homeScreen;
  }
  public static SearchScreen getSearchScreen(){
    return searchScreen;
  }
  public static ProductScreen getProductScreen() { return productScreen; }
  public static SearchResultsScreen getSearchResultsScreen() { return searchResultsScreen; }
  public static ProductOptionsScreen getProductOptionsScreen() { return productOptionsScreen; }
  public static SignInScreen getSignInScreen() { return signInScreen; }
  public static CategoriesScreen getCategoriesScreen() { return categoriesScreen; }
  public static CreateAnAccountScreen getCreateAnAccountScreen() { return createAnAccountScreen; }
  public static RegisterScreen getRegisterScreen() { return registerScreen; }
}
