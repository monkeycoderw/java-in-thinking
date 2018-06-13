package generics;
/**
 * @author zhongwei Date: 2018/5/4 Time: 9:08.
 */
class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
public class CovariantArrays {
  public static void main(String[] args) {
    Fruit[] fruits = new Apple[10];
    fruits[0] = new Apple();
    fruits[1] = new Jonathan();
    // Runtime type is apple, not Fruit, not Orange;
    try {
      // compiler allow you add fruit
      fruits[2] = new Fruit();
    } catch (Exception e) {
      System.out.println(e);
    }
    try {
      // compiler allow you add orange
      fruits[3] = new Orange();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
