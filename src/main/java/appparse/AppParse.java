package appparse;

import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import net.dongliu.apk.parser.bean.Icon;
import net.dongliu.apk.parser.bean.UseFeature;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;

/**
 * @author zhongwei Date: 2018/5/11 Time: 14:30.
 */
public class AppParse {

  static void byte2image(byte[] data,String path){
    if(data.length<3||path.equals("")) return;
    try{
      FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
      imageOutput.write(data, 0, data.length);
      imageOutput.close();
      System.out.println("Make Picture success,Please find image in " + path);
    } catch(Exception ex) {
      System.out.println("Exception: " + ex);
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    try {
      String filePath = "C:\\Users\\zhongwei\\Downloads\\test07.apk";
      String iconPath = "C:\\Users\\zhongwei\\Downloads\\";
      File file = new File(filePath);
      System.out.println("filePath:" + file.getAbsolutePath());
      try (ApkFile apkFile = new ApkFile(new File(filePath))) {
        ApkMeta apkMeta = apkFile.getApkMeta();
        System.out.println("Label:" + apkMeta.getLabel());
        System.out.println("PackageName:" + apkMeta.getPackageName());
        System.out.println("VersionName:" + apkMeta.getVersionName());
        System.out.println("VersionCode:" + apkMeta.getVersionCode());
        for (UseFeature feature : apkMeta.getUsesFeatures()) {
          System.out.println(feature.getName());
        }

        Icon icon = apkFile.getIconFile();
        System.out.println(String.format("Density:%s, Path:%s", icon.getDensity(), icon.getPath()));
        String[] iconResArray =icon.getPath().split("/");
        String iconName = iconResArray[iconResArray.length - 1];
        iconPath += iconName;
        System.out.println("iconPath:" + iconPath);
        if (icon.getData() != null) {
          byte2image(icon.getData(), iconPath);
        }
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

}
