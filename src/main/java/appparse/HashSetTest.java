package appparse;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @author zhongwei Date: 2018/5/28 Time: 20:25.
 */
public class HashSetTest {

  public static void main(String[] args) {
    List<String> pkgTypes = Lists.newArrayList("apk", "APK");
    List<String> picTypes =
      Lists.newArrayList("JPEG", "jpeg", "JPG", "jpg", "GIF", "gif", "BMP", "bmp", "PNG", "png");
    System.out.println(pkgTypes.contains("apk"));
    String fileName = "test03.jpg";
    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
    System.out.println("suffix:" + suffix);
  }

}
