package typeinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhongwei Date: 18-1-30 Time: 上午9:27.
 */
public abstract class Shape {
  void draw() { System.out.println(this + ".draw()"); }
  abstract public String toString();
}

class Circle extends Shape {
  public String toString() { return "Circle:"; }
}

class Square extends Shape {
  public String toString() { return "Square:"; }
}

class Triangle extends Shape {
  public String toString() { return "Triangle"; }
}

class Shapes {
  public static void main(String[] args) {
    List<Shape> shapeList = Arrays.asList(
      new Circle(), new Square(), new Triangle()
    );
    for(Shape shape : shapeList) {
      shape.draw();
    }
  }
}
