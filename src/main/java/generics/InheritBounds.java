package generics;

import java.awt.*;

/**
 * @author zhongwei Date: 2018/4/27 Time: 22:52.
 */

class HoldItem<T> {
  T item;
  public HoldItem(T t) { item = t; }
  T getItem() { return item; }
}

class Colored2<T extends HasColor> extends HoldItem<T> {
  Colored2(T item) {super(item);}
  Color getColor() { return item.getColor(); }
}

class ColoredDimension2 <T extends Dimension & HasColor> extends Colored2<T> {
  ColoredDimension2(T item) { super(item); }
  int getX() { return item.x; }
  int getY() { return item.y; }
  int getZ() { return item.z; }
}

class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension2<T> {
  Solid2(T item) { super(item); }
  int getWeight() { return item.getWeight(); }
}

public class InheritBounds {
  public static void main(String[] args) {
    Solid2<Bound> solid2 = new Solid2<>(new Bound());
    solid2.getColor();
    solid2.getWeight();
    solid2.getX();

    System.out.println("Color:" + solid2.getColor());
    System.out.println(String.format("X:%s, Y:%s, Z:%s", solid2.getX(), solid2.getY(),solid2.getZ()));
    System.out.println("Weight:" + solid2.getWeight());
  }
}
