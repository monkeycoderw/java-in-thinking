package generics;

/**
 * 捕获异常
 * @author zhongwei Date: 2018/5/11 Time: 9:50.
 */
public class CaptureConversion {
  static <T> void f1(Holder<T> holder) {
    T t = holder.getValue();
    System.out.println("SimpleName:" + t.getClass().getSimpleName());
  }
  static void f2(Holder<?> holder) {
    f1(holder);
  }
  public static void main(String[] args) {
    Holder raw = new Holder<Integer>(1);
    f1(raw);
    f2(raw);
    Holder rawBasic = new Holder();
    System.out.println("rawBasic:" + rawBasic.getValue());
    rawBasic.setValue(new Object());
    f2(rawBasic);
    Holder<?> wildcarded = new Holder<Double>(1.0);
    f2(wildcarded);
  }
}
