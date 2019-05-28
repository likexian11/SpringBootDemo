package com.example.demo.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.SecretKeyDao;
import com.example.demo.model.FKRSecretKey;
import com.example.demo.util.DateUtil;
import com.example.demo.util.EmptyUtil;
import com.example.demo.util.EncryptionMD5;

@Service
public class SecretKeyInterFaceImpl implements SecretKeyInterFace {
	@Autowired SecretKeyDao secretKeyDao;
	
	@Override
	public String getPayUrl(String businessId,Map<String, String> map){
		// TODO Auto-generated method stub
		Map<String, String> signMap = new HashMap<String, String>();
		String payUrl = "";
		String sign=null;
	    StringBuffer sb = new StringBuffer();
		String date = DateUtil.dateFormat(new Date(), DateUtil.TIME_STAMP);
		
		FKRSecretKey secretKey = secretKeyDao.queryKeyInfo(businessId);
		if(EmptyUtil.isNotEmpty(secretKey)) {
			signMap.put("app", secretKey.getApp());
			signMap.put("operator_id", secretKey.getOperator_id());
			signMap.put("amount", map.get("amount"));
			signMap.put("local_order_no", "TEST_"+date);
			signMap.put("timestamp", System.currentTimeMillis()+"");
			signMap.put("subject", map.get("remark"));
			
		    //排序
		    List<Map.Entry<String, String>> infoIds =
		            new ArrayList<Map.Entry<String, String>>(signMap.entrySet());
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
		    System.out.println(secretKey.getKey().trim());
		    String newStrTemp = sb.toString()+"key="+secretKey.getKey().trim();
			//生成签名
		    sign = EncryptionMD5.encryptWithMD5(newStrTemp,"UTF-8");
			//拼接请求url
			String uri="http://openapi.borongsoft.com/gatewayOpen.htm"+"?"
						+newStrTemp +"&command="+secretKey.getCommand() +"&redirect_url="+secretKey.getRedirect_url() +"&version="+secretKey.getVersion()
						+ "&sign="+sign;;
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	        HttpEntity<String> entity = new HttpEntity<String>(headers);
	        String strbody=new RestTemplate().exchange(uri, HttpMethod.GET, entity,String.class).getBody();
	        System.out.println(strbody);
	        
	        JSONObject jsonResult = (JSONObject) JSONObject.parseObject(strbody).get("result");
	        JSONObject jsonData = (JSONObject) JSONObject.parseObject(strbody).get("data");

	        if((boolean) jsonResult.get("success")) {
				payUrl = jsonData.getString("url");
				return payUrl;
			}
		}
		return payUrl;
	}

}
