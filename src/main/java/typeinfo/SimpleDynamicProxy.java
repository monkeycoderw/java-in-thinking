package typeinfo;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhongwei Date: 18-2-11 Time: 上午9:59.
 */
class DynamicProxyHandler implements InvocationHandler {
  private Object proxied;

  public DynamicProxyHandler(Object proxied) {
    this.proxied = proxied;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("**** proxy: " + proxy.getClass() + ", method:" + method + ", args:" + args);
    if(args != null) {
      for(Object arg : args) {
        System.out.println(" " + arg);
      }
    }
    return method.invoke(proxied, args);
  }
}

public class SimpleDynamicProxy {
  public static void consumer(Interface iface) {
    iface.doSomething();
    iface.somethingElse("bonono");
  }

  public static void main(String[] args) {
    RealObject real = new RealObject();
    consumer(real);
    // insert a proxy and call again:
    Interface proxy = (Interface) Proxy.newProxyInstance(
      Interface.class.getClassLoader(),
      new Class[]{ Interface.class },
      (InvocationHandler) new DynamicProxyHandler(real)
    );
    consumer(proxy);
  }
}
