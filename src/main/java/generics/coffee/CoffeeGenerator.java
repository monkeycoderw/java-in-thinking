package generics.coffee;

import generics.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @author zhongwei Date: 2018/4/16 Time: 22:43.
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

  private Class[] types = {Americano.class, Breve.class, Cappuccino.class, Latte.class, Mocha.class};

  private static Random random = new Random(47);

  public CoffeeGenerator() {}

  private int size = 0;

  public CoffeeGenerator(int sz) { size = sz; }

  @Override public Coffee next() {
    try {
      return (Coffee)types[random.nextInt(types.length)].newInstance();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  class CoffeeIterator implements Iterator<Coffee> {
    int count = size;
    public boolean hasNext() { return count > 0;}
    public Coffee next() {
      count--;
      return CoffeeGenerator.this.next();
    }
    public void remove(){}
  }

  public Iterator<Coffee> iterator() {
    return new CoffeeIterator();
  }

  public static void main(String[] args) {
    CoffeeGenerator gen  = new CoffeeGenerator();
    for (int i = 0; i < 5; i++) {
      System.out.println(gen.next());
    }
    for(Coffee c : new CoffeeGenerator(5)) {
      System.out.println(gen.next());
    }
  }

}
