package com.example.demo.utils;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncryptionMD5 {
	
	private final static Logger log = LoggerFactory.getLogger(EncryptionMD5.class);
	
	
	/**
	 * 使用md5算法进行加密
	 *
	 * @param target
	 *            要加密的字符串
	 * @param charset
	 *            编码（请设置为UTF-8)
	 * @return 加密后的字符串
	 */
	public static String encryptWithMD5(String target,String charset) {
	    String md5Str = null;
	    try {
	        MessageDigest md5 = MessageDigest.getInstance("MD5");
	        md5.reset();
	        byte[] bytes = md5.digest(charset==null?target.getBytes():target.getBytes(charset));
	        StringBuffer stringBuffer = new StringBuffer();
	        for (byte b : bytes) {
	            int bt = b & 0xff;
	            if (bt < 16) {
	                stringBuffer.append(0);
	            }
	            stringBuffer.append(Integer.toHexString(bt));
	        }
	        md5Str = stringBuffer.toString();
	    } catch (Exception ex) {
	    	log.error("encrypt error,target:" + target, ex);
	    }
	    return md5Str;
	}

}
