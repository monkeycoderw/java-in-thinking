package generics;

import java.util.List;

/**
 * @author zhongwei Date: 2018/5/4 Time: 9:48.
 */
public class SuperTypeWildCards {

   public static void writeTo(List<? super Apple> apples) {
    apples.add(new Apple());
    apples.add(new Jonathan());
  }

}
