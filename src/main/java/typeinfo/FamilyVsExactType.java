package typeinfo;

class Base {}
class Derived extends Base {}

/**
 * @author zhongwei Date: 18-2-8 Time: 上午9:16.
 */
public class FamilyVsExactType {
  public static void test(Object x) {
    System.out.println("\n\nTesting x of type " + x.getClass());
    System.out.println("x instanceof Base " + (x instanceof Base));
    System.out.println("x instanceof Derived " + (x instanceof Derived));
    System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
    System.out.println("Derived.isInstance(x) " + Derived.class.isInstance(x));
    System.out.println("x.getClass() == Base.class " + (x.getClass() == Base.class));
    System.out.println("x.getClass() == Derived " + (x.getClass() == Derived.class));
    System.out.println("x.getClass().equal(Base.class)" + (x.getClass().equals(Base.class)));
    System.out.println("x.getClass().equal(Derived.class)" + (x.getClass().equals(Derived.class)));
  }

  public static void main(String[] args) {
    test(new Base());
    test(new Derived());
  }
}
