package appparse;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @author zhongwei Date: 2018/5/17 Time: 20:28.
 */
public class Test {
  public static void main(String[] args) {

//    try {
    ////      String uuid = UUID.randomUUID().toString().replace("-", "");
    ////      System.out.println("uuid:" + uuid + ", length:" + uuid.length());
    ////
    ////
    ////      // uuid:df46e9083ca64b919a66c397145c335f, length:32
    ////      String nanoTime = String.valueOf(System.nanoTime());
    ////      System.out.println("nanoTime:" + nanoTime + ", length:" + nanoTime.length());
    ////      String timestamp = String.valueOf(System.currentTimeMillis());
    ////      System.out.println("timestamp:" + timestamp + ", length:" + timestamp.length());
    ////
    ////      // 先进行MD5加密
    ////      MessageDigest md5 = MessageDigest.getInstance("md5");
    ////      // 对数据进行加密
    ////      byte[] bs = md5.digest(uuid.getBytes());
    ////      String md5Str = new String(bs);
    ////      System.out.println("md5Str:" + md5Str + ", length:" + md5Str.length());
    ////
    ////      /*
    ////       * BASE64Encoder所在包的引入方式（Eclipse）： 在Java Build Path下的
    ////       * Libraries中拉开JRE，然后点击 第一个选项Access rules（双击），然后点击add，在上面的框中选择
    ////       * Accessible，下面输入**，保存即可引入相应的包。
    ////       *
    ////       * BASE64Encoder底层实现原理：三字节变四字节
    ////       */
    ////      // 采用数据指纹进一步加密，拿到数据指纹
    ////      BASE64Encoder base = new BASE64Encoder();
    ////      // 进一步加密
    ////      String  fingerPrints = base.encode(bs);
    ////      System.out.println("fingerPrints:" + fingerPrints + ", length:" + fingerPrints.length());
    ////
    ////    } catch (Exception e) {
    ////      System.out.println(e);
    ////    }
    String name = "M-wo";
    String pattern = "^[0-9a-zA-Z-]*$";
    if (!Pattern.matches(pattern, name)) {
      System.out.println("It's not legal!");
    } else {
      System.out.println("It's legal!");
    }
  }
}
