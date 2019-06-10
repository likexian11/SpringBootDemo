package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.config.BasicConfig;
import com.example.demo.pojo.Custom;
import com.example.demo.pojo.Dept;
import com.example.demo.pojo.PayProject;
import com.example.demo.service.PayDetailInterFace;
import com.example.demo.service.SecretKeyInterFace;

@RestController
@RequestMapping(value ="/page")
public class PageController {
	
	@Autowired
	private PayDetailInterFace payDetailInterFace;
	@Autowired
	private SecretKeyInterFace secretKeyInterFace;

	//支付界面
	@RequestMapping(value ="/zhif")
	public ModelAndView  getPayPage(ModelMap retMap,@RequestParam Map<String,String> reqMap) {
		if(reqMap.containsKey("pid")) {
			List<Dept>  deptList =  payDetailInterFace.queryOrgList(reqMap.get("pid"));
			retMap.addAttribute("schoolList",deptList);
		}
		if(reqMap.containsKey("businessId")) {
			retMap.addAttribute("businessId",reqMap.get("businessId"));
		}
		return new ModelAndView("pay");
	}
	
	//获取缴费信息
	@RequestMapping(value ="/payDetail")
	public List<Custom> getPayByNum(@RequestParam("payNo")  String payNo) {
		List<Custom> CustomList = payDetailInterFace.queryDetail(payNo);
		return CustomList;
	}
	//反显机构信息
	@RequestMapping(value ="/payDetailOrg")
	public List<Dept> getPayDetailOrg(@RequestParam("orgId")  Integer orgId) {
		List<Dept> deptList = payDetailInterFace.queryOrgInfo(orgId);
		return deptList;
	}
	
	//联动选择列表
	@RequestMapping(value ="/relevance")
	public List<Dept> getAreaInfo(@RequestParam("pid") String pid) {
		List<Dept> reList = payDetailInterFace.queryOrgList(pid);
		return reList;
	}
	
	
	//获取已选择的机构对应的缴费项目
	@RequestMapping(value ="/costType")
	public List<PayProject> getCostType(@RequestParam("orgId") String orgId) {
		List<PayProject> costList = payDetailInterFace.queryCostList(orgId);
		return costList;
	}
	
	
	//获取支付url
	@RequestMapping(value ="/sign")
	public String markSign(@RequestParam Map<String,String> map) throws ParseException {
		String businessId="";
		String payUrl="";
		
		if(map.containsKey("businessId")) {
			businessId= map.get("businessId");
			payUrl = secretKeyInterFace.getPayUrl(businessId,BasicConfig.LOCAL_HOST, map);
		}
		return payUrl;
	}
}
