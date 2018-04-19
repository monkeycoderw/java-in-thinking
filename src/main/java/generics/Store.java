package generics;

import sun.nio.cs.Surrogate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhongwei Date: 2018/4/19 Time: 11:16.
 */

class Product {
  private final int id;
  private String description;
  private double price;

  public Product(int IDNumber, String desc, double price) {
    this.id = IDNumber;
    this.description = desc;
    this.price = price;
    System.out.println(toString());
  }

  public String toString() {
    return "id:" + this.id + ", description:" + this.description + ", price:" + this.price;
  }

  public void priceChage(double change) {
    this.price += change;
  }

  public static Generator<Product> generator =
    new Generator<Product>() {
      private Random random = new Random();
      @Override public Product next() {
        return new Product(random.nextInt(1000), "Test", Math.round(random.nextDouble() * 1000.0) + 0.99);
      }
    };
}

class Shelf extends ArrayList<Product> {
  public Shelf(int nProduct) {
    Generators.fill(this, Product.generator, nProduct);
  }
}

class Asile extends ArrayList<Shelf> {
  public Asile(int nShelf, int nProduct) {
    for(int i = 0; i < nShelf; i++) {
      add(new Shelf(nProduct));
    }
  }
}

class CheckoutStand {}

class Office {}

public class Store extends ArrayList<Asile> {
  private List<CheckoutStand> checkouts = new ArrayList<>();
  private Office office = new Office();
  public Store (int nAsile, int nShelf, int nProduct) {
    for (int i = 0; i < nAsile; i++) {
      add(new Asile(nShelf, nProduct));
    }
  }

  public String toString() {
    StringBuilder result = new StringBuilder();
    for(Asile a : this) {
      for (Shelf s : a) {
        for (Product p : s) {
          result.append(p.toString() + "\n");
        }
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Store(5,6,10));
  }
}
