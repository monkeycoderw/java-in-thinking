package generics;

import java.lang.reflect.Array;

/**
 * @author zhongwei Date: 2018/4/26 Time: 10:28.
 */
public class GenericArrayWithTypeToken<T> {

  private T[] array;

  public GenericArrayWithTypeToken(Class<T> type, int sz) {
    array = (T[]) Array.newInstance(type, sz);
  }

  public void put(int index, T item) {
    array[index] = item;
  }

  public T get(int index) {
    return array[index];
  }

  public T[] rep() {
    return array;
  }

  public static void main(String[] args) {
    GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
    Integer[] ai = gai.rep();
    System.out.println(ai.toString());
    for(int i = 0; i < 10; i ++) {
      System.out.println(ai[i]);
    }
  }
}
