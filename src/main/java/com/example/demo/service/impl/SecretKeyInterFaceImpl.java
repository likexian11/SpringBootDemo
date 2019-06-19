package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.n3r.idworker.Sid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.config.BasicConfig;
import com.example.demo.mapper.PaySecretkeyInfoMapper;
import com.example.demo.pojo.PaySecretkeyInfo;
import com.example.demo.service.SecretKeyInterFace;
import com.example.demo.utils.EmptyUtil;
import com.example.demo.utils.EncryptionMD5;

import ch.qos.logback.classic.Logger;

@Service
public class SecretKeyInterFaceImpl implements SecretKeyInterFace {
	
	@Autowired 
	PaySecretkeyInfoMapper paySecretkeyInfoMapper;
	
	@Autowired private Sid sid;
	
	private final Logger log = (Logger) LoggerFactory.getLogger(SecretKeyInterFaceImpl.class);
	
	@Override
	public String getPayUrl(String bid, String ip, Map<String, String> map){
		
		Map<String, String> signMap = new HashMap<String, String>();
		String payUrl = "";
		String sign=null;
		String localNo = map.get("localNo");
		
		PaySecretkeyInfo secretKey = paySecretkeyInfoMapper.getKeyInfo(bid);
		if(EmptyUtil.isNotEmpty(secretKey)) {
			signMap.put("app", secretKey.getApp());
			signMap.put("operator_id", secretKey.getOperator_id());
			signMap.put("amount", map.get("amount"));
			signMap.put("local_order_no", map.get("localNo") +"_"+sid.nextShort());
			//signMap.put("local_order_no", localNo);
			signMap.put("timestamp", System.currentTimeMillis()+"");
			signMap.put("subject", map.get("subject"));
			signMap.put("remark", map.get("remark"));
			//排序
			String newStrTemp = EncryptionMD5.sortMD5Sign(signMap, secretKey);
			//生成签名
		    sign = EncryptionMD5.encryptWithMD5(newStrTemp,"UTF-8");
		    log.info("订单："+ localNo +"发起支付....");
		    
			//拼接请求url
			String uri=BasicConfig.H5_PAY_URL+"?"
						+ newStrTemp + "&remark=" 
						+ map.get("remark") + "&command="
						+ secretKey.getCommand() 
						+ "&redirect_url="+secretKey.getRedirect_url() 
						+ "&version="+secretKey.getVersion()
						+ "&notify_url="+ ip +secretKey.getNotify_url()
						+ "&sign="+sign;;
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	        HttpEntity<String> entity = new HttpEntity<String>(headers);
	        String strbody=new RestTemplate().exchange(uri, HttpMethod.GET, entity,String.class).getBody();

	        JSONObject jsonResult = (JSONObject) JSON.parseObject(strbody).get("result");
	        JSONObject jsonData = (JSONObject) JSON.parseObject(strbody).get("data");

	        if((boolean) jsonResult.get("success")) {
				payUrl = jsonData.getString("url");
				log.info("订单："+ localNo +"返回支付链接：."+ payUrl);
				return payUrl;
			}
		}
		return payUrl;
	}

}
