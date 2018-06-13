package generics;

import java.util.List;

/**
 * @author zhongwei Date: 2018/4/28 Time: 19:45.
 */

interface SuperPower {}

interface XRayVision extends SuperPower {
  void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
  void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
  void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
  POWER power;
  SuperHero(POWER power) { this.power = power; }
  POWER getPower() { return power; }
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {
  POWER power;
  SuperSleuth(POWER power) { super(power); }
  void see() { power.seeThroughWalls(); }
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {
  CanineHero(POWER power) { super(power); }
  void hear() { power.hearSubtleNoises(); }
  void smell() { power.trackBySmell(); }
}

class SuperHearSmell implements SuperHearing,SuperSmell {
  public void hearSubtleNoises() { System.out.println("hear subtle noise!"); }
  public void trackBySmell() { System.out.println("track by smell"); }
}

class DogBoy extends CanineHero<SuperHearSmell> {
  DogBoy() { super(new SuperHearSmell()); }
}

public class EpicBattle {
  static <POWER extends SuperHearing> void  useSuperHearing(SuperHero<POWER> hero) {
    hero.getPower().hearSubtleNoises();
  }
  static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
    hero.getPower().hearSubtleNoises();
    hero.getPower().trackBySmell();
  }
  public static void main(String[] args) {
    DogBoy dogBoy = new DogBoy();
    useSuperHearing(dogBoy);
    superFind(dogBoy);
    List<? extends SuperHearing> audioBoys;
  }
}
