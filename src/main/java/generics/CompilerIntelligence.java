package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhongwei Date: 2018/5/4 Time: 9:27.
 */
public class CompilerIntelligence {
  public static void main(String[] args) {
    List<? extends Fruit> flist = Arrays.asList(new Apple());
    Apple apple = (Apple) flist.get(0);
    System.out.println("flist.contains(new Fruit()) result : " + flist.contains(new Fruit()));
    System.out.println("flist.indexOf(new Fruit()) result : " + flist.indexOf(new Fruit()));

    System.out.println("flist.contains(new Apple()) result : " + flist.contains(new Apple()));
    System.out.println("flist.indexOf(new Apple()) result : " + flist.indexOf(new Apple()));

    System.out.println("flist.contains(new Apple()) result : " + flist.contains(apple));
    System.out.println("flist.indexOf(new Apple()) result : " + flist.indexOf(apple));

  }
}
