package generics;

import java.util.EnumSet;
import java.util.Set;

import static generics.WaterColors.*;
import static net.mindview.util.Sets.*;

/**
 * @author zhongwei Date: 2018/4/18 Time: 12:01.
 */
public class WaterColorSets {

  public static void main(String[] args) {
    Set<WaterColors> set1 = EnumSet.range(B, N);
    Set<WaterColors> set2 = EnumSet.range(H, Z);
    System.out.println("set1:" + set1 + ", size1:" + set1.size());
    System.out.println("set2:" + set2 + ", size2:" + set2.size());
    System.out.println("union(set1,set2):" + union(set1, set2));
    Set<WaterColors> subSet = intersection(set1, set2);
    System.out.println("intersection(set1, set2):" + subSet);
    System.out.println("difference(set1, subSet):" + difference(set1, subSet));
    System.out.println("difference(set2, subSet):" + difference(set2, subSet));
    System.out.println("complement(set1, set2):" + complement(set1, set2));
  }
}
