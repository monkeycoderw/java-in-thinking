package generics;

/**
 * @author zhongwei Date: 2018/4/17 Time: 20:25.
 */
public class CountedObject {
  private static long count = 0;
  private final long id = count++;
  public long id() {return id;}
  public String toString() { return "CountedObject:" + id;}
}
