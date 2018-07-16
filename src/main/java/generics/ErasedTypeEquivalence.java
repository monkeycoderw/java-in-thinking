package generics;

import java.util.ArrayList;

/**
 * @author zhongwei Date: 2018/4/19 Time: 22:44.
 */
public class ErasedTypeEquivalence {

  public static void main(String[] args) {
    Class c1 = new ArrayList<String>().getClass();
    Class c2 = new ArrayList<Integer>().getClass();
    System.out.println(c1 == c2);
  }
}
