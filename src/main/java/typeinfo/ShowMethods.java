package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author zhongwei Date: 18-2-8 Time: 上午9:37.
 */
public class ShowMethods {
  private static String usage = "usage:\n" +
    "ShowMethods qualified.class.name\n" +
    "To show all methods in class or:\n" +
    "ShowMethods qualified.class.name word\n" +
    "To search for methods involing 'word'";
  private static Pattern pattern = Pattern.compile("\\w+\\.");

  public static void main(String[] args) {
    if(args.length < 1) {
      System.out.println(usage);
      System.exit(0);
    }
    System.out.println("args:" + args[0]);
    int lines = 0;
    try {
      Class<?> c = Class.forName(args[0]);
      Method[] methods = c.getMethods();
      Constructor[] ctors = c.getConstructors();
      if (args.length == 1) {
        for(Method method : methods) {
          System.out.println(pattern.matcher(method.toString()).replaceAll(""));
        }
        for(Constructor constructor : ctors) {
          System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
        }
      } else {
        for(Method method : methods) {
          if(method.toString().indexOf(args[1]) != -1) {
            System.out.println(pattern.matcher(method.toString()).replaceAll(""));
            lines++; // why
          }
        }
        for(Constructor constructor : ctors) {
          if(constructor.toString().indexOf(args[1]) != -1) {
            System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
            lines++;
          }
        }
      }
    } catch (ClassNotFoundException e) {
      System.out.println("Not such class:" + e);
    }
  }
}
