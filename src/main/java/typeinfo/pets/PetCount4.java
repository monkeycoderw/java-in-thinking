package typeinfo.pets;

import typeinfo.TypeCounter;

/**
 * @author zhongwei Date: 18-2-7 Time: 下午7:58.
 */
public class PetCount4 {
  public static void main(String[] args) {
    TypeCounter counter = new TypeCounter(Pet.class);
    for(Pet pet : Pets.createArray(20)) {
      System.out.println(pet.getClass().getSimpleName() + " ");
      counter.count(pet);
    }
    System.out.println(counter.toString());
  }
}
