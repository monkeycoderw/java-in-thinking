package generics;

import net.mindview.util.BasicGenerator;

/**
 * @author zhongwei Date: 2018/4/17 Time: 20:29.
 */
public class BasicGeneratorDemo {

  public static void main(String[] args) {
    Generator<CountedObject> gen = BasicGenerator.creator(CountedObject.class);

    for(int i = 0; i < 5; i++) {
      System.out.println(gen.next());
    }
  }
}
