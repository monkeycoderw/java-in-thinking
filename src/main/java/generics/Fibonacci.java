package generics;

/**
 * @author zhongwei Date: 2018/4/17 Time: 9:37.
 */
public class Fibonacci implements Generator<Integer> {

  private int count = 0;

  public Integer next() { return fib(count++); }

  private Integer fib(int n) {
    if (n < 1) return 1;
    return fib(n-1) + fib(n -2);
  }

  public static void main(String[] args) {
    Fibonacci gen = new Fibonacci();
    for (int i = 0; i < 9; i++) {
      System.out.println(gen.next() + ", ");
    }

  }
}
