package generics;

/**
 * @author zhongwei Date: 2018/4/17 Time: 10:09.
 */
public class GenericMethods {

  public <T> void f(T x) {
    System.out.println(x.getClass().getSimpleName() + ", ");
  }

  public static void main(String[] args) {
    GenericMethods gen = new GenericMethods();
    gen.f("");
    gen.f(1);
    gen.f(1.0);
    gen.f(1.0F);
    gen.f('c');
    gen.f(gen);
  }

}
