package typeinfo;

/**
 * @author zhongwei Date: 18-2-5 Time: 上午9:47.
 */
public class BoundClassReference {
  public static void main(String[] args) {
    Class<? extends Number> bounded = int.class;
    bounded = double.class;
    bounded = Number.class;
    // or anything else derived from Number.
  }
}
