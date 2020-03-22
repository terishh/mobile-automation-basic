package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import general.ScreenManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static general.ScreenManager.getHomeScreen;

public class Hooks {
  private String apkPath = Paths.get("").toAbsolutePath().toString() + "/apk/";
  private String appName = "ebay.apk";
  private DesiredCapabilities capabilities = new DesiredCapabilities();
  private static AppiumDriver driver;
  public static AppiumDriver getDriver(){
    return driver;
  }
  private void setCapabilities(){
    capabilities.setCapability("appium-version", "7.0");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("deviceName", "emulator-5554");
    capabilities.setCapability("fullReset", "true");
    capabilities.setCapability("automationName", "uiautomator2");
    capabilities.setCapability("app", apkPath + appName);
  }
  private void startDriver() throws MalformedURLException {
  setCapabilities();
  driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  ScreenManager.setDriver(driver);
  ScreenManager.initPages();
  ScreenManager.setCurrentPage(getHomeScreen());
  }

  @Before
  public void launchApp() throws MalformedURLException {
    startDriver();
  }

  @After
  public void closeApp(){
    driver.resetApp();
  }


}
