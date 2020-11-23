package com.dzzh.hz.hzsf.common.encrypt;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.security.MessageDigest;

/**
 * @Classname Md5Encrypt
 * @Description TODO
 * @Date 2020-01-20 00:12
 * @Created by hzong
 */
public class Md5Encrypt {

    public Md5Encrypt() {
    }

    /**
     * 验证MD5密码是否正确
     */
    public static boolean authMD5String(String md5, String inputString) {
        if (md5.equalsIgnoreCase(encodeByMD5(inputString))) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 对字符串进行MD5编码
     *
     * @param originStr
     * @return
     */
    public static String encodeByMD5(String originStr,String salt) {
        return encodeByMD5(originStr+salt);
    }

    /**
     * 对字符串进行MD5编码
     *
     * @param originStr
     * @return
     */
    public static String encodeByMD5(String originStr) {
        if (originStr != null) {
            try {
                // 创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 使用指定的字节数组对摘要进行最后的更新，然后完成摘要计算
                char[] _charStr = originStr.toCharArray();
                byte[] _byteStr = new byte[_charStr.length];
                for (int i = 0; i < _charStr.length; i++) {
                    _byteStr[i] = (byte)_charStr[i];
                }
                byte[] _results = md.digest(_byteStr);
                StringBuffer _hexValue = new StringBuffer();
                for (int i = 0; i < _results.length; i++) {
                    int _val = ((int)_results[i]) & 0xff;
                    if(_val < 16){
                        _hexValue.append("0");
                    }
                    _hexValue.append(Integer.toHexString(_val));
                }
                return _hexValue.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}
