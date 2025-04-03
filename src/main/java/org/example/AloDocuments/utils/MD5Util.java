package org.example.AloDocuments.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    /**
     * 将明文密码进行 MD5 加密
     *
     * @param plainText 明文密码
     * @return 密文密码
     */
    public static String getMD5String(String plainText) {
        try {
            // 获取 MD5 加密算法的实例
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 将明文密码转换为字节数组
            byte[] inputBytes = plainText.getBytes();
            // 使用 MD5 算法对字节数组进行加密
            byte[] digest = md.digest(inputBytes);

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                // 将每个字节转换为十六进制字符串
                String hex = Integer.toHexString(b & 0xFF);
                if (hex.length() == 1) {
                    sb.append('0');
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // 若指定的加密算法不存在，抛出运行时异常
            throw new RuntimeException(e);
        }
    }
}
