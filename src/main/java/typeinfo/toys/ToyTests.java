package typeinfo.toys;

/**
 * @author zhongwei Date: 18-1-30 Time: 上午9:50.
 */

interface HasBatters {}

interface Waterproof {}

interface Shoots {}

class Toy {
  Toy() {}
  Toy(int i) {}
}

class FancyToy extends Toy implements HasBatters, Waterproof, Shoots {
  FancyToy() { super(); }
}
public class ToyTests {
  static void printInfo(Class cc) {
    System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
    System.out.println("Simple name: " + cc.getSimpleName());
    System.out.println("Canonical name:" + cc.getCanonicalName());
  }
  public static void main(String[] args) {
    Class c = null;
    try {
      c = Class.forName("typeinfo.toys.FancyToy");
    } catch (ClassNotFoundException e) {
      System.out.println("Cann't find FancyToy!");
    }
    printInfo(c);
    for(Class face : c.getInterfaces()) {
      printInfo(face);
    }
    Class up = c.getSuperclass();
    Object obj = null;
    try {
      obj = up.newInstance();
    } catch (InstantiationException e) {
      System.out.println("Cannot instantiate");
      System.exit(1);
    } catch (IllegalAccessException e) {
      System.out.println("Cannot access");
      System.exit(1);
    }
    printInfo(obj.getClass());
  }
}
