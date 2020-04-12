package general;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Dimension;
import java.util.concurrent.TimeUnit;

import static general.Logger.info;
import static io.appium.java_client.touch.offset.PointOption.point;

public class AppiumElement {
  // Variables
  private String key;
  private String by;
  private String using;
  private AppiumDriver driver;
  private final Integer TIMEOUT = 10;
  // Constructors
  public AppiumElement(String key, String by, String using, AppiumDriver driver){
    this.key = key;
    this.by = by;
    this.using = using;
    this.driver = driver;
  }
  // Methods
  public void click() {
    find(TIMEOUT).click();
    info("Clicked: " + key);
  }
  public void scrollIntoView() {
    info("Scrolling to: " + key);
    Dimension size = driver.manage().window().getSize();
    int anchor = (int) (size.width / 2);

    for (int i = 0; i < TIMEOUT; i++) {
      if(isDisplayed(1)){
        info("Scrolled to: " + key);
        break;
      }
      new TouchAction(driver)
              .longPress(point(anchor, anchor))
              .moveTo(point(anchor, 10))
              .release()
              .perform();
    }
    info("Done Scrolling");
  }
  public Boolean isDisplayed(Integer timeout){
    try {
      find(timeout);
      info("Found: " + key);
      return true;
    }catch (org.openqa.selenium.NoSuchElementException e){
      info("Did not find: " + key);
      return false;
    }
  }
  public AndroidElement find(Integer timeout){
    driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    info("Finding: " + key);
    return (AndroidElement) driver.findElement(by, using);
  }
}
