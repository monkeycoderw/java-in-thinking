package generics;

/**
 * @author zhongwei Date: 2018/4/25 Time: 9:45.
 */

interface FactoryI<T> {
  T create();
}

class Foo2<T> {
  private T x;
  public <F extends FactoryI<T>> Foo2(F f) {
    x = f.create();
  }
}

class IntegerFactory implements FactoryI<Integer> {
  public Integer create() {
    return new Integer(0);
  }
}

class Widget {
  public static class Factory implements FactoryI<Widget> {
    public Widget create() {
      return new Widget();
    }
  }
}

public class FactoryConstraint {
  public static void main(String[] args) {
    new Foo2<>(new IntegerFactory());
    new Foo2<>(new Widget.Factory());
  }
}
