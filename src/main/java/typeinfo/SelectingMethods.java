package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhongwei Date: 18-2-11 Time: 下午8:15.
 */
class MethodSelector implements InvocationHandler {

  private Object proxied;

  public MethodSelector(Object proxied) {
    this.proxied = proxied;
  }

  @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("method name:" + method);

    if (method.getName().equals("interesting")) {
      System.out.println("Proxy detected the interesting method");
      //return method.invoke(proxy, args);
    }
    return method.invoke(proxy, args);
  }
}

interface SomeMethods {
  void boring1 ();
  void boring2 ();
  void boring3 ();
  void interesting(String arg);
}

class Implementation implements SomeMethods {

  @Override public void boring1() {
    System.out.println("boring1");
  }

  @Override public void boring2() {
    System.out.println("boring2");
  }

  @Override public void boring3() {
    System.out.println("boring3");
  }

  @Override public void interesting(String arg) {
    System.out.println("interesting " + arg);
  }
}

public class SelectingMethods {
  public static void main(String[] args) {
    new Implementation().boring1();
    SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
      SomeMethods.class.getClassLoader(),
      new Class[] { SomeMethods.class },
      new MethodSelector(new Implementation()));
    System.out.println(proxy.getClass().getSimpleName());
    System.out.println(proxy.getClass().getCanonicalName());
    for(Method method : proxy.getClass().getMethods()) {
      System.out.println(method);
    }
    proxy.boring3();
    // proxy.boring1();
    // proxy.boring2();
    // proxy.interesting("bonobo");
    // proxy.boring3();
  }
}
