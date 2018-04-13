package typeinfo;

/**
 * @author zhongwei Date: 18-2-5 Time: 上午9:37.
 */
public class GenericClassReference {
    public static void main(String[] args) {
      Class intClass = int.class;
      Class<Integer> genericIntClass = int.class;
      genericIntClass = Integer.class;
      intClass = double.class;
      // genericIntClass = double.class;
    }
}
