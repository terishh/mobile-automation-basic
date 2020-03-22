package general;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Logger {
  // Variables
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
  private static String INFO = "[INFO]";
  // Methods
  public static void info(String str){
    output(infoContent(str));
  }
  // Private methods
  private static void output(String str){
    System.out.println(str);
  }
  private static String getTime(){
    String date = sdf.format(new Date());
    return "[" + date + "]";
  }
  private static String infoContent(String str){
    String INFO_ = INFO + ": ";
    return getTime() + INFO_ + str;
  }
}
