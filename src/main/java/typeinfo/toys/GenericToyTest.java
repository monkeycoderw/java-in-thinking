package typeinfo.toys;

/**
 * @author zhongwei Date: 18-2-6 Time: 上午8:57.
 */
public class GenericToyTest {

  public static void main(String[] args) throws Exception {
    Class<FancyToy> ftClass = FancyToy.class;
    // Produces exact types
    FancyToy fancyToy = ftClass.newInstance();
    Class<? super FancyToy> up = ftClass.getSuperclass();
    // This won't compile
    // Class<Toy> up2 = ftClass.getSuperclass();
    // Only produces Object
    Object obj = up.newInstance();
  }

}
