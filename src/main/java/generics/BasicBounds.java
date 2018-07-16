package generics;

import java.awt.*;

/**
 * @author zhongwei Date: 2018/4/28 Time: 9:23.
 */

interface HasColor { java.awt.Color getColor(); }

class Colored<T extends HasColor> {
  T item;
  Colored(T item) { this.item = item; }
  T getItem() { return this.item; }
  java.awt.Color color() { return item.getColor(); }
}

class Dimension { public int x, y, z; }

class ColoredDimension<T extends Dimension & HasColor> {
  T item;
  ColoredDimension(T item) { this.item = item; }
  java.awt.Color color() {  return item.getColor(); }
  int getX() { return item.x; }
  int getY() { return item.y; }
  int getZ() { return item.z; }
}

interface Weight { int getWeight(); }

class Solid<T extends Dimension & HasColor & Weight> {
  T item;
  Solid(T item) { this.item = item; }
  T getItem() { return item; }
  Color getColor() { return item.getColor(); }
  int getX() { return item.x; }
  int getY() { return item.y; }
  int getZ() { return item.z; }
  int getWeight() { return item.getWeight(); }
}

class Bound extends Dimension implements HasColor,Weight {

  @Override public java.awt.Color getColor() {
    return Color.red;
  }

  @Override public int getWeight() {
    return 2;
  }
}

public class BasicBounds {

  public static void main(String[] args) {
    Solid<Bound> solid = new Solid<>(new Bound());
    System.out.println("Color:" + solid.getColor());
    System.out.println(String.format("X:%s, Y:%s, Z:%s", solid.getX(), solid.getY(),solid.getZ()));
    System.out.println("Weight" + solid.getWeight());
  }
}
