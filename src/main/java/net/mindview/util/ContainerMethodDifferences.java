package net.mindview.util;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author zhongwei Date: 2018/4/18 Time: 22:36.
 */
public class ContainerMethodDifferences {

  static Set<String> methodSet(Class<?> type) {
    Set<String> result = new TreeSet<>();
    for(Method m : type.getMethods()) {
      result.add(m.getName());
    }
    return result;
  }

  static void interfaces(Class<?> type) {
    System.out.println("Interfaces in " + type.getSimpleName() + ":");
    List<String> result = new ArrayList<>();
    for(Class<?> c : type.getInterfaces()) {
      result.add(c.getSimpleName());
    }
    System.out.println(result.toString());
  }

  static Set<String> object = methodSet(Object.class);
  static {
    object.add("clone");
  }

  static void difference(Class<?> superset, Class<?> subset) {
    System.out.println(superset.getSimpleName() + " is extends " + subset.getSimpleName() + ", adds:");
    Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
    comp.removeAll(object);
    System.out.println(comp.toString());
    interfaces(superset);
  }

  public static void main(String[] args) {
    System.out.println("Collection: " + methodSet(Collection.class));
    interfaces(Collection.class);
    difference(Set.class, Collection.class);
    difference(HashSet.class, Set.class);
    difference(LinkedHashSet.class, HashSet.class);
    difference(TreeSet.class, Set.class);
    difference(List.class, Collection.class);
    difference(ArrayList.class, List.class);
    difference(LinkedList.class, List.class);
    difference(Queue.class, Collection.class);
    difference(PriorityQueue.class, Queue.class);
    difference(Map.class, Collection.class);
    difference(HashMap.class, Map.class);
    difference(LinkedHashMap.class, HashMap.class);
    difference(SortedMap.class, Map.class);
    difference(TreeMap.class, Map.class);
  }
}
