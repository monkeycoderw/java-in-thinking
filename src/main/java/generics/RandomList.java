package generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author zhongwei Date: 2018/4/13 Time: 18:52.
 */
public class RandomList<T> {

  private ArrayList<T> storage = new ArrayList<>();

  private Random rand = new Random(47);

  public void add(T t) {
    storage.add(t);
  }

  public T select() {
    return storage.get(rand.nextInt(storage.size()));
  }

  public static void main(String[] args) {
    RandomList<String> rs = new RandomList<>();
    for(String s : "The quick brown fox jumped the lazy black dog!".split(" ")) {
      rs.add(s);
    }
    for(int i = 0; i < 11; i++) {
      System.out.println(rs.select());
    }
  }

}
