package net.mindview.util;

import java.util.*;

/**
 * @author zhongwei Date: 2018/4/17 Time: 10:23.
 */
public class New {

  public static <K,V> Map<K,V> map() {
    return new HashMap<K,V>();
  }

  public static <T> List<T> list() {
    return new ArrayList<T>();
  }

  public static <T> LinkedList<T> llist() {
    return new LinkedList<T>();
  }

  public static <T> Set<T> set() {
    return new HashSet<T>();
  }

  public static <T> Queue<T> queue() {
    return new LinkedList<T>();
  }

  public static void main(String[] args) {
    Map<String, List<String>> sls = New.map();
    List<String> ls = New.list();
    LinkedList<String> lls = New.llist();
    Set<String> ss = New.set();
    Queue<String> qs = New.queue();

  }
}
