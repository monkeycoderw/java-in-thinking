package generics.coffee;

/**
 * @author zhongwei Date: 2018/4/16 Time: 22:23.
 */
public class Coffee {

  private static long counter = 0;

  private final long id = counter++;

  public String toString() {
    return getClass().getSimpleName() + " " + id;
  }

}
