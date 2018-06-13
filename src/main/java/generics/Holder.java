package generics;

/**
 * @author zhongwei Date: 2018/5/4 Time: 9:36.
 */
public class Holder<T> {

  private T value;

  public Holder() {}
  public Holder(T value) { this.value = value; }
  public T getValue() { return this.value; }
  public void setValue(T value) { this.value = value; }
  public boolean equals(Object obj) { return value.equals(obj); }

  public static void main(String[] args) {
    Holder<Apple> appleHolder = new Holder<>(new Apple());
    Apple apple = appleHolder.getValue();
    appleHolder.setValue(apple);
    Holder<? extends Fruit> fruit = appleHolder;
    Apple afruit = (Apple) fruit.getValue();
    try {
      Orange orange = (Orange) fruit.getValue();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println(fruit.equals(apple));
  }
}
