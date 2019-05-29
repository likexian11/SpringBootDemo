package com.example.demo.controller;

import java.awt.RenderingHints.Key;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.AcademyInfo;
import com.example.demo.model.CostType;
import com.example.demo.model.PayDetail;
import com.example.demo.model.Professional;
import com.example.demo.model.SchoolInfo;
import com.example.demo.service.PayDetailInterFace;
import com.example.demo.service.SecretKeyInterFace;
import com.example.demo.util.DateUtil;
import com.example.demo.util.EmptyUtil;
import com.example.demo.util.EncryptionMD5;

@RestController
@RequestMapping(value ="/page")
public class PageController {
	
	@Autowired
	private PayDetailInterFace payDetailInterFace;
	@Autowired
	private SecretKeyInterFace secretKeyInterFace;
	
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
	public ModelAndView  getPayPage(ModelMap map,@RequestParam(name = "businessId",required = false) String businessId) {
		List<SchoolInfo>  schoolList =  payDetailInterFace.querySchoolList();
		map.addAttribute("schoolList",schoolList);
		map.addAttribute("businessId",businessId);
		//System.out.println("businessId:"+businessId);
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
		String businessId="";
		String payUrl="";
		
		if(map.containsKey("businessId")) {
			businessId= map.get("businessId");
			//System.out.println("businessId:"+businessId);
			payUrl = secretKeyInterFace.getPayUrl(businessId, map);
		}
		return payUrl;
		
	}
	
}
