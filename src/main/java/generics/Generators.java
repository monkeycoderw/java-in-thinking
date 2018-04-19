package generics;

import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhongwei Date: 2018/4/17 Time: 19:54.
 */
public class Generators {

  public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
    for(int i = 0; i < n; i++) {
      coll.add(gen.next());
    }
    return coll;
  }
  public static void main(String[] args) {
    Collection<Coffee> coffees = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 5);
    for(Coffee c : coffees) {
      System.out.println(c);
    }
    Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
    for(Integer f : fnumbers) {
      System.out.println(f);
    }
  }
}
