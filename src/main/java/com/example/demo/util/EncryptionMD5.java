package com.example.demo.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.controller.TestController;

public class EncryptionMD5 {
	
	private final static Logger log = LoggerFactory.getLogger(TestController.class);
	
	/**
	 * 对params中的参数进行排序后生成签名串
	 * @param params 参与签名的参数map
	 * @param key 签名要用到的加密串
	 * @return
	 */
	
	public static String getReqParms(Map<String,String> params,String key) {
		
		String sign=null;
	    StringBuffer sb = new StringBuffer();
	    
	    String command = "caibao.pay.h5";
		String redirect_url ="http://www.borongsoft.com";
		String version = "1.0";
		
	    //排序
	    List<Map.Entry<String, String>> infoIds =
	            new ArrayList<Map.Entry<String, String>>(params.entrySet());
	    Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>() {
	        public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
	            return (o1.getKey()).toString().compareTo(o2.getKey());
	        }
	    });
	    //对参数数组进行按key升序排列,然后拼接，最后调用md5签名方法
	    int size  = infoIds.size();
	    for(int i = 0; i < size; i++) {
	        if(EmptyUtil.isNotEmptyStrTrim(infoIds.get(i).getValue())) {//不为空，为空的不参与签名
	            sb.append(infoIds.get(i).getKey() + "=" + infoIds.get(i).getValue() + "&");
	        }
	    }
	    String newStrTemp = sb.toString()+"key="+key.trim();
	    //获取sign_method

	    sign = encryptWithMD5(newStrTemp,"UTF-8");
	    String reqParms = "?"+newStrTemp +"&command="+command +"&redirect_url="+redirect_url +"&version="+version + "&sign="+sign;
	    
	    return reqParms;
	}
	
	
	
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
