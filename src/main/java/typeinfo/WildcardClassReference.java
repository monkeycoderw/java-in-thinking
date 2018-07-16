package typeinfo;

/**
 * @author zhongwei Date: 18-2-5 Time: 上午9:42.
 */
public class WildcardClassReference {
  public static void main(String[] args) {
    Class<?> intClass = int.class;
    intClass = double.class;
  }
}
