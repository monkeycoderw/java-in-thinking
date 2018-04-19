package generics;

import java.util.*;

/**
 * @author zhongwei Date: 2018/4/19 Time: 10:32.
 */

class Customer {
  private static long counter = 0;
  private final long id = counter++;
  private Customer(){}
  public String toString() {
    return "Customer " + id;
  }
  public static Generator<Customer> generator() {
    return new Generator<Customer>() {
      @Override public Customer next() {
        return new Customer();
      }
    };
  }
}

class Teller {
  private static long counter = 0;
  private final long id = counter++;
  private Teller(){}
  public String toString() {
    return "Teller " + id;
  }
  public static Generator<Teller> generator() {
    return new Generator<Teller>() {
      @Override public Teller next() {
        return new Teller();
      }
    };
  }
}

public class BankTeller {

  public static void server(Teller t, Customer c) {
    System.out.println(t + " serves " + c);
  }
  public static void main(String[] args) {
    Random rand = new Random();
    Queue<Customer> line = new LinkedList<>();
    Generators.fill(line, Customer.generator(), 15);
    List<Teller> tellers = new ArrayList<>();
    Generators.fill(tellers, Teller.generator(), 4);
    for(Customer c : line) {
      server(tellers.get(rand.nextInt(tellers.size())), c);
    }
  }

}
