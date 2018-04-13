package typeinfo.pets;

import java.util.ArrayList;

/**
 * @author zhongwei Date: 18-2-7 Time: 上午9:58.
 */
public class Pets {
  public static final PetCreator creator = new LiteralPetCreator();

  public static Pet randomPet() {
    return creator.randomPet();
  }

  public static Pet[] createArray(int size) {
    return creator.createArray(size);
  }

  public static ArrayList<Pet> arrayList(int size) {
    return creator.arrayList(size);
  }
}
