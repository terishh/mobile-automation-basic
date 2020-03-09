package general;

import io.appium.java_client.AppiumDriver;
import screen.*;

public class ScreenManager {
  private static BaseScreenObject currentPage = null;
  private static AppiumDriver driver;
  private static BaseScreenObject baseScreen;
  private static HomeScreenObject homeScreen;
  private static SearchScreenObject searchScreen;
  private static SearchResultsScreenObject searchResultsScreen;

  public static void setDriver(AppiumDriver driver){
    ScreenManager.driver = driver;
  }
  public static void setCurrentPage(BaseScreenObject page){
    currentPage = page;
    ScreenManager.getCurrentPage().validatePage();
  }
  public static BaseScreenObject getCurrentPage(){
    return currentPage;
  }
  public static void initPages(){
    baseScreen = new BaseScreenObject(driver);
    homeScreen = new HomeScreenObject(driver);
    searchScreen = new SearchScreenObject(driver);
    searchResultsScreen = new SearchResultsScreenObject(driver);
  }

  // Screen getters
  public static BaseScreenObject getBaseScreen(){
    return baseScreen;
  }
  public static HomeScreenObject getHomeScreen(){
    return homeScreen;
  }
  public static SearchScreenObject getSearchScreen(){
    return searchScreen;
  }
  public static SearchResultsScreenObject getSearchResultsScreenObject() { return searchResultsScreen; }
}
