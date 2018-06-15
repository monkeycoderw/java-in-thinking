package arrays;

import java.util.Arrays;

/**
 * @author zhongwei Date: 2018/6/15 Time: 9:44.
 */
public class MultidimensinalObjectArrays {
  public static void main(String[] args) {
    BerylliumSphere[][] spheres = {
      { new BerylliumSphere(), new BerylliumSphere()},
      { new BerylliumSphere(), new BerylliumSphere(),
        new BerylliumSphere(), new BerylliumSphere()},
      { new BerylliumSphere(), new BerylliumSphere(),
        new BerylliumSphere(), new BerylliumSphere(),
        new BerylliumSphere(), new BerylliumSphere()},
    };
    System.out.println(Arrays.deepToString(spheres));
  }
}
