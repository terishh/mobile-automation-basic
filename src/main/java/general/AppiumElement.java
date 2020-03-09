package general;

public class AppiumElement {
  private String by;
  private String using;

  public AppiumElement(String by, String using){
    this.by = by;
    this.using = using;
  }

  public String getBy(){
    return by;
  }
  public String getUsing(){
    return using;
  }
}
