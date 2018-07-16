package typeinfo;

/**
 * @author zhongwei Date: 18-2-12 Time: 上午9:28.
 */
interface Null {}

public class Person {
  public final String first;
  public final String last;
  public final String address;

  public Person(String first, String last, String address) {
    this.first = first;
    this.last = last;
    this.address = address;
  }

  public String toString() {
    return "Person: " + first + " " + last + " " + address + "\n";
  }

  public static class NullPerson extends Person implements Null {
    private NullPerson() { super("None", "None", "None"); }
    public String toString() { return "NullPerson\n"; }
  }

  public static final Person NULL = new NullPerson();
}
