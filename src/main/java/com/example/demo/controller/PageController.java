package com.example.demo.controller;

import java.awt.RenderingHints.Key;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.AcademyInfo;
import com.example.demo.model.CostType;
import com.example.demo.model.PayDetail;
import com.example.demo.model.Professional;
import com.example.demo.model.SchoolInfo;
import com.example.demo.service.PayDetailInterFace;
import com.example.demo.util.DateUtil;
import com.example.demo.util.EmptyUtil;
import com.example.demo.util.EncryptionMD5;

@RestController
@RequestMapping(value ="/page")
public class PageController {
	
	@Autowired
	private PayDetailInterFace payDetailInterFace;
	
	@RequestMapping(value ="/sy")
	public ModelAndView  getPage(ModelMap map) {
		List<SchoolInfo>  schoolList =  payDetailInterFace.querySchoolList();
		map.addAttribute("schoolList",schoolList);
		
		return new ModelAndView("index");
	}
	
	@RequestMapping(value ="/te")
	public ModelAndView  getPayPage() {
		
		return new ModelAndView("test");
	}
	//支付界面
	@RequestMapping(value ="/zhif")
	public ModelAndView  getPayPage(ModelMap map) {
		List<SchoolInfo>  schoolList =  payDetailInterFace.querySchoolList();
		map.addAttribute("schoolList",schoolList);
		return new ModelAndView("pay");
	}
	//获取缴费信息
	@RequestMapping(value ="/costDetail")
	public PayDetail getPayByNum(@RequestParam("num")  String num) {
		PayDetail payDetail = payDetailInterFace.queryDetail(num);
		return payDetail;
	}
	//获取已选择学校的学院列表
	@RequestMapping(value ="/academy")
	public List<AcademyInfo> getAcademy(@RequestParam("id") String id) {
		int school_id = Integer.valueOf(id.split("-")[0]);
		int school_area_id = Integer.valueOf(id.split("-")[1]);
		List<AcademyInfo> academyList = payDetailInterFace.queryAcademyList(school_id,school_area_id);
		return academyList;
	}
	//获取已选择的学院的专业列表
	@RequestMapping(value ="/professional")
	public List<Professional> getProfessional(@RequestParam("id") String id,@RequestParam("aid") String aid) {
		int school_id = Integer.valueOf(id.split("-")[0]);
		int school_area_id = Integer.valueOf(id.split("-")[1]);
		int academy_id = Integer.valueOf(aid);
		List<Professional> prfList = payDetailInterFace.queryPrfList(school_id, school_area_id, academy_id);
		return prfList;
	}
	//获取已选择的专业对应的缴费项目
	@RequestMapping(value ="/costType")
	public List<CostType> getCostType(@RequestParam("pid") String pid) {
		int professional_id = Integer.valueOf(pid);
		List<CostType> costList = payDetailInterFace.queryCostList(professional_id);
		return costList;
	}
	//
	@RequestMapping(value ="/sign")
	public String markSign(@RequestParam Map<String,String> map) throws ParseException {
		String key = "fc471d2a8ec3670f7789e0dfcbb8dfb1";
		String parms = "";
		
		if(!EmptyUtil.isEmpty(map)) {
			String date= DateUtil.dateFormat(new Date(), DateUtil.TIME_STAMP);
			//map.put("command","caibao.pay.h5");
			map.put("app","h50008530000066");
			map.put("operator_id","c777292c6becd2d7fd3f7d898e847d04");
			//System.out.println(map.get("amount"));
			map.put("local_order_no", "ddh"+date);
			map.put("timestamp", System.currentTimeMillis()+"");
			//System.out.println(map.get("timestamp"));
			map.put("subject", "学校缴费系统测试");
			System.out.println(map.get("remark"));
			//map.put("redirect_url", "http://www.borongsoft.com");
			//map.put("version", "1.0");
			parms = EncryptionMD5.getReqParms(map, key);
			//System.out.println(parms);
			
			ResponseEntity<String> response = new RestTemplate().postForEntity("http://openapi.borongsoft.com/gatewayOpen.htm", map, String.class);
	        String body = response.getBody();
	        System.out.println(body);
			
		}
		
		/*
		Map<String,String> map = new HashMap<String, String>();
		String key = "fc471d2a8ec3670f7789e0dfcbb8dfb1";
		map.put("amount", "1");
		map.put("app", "h50008530000066");
		map.put("local_order_no", "OPENAPI201808291113261934988");
		map.put("operator_id", "c777292c6becd2d7fd3f7d898e847d04");
		map.put("remark", "左思幸|201808001|计算机系|计算机科学与技术专业|学费|5000");
		map.put("subject", "博融缴费平台测试");
		map.put("timestamp", "1535512406676");
		String signMD5 = EncryptionMD5.sortAndEncryptionMD5(map, key);
		//System.out.println("remark:"+remark);
		String str= "3e93620707342b144a93e841241cd5a6";
		System.out.println("signMD5:"+signMD5);
		System.out.println("yanzheng:"+str.equals(signMD5));
		*/
		
		//String str1 = "amount=100&app=zyptestapp&barcode=123123123123&local_order_no=localorderno123123123123&operator_id=axgdfdafd34124&subject=这是一笔支付订单&timestamp=1460512556270&key=thisistestkey";
		//String str2 = EncryptionMD5.encryptWithMD5(str1, "UTF-8");
		//System.out.println("yanzheng2222:"+str.equals(str2));
		return parms;
		
		
	}
	
}
