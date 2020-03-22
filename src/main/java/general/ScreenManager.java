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
  // Methods
  public static void initPages(){
    homeScreen = new HomeScreen(driver);
    searchScreen = new SearchScreen(driver);
    signInScreen = new SignInScreen(driver);
    productScreen = new ProductScreen(driver);
    searchResultsScreen = new SearchResultsScreen(driver);
    productOptionsScreen = new ProductOptionsScreen(driver);
  }
  public static void setDriver(AppiumDriver driver){
    ScreenManager.driver = driver;
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
}
