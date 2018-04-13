package typeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author zhongwei Date: 18-2-7 Time: 下午8:15.
 */
class Part {
  private static Random random = new Random();
  public static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();

  static {
    partFactories.add(new FuelFilter.Factory());
    partFactories.add(new AirFilter.Factory());
    partFactories.add(new CabinFilter.Factory());
    partFactories.add(new OilFilter.Factory());
    partFactories.add(new FanBelt.Factory());
    partFactories.add(new GeneratorBelt.Factory());
    partFactories.add(new PowerSteeringBelt.Factory());
  }

  public static Part ceateRandom() {
    int n = random.nextInt(partFactories.size());
    return partFactories.get(n).create();
  }

  public String toString() {
    return getClass().getSimpleName();
  }
}

class Filter extends Part {}

class FuelFilter extends Filter {
  public static class Factory implements typeinfo.Factory<FuelFilter> {
    public FuelFilter create() { return new FuelFilter();}
  }
}

class AirFilter extends Filter {
  public static class Factory implements typeinfo.Factory<AirFilter> {
    public AirFilter create() { return new AirFilter();}
  }
}

class CabinFilter extends Filter {
  public static class Factory implements typeinfo.Factory<CabinFilter> {
    public CabinFilter create() { return new CabinFilter();}
  }
}

class OilFilter extends Filter {
  public static class Factory implements typeinfo.Factory<OilFilter> {
    public OilFilter create() { return new OilFilter();}
  }
}

class Belt extends Part {}

class FanBelt extends Belt {
  public static class Factory implements typeinfo.Factory<FanBelt> {
    public FanBelt create() { return new FanBelt();}
  }
}

class GeneratorBelt extends Belt {
  public static class Factory implements typeinfo.Factory<GeneratorBelt> {
    public GeneratorBelt create() { return new GeneratorBelt();}
  }
}

class PowerSteeringBelt extends Belt {
  public static class Factory implements typeinfo.Factory<PowerSteeringBelt> {
    public PowerSteeringBelt create() { return new PowerSteeringBelt();}
  }
}

public class RegisteredFactories {
  public static void main(String[] args) {
    for(int i = 0; i < 10; i++) {
      System.out.println(Part.ceateRandom());
    }
  }
}
