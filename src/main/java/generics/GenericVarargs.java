package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhongwei Date: 2018/4/17 Time: 19:39.
 */
public class GenericVarargs {

  public static <T> List<T> makeList(T... args) {
    List<T> list = new ArrayList<T>();
    for(T t : args) {
      list.add(t);
    }
    return list;
  }

  public static void main(String[] args) {
    List<String> lss = makeList("A");
    System.out.println(lss);
    lss = makeList("A", "B", "C");
    System.out.println(lss);
    lss = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
    System.out.println(lss);
  }
}
