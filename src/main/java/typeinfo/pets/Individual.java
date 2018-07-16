package typeinfo.pets;

/**
 * @author zhongwei Date: 18-2-6 Time: 上午9:20.
 */
public class Individual {
  public static int count = 0;
  private final int id = count;
  private String name;

  public Individual () {}

  public Individual(String name) {
    this.name = name;
  }

  public String toString() {
    return "name:" + this.name + ", id:" +this.id;
  }
}
