package typeinfo;

/**
 * @author zhongwei Date: 18-2-11 Time: 上午9:25.
 */
interface Interface {
  void doSomething();
  void somethingElse(String arg);
}

class RealObject implements Interface {
  @Override public void doSomething() {
    System.out.println("doSomething");
  }

  @Override public void somethingElse(String arg) {
    System.out.println("SomethingElse " + arg);
  }
}

class SimpleProxy implements Interface {
  private Interface proxied;

  public SimpleProxy(Interface proxied) {
    this.proxied = proxied;
  }

  public void doSomething() {
    System.out.println("SimpleProxy doSomething");
    proxied.doSomething();
  }

  public void somethingElse(String args) {
    System.out.println("SimpleProxy somethingElse " + args);
    proxied.somethingElse(args);
  }
}

public class SimpleProxyDemo {
  public static void consumer(Interface iface) {
    iface.doSomething();
    iface.somethingElse("bonobo");
  }

  public static void main(String[] args) {
    consumer(new RealObject());
    consumer(new SimpleProxy(new RealObject()));
  }
}
