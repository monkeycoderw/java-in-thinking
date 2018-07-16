package typeinfo;

class Building {}
class House extends Building {}

/**
 * @author zhongwei Date: 18-2-6 Time: 上午9:05.
 */
public class ClassCasts {

  public static void main(String[] args) {
    Building b = new House();
    Class<House> houseType = House.class;
    House h = houseType.cast(b);
    h = (House) b;
    
  }

}
