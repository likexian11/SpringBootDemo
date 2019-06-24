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

import com.alibaba.fastjson.JSON;
import com.example.demo.config.BasicConfig;
import com.example.demo.pojo.Custom;
import com.example.demo.pojo.Dept;
import com.example.demo.pojo.PayPage;
import com.example.demo.pojo.PayProject;
import com.example.demo.service.PageJumpInterFace;
import com.example.demo.service.PayDetailInterFace;
import com.example.demo.service.SecretKeyInterFace;

@RestController
@RequestMapping(value ="/page")
public class PageController {
	
	@Autowired
	private PayDetailInterFace payDetailInterFace;
	@Autowired
	private SecretKeyInterFace secretKeyInterFace;
	@Autowired
	private PageJumpInterFace pageJumpInterFace;

	//主页
	@RequestMapping(value ="/index")
	public ModelAndView  getIndexPage(ModelMap retMap,@RequestParam Map<String,String> reqMap) {
		if(reqMap.containsKey("bid")) {
			List<PayPage> payPageList = pageJumpInterFace.queryPageUrl(reqMap.get("bid"));
			retMap.addAttribute("payPageList",payPageList);
			retMap.addAttribute("bid",reqMap.get("bid"));
		}
		return new ModelAndView("index");
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//输入缴费号界面
	@RequestMapping(value ="/zhif")
	public ModelAndView  getPayPage(ModelMap retMap,@RequestParam Map<String,String> reqMap) {
		if(reqMap.containsKey("bid")) {
			//List<Dept>  deptList =  payDetailInterFace.queryOrgList(reqMap.get("bid"));
			//retMap.addAttribute("schoolList",deptList);
			//Dept dept = payDetailInterFace.queryOrg(Integer.valueOf(reqMap.get("bid")));
			retMap.addAttribute("bid",reqMap.get("bid"));
			//retMap.addAttribute("dept",dept);
		}
		return new ModelAndView("payno");
	}
	
	//获取缴费信息
	@RequestMapping(value ="/payDetail")
	public ModelAndView getPayByNum(@RequestParam("payNo")  String payNo ,ModelMap retMap) {
		List<Custom> customList = payDetailInterFace.queryDetail(payNo);
		retMap.addAttribute("payNo", payNo);	
		retMap.addAttribute("customList", customList);
		return new ModelAndView("paydata");
		//return CustomList;
	}
	//反显机构信息
	@RequestMapping(value ="/payDetailOrg")
	public List<Dept> getPayDetailOrg(@RequestParam("orgId")  Integer orgId) {
		List<Dept> deptList = payDetailInterFace.queryOrgInfo(orgId);
		return deptList;
	}
	
	//确认支付页面
	@RequestMapping(value ="/confirm")
	public ModelAndView ConfirmPage(@RequestParam Map<String,String> map) {
		String paramsJson = JSON.toJSONString(map);
		System.out.println(paramsJson);
		//List<Dept> reList = payDetailInterFace.queryOrgList(pid);
		//return reList;
		return new ModelAndView("pay");
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
		
		if(map.containsKey("bid")) {
			businessId= map.get("bid");
			payUrl = secretKeyInterFace.getPayUrl(businessId,BasicConfig.LOCAL_HOST, map);
		}
		return payUrl;
	}
}
