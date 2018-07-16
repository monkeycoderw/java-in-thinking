package net.mindview.util;

import generics.Generator;

/**
 * @author zhongwei Date: 2018/4/17 Time: 20:17.
 */
public class BasicGenerator<T> implements Generator<T> {

  private Class<T> type;

  public BasicGenerator(Class<T> type) { this.type = type; }

  public T next() {
    try {
      return type.newInstance();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> Generator<T> creator(Class<T> type) {
    return new BasicGenerator<T>(type);
  }
}
