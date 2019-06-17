package com.example.demo.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class Rsa256Sign {

	/**
	 * 使用Rsa算法进行加密
	 *
	 * @param target
	 *            要加密的字符串
	 * @param charset
	 *            编码（请设置为UTF-8)
	 * @return 加密后的字符串
	 */
	public static String rsa256Sign(String content, String privateKey, String charset) throws Exception {
	        try {
	            PrivateKey e = getPrivateKeyFromPKCS8("RSA", new ByteArrayInputStream(privateKey.getBytes()));
	            Signature signature = Signature.getInstance("SHA256WithRSA");
	            signature.initSign(e);
	            if (EmptyUtil.isEmpty(charset)) {
	                signature.update(content.getBytes());
	            } else {
	                signature.update(content.getBytes(charset));
	            }

	            byte[] signed = signature.sign();
	            return new String(Base64.encodeBase64(signed));
	        } catch (Exception var6) {
	            throw new Exception("RSAcontent = " + content + "; charset = " + charset, var6);
	        }
	    }

	    public static PrivateKey getPrivateKeyFromPKCS8(String algorithm, InputStream ins) throws Exception {
	        if (ins != null && !EmptyUtil.isEmpty(algorithm)) {
	            KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
	            byte[] encodedKey = StreamUtil.readText(ins).getBytes();
	            encodedKey = Base64.decodeBase64(encodedKey);
	            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
	        } else {
	            return null;
	        }
	    }
	    
	    public static void main(String[] args) throws Exception {
	    	
	    	String content = "&timestamp=1460512556270";
	    	String privateKey = "111";
	    	String charset = "UTF-8";
	    	System.out.println(rsa256Sign(content, privateKey, charset));
		}
	
}
