package com.example.demo.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;

public class Rsa256Sign {

	/**
	 * 使用Rsa算法进行加密
	 *
	 * @param content
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
	    
	    
	    /**
	     * 排序需要签名的字段
	     * @param sortedParams 参数Map
	     * @return
	     */
	    public static String getSignContent(Map<String, String> sortedParams) {
	        StringBuffer content = new StringBuffer();
	        ArrayList keys = new ArrayList(sortedParams.keySet());
	        Collections.sort(keys);
	        int index = 0;

	        for(int i = 0; i < keys.size(); ++i) {
	            String key = (String)keys.get(i);
	            String value = (String)sortedParams.get(key);
	            if (EmptyUtil.isNotEmpty(value)) {
	                content.append((index == 0 ? "" : "&") + key + "=" + value);
	                ++index;
	            }
	        }

	        return content.toString();
	    }
	    
	    public static void main(String[] args) throws Exception {
	    	
	    	String content = "amount=100&app=zyptestapp&barcode=123123123123&local_order_no=localorderno123123123123&operator_id=axgdfdafd34124&subject=这是一笔支付订单&timestamp=1460512556270";
	    	String content1= "amount=1&app=h50008530000066&local_order_no=10F92A0D077E43D7A503A29847F101C0_100&operator_id=c777292c6becd2d7fd3f7d898e847d04&subject=测试缴费人员2|住宿费|计算机1901班|0.01|201910002&timestamp=1560849204520&key=fc471d2a8ec3670f7789e0dfcbb8dfb1";
	    	String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMA2dnFiVyJKFNEi" + 
	    			"W97eeuPHM4smlLiNsCNPoinTpEvazBpfbeMRMo0kyY/B/B5uV02A/N0408K1NykW" + 
	    			"5yQ7NgUfjDUweW/4wfaeiGcRWE3QEdzBgQNXTXdfhIm5s9l89PwrqZls2kgwKUm+" + 
	    			"ud/ffOOXSx34tg+xUdjTz1Hjou5jAgMBAAECgYA6muB2JbPHgqriMQWt6Euz03LF" + 
	    			"xJenxZukyIz7D8qSTj3Y9Ku+henR2xuRt2W1qZL40JFIqiD2xuXwo0kKZPtNAVJe" + 
	    			"ELDRhVczcYpL+948QntJgKTlqjv3yo0Nd9eL+u0EOqixh6Q3MjZUsymVvMEncAXl" + 
	    			"1TouYsIjGM/qNvuQwQJBAN5AQNLK7m3wPXZCEu3GRucmRVCsRcpHAAukd2yJ1hqE" + 
	    			"Y0wW/LddBLkD10EvNz+w/oeffY4Lk8UR9GznoiEdlPMCQQDdZoIFtNULuDfhJf+b" + 
	    			"OjCDM9lK+wr+saC6VMI3yA78WEQdzJ7ORSNnzdsdqA/7uHhT1hX8ibEHBNvHzGkU" + 
	    			"d1zRAkA2VnFC2DiZCm6MdjUYiyyUoQe7ZJMflGJPdmN4Vu7QxuNcHBanYgegkG7V" + 
	    			"Ugzo9oYUdIsG6o+zU+N1qOA7xna/AkEAtF8e7qc0Kiga3kKmyz/M5hcHoB6GBpmP" + 
	    			"6D3FPMyv6MXAOMbLWiDZh2geazrQSrMu1J5Fq0hCAQXkSBIwSYw1AQJAODHKez1W" + 
	    			"4opQLtx4sXaon/KJlAQytowtVfd/BROUM1oYpWfOipkE9JcF+bSSERrvY+923WiF" + 
	    			"fcsQUfHTYjVCUg==";
	    	String charset = "UTF-8";
	    	System.out.println(rsa256Sign(content1, privateKey, charset));
		}
	
}
