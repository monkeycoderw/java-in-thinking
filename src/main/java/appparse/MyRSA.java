package appparse;


import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class MyRSA {
  public static final String KEY_ALGORITHM = "RSA";
  /**
   * 貌似默认是RSA/NONE/PKCS1Padding，未验证
   */
  public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
  public static final String PUBLIC_KEY = "publicKey";
  public static final String PRIVATE_KEY = "privateKey";

  /**
   * RSA密钥长度必须是64的倍数，在512~65536之间。默认是2048
   */
  public static final int KEY_SIZE = 2048;

  public static final String PLAIN_TEXT = "100000";

  public static void main(String[] args) {
    // generate
    Map<String, byte[]> keyMap = generateKeyBytes();
    // encrypt
    PublicKey publicKey = restorePublicKey(keyMap.get(PUBLIC_KEY));
    System.out.println("public key:" + publicKey.toString());

    // Decrypt
    PrivateKey privateKey = restorePrivateKey(keyMap.get(PRIVATE_KEY));
    System.out.println("pri key:" + privateKey.toString());

    // 公钥加密，私钥解密
    byte[] pubText = RSAEncode(publicKey, PLAIN_TEXT.getBytes());
    System.out.println("Pub RSA encoded: " + Base64.getEncoder().encodeToString(pubText));
    System.out.println("Pub RSA decoded: " + RSADecode(privateKey, pubText));

    // 私钥加密，公钥解密
    byte[] priText = RSAEncode(privateKey, PLAIN_TEXT.getBytes());
    System.out.println("Pri RSA encoded: " + Base64.getEncoder().encodeToString(priText));
    System.out.println("Pri RSA decoded: " + RSADecode(publicKey, priText));

    try {
      String newPubKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
      System.out.println("newPubKey key:" + newPubKey);
      String newPriKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
      System.out.println("newPriKey key:" + newPriKey);
      PublicKey newPublicKey = restorePublicKey(Base64.getDecoder().decode(newPubKey));
      PrivateKey newPrivateKey = restorePrivateKey(Base64.getDecoder().decode(newPriKey));
      // 私钥加密，公钥解密
      byte[] newPriText = RSAEncode(newPrivateKey, PLAIN_TEXT.getBytes());
      System.out.println("NEW Pri RSA encoded: " + Base64.getEncoder().encodeToString(newPriText));
      System.out.println("NEW Pri RSA decoded: " + RSADecode(newPublicKey, newPriText));
    } catch (Exception e) {

    }




  }

  /**
   * 生成密钥对。注意这里是生成密钥对KeyPair，再由密钥对获取公私钥
   *
   * @return
   */
  public static Map<String, byte[]> generateKeyBytes() {
    try {
      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
      keyPairGenerator.initialize(KEY_SIZE);
      KeyPair keyPair = keyPairGenerator.generateKeyPair();
      RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
      RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

      Map<String, byte[]> keyMap = new HashMap<String, byte[]>();
      keyMap.put(PUBLIC_KEY, publicKey.getEncoded());
      keyMap.put(PRIVATE_KEY, privateKey.getEncoded());
      return keyMap;
    } catch (NoSuchAlgorithmException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 还原公钥，X509EncodedKeySpec 用于构建公钥的规范
   *
   * @param keyBytes
   * @return
   */
  public static PublicKey restorePublicKey(byte[] keyBytes) {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);

    try {
      KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
      PublicKey publicKey = factory.generatePublic(x509EncodedKeySpec);
      return publicKey;
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 还原私钥，PKCS8EncodedKeySpec 用于构建私钥的规范
   *
   * @param keyBytes
   * @return
   */
  public static PrivateKey restorePrivateKey(byte[] keyBytes) {
    PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
    try {
      KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
      PrivateKey privateKey = factory.generatePrivate(pkcs8EncodedKeySpec);
      return privateKey;
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 加密，三步走。
   *
   * @param key
   * @param plainText
   * @return
   */
  public static byte[] RSAEncode(Key key, byte[] plainText) {

    try {
      Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
      cipher.init(Cipher.ENCRYPT_MODE, key);
      return cipher.doFinal(plainText);
    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 解密，三步走。
   *
   * @param key
   * @param encodedText
   * @return
   */
  public static String RSADecode(Key key, byte[] encodedText) {

    try {
      Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
      cipher.init(Cipher.DECRYPT_MODE, key);
      return new String(cipher.doFinal(encodedText));
    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }




}
