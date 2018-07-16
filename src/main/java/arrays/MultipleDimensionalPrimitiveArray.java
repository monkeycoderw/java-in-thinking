package arrays;

import java.util.Arrays;

/**
 * @author zhongwei Date: 2018/6/15 Time: 9:31.
 */
public class MultipleDimensionalPrimitiveArray {
  public static void main(String[] args) {
    int[][] a  = {
      { 1, 2, 3, },
      { 4, 5, 6, },
    };
    System.out.println(Arrays.deepToString(a));
  }
}
